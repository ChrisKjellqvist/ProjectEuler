package problems60_69;

import java.math.BigInteger;

public class Problem63 {
    public static void main(String[] args) {
        final long t1 = System.currentTimeMillis();
        System.out.println(execute());
        final long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);

    }

    public static int execute() {
        final BigInteger NINE = new BigInteger("9");
        int currentPower = 1;
        int count = 0;
        while (length(NINE.pow(currentPower)) >= currentPower) {
            for (BigInteger i = new BigInteger("9"); i.compareTo(BigInteger.ONE) >= 0; i = i.subtract(BigInteger.ONE)) {
                if (length(i.pow(currentPower)) == currentPower) {
                    count++;
                }
            }
            currentPower++;
        }
        return count;
    }

    public static int length(BigInteger n) {
        int c = 0;
        for (BigInteger i = n; i.compareTo(BigInteger.ONE) != -1; i = i.divide(BigInteger.TEN)) {
            c++;
        }
        return c;
    }
}
