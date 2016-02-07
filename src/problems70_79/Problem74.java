package problems70_79;

import java.util.ArrayList;

/**
 * Created by chris on 12/26/15.
 */
public class Problem74 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 1000000; i++) {
            if (findChainLength(i) == 60) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static int factorial(int n) {
        int acc = 1;
        for (int i = 2; i <= n; i++) {
            acc *= i;
        }
        return acc;
    }

    public static int digitFactorialSum(String str) {
        int sum = 0;
        char[] ar = str.toCharArray();
        for (char a : ar) {
            sum += factorial(Character.getNumericValue(a));
        }
        return sum;
    }

    public static int findChainLength(int n) {
        ArrayList<Integer> previousOccurences = new ArrayList<>();
        int len = 0;
        while (!previousOccurences.contains(n)) {
            previousOccurences.add(n);
            n = digitFactorialSum(Integer.toString(n));
            len++;
        }
        return len;
    }
}