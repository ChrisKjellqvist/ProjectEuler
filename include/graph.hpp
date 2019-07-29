#pragma once
#include <stdlib.h>
#include <vector>

class GraphState {
  public:
    virtual void insertEdge(long, long);
    virtual void removeEdge(long, long);
    virtual bool isConnected(long, long) const;
    virtual void getNeighbors(long, std::vector<long> &Neighbors) const;
    GraphState(size_t);
};

class IncidenceMatrix : public GraphState {
  private:
    bool **Connections;
    const size_t SZ;
  public:
    IncidenceMatrix (size_t Size) : SZ(Size){
      Connections = (bool**)malloc(sizeof(bool*)*Size);
      for(size_t i = 0; i < Size; ++i) {
	memset(Connections[i] = (bool*)malloc(sizeof(bool)*Size), 0, sizeof(bool)*Size);
    }

    IncidenceMatrix () = delete;

    void insertEdge(long A, long B){
      Connections[A][B] = Connections[B][A] = 1;
    }

    void removeEdge(long A, long B){
      Connections[A][B] = Connections[B][A] = 0;
    }
    
    bool isConnected(long A, long B){
      return Connections[A][B];
    }

    void getNeighbors(long A, std::vector<long> &Neighbors){
      for(size_t i = 0; i < A; ++i)
	if (Connections[A][i]) Neighbors.push_back(i);
      for(size_t i = A + 1; i < SZ; ++i)
	if (Connections[A][i]) Neighbors.push_back(i);
    }
};

template <class T : public GraphState>
class Graph{
  private:
    T *GS;
  public:
    Graph (size_t sz) {
      GS = new T(sz); 
    }
};
