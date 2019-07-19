package problems40_49;

import java.util.ArrayList;

/**
 * Goldbach's other conjecture
 * Problem 46
 * <p/>
 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
 * <p/>
 * 9 = 7 + 2×1^2
 * 15 = 7 + 2×2^2
 * 21 = 3 + 2×3^2
 * 25 = 7 + 2×3^2
 * 27 = 19 + 2×2^2
 * 33 = 31 + 2×1^2
 * <p/>
 * It turns out that the conjecture was false.
 * <p/>
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */


public class Problem46 {
    static final int PRIMELIM = 6000;
    static ArrayList<Boolean> useful;
    static final ArrayList<Integer> primes = sieve(PRIMELIM);
    static final ArrayList<Integer> composites = comp(PRIMELIM);

    public static void main(String args[]) {
        long t1 = System.currentTimeMillis();
        for (int composite : composites) {
            boolean check = false;
            for (int sq = 1; sq * sq * 2 + 2 < composite; sq++) {
                if (primes.contains(composite - 2 * sq * sq)) {
                    sq = sq * sq * 5;
                    check = true;
                }
            }
            if (!check) {
                System.out.println(composite);
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }


    public static ArrayList<Integer> comp(int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 3; i < n; i += 2) {
            if (!useful.get(i)) {
                ans.add(i);
            }
        }
        return ans;
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
        useful = primes;
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int k = 0; k < n; k++) {
            if (primes.get(k)) {
                answer.add(k);
            }
        }
        return answer;
    }
}
