#include "../include/matrix.hpp"
#include <assert.h>

template <class matrix_ty>
void init(matrix_ty &mat, unsigned mazeDimX, unsigned mazeDimY){
  unsigned il = mazeDimX * mazeDimY;
  unsigned jl = il;
  for(unsigned i = 0; i < il; ++i){
    for(unsigned j = 0; j < jl; ++j){
      unsigned modres = i % mazeDimX;
      bool differentRows = ((i-1) / mazeDimX) == ((j-1) / mazeDimX);
      // Top & Bottom borders
      bool isTB = (i < mazeDimX) || (i >= ((mazeDimY-1)*mazeDimX));
      // Left & Right borders
      bool isLR = modres == 0 || modres == (mazeDimX - 1);
      unsigned absdiff = abs((int)(i - j));
      if (i == j && isTB && isLR)
        mat.at(i, j) = 2;
      else if (i == j && (isTB || isLR))
        mat.at(i, j) = 3;
      else if (i == j)
        mat.at(i, j) = 4;
#ifdef DEBUG
      if (mat.at(i, j) != 0)
        printf("(%d, %d) -> %f\n", i, j, mat.at(i, j));
#endif

      else if (absdiff == mazeDimX) 
        mat.at(i, j) = -1;
      // No left neighbor on left wall
      else if (modres == (mazeDimX -1) && (j - i == 1))
        continue;
      // No right neighbor on right wall
      else if (modres == 0 && (j - i == -1))
        continue;
      // LR neighbors otherwise
      else if (absdiff == 1) 
        mat.at(i, j) = -1;
#ifdef DEBUG2
      printf("(%d, %d) %d %d -> %f\n", i, j, modres, absdiff, mat.at(i, j));
#endif
    }
  } 

  // Verify this is a laplacian
  for(unsigned i = 0; i< il; ++i){
    unsigned acc = 0;
    for(unsigned j = 0; j < jl; ++j){
      if (mat.valid(i, j))
        acc += mat.at(i, j);
    }
    assert(acc == 0);
  }
  
}

#define maze_dim_x 500
#define maze_dim_y 1000

//using mat_ty = SquareMatrix<double>;
using mat_ty = SparseDiagonalMatrix<double, maze_dim_x>;

int main(){
  unsigned matrix_n = maze_dim_x * maze_dim_y;
  mat_ty mat(matrix_n);
  init(mat, maze_dim_x, maze_dim_y);
  auto m2 = mat.minor(0, 0);
  naive_cholesky<mat_ty, double>(*m2, maze_dim_x);
//  printf("%f\n", trace(*m2));
  big_trace(*m2).print();
}
