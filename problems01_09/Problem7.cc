#include <stdio.h>
#include <vector>
#include <math.h>
#include <stdlib.h>
#include <string.h>

static std::vector<unsigned> PrimeList;
void doSieve(unsigned lim){
  char *SieveAr = (char *)malloc(sizeof(char)*lim);
  memset(SieveAr, 1, sizeof(char)*lim);
  SieveAr[0] = 0;
  SieveAr[1] = 0;
  unsigned roof = sqrt(lim);
  for(unsigned i = 2; i < lim; ++i){
    if (SieveAr[i]){
      for(unsigned j = i * i; j < lim; j+=i)
	SieveAr[j] = 0;
      PrimeList.push_back(i);
    }
  }
  free(SieveAr);
}

int main(){
  doSieve(1000000);
  printf("%d primes\n", PrimeList.size());
  printf("%d\n", PrimeList[10001]);
}
