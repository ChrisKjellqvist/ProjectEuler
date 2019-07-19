package problems20_29;

import java.math.BigInteger;

/**
 * Created by chris on 2/28/15.
 */
public class Problem25 {
    public static void main(String[] args) {
        BigInteger num1 = new BigInteger("1");
        BigInteger num2 = new BigInteger("1");
        int count = 2;
        while (num2.toString().length() != 1000) {
            BigInteger temp = num2.add(num1);
            num1 = num2;
            num2 = temp;
            count++;
        }
        System.out.println(count);
    }
}
