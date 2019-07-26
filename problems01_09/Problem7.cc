#include "../include/primes.hpp"
#include <stdio.h>

int main(){
  std::vector<long> Primes;
  getPrimes(Primes, 1000000);
  printf("%lu\n", Primes.size());
  printf("%lu\n", Primes[10001]);
}
