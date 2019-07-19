package problems50_59;

import java.math.BigInteger;

public class Problem57 {
    static BigInteger numerator = new BigInteger("3");
    static BigInteger denominator = new BigInteger("2");

    public static void main(String[] args) {
        final long t1 = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 999; i++) {
            BigInteger store = denominator;
            denominator = numerator.add(store);
            numerator = denominator.add(store);
            if (numerator.toString().length() > denominator.toString().length()) {
                count++;
            }
        }
        final long t2 = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(t2 - t1);

    }
}