package problems40_49;

import java.util.ArrayList;

public class Problem49 {
    static ArrayList<Integer> primes = sieve(10000);

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
        int size = primes.size();
        int lowerlim = 0;
        System.out.println(isPermutationOf(6299, 9926));
        for (int i = 0; i < size; i++) {
            if (primes.get(i) > 1000) {
                lowerlim = i;
                break;
            }
        }

        for (int i = lowerlim; i < size; i++) {
            for (int j = lowerlim + 1; j < size; j++) {
                while (j <= i) {
                    j++;
                }
                if (j >= size) {
                    break;
                }
                int primea = primes.get(i);
                int primeb = primes.get(j);
                int n = primeb + (primeb - primea);
                if (primes.contains(n)) {
                    if (n == 9629) {
                    }
                    if (isPermutationOf(primea, primeb) && isPermutationOf(primea, n)) {
                        System.out.println(primea + "" + primeb + "" + n);
                    }
                }
            }
        }
    }

    static boolean isPermutationOf(int a, int b) {
        int[] achars = new int[4];
        int[] bchars = new int[4];
        for (int i = 0; i < 4; i++) {
            achars[i] = subString(a, i, i + 1);
        }
        for (int i = 0; i < 4; i++) {
            bchars[i] = subString(b, i, i + 1);
        }
        boolean found;
        for (int i = 0; i < 4; i++) {
            found = false;
            for (int j = 0; j < 4; j++) {
                if (achars[i] == bchars[j] && !found) {
                    found = true;
                    bchars[j] = -1;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;

    }

    public static int subString(int n, int a, int b) {
        int size = (int) Math.log10(n) + 1;
        int x = n / pow(10, size - a);
        n -= x * pow(10, size - a);
        n /= pow(10, (size - a) - (b - a));
        return n;
    }

    public static int pow(int a, int b) {
        int acc = 1;
        for (int i = 0; i < b; i++) {
            acc *= a;
        }
        return acc;
    }
}
