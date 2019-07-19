package problems30_39;

import java.util.ArrayList;

public class Problem35 {
    final static int LIM = 1000000;
    static ArrayList<Integer> primes = sieve(LIM);

    public static void main(String args[]) {
        int count = 0;
        for (int i = 0; i < primes.size(); i++) {
            if (isCircular(primes.get(i))) {
                count++;
            }
            if (i % 10000 == 0) {
                System.out.println(i);
            }
        }
        System.out.println("The count is " + count);
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

    public static boolean isCircular(int n) {
        StringBuffer o = new StringBuffer();
        o.append(n);
        for (int i = 0; i < o.length(); i++) {
            String h = o.substring(0, 1);
            o.append(h);
            o.delete(0, 1);
            if (!primes.contains(Integer.parseInt(o.toString()))) {
                return false;
            }
        }
        return true;
    }
}
