package problems30_39;

import java.util.ArrayList;

public class Problem37 {

    static ArrayList<Integer> primes = sieve(1000000);

    public static ArrayList<Integer> sieve(int n) {
        ArrayList<Boolean> boolPrimes = new ArrayList<Boolean>();
        for (int i = 0; i < n; i++) {
            boolPrimes.add(true);
        }
        int count = 2;
        while (count < n) {
            for (int i = 2; i < n / count; i++) {
                boolPrimes.set(count * i, false);
            }
            count++;
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 2; i < n; i++) {
            if (boolPrimes.get(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static boolean isTruncatableBackwards(int n) {
        int log = (int) Math.log10(n);
        for (int i = 1; i <= log; i++) {
            if (!primes.contains(n / (int) Math.pow(10, i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTruncatableForwards(int n) {
        String nString = Integer.toString(n);
        for (int i = 1; i < nString.length(); i++) {
            if (!primes.contains(Integer.parseInt(nString.substring(i, nString.length())))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 0;
        int count = 4;
        int sum = 0;
        while (n < 11) {
            int current = primes.get(count);
            if (isTruncatableBackwards(current) && isTruncatableForwards(current)) {
                n++;
                sum += current;
                System.out.println(current);
            }
            count++;
        }
        System.out.println(sum);
    }
}
