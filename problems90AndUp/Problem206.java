package problems90AndUp;

import java.math.BigInteger;

/**
 * Created by chris on 3/2/15.
 */
public class Problem206 {
    static char[] list = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    public static void main(String[] args) {
        for (long i = 1010101010; i < 1389026623; i += 10) {
            BigInteger a = BigInteger.valueOf(i);
            a = a.pow(2);
            if (works(a)) {
                System.out.println(i + " squared equals " + a);
            }
        }
    }

    public static boolean works(BigInteger i) {
        String a = i.toString();
        for (int b = 0; b <= 9; b++) {
            if (a.charAt(b * 2) != list[b]) {
                return false;
            }
        }
        return true;
    }
}
