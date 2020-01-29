#include "../include/primes.hpp"
#include <stdio.h>
#include <assert.h>
#include <algorithm>
#include <chrono>
#include <iostream>

inline int split(int x){
  int x_a = 0;
  x_a |= 1 << (x % 10);
  x /= 10;
  x_a |= 1 << (x % 10);
  x /= 10;
  x_a |= 1 << (x % 10);
  x /= 10;
  x_a |= 1 << (x % 10);
  return x_a;
}

std::vector<long> filtered;
int main(){
  // CLOCK
  auto start = std::chrono::steady_clock::now();


  std::vector<long> primes;
  primes.reserve(2048);
  filtered.reserve(2048);
  getPrimes(&primes, 10000); 
  for(long pr: primes) {
    if (pr > 1000)
      filtered.push_back(pr);
  }
  bool found_first = false;
  unsigned sz = filtered.size();
  int dist;
  for(unsigned i = 0; i < sz; ++i){
    int i_num = filtered[i];
    int i_rep = split(i_num);
    int break_distance = (10000 - i_num) >> 1;
    for(unsigned j = i+1; j < sz; ++j){
      int j_num = filtered[j];
      int j_rep = split(j_num);
      if ((dist = j_num - i_num) > break_distance) break;
      if (i_rep != j_rep) continue;
      unsigned k_num = j_num + dist;
      int k_rep = split(k_num);
      if(k_rep != j_rep) continue;
      if(!std::binary_search(filtered.begin() + i, filtered.end(), k_num)) continue;
      printf("%d %d %d\n", i_num, j_num, k_num);
      if (found_first)
	goto end;
      found_first = true;
    }
  }
end:
    auto end = std::chrono::steady_clock::now();
    auto elapsed = std::chrono::duration_cast<std::chrono::microseconds>(end - start);
    std::cout << "It took me " << elapsed.count() << " microseconds." << std::endl;

}
