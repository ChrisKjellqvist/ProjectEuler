#include <stdio.h>
#include <string>
#include <vector>
#include <algorithm>

long getNameScore(std::string Str, int index){
  long Score = 0;
  for(char c : Str)
    Score += c - 'A' + 1;
  return Score * index;
}

int main(){
  std::vector<std::string> Names;
  char Buffer[32];
  while(scanf("%s", Buffer) != EOF) Names.push_back(std::string(Buffer));
  std::sort(Names.begin(), Names.end());

  long Result = 0;
  for(size_t i = 0; i < Names.size(); ++i)
    Result += getNameScore(Names[i], i + 1);
  printf("%lu\n", Result);
}
