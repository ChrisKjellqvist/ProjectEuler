package problems1_9;

/**
 * @author chris
 *         <p/>
 *         <p/>
 *         A palindromic number reads the same both ways. The largest palindrome
 *         made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *         <p/>
 *         Find the largest palindrome made from the product of two 3-digit
 *         numbers.
 */
public class Problem4 {
    public static void main(String[] args) {
        int highest = 0;
        final long t1 = System.currentTimeMillis();
        for (int a = 100; a < 1000; a++) {
            for (int b = a + 1; b < 1000; b++) {
                if (isPalindrome(Integer.toString(a * b))) {
                    if (a * b > highest) {
                        highest = a * b;
                    }
                }
            }
        }
        final long t2 = System.currentTimeMillis();
        System.out.println(highest);
        System.out.println("Execution time: " + (double) (t2 - t1) / 1000);
    }

    static boolean isPalindrome(String cheese) {
        String reverse = "";
        for (int i = 0; i < cheese.length(); i++) {
            reverse += cheese.substring(cheese.length() - 1 - i,
                    cheese.length() - i);
        }
        return reverse.equals(cheese);
    }
}
