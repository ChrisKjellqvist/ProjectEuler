package problems60_69;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chris on 12/25/15.
 */
public class Problem62 {
    public static void main(String[] args) {
        HashMap<String, Integer> permutations = new HashMap<String, Integer>();
        int c = 100;
        while (true) {
            BigInteger num = new BigInteger(Integer.toString(c));
            num = num.pow(3);
            int[] ar = numberToArray(num);
            String str = arrayToString(ar);
            int numberOfPreviousOccurences;
            try {
                numberOfPreviousOccurences = permutations.get(str);
            } catch (NullPointerException ex) {
                numberOfPreviousOccurences = 0;
            }
            if (numberOfPreviousOccurences == 14) {
                System.out.println(arrayToNumber(ar));
                break;
            } else {
                numberOfPreviousOccurences++;
                permutations.put(str, numberOfPreviousOccurences);
            }
            c++;
        }
    }

    public static String arrayToString(int[] ar) {
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            temp.append(ar[i]);
        }
        return temp.toString();
    }

    public static int[] numberToArray(BigInteger n) {
        int[] nums = new int[10];
        char[] ar = n.toString().toCharArray();
        for (char t : ar) {
            nums[Character.getNumericValue(t)]++;
        }
        return nums;
    }

    public static String arrayToNumber(int[] ar) {
        String toMatch = arrayToString(ar);
        long c = 1;
        while (!arrayToString(numberToArray(new BigInteger(Long.toString(c)).pow(3))).equals(toMatch)) {
            c++;
        }
        return (new BigInteger(Long.toString(c)).pow(3).toString() + " " + c);
    }
}
