#include "../include/matrix.hpp"
#include <assert.h>

template <class t>
void init(SquareMatrix<t> &mat, unsigned mazeDimX, unsigned mazeDimY){
  unsigned il = mazeDimX * mazeDimY;
  unsigned jl = il;
  printf("mX -> %d, mY -> %d\n", mazeDimX, mazeDimY);
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
        mat[i][j] = 2;
      else if (i == j && (isTB || isLR))
        mat[i][j] = 3;
      else if (i == j)
        mat[i][j] = 4;
#ifdef DEBUG
      if (mat[i][j] != 0)
        printf("(%d, %d) -> %f\n", i, j, mat[i][j]);
#endif
      // up and down neighbors
      else if (absdiff == mazeDimX) 
        mat[i][j] = -1;
      // No left neighbor on left wall
      else if (modres == (mazeDimX -1) && (j - i == 1))
        mat[i][j] = 0;
      // No right neighbor on right wall
      else if (modres == 0 && (j - i == -1))
        mat[i][j] = 0;
      // LR neighbors otherwise
      else if (absdiff == 1) 
        mat[i][j] = -1;
#ifdef DEBUG2
      printf("(%d, %d) %d %d -> %f\n", i, j, modres, absdiff, mat[i][j]);
#endif
    }
  } 

  // Verify this is a laplacian
  for(unsigned i = 0; i< il; ++i){
    unsigned acc = 0;
    for(unsigned j = 0; j < jl; ++j){
      acc += mat[i][j];
    }
    assert(acc == 0);
  }
}

int main(){
  unsigned maze_mazeDimX = 20, maze_mazeDimY = 8;
  unsigned matrix_n = maze_mazeDimX * maze_mazeDimY;
  SquareMatrix<double> mat(matrix_n);
  init(mat, maze_mazeDimX, maze_mazeDimY);
  mat.minor(0, 0);
  printf("finished init\n");
  fflush(stdout);
  auto q = mat.naive_cholesky();
  q->print();
//  printf("\n\ndeterminant is %f?\n", q->trace()); 
}
