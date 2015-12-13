package problems40_49;

import java.util.ArrayList;

public class Problem41 {
    static ArrayList<Boolean> currentlyDone = new ArrayList<Boolean>();
    static boolean hasDone = false;

    public static ArrayList<Integer> sieve(int lim) {
        boolean[] nums = new boolean[lim];
        for (int i = 0; i < lim; i++) {
            nums[i] = true;
        }
        nums[0] = false;
        nums[1] = false;
        for (int i = 2; i < lim; i++) {
            if (nums[i] == true) {
                int j = 2;
                int p = i * j;
                while (p < lim) {
                    nums[p] = false;
                    j++;
                    p = i * j;
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == true) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        ArrayList<Integer> primes = sieve(9999999);
        System.out.println("Done generating primes");
        for (int i = primes.size() - 1; i >= 0; i--) {
            if (PandigitalToN(Integer.toString(primes.get(i)))) {
                System.out.println(primes.get(i));
                break;
            }
        }
    }

    public static boolean isPrime(int n) {
        if (!hasDone) {
            for (int i = 0; i <= n; i++) {
                currentlyDone.add(true);
            }
            currentlyDone.set(0, false);
            currentlyDone.set(1, false);
            for (int i = 2; i < n; i++) {
                if (currentlyDone.get(i)) {
                    int ele = 4;
                    while (ele < n) {
                        currentlyDone.set(ele, false);
                        ele += i;
                    }
                }
            }
            return currentlyDone.get(n);
        } else {
            return currentlyDone.get(n);
        }
    }

    public static boolean PandigitalToN(String a) {
        boolean[] numbers = new boolean[9];
        for (int i = 0; i < a.length(); i++) {
            int val = Character.getNumericValue(a.charAt(i));
            if (val == 0) {
                return false;
            } else if (numbers[val - 1]) {
                return false;
            } else if (val > a.length()) {
                return false;
            } else {
                numbers[val - 1] = true;
            }
        }
        return true;
    }
}
