#include <stdio.h>
#include <math.h>

// What is the largest prime factor of the 
// number 600851475143 ?



int main(){
  long fac, n;
  for(n = 600851475143, fac = 2; n != 1; ++fac)
    if (n % fac == 0) n /= fac;
  printf("%ld\n", fac - 1);
}
