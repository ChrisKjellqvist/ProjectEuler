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

    ctype& at(size_t idx, size_t idy){
      return *(A + n * idx + idy);
    }

    ctype* operator[] (size_t idx){
      return A + n * idx;
    }

    SquareMatrix<ctype> *copy(){
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

    ctype trace(){
      ctype acc = *A;
      for(unsigned i = 1; i < n; ++i){
        acc *= at(i, i);
      }
      return acc;
    }
    // A work in progress. Might need to find a variant for a sparse cholesky
    SquareMatrix<ctype> *naive_cholesky(){
      auto S = copy();
      auto L = new SquareMatrix(n);
      for (unsigned j = 0; j < n; ++j){
        if (S->at(j, j) == 0) continue; // Skip if our diagonal entry is 0
        ctype q = L->at(j, j) = sqrt(S->at(j, j));
        for(unsigned k = j+1; k < n; ++k){
          L->at(k, j) = S->at(k, j) / q;
        }
        for(unsigned i = j + 1; i < n; ++i){
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
///**
// * Sparse Square Matrix
// **/
//// Provide internal storage type of weights
//
//#define __UNUSED 0xFFFFFFFF
//template<class ctype>
//class SparseSquareMatrix {
//  private:
//    struct AdjPair {
//      unsigned v;
//      ctype w;
//      AdjPair(unsigned q, ctype r) : v(q), w(r) {}
//    };
//
//    const size_t RowCardinality, n;
//    /**
//     * Each row stores RowCardinality number of columns
//     **/
//    AdjPair *A;
//
//    unsigned *occupations;
//
//    // Access row
//    AdjPair *getRow(size_t idx){
//      return A + RowCardinality * idx; 
//    }
//  public:
//
//    // Construction
//    
//    SparseSquareMatrix(size_t sz, size_t rc) : n(sz), RowCardinality(rc) {
//      assert(RowCardinality >= 1);
//      A = (AdjPair*)calloc(sizeof(AdjPair), rc * n);
//      occupations = (unsigned*)calloc(sizeof(unsigned), n);
//      for(unsigned i = 0; i < sz * rc; ++i){
//        A[i]->v = __UNUSED;
//      }
//    }
//
//    SparseSquareMatrix *copy(){
//      auto S = new SparseSquareMatrix(n);
//      memcpy(&S.at(0, 0), A, n * RowCardinality * sizeof(AdjPair));
//      return S;
//    }
//
//    // Return true for success, false otherwise
//    // If row == col, then it will always be in the 0th slot
//    bool addColumn(unsigned row, unsigned col, ctype val){
//      if (occupations[row] == RowCardinality) return false;
//      if (row != col){
//        A[row*rowCardinality + (occupations[row]++) + 1] = AdjPair(col, val);
//      } else {
//        A[row*rowCardinality] = AdjPair(col, val); 
//      }
//      return true;
//    } 
//
//    // Modifications
//
//    /**
//     * Remove a row and column from the matrix to form another
//     * sparse square matrix. Because of layout, this can not be
//     * done in place. At least not easily.
//     **/
//    SparseSquareMatrix *minor(size_t row, size_t col){
//      if (row >= n || col >= n) return nullptr;
//      auto S = new SparseSquareMatrix(n-1, RowCardinality);
//      for(unsigned i = 0; i < row; ++i){
//        AdjPair *row_entries = getRow(i);
//        for(unsigned j = 0; j < RowCardinality; ++j){
//          if (row_entries[j]->v == col) continue;
//          S->addColumn(i, row_entries[j]->v, row_entries[j]->w);
//        }
//      }
//      for(unsigned i = row + 1; i < n; ++i){
//        AdjPair *row_entries = getRow(i);
//        for(unsigned j = 0; j < RowCardinality; ++j){
//          if (row_entries[j]->v == col) continue;
//          S->addColumn(i-1, row_entries[j]->v, row_entries[j]->w);
//        }
//      }
//      return S;
//    }
//
//    // Operations
//
//    // A work in progress. Might need to find a variant for a sparse cholesky
//    SquareMatrix *naive_cholesky(){
//      auto S = copy();
//      SquareMatrix L(n);
//      for (unsigned j = 0; j < n; ++j){
//        AdjPair *row = getRow(j);
//        if (row[i].w == 0) continue; // Skip if our diagonal entry is 0
//        ctype q = L[j][j] = sqrt(row[i].w);
//        for (unsigned card = 1; card < RowCardinality; ++card) {
//
//        }
//        for(unsigned k = j+1; k < n; ++k){
//          L[k][j] = S[k][j]/q;
//        }
//        for(unsigned i = j + 1; i < n; ++i){
//          for(unsigned k = j + 1; k < n; ++k){
//            S[i][k] = S[i][k] - L[i][j]*L[k][j];
//          }
//        }
//      }
//      return S;
//    }
//
//
//};
