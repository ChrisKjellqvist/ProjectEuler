package problems60_69;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chris on 5/28/15.
 */
public class Problem60 {
    //GLOBAL VARIABLES
    static final int ceiling = 100000;
    static final ArrayList<Integer> primes = sieve(ceiling);
    static final int arrayLength = primes.size() - 1;

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
        return returning;
    }

    public static boolean isPrimePairSet(int[] set) {
        return true;
    }

    public static void main(String[] args) {
        int[] numbers = new int[5];
        primes.remove(0);
        System.out.println(primes);
        for (int a = 0; a < arrayLength; a++) {
            numbers[0] = primes.get(a);
            for (int b = 0; b < a; b++) {
                numbers[1] = primes.get(b);
                for (int c = 0; c < b; c++) {
                    numbers[2] = primes.get(c);
                    for (int d = 0; d < c; d++) {
                        numbers[3] = primes.get(d);
                        for (int e = 0; e < d; e++) {
                            numbers[4] = primes.get(e);

                        }
                    }
                }
            }
        }
    }
}
