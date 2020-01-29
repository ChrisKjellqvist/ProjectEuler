#pragma once
#include <vector>
#include <inttypes.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

// Sieve of Eratosthenes
inline void
getPrimes(std::vector<long> *Primes, 
    long Limit){
  char *PrimeAr = (char*)malloc(sizeof(char)*Limit);
  memset(PrimeAr, 1, sizeof(bool)*Limit);
  long I;
  for(I = 2; I < sqrt(Limit); ++I){
    if(PrimeAr[I]){
      Primes->push_back(I);
      for(long J = I*I; J < Limit; J += I)
	PrimeAr[J] = 0;
    }
  }
  for(; I < Limit; ++I)
    if (PrimeAr[I]) Primes->push_back(I);
}


// For each current factor in divisor list, multiply it by the
// current power of prime being accumulated.
// So for divisors <1, 2> of 18, the next prime will be 3.
// In the DOCP list you will first push back <1, 2> * 3
// and then <1, 2> * 9. Then merge the lists and continue
// for the next prime divisor.
void
getDivisors(std::vector<long> &Divisors,
    std::vector<long> &Primes, long N){
  long NSave = N;
  Divisors.push_back(1);
  std::vector<long> DivisorsOfCurrentPrime;
  for (long Prime : Primes){
    if (N == 1) break;
    if (N % Prime != 0) continue;
    long Accum = Prime;
    for(; N % Prime == 0; N /= Prime, Accum *= Prime)
      for(long Divisor : Divisors) {
	DivisorsOfCurrentPrime.push_back(Divisor * Accum);
      }
    for(long DOCP : DivisorsOfCurrentPrime)
      Divisors.push_back(DOCP);
    DivisorsOfCurrentPrime.clear();
  }
}
