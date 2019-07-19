package problems50_59;

/**
 * There are exactly ten ways of selecting three from five, 12345:
 * <p/>
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 * <p/>
 * In combinatorics, we use the notation, 5C3 = 10.
 * <p/>
 * In general, nCr = n! r!(n−r)! ,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! =
 * 1.
 * <p/>
 * It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 * <p/>
 * How many, not necessarily distinct, values of nCr, for 1 ≤ n ≤ 100, are
 * greater than one-million?
 *
 * @author chris
 */
public class Problem53 {
    public static void main(String[] args) {
        int count = 0;
        final long t1 = System.currentTimeMillis();
        for (int n = 23; n <= 100; n++) {
            for (int r = n; r >= 0; r--) {
                if (ChooseExceedsMillion(n, r)) {
                    count++;
                }
            }
        }
        final long t2 = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(t2 - t1);

    }

    /**
     * The smart thing about this program is that it doesn't work out what the
     * value of the choose expression is, it just sees if it's above a million.
     * <p/>
     * Since choose is defined as n!/(r!(n-r)!), we can break it up into 1/(r!)
     * * (n!/(n-r)!) The first for loop does 1/(r!) And since the second part of
     * the expression overlaps because of the nature of factorials, you can just
     * multiply all numbers in the range of ((n-r),n]. Lastly, since the second
     * expression will only increase the value of the expression, there is no
     * need to worry once it passes one million, it will not go back down.
     * That's why I check for one million every pass around, so that I won't
     * waste computing time once it's already fulfilled the parameters.
     *
     * @param n
     * @param r
     * @return
     */
    public static boolean ChooseExceedsMillion(int n, int r) {
        double c = 1;
        for (int i = 2; i <= r; i++) {
            c /= i;
        }
        for (int i = n - r + 1; i <= n; i++) {
            c *= i;
            if (c > 1000000) {
                return true;
            }
        }
        return false;
    }
}
