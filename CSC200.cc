#include "include/primes.hpp"

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

int main(){
  std::vector<long> primes;
  getPrimes(&primes, 10000); 
  std::vector<long> filtered;
  for(long pr: primes) {
    if (pr > 1000)
      filtered.push_back(pr);
  }
  bool found_first = false;

  unsigned sz = filtered.size();
  for(unsigned i = 0; i < sz; ++i){
    int i_num = filtered[i];
    int i_f = split(i_num);
    for(unsigned j = i+1; j < sz; ++j){
      int j_num = filtered[j];
      int j_f = split(j_num);
      if (i_f != j_f) continue;
      for(unsigned k = j +1; k < sz; ++k){
        int k_num = filtered[k];
        if ((k_num - j_num) != (j_num - i_num))
            continue;
        int k_f = split(k_num);
        if(k_f != j_f) continue;
        printf("%d %d %d\n", i_num, j_num, k_num);
        if (found_first)
          return 0;
        found_first = true;
      }
    }
  }

}
