package problems90AndUp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chris on 12/27/15.
 */
public class Problem387 {
    static int lim = 100000000;
    static boolean[] rawArray;
    static final ArrayList<Integer> primes = sieve(lim);

    public static ArrayList<Integer> sieve(int lim) {
        int i, j;
        ArrayList<Integer> returning = new ArrayList<Integer>();
        boolean[] array = new boolean[lim];
        Arrays.fill(array, true);
        array[0] = false;
        array[1] = false;
        for (i = 0; i < lim; i++) {
            if (array[i]) {
                returning.add(i);
                for (j = 2 * i; j < lim; j += i) {
                    array[j] = false;
                }
            }
        }
        rawArray = array;
        return returning;
    }

    public static boolean isRightTruncatableHarshad(String n) {
        if (n.equals("")) return true;
        int sum = 0;
        for (char a : n.toCharArray()) {
            sum += Character.getNumericValue(a);
        }
        if (Integer.parseInt(n) % sum == 0) {
            return isRightTruncatableHarshad(n.substring(0, n.length() - 1));
        }
        return false;

    }

    public static boolean isStrongRightTruncatablePrime(int n) {
        if (n < 11) return false;
        int sum = 0;
        String num = Integer.toString(n);
        num = num.substring(0, num.length() - 1);
        n = Integer.parseInt(num);
        for (char a : num.toCharArray()) {
            sum += Character.getNumericValue(a);
        }
        if (!(n % sum == 0)) {
            return false;
        }
        if (rawArray[n / sum]) {
            return isRightTruncatableHarshad(num.substring(0, num.length() - 1));
        }
        return false;
    }

    public static void main(String[] args) {
        int sum = 0;
        for (int a : primes) {
            if (isStrongRightTruncatablePrime(a)) sum += a;
        }
        System.out.println(sum);
    }
}
