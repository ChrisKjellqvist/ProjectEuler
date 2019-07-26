#include "../include/primes.hpp"
#include <stdio.h>

int main(){
  std::vector<long> Primes;
  getPrimes(Primes, 2000000);
  long Sum = 0;
  for(long P : Primes)
    Sum += P;
  printf("%lu\n", Sum);
}
