#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <vector>
#define _MAX 1000001 
std::vector<int> **factor_list;

// 0 is prime, 1 is not-prime
void get_prime_factors(){
  int* ar = (int*)malloc(sizeof(int)*_MAX);
  memset(ar, 0, sizeof(int)*_MAX);
  for(int i = 2; i < _MAX; ++i){
    if (ar[i] == 1)
      continue;
    for(int j = i << 1; j < _MAX; j+=i){
      ar[j] = 1;
      factor_list[j]->push_back(i);
    }
  }
}

unsigned long long get_num_coprimes(int q){
  unsigned long long n = 1, d = 1;
  if(factor_list[q]->size() == 0)
    return q-1;
  for(int fac: *(factor_list[q])){
    n *= fac-1;
    d *= fac;
  }
  unsigned long long a = q*n/d;
  return a;
}
int main(){
  factor_list = (std::vector<int>**)malloc(sizeof(std::vector<int>*)*_MAX);
  for(int i = 0; i < _MAX; ++i)
    factor_list[i] = new std::vector<int>;
  get_prime_factors();
  unsigned long long sum = 0;
  for(int i = 2; i < _MAX; ++i){
    sum += get_num_coprimes(i);
  }
  printf("%llu\n", sum);
}
