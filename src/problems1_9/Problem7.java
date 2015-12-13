package problems1_9;

import java.util.ArrayList;

//Here we go, sieve of Erathsmus

/**
 * @author chris
 *         <p/>
 *         <p/>
 *         By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we
 *         can see that the 6th prime is 13.
 *         <p/>
 *         What is the 10 001st prime number?
 */
public class Problem7 {
    public static void asdf(String[] args) {
        //The 10,001st prime won't be that high, so i'll just pick a limit I think it'll be within.
        ArrayList<Double> primes = sieve(1000000);//A million
        System.out.println(primes.get(10000));
    }

    public static void main(String[] args) {
        double sum = 0;
        for (double a = 0; a <= 10000; a++) {
            sum += 1 / Math.pow(10, a);
        }
        System.out.println(sum);
    }

    public static ArrayList<Double> sieve(int lim) {
        boolean[] nums = new boolean[lim];
        for (int i = 0; i < lim; i++) {
            nums[i] = true;
        }
        nums[0] = false;
        nums[1] = false;
        for (int i = 2; i < lim; i++) {
            if (nums[i] == true) {
                int j = 2;
                int p = i * j;
                while (p < lim) {
                    nums[p] = false;
                    j++;
                    p = i * j;
                }
            }
        }
        ArrayList<Double> primes = new ArrayList<Double>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == true) {
                primes.add((double) i);
            }
        }
        return primes;
    }
}
