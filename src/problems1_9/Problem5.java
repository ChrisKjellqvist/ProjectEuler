package problems1_9;

import java.util.ArrayList;

/**
 * @author chris
 *         <p/>
 *         <p/>
 *         2520 is the smallest number that can be divided by each of the
 *         numbers from 1 to 10 without any remainder.
 *         <p/>
 *         What is the smallest positive number that is evenly divisible by all
 *         of the numbers from 1 to 20?
 */
public class Problem5 {
    public static void main(String[] args) {
        System.out.println(findSmallestMultiple(20));
    }

    static int findSmallestMultiple(int n) {
        int[] hasDone = new int[n];
        int multiple = 1;
        for (int i = 2; i <= n; i++) {
            int[] thresh = new int[i + 1];
            ArrayList<Integer> factors = factorize(i);
            for (int j = 0; j < factors.size(); j++) {
                if (thresh[factors.get(j)] >= hasDone[factors.get(j)]) {
                    multiple *= factors.get(j);
                    hasDone[factors.get(j)]++;
                }
                thresh[factors.get(j)]++;
            }
        }
        return multiple;

    }

    public static ArrayList<Integer> factorize(Integer n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int ch = n;
        int count = 2;
        while (ch != 1) {
            if (ch % count == 0) {
                ch /= count;
                list.add(count);
            } else {
                count++;
            }
        }
        return list;
    }
}
