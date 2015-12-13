package problems1_9;

/**
 * The sum of the squares of the first ten natural numbers is, 12 + 22 + ... +
 * 102 = 385
 * <p/>
 * The square of the sum of the first ten natural numbers is, (1 + 2 + ... +
 * 10)2 = 552 = 3025
 * <p/>
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 − 385 = 2640.
 * <p/>
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 *
 * @author chris
 */
public class Problem6 {
    public static void main(String[] args) {
        System.out.println(SquareSum(100) - sumSquare(100));
    }

    public static int sumSquare(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i * i;
        }
        return sum;
    }

    public static int SquareSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum * sum;
    }
}
