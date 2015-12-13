package problems1_9;

import java.util.ArrayList;

/**
 * Created by chris on 2/28/15.
 */
public class Problem3 {

    public static void main(String[] args) {
        ArrayList<Long> a = factorize(600851475143L);
        System.out.println(a.get(a.size() - 1));
    }

    public static ArrayList<Long> factorize(long n) {
        ArrayList<Long> list = new ArrayList<Long>();
        long ch = n;
        long count = 2;
        while (ch != 1) {
            if (ch % count == 0) {
                ch /= count;
                list.add(count);
            } else {
                count++;
            }
        }
        return list;
    }
}