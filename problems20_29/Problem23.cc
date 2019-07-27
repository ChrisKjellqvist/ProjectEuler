// Completed by Chris on Fri, 26 Dec 2014, 09:33

// Find the sum of all numbers that can't be described as the sum
// of two abundant numbers. All numbers over 28123 can be written
// this way.

#include "../include/primes.hpp"
#include <stdio.h>
#include <string.h>

#define LIM 28124

std::vector<long> Primes;

bool isAbundant(long N){
  std::vector<long> Divisors;
  getDivisors(Divisors, Primes, N);
  Divisors.pop_back();
  long Sum = 0;
  for(long Div : Divisors){
    Sum += Div;
  }
  return Sum > N;
}

int main(){
  getPrimes(Primes, 10000000);
  std::vector<long> Abundants;
  for(int i = 2; i < LIM; ++i)
    if (isAbundant(i)) Abundants.push_back(i);
  bool CanBeWritten[LIM];
  memset(CanBeWritten, 0, LIM);
  for(size_t i = 0; i < Abundants.size(); ++i){
    long Ab1 = Abundants[i];
    for(size_t j = i; j < Abundants.size() && (Ab1 + Abundants[j]) < LIM;
	++j){
      long Ab2 = Abundants[j];
      CanBeWritten[Ab1 + Ab2] = 1;
    }
  }
  long Sum = 0;
  for(size_t i = 0; i < LIM; ++i)
    if (!CanBeWritten[i])
      Sum += i;
  printf("%lu\n", Sum);
}
