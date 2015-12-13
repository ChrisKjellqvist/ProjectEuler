package problems10_19;

/**
 * @author chris
 *         <p/>
 *         <p/>
 *         The sequence of triangle numbers is generated by adding the natural
 *         numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 +
 *         7 = 28. The first ten terms would be:
 *         <p/>
 *         1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *         <p/>
 *         Let us list the factors of the first seven triangle numbers:
 *         <p/>
 *         1: 1 3: 1,3 6: 1,2,3,6 10: 1,2,5,10 15: 1,3,5,15 21: 1,3,7,21 28:
 *         1,2,4,7,14,28
 *         <p/>
 *         We can see that 28 is the first triangle number to have over five
 *         divisors.
 *         <p/>
 *         What is the value of the first triangle number to have over five
 *         hundred divisors?
 */
public class Problem12 {
    public static void main(String[] args) {
        int count = 0;
        while (numOfDivisors(triangle(count)) <= 500) {
            count++;
        }
        System.out.println(triangle(count));
    }

    public static int triangle(int n) {
        return (n * (n + 1)) / 2;
    }

    public static int numOfDivisors(int n) {
        int lim = (int) Math.ceil(Math.sqrt(n));
        int f = 1;
        int num = 0;
        while (f <= lim) {
            if (n % f == 0) {
                num += 2;
            }
            if (f * f == n) {
                num -= 1;
            }
            f++;
        }
        return num;
    }
}
