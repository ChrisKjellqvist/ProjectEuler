#pragma once
#include <stdio.h>

// Currently only supports positive numbers.
class BigDouble {
  private:
    double mantissa;
    long exponent;
  public:
    BigDouble (){
      mantissa = 0;
      exponent = 0;
    }

    BigDouble (double f){
      exponent = 0;
      while (f > 10){
        f /= 10;
        ++exponent;
      }
      mantissa = f;
    }

    BigDouble (BigDouble &rhs){
      exponent = rhs.exponent;
      mantissa = rhs.mantissa;
    }

    BigDouble (double m, long e){
      mantissa = m;
      exponent = e;
    }

    BigDouble operator * (double &rhs){
      double t = mantissa * rhs;
      long exp = exponent;
      while (t > 10) {
        ++exp;
        t /= 10;
      }
      while (t < 1) {
        --exp;
        t *= 10;
      }
      return BigDouble(t, exp);
    }

    BigDouble& operator *= (double &rhs){
      double t = mantissa * rhs;
      long exp = exponent;
      while (t > 10) {
        ++exp;
        t /= 10;
      }

      while (t < 1) {
        --exp;
        t *= 10;
      }
      mantissa = t;
      exponent = exp;
      return *this;
    }

    void print(){
      printf("%fe%ld", mantissa, exponent);
    }
};
