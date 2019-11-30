#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <string.h>
#include <assert.h>

#include <iterator>
#include <exception>



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
    SquareMatrix(unsigned sz) : n(sz){
      A = (ctype*)malloc(sizeof(ctype) * n * n);
      memset(A, 0, sizeof(ctype) * n * n);
    }

    // It's a Matrix, so this requires 2 indexes, but we let the float*
    // type handle the 2nd index

    ctype& at(unsigned idx, unsigned idy) const {
      return *(A + n * idx + idy);
    }

    ctype* operator[] (unsigned idx) const {
      return A + n * idx;
    }

    SquareMatrix (SquareMatrix &other) {
      n = other.n;
      A = (ctype*)malloc(sizeof(ctype)*n*n);
      memcpy((char*)A, (char*)(&other.at(0, 0)), sizeof(ctype) * n * n);
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

    ctype trace() const {
      ctype acc = *A;
      for(unsigned i = 1; i < n; ++i){
        acc *= at(i, i);
      }
      return acc;
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

/**
 * Sparse Square Matrix made specifically for the Maze Problem (380).
 * Stores matrix as diagonal entry +- 20. 
 **/
template <class ctype, unsigned row_range>
class SparseMatrix {
  private:
    struct SMRow {
        unsigned offset;
        ctype *A;
        SMRow(unsigned n, unsigned rown){
          A = (ctype*)malloc(sizeof(ctype)*(row_range * 2 + 1));
          memset(A, 0, sizeof(ctype)*(row_range*2+1));
          if (rown < row_range)
            offset = 0;
          else 
            offset = rown - row_range - 1;
          assert(offset >= 0 && offset <= n);
        } 

        ctype& at(unsigned col){
          if (col < offset)
            assert(0 && "Out of Bounds!");
          else
            return A[col-offset];

        }
    };
    SMRow* rows;
  public:
    unsigned n;
    SparseMatrix (unsigned sz){
      n = sz;
      rows = (SMRow*)malloc(sizeof(SMRow)*n);
      for(unsigned i = 0; i < sz; ++i){
        rows[i] = SMRow(n, i, row_range);
      }
    }

    ctype& at(unsigned row, unsigned col){
      return rows[row].at(col);
    } 

    class SMIterator : public std::iterator<std::forward_iterator_tag, ctype> {
      private:
        ctype *ptr;

      public:
        SMIterator (ctype *p){
          ptr = p;
        }

        ctype& operator* (){
          return *ptr;
        }

        SMIterator& operator++(){
          ++ptr;
          return this;
        }

        bool operator== (SMIterator &other) const {
          return ptr == other.ptr;
        }
        
        bool operator!= (SMIterator &other) const {
          return ptr != other.ptr;
        }
    }; 

    SMIterator& begin_row_nz(unsigned row){
      return *(new SMIterator(rows[row].A));
    }

    SMIterator& end_row_nz(unsigned row){
      return *(new SMIterator(rows[row].A+(2*rows[row].offset+1)));
    }
};

// A work in progress. Might need to find a variant for a sparse cholesky
template <class ctype>
void naive_cholesky(SquareMatrix<ctype>& S) {
  unsigned n = S.n;
  auto L = new SquareMatrix<ctype>(n);
  for (unsigned j = 0; j < n; ++j){
    if (S.at(j, j) == 0) continue; // Skip if our diagonal entry is 0
    ctype q = L->at(j, j) = sqrt(S.at(j, j));
    for(unsigned k = j+1; k < n; ++k){
      L->at(k, j) = S.at(k, j) / q;
    }
    for(unsigned i = j + 1; i < n; ++i){
      if (L->at(i, j) ==  0) continue;
      for(unsigned k = j + 1; k < n; ++k){
        S.at(i, k) = S.at(i, k) - L->at(i, j) * L->at(k, j);
      }
    }
  }
}

/*
void naive_cholesky(SparseMatrix &S){
  unsigned n = S.n;
  auto L = new SquareMatrix(n);
  for (unsigned j = 0; j < n; ++j){
    if (S->at(j, j) == 0) continue;

    ctype q = L->at(j, j) = sqrt(S->at(j, j));

    for(auto it = S.begin_row_nz(k), it_end = S.end_row_nz(j); it != it_end;
        ++it)
      L->at(k, j) = *it / q;

    for(unsigned i = j + 1; i < n; ++i){
      if (L->at(i, j) ==  0) continue;
      for(unsigned k = j + 1; k < n; ++k){
        S->at(i, k) = S->at(i, k) - L->at(i, j) * L->at(k, j);
      }
    }
  }
}
*/
