/**
 * Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of numbers
 * less than n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and
 * relatively prime to nine, φ(9)=6.n 	Relatively Prime 	φ(n) 	n/φ(n)It can be seen that n=6 produces a maximum
 * n/φ(n) for n ≤ 10.Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
 */
package problems60_69;

import java.util.ArrayList;

public class Problem69 {
    static ArrayList<Integer> primes = sieve(1000000);

    static double phi(double n) {
        if (primes.contains(n)) {
            return n;
        }
        double phi = n;
        int count = 0;
        while (n != 1) {
            int c = primes.get(count);
            if (n % c == 0) {
                phi /= c;
                phi *= (c - 1);
                while (n % c == 0) {
                    n /= c;
                }
            }
            count++;
        }

        return phi;
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

    public static void main(String[] args) {
        double highest = 0;
        double n = 0;
        for (double i = 6; i <= 1000000; i += 6) {
            double nPhi = i / phi(i);
            if (nPhi > highest) {
                highest = nPhi;
                n = i;
            }
            if (i % 100000 == 0) {
                System.out.println(i);
            }

        }
        System.out.println(n + " has the highest totient maximum of " + highest);
    }
}
