package problems10_19;

/**
 * @author chris The following iterative sequence is defined for the set of
 *         positive integers:
 *         <p/>
 *         n → n/2 (n is even) n → 3n + 1 (n is odd)
 *         <p/>
 *         Using the rule above and starting with 13, we generate the following
 *         sequence: 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *         <p/>
 *         It can be seen that this sequence (starting at 13 and finishing at 1)
 *         contains 10 terms. Although it has not been proved yet (Collatz
 *         Problem), it is thought that all starting numbers finish at 1.
 *         <p/>
 *         Which starting number, under one million, produces the longest chain?
 */
public class Problem14 {
    public static void main(String[] args) {
        long highestchainlength = 0;
        long highestchainstartingvalue = 0;
        long length = 0;
        for (long i = 11; i < 1000000; i += 2) {
            length = findCollatzLength(i);

            if (length > highestchainlength) {
                highestchainstartingvalue = i;
                highestchainlength = length;
                System.out.println("highest is now " + highestchainlength + " " + highestchainstartingvalue);
            }
            System.out.println(i);
        }
        System.out.println("Highest chain length is " + highestchainlength
                + "\nwith a starting value of " + highestchainstartingvalue);
    }

    public static long findCollatzLength(long n) {
        long a = n;
        long currentlength = 0;
        while (a != 1) {
            if (a % 2 == 0) {
                a /= 2;
            } else {
                a = (3 * a) + 1;
            }
            currentlength++;
        }
        return currentlength;
    }
}
