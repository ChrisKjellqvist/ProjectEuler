/**
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 * <p/>
 * 1634 = 14 + 64 + 34 + 44
 * 8208 = 84 + 24 + 04 + 84
 * 9474 = 94 + 44 + 74 + 44
 * <p/>
 * As 1 = 14 is not a sum it is not included.
 * <p/>
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * <p/>
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
package problems30_39;

public class Problem30 {
    public static void main(String args[]) {
        int sum = 0;
        for (int x = 2; x < 200000; x++) {
            int intermediary = 0;
            String a = Integer.toString(x);
            for (int i = 0; i < a.length(); i++) {
                intermediary += Math.pow(Integer.parseInt(a.substring(i, i + 1)), 5);
            }
            if (intermediary == x) {
                sum += x;
                System.out.println(x);

            }
        }
        System.out.println(sum);
    }
}
