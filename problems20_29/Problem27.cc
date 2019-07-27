#include "../include/primes.hpp"

public class Problem27 {
    static ArrayList<Integer> primes = sieve(200000);

    public static void main(String args[]) {
        int h = 0;
        int n = 0;
        final long t1 = System.currentTimeMillis();
        for (int k = -1; k < 2; k += 2) {
            for (int j = 10; j <= 167; j++) {
                for (int l = 10; l <= 167; l++) {
                    int a = k * primes.get(j);
                    int b = primes.get(l);
                    int c = getLength(a, b);
                    if (c > h) {
                        h = c;
                        n = a * b;
                    }
                }
            }

        }
        final long t2 = System.currentTimeMillis();
        System.out.println(n);
        System.out.println(t2 - t1);
    }

    public static int getLength(int n, int m) {
        int l = 0;
        while (true) {
            if (primes.contains(evalQuadratic(n, m, l))) {
                l++;
            } else {
                return l;
            }
        }
    }

    public static int evalQuadratic(int a, int b, int n) {
        return (n * n + a * n + b);
    }

    public static ArrayList<Integer> sieve(int n) {
        ArrayList<Boolean> primes = new ArrayList<Boolean>();
        for (int i = 0; i < n; i++) {
            primes.add(true);
        }
        primes.set(0, false);
        primes.set(1, false);
        for (int i = 2; i < n; i += 1) {
            if (primes.get(i)) {
                for (int j = i * 2; j < n; j += i) {
                    primes.set(j, false);
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int k = 0; k < n; k++) {
            if (primes.get(k)) {
                answer.add(k);
            }
        }
        return answer;
    }
}
