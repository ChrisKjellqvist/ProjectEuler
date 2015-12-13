package problems10_19;

import java.math.BigInteger;

public class Problem16 {
    public static void main(String[] args) {
        BigInteger val = new BigInteger("1");
        for (int i = 0; i < 1000; i++) {
            val = val.multiply(BigInteger.valueOf((long) 2));
        }
        String a = val.toString();
        int sum = 0;
        for (int i = 0; i < a.length(); i++) {
            sum += Integer.parseInt(a.substring(i, i + 1));
        }
        System.out.println(sum);
    }
}
