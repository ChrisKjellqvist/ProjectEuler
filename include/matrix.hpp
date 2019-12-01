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
    SquareMatrix *minor(unsigned idx, unsigned idy){
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
      return this;
    }

    bool valid(unsigned idx, unsigned idy){
      return (idx >= 0 && idx < n) && (idy >= 0 && idy < n);
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
template<class ctype, unsigned diagonality>
class SparseDiagonalMatrix {
  private:
    ctype* A;
  public:
    unsigned n;
    unsigned diag;

    SparseDiagonalMatrix (unsigned sz){
      diag = diagonality * 2 + 1;
      n = sz;
      A = (ctype*)malloc(sizeof(ctype)*diag*n);
      memset(A, 0, sizeof(ctype)*diag*n);
    }

    bool valid(unsigned idx, unsigned idy){
      return abs((long)idy-(long)idx) <= diagonality;
    }

    ctype& at(unsigned idx, unsigned idy){
      unsigned index = (idx * diag) + (idy - idx) + diagonality;
      assert(abs((long)idy-(long)idx) <= diagonality);
      return A[index];
    }

    SparseDiagonalMatrix<ctype, diagonality> *minor(unsigned idx, unsigned idy){
      auto min = new SparseDiagonalMatrix<ctype, diagonality>(n-1);
      for(unsigned i = 0; i < n - 1; ++i){
        unsigned row = (i < idx) ? i : i + 1;
        for(unsigned j = 0; j < n - 1; ++j){
          unsigned col = (j < idy) ? j : j + 1;
          if (min->valid(i, j) && valid(row, col))
            min->at(i, j) = at(row, col);
        }
      }
      return min;
    }
    void print(){
      for(unsigned i = 0; i < n; ++i){
        for(unsigned j = 0; j < n; ++j){
          if (valid(i, j))
            printf("%f\n", at(i, j));
          else
            printf("0.00000\n");
        }
        printf("---------------\n");
      }
    }
};

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

template <class matrix_ty, class ctype>
void naive_cholesky(matrix_ty& S, unsigned row_length) {
  unsigned n = S.n;
  auto L = new matrix_ty(n);
  for (unsigned j = 0; j < n; ++j){
    // only walk through our band, don't bother calculating 0s!
    unsigned walk_max = (n > j+row_length+1)?(j+row_length+1):n;
    if (S.at(j, j) == 0) continue; // Skip if our diagonal entry is 0
    ctype q = L->at(j, j) = sqrt(S.at(j, j));
    for(unsigned k = j+1; k < walk_max; ++k){
      L->at(k, j) = S.at(k, j) / q;
    }
    for(unsigned i = j + 1; i < walk_max; ++i){
      if (L->at(i, j) ==  0) continue;
      ctype r = L->at(i, j);
      for(unsigned k = j + 1; k < walk_max; ++k){
        S.at(i, k) -= r * L->at(k, j);
      }
    }
  }
}
