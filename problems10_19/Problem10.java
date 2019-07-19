package problems10_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chris The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *         <p/>
 *         Find the sum of all the primes below two million.
 */
public class Problem10 {
    public static void main(String[] args) {
        List<Integer> primes = sieve(2000000);
        long sum = 0;
        for (int i = 0; i < primes.size(); i++) {
            sum += primes.get(i);
        }
        System.out.println(sum);
    }

    public static ArrayList<Integer> sieve(int n) {
        boolean[] array = new boolean[n + 1];
        Arrays.fill(array, true);
        array[0] = false;
        array[1] = false;
        for (int i = 2; i <= n; i++) {
            if (array[i]) {
                for (int j = 2 * i; j <= n; j += i) {
                    array[j] = false;
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (array[i]) {
                answer.add(i);
            }
        }
        return answer;
    }
}
