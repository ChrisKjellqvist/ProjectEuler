package problems60_69;

import java.math.BigInteger;

/**
 * Created by chris on 4/26/15.
 */
public class Problem65 {
    public static void main(String[] args) {
        int[] divisors = new int[102];
        int i, j;
        for (i = 0; i < 34; i++) {
            for (j = 0; j < 3; j++) {
                int index = i * 3 + j;
                divisors[index] = 1;
                if (j == 1) {
                    divisors[index] = 2 * (i + 1);
                }
            }
        }
        BigInteger numerator = new BigInteger("1");
        BigInteger denominator = BigInteger.valueOf((long) divisors[98]);
        for (i = 97; i >= 0; i--) {
            numerator = numerator.add(denominator.multiply(BigInteger.valueOf((long) divisors[i])));
            BigInteger hold = numerator;
            numerator = denominator;
            denominator = hold;
        }
        numerator = numerator.add(denominator.multiply(BigInteger.valueOf((long) 2)));
        System.out.println(numerator);
        System.out.println(denominator);
        char[] a = numerator.toString().toCharArray();
        int sum = 0;
        for (char b : a) {
            sum += Character.getNumericValue(b);
        }
        System.out.println(sum);
    }
}
