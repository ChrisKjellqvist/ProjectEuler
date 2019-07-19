package problems50_59;

import java.util.ArrayList;

public class Problem50 {
    public static void main(String[] args) {
        int highest = 0;
        int highestterms = 0;
        int lim = 1000000;
        ArrayList<Integer> primes = sieve(lim * 20);
        System.out.println("starting now");
        int t = 0;
        for (int i = 0; i < primes.size(); i++) {
            if (primes.get(i) > lim) {
                t = i;
                break;
            }
        }
        for (int i = 0; i < t; i++) {
            int current = 0;
            int nterms = 0;
            int j = 0;
            while (current < lim) {
                current += primes.get(j + i);
                nterms++;
                if (nterms > highestterms) {
                    if (primes.contains(current)) {
                        highest = current;
                        highestterms = nterms;
                    }
                }
                j++;
            }
        }
        System.out.println(highest);
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
