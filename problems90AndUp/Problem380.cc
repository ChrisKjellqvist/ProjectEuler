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
      bool isTB = (i < mazeDimX) || (i >= ((mazeDimY-1)*mazeDimX));
      bool isLR = modres == 0 || modres == (mazeDimX - 1);
      unsigned absdiff = abs((int)(i - j));
      if (i == j && isTB && isLR)
        mat[i][j] = 2;
      else if (i == j && (isTB || isLR))
        mat[i][j] = 3;
      else if (i == j)
        mat[i][j] = 4;
//      if (mat[i][j] != 0)
//        printf("(%d, %d) -> %f\n", i, j, mat[i][j]);
      else if (absdiff == mazeDimX) // up and down neighbors
        mat[i][j] = -1;
      else if (modres == (mazeDimX -1) && (j - i == 1))
        mat[i][j] = 0;
      else if (modres == 0 && (j - i == -1))
        mat[i][j] = 0;
      else if (absdiff == 1) 
        mat[i][j] = -1;
//      printf("(%d, %d) %d %d -> %f\n", i, j, modres, absdiff, mat[i][j]);
    }
  } 

  for(unsigned i = 0; i< il; ++i){
    unsigned acc = 0;
    for(unsigned j = 0; j < jl; ++j){
      acc += mat[i][j];
    }
    assert(acc == 0);
  }
}

int main(){
  unsigned maze_mazeDimX = 50, maze_mazeDimY = 50;
  unsigned matrix_n = maze_mazeDimX * maze_mazeDimY;
  SquareMatrix<double> mat(matrix_n);
  init(mat, maze_mazeDimX, maze_mazeDimY);
  mat.minor(0, 0);
  printf("finished init\n");
  fflush(stdout);
  auto q = mat.naive_cholesky();
//  q->print();
//  printf("\n\ndeterminant is %f?\n", q->trace()); 
}
