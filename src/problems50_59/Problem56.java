package problems50_59;

import java.math.BigInteger;

public class Problem56 {
    public static void main(String[] args) {
        int max = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int sum = digitSum(BigInteger.valueOf(i).pow(j));
                if (sum > max) max = sum;
            }
        }
        System.out.println(max);
    }

    public static int digitSum(BigInteger n) {
        String s = n.toString();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        return sum;
    }
}
