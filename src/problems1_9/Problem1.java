package problems1_9;

/**
 * Created by chris on 2/28/15.
 * If we list all the natural numbers below 10 that are multiples of 3
 * or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * <p/>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem1 {
    public static void main(String[] args) {
        System.out.println(findSum(3, 5, 1000));
    }

    public static int findSum(int a, int b, int lim) {
        int count = 1;
        int sum = 0;
        while (count < lim) {
            if (count % a == 0 || count % b == 0) {
                sum += count;
            }
            count++;
        }
        return sum;
    }
}

