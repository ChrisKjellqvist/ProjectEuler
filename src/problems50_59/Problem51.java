package problems50_59;

import java.util.ArrayList;

/**
 * Created by chris on 3/1/15.
 */
public class Problem51 {
    public static void main(String[] args) {
        ArrayList<String> primes = sieve(1000000);
        int index = 0;
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        while (primes.get(index).length() != 6) {
            index++;
        }
        for (int i = index; i < primes.size(); i++) {
            if (hasOnes(primes.get(i))) {
                int strikes = 0;
                int num = 1;
                String c = primes.get(i);
                for (int j = 2; j <= 9; j++) {
                    if (primes.contains(replace(c, '1', numbers[j]))) {
                        num++;
                    } else {
                        strikes++;
                    }
                    if (strikes >= 3) {
                        j += 1000;
                    }
                }
                if (num == 8) {
                    System.out.println(primes.get(i));
                    break;
                }
            }
            if (hasTwos(primes.get(i))) {
                int num = 1;
                int strikes = 0;
                String c = primes.get(i);
                for (int j = 2; j <= 9; j++) {
                    if (primes.contains(replace(c, '2', numbers[j]))) {
                        num++;
                    } else {
                        strikes++;
                    }
                    if (strikes >= 3) {
                        j += 1000;
                    }
                }
                if (num == 8) {
                    System.out.println(primes.get(i));
                    break;
                }
            }
        }

    }

    public static boolean hasOnes(String n) {

        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '1') {
                return true;
            }
        }
        return false;
    }

    public static boolean hasTwos(String n) {
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '2') {
                return true;
            }
        }
        return false;
    }

    public static String replace(String n, char toreplace, char replacer) {
        String answer = "";
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == toreplace) {
                answer += replacer;
            } else {
                answer += n.charAt(i);
            }
        }
        return answer;
    }

    public static ArrayList<String> sieve(int lim) {
        boolean[] nums = new boolean[lim];
        for (int i = 0; i < lim; i++) {
            nums[i] = true;
        }
        ArrayList<String> primes = new ArrayList<String>();
        nums[0] = false;
        nums[1] = false;
        for (int i = 2; i < lim; i++) {
            if (nums[i] == true) {
                int j = 2;
                primes.add(Integer.toString(i));
                int p = i * j;
                while (p < lim) {
                    nums[p] = false;
                    j++;
                    p = i * j;
                }
            }
        }
        return primes;
    }
}
