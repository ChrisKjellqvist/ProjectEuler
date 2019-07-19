#include <stdio.h>

int isPalindrome(unsigned n){
  char num_storage[16]; // should be < 16 digit number
  unsigned count = 0;
  while(n){
    num_storage[count++] = n%10;
    n/=10;
  }
  for(unsigned i = 0; i < count/2;++i)
    if (num_storage[i] != num_storage[count-i-1])
      return 0;
  return 1;
}

int main(){
  int highest = 0;
  for(int i = 100; i < 1000; ++i){
    for(int j = i; j < 1000; ++j){
      if (i*j > highest && isPalindrome(i*j))
	highest = i*j;
    }
  }
  printf("%d\n", highest);
}
