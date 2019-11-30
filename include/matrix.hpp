#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <string.h>
#include <assert.h>

#include <iterator>
#include <exception>

#include "util.hpp"



// Some utility matrix operations

/**
 * Square Matrix (non-sparse)
 **/
template<class ctype>
class SquareMatrix {
  private:
    ctype *A;
  public:
    unsigned n;
    
    // Construction
    SquareMatrix (SquareMatrix &other) = delete;

    SquareMatrix(unsigned sz) : n(sz){
      A = (ctype*)malloc(sizeof(ctype) * n * n);
      memset(A, 0, sizeof(ctype) * n * n);
    }

    ctype& at(unsigned idx, unsigned idy) const {
      return *(A + n * idx + idy);
    }

    // Get the minor of a matrix. Does it in place.
    void minor(unsigned idx, unsigned idy){
      unsigned off = 0;
      ctype *ptr = A;
      for(unsigned i = 0; i < n; ++i){
        if (i == idx){
          off += n;
          continue;
        }
        for(unsigned j = 0; j < n; ++j){
          if (j == idy){
            ++off;
            continue;
          }
          *(ptr) = *(ptr+off);
          ++ptr;
        }
      }
      --n;
    }

    void print(){
      ctype *ptr = A;
      for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
          printf("%f\n", *(ptr++));
        }
        printf("-----------------\n");
      }
    }
};

/*
 * Sparse Diagonal Matrix
 * the 'diagonality' of it will be the width of the diagonal
 */
template<class ctype>
class SparseDiagonalMatrix {
  private:
    ctype* A;
  public:
    unsigned n;
    unsigned diag;
    unsigned hdiag;

    SparseDiagonalMatrix (unsigned sz, unsigned diagonality){
      diag = diagonality * 2 + 1;
      hdiag = diagonality;
      A = (ctype*)malloc(sizeof(ctype)*diag*n);
      memset(A, 0, sizeof(ctype)*diag*n);
    }

    ctype& at(unsigned idx, unsigned idy){
      unsigned index = (idx * diag) + (idy - idx) + hdiag;
      assert(abs(idy-idx) <= hdiag);
      return A[index];
    }

    SparseDiagonalMatrix<ctype> *minor(unsigned idx, unsigned idy){
      auto min = new SparseDiagonalMatrix<ctype>(n-1, hdiag);
      i

    }
}

template<class Mat>
double trace(Mat &M) {
  double acc = 1;
  for(unsigned i = 0; i < M.n; ++i){
    acc *= M.at(i, i);
  }
  return acc;
}
  
template<class Mat>
BigDouble big_trace(Mat &M) {
  BigDouble trace_acc(1, 0);
  for(unsigned i = 0; i < M.n; ++i){
    trace_acc *= M.at(i, i);
  }
  return trace_acc;
}

// A work in progress. Might need to find a variant for a sparse cholesky
template <class ctype>
void naive_cholesky(SquareMatrix<ctype>& S, 
    unsigned row_length // This is special information about the maze matrix
    ) {
  unsigned n = S.n;
  auto L = new SquareMatrix<ctype>(n);
  for (unsigned j = 0; j < n; ++j){
    unsigned walk_max = (n > j+row_length+1)?(j+row_length+1):n;
    if (S.at(j, j) == 0) continue; // Skip if our diagonal entry is 0
    ctype q = L->at(j, j) = sqrt(S.at(j, j));
    for(unsigned k = j+1; k < walk_max; ++k){
      L->at(k, j) = S.at(k, j) / q;
    }
    for(unsigned i = j + 1; i < walk_max; ++i){
      if (L->at(i, j) ==  0) continue;
      q = L->at(i, j);
      for(unsigned k = j + 1; k < walk_max; ++k){
        S.at(i, k) = S.at(i, k) - q * L->at(k, j);
      }
    }
  }
}
