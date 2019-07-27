// Originally completed by Chris on 2/28/15

#include "../include/primes.hpp"

std::vector<long> Primes;
long getSumOfDivisors(long N){
  std::vector<long> Divisors;
  getDivisors(Divisors, Primes, N);
  Divisors.pop_back();
  long Sum = 0;
  for(long Divisor : Divisors)
    Sum += Divisor;
  return Sum;
}

int main(){
  getPrimes(Primes, 1000000);
  long *ArrayOfDSums = (long*)malloc(sizeof(long)*10000);
  for(int i = 1; i < 10000; ++i)
    ArrayOfDSums[i] = getSumOfDivisors((long)i);
  int Sum = 0;
  for(int i = 1; i < 10000; ++i){
    long Q = ArrayOfDSums[i];
    if (Q == 0)
      Q = getSumOfDivisors(i);
    long I = ArrayOfDSums[Q];
    if (I == 0)
      I = getSumOfDivisors(Q);
    if (I == i && I != Q) {
      Sum += i;
    }
  }
  printf("%d\n", Sum);
}
