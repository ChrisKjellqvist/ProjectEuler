package problems40_49;

import java.math.BigInteger;

public class Problem48 {
    public static void main(String args[]) {
        BigInteger big = new BigInteger("0");
        for (int x = 1; x <= 1000; x++) {
            big = big.add(BigInteger.valueOf(x).pow(x));
        }
        String a = big.toString();
        System.out.println(a.substring(a.length() - 19, a.length()));
    }
}
