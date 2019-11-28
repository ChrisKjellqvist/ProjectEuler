#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <string.h>


// Some utility matrix operations

/**
 * Square Matrix (non-sparse)
 **/
template<class ctype>
class SquareMatrix {
  private:
    ctype *A;
    size_t n;
  public:
    // Construction
    SquareMatrix(size_t sz) : n(sz){
      A = (ctype*)malloc(sizeof(ctype) * n * n);
      memset(A, 0, sizeof(ctype) * n * n);
    }

    // It's a Matrix, so this requires 2 indexes, but we let the float*
    // type handle the 2nd index

    ctype& at(size_t idx, size_t idy) const {
      return *(A + n * idx + idy);
    }

    ctype* operator[] (size_t idx) const {
      return A + n * idx;
    }

    SquareMatrix<ctype> *copy() const {
      auto S = new SquareMatrix(n);
      memcpy((char*)(&S->at(0, 0)), (char*)A, sizeof(ctype) * n * n);
      return S;
    }

    // Get the minor of a matrix. Does it in place.
    void minor(size_t idx, size_t idy){
      size_t off = 0;
      ctype *ptr = A;
      for(size_t i = 0; i < n; ++i){
        if (i == idx){
          off += n;
          continue;
        }
        for(size_t j = 0; j < n; ++j){
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

    ctype trace() const {
      ctype acc = *A;
      for(unsigned i = 1; i < n; ++i){
        acc *= at(i, i);
      }
      return acc;
    }
    // A work in progress. Might need to find a variant for a sparse cholesky
    SquareMatrix<ctype> *naive_cholesky() const {
      auto S = copy();
      auto L = new SquareMatrix(n);
      for (unsigned j = 0; j < n; ++j){
        if (S->at(j, j) == 0) continue; // Skip if our diagonal entry is 0
        ctype q = L->at(j, j) = sqrt(S->at(j, j));
        for(unsigned k = j+1; k < n; ++k){
          L->at(k, j) = S->at(k, j) / q;
        }
        for(unsigned i = j + 1; i < n; ++i){
          if (L->at(i, j) == 0) continue;
          for(unsigned k = j + 1; k < n; ++k){
            S->at(i, k) = S->at(i, k) - L->at(i, j) * L->at(k, j);
          }
        }
      }
      return S;
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
