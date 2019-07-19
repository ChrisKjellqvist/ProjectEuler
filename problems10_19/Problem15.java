package problems10_19;

import java.math.BigInteger;

public class Problem15 {
    public static void main(String[] args) {
        BigInteger a = factorial(40);
        a = a.divide(factorial(20).multiply(factorial(20)));
        System.out.println(a);
    }

    public static BigInteger factorial(int n) {
        BigInteger acc = new BigInteger("1");
        for (int i = 2; i < n; i++) {
            acc = acc.multiply(BigInteger.valueOf((long) i));
        }
        return acc;
    }
}
