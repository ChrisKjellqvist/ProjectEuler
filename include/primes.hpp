#pragma once
#include <vector>
#include <inttypes.h>
#include <stdlib.h>
#include <math.h>

void
getPrimes(std::vector<long> &Primes, 
    long Limit){
  char *PrimeAr = (char*)malloc(sizeof(char)*Limit);
  memset(PrimeAr, 1, sizeof(bool)*Limit);
  long I;
  for(I = 2; I < sqrt(Limit); ++I){
    if(PrimeAr[I]){
      Primes.push_back(I);
      for(long J = I*I; J < Limit; J += I)
	PrimeAr[J] = 0;
    }
  }
  for(; I < Limit; ++I)
    if (PrimeAr[I]) Primes.push_back(I);
}
