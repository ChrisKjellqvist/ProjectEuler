package problems20_29;

import java.math.BigInteger;

/**
 * Created by chris on 2/28/15.
 */
public class Problem20 {
    public static void main(String[] args) {
        BigInteger big = new BigInteger("1");
        for (int i = 2; i <= 100; i++) {
            big = big.multiply(BigInteger.valueOf((long) i));
        }
        String cheese = big.toString();
        int sum = 0;
        for (int i = 0; i < cheese.length(); i++) {
            sum += Character.getNumericValue(cheese.charAt(i));
        }
        System.out.println(sum);
    }
}
