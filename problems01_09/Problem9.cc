#include <stdio.h>
#include <math.h>
int main(){
  for(int a = 1; a < 500; ++a){
    for(int b = a + 1; b < 500; ++b){
      int as = a * a;
      int bs = b * b;
      double sq = sqrt(as + bs);
      int cs = (int)sq * (int)sq;
      if (as + bs != cs) continue;
      if (a + b + (int)sq != 1000) continue;
      printf("\t%d %d %d\n", a, b, (int)sq);
      printf("%lu\n", (long)a*(long)b*(long)sq);
    }
  }
}
