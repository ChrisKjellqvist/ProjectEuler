// 1 millionth lexicographic permutation of 0123456789
// Do a binary search-ish thing
// Original completed by Chris on Fri, 26 Dec 2014, 10:39

#include <stdio.h>
#include <string.h>

int factorial(int N){
  int Acc = 1;
  for(int i = 2; i <= N; ++i)
    Acc *= i;
  return Acc;
}

int main(){
  char Taken[10];
  char Num[11];
  memset(Taken, 0, 10);
  memset(Num, 0, 11);
  int Offset = 999999;
  for(int i = 0; i < 10; ++i){
    int Stride = factorial(9-i);
    int Index = Offset / Stride;
    Offset -= Index * Stride;
    int c, j;
    for(j = 0, c = 0; j < 10; ++j){
      if (!Taken[j]) {
	if (c == Index){
	  Taken[j] = true;
	  break;
	}
	else ++c;
      }
    }
    Num[i] = '0' + j;
  }
  printf("%s\n", Num);
}

