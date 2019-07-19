/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
package problems30_39;

public class Problem34 {
    public static void main(String args[]) {
        int finalsum = 0;
        int lim = 2540160;
        for (int i = 10; i <= lim; i++) {
            if (isSum(i)) {
                finalsum += i;
            }
        }
        System.out.println(finalsum);
    }

    static boolean isSum(int n) {
        String temp = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < temp.length(); i++) {
            sum += factorial(Integer.parseInt(temp.substring(i, i + 1)));

        }
        return sum == n;
    }

    static int factorial(int n) {
        int a = 1;
        if (n == 0) return 1;
        if (n < 3) return n;
        else {
            for (int i = 2; i <= n; i++) {
                a *= i;
            }
        }
        return a;
    }
}
