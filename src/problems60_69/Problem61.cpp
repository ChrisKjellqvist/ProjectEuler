//
//  main.cpp
//  testytest
//
//  Created by Chris Kjellqvist on 6/7/16.
//  Copyright © 2016 Chris Kjellqvist. All rights reserved.
//

#include <iostream>
#include <vector>
#include <math.h>


std::vector<int> primeSieve(int lim){
    std::vector<int> primes;
    bool boolAr[lim];
    boolAr[0]=true;
    boolAr[1]=true;
    for (int i = 0; i<lim; i++) {
        if(!boolAr[i]){
            primes.push_back(i);
            for (int j = 2*i; j<lim; j+=i) {
                boolAr[j]=true;
            }
        }
    }
    return primes;
}
bool isPrime(std::vector<int>* primes, long n){
    int c;
    for(int i = 0; (c = primes->at(i))<sqrt(n); i++){
        if (n%c==0) {
            return false;
        }
    }
    return true;
}

bool areConcatenationsPrimes(long a, long b, std::vector<int> *primes, int largest){
    long concatAB = pow(10,ceil(log10(b)))*a+b;
    long concatBA = pow(10,ceil(log10(a)))*b+a;
    if (concatAB>largest || concatBA > largest) {
        if (isPrime(primes, concatAB) && isPrime(primes, concatBA)) {
            return true;
        } else {
            return false;
        }
    }

    if (std::binary_search(primes->begin(), primes->end(), concatAB)) {
        if (std::binary_search(primes->begin(), primes->end(), concatBA)) {
            return true;
        }
    }
    return false;
}

bool allConcat(int* ar, int l,std::vector<int>* primes){
    for (int i = 0; i<l-1; i++) {
        if (!areConcatenationsPrimes(ar[i], ar[l-1], primes, primes->at(primes->size()-1))) {
            return false;
        }
    }
    return true;
}

int sumAr(int* ar, int l){
    int sum = 0;
    for (int i = 0; i < l; i++) {
        sum+=ar[i];
    }
    return sum;
}
int main(int argc, const char * argv[]) {
    std::vector<int> primes = primeSieve(1000000);
    int lim = (int)primes.size()/5;
    int primeAr[5];
    int currentSum = 1000000;
    for (int i = 1; i<8; i++) {
        std::cout << i << "/" << lim << std::endl;
        primeAr[0] = primes.at(i);
        for (int j = i+1; j<lim; j++) {
            primeAr[1] = primes.at(j);
            if (allConcat(primeAr, 2, &primes)) {
                for (int k = j+1; k< lim; k++) {
                    primeAr[2] = primes.at(k);
                    if (allConcat(primeAr, 3, &primes)) {
                        for (int l = k+1; l<lim; l++) {
                            primeAr[3] = primes.at(l);
                            primeAr[4] = primeAr[3];
                            if(sumAr(primeAr, 5)<currentSum){
                            if (allConcat(primeAr, 4, &primes)) {
                                for (int m = l+1; m<lim; m++) {
                                    primeAr[4] = primes.at(m);
                                    if(sumAr(primeAr, 5)<currentSum){
                                        if (allConcat(primeAr, 5, &primes)) {
                                            std::cout << primeAr[0] << " " << primeAr[1] << " " << primeAr[2] << " " << primeAr[3] << " " << primeAr[4] << std::endl;
                                            currentSum = sumAr(primeAr, 5);
                                            std::cout << "sum: " << currentSum << std::endl;
                                        }
                                    }
                                }
                            }
                            }
                        }
                    }
                }
            }
        }
    }
    return 0;
}
