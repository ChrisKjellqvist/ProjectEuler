package problems60_69;

import java.util.ArrayList;

/**
 * Created by chris on 7/30/15.
 */
public class Problem62 {
    public static long cube(long n) {
        return n * n * n;
    }

    public static void main(String[] args) {
        ArrayList<numberSet> list = new ArrayList<numberSet>();
        int lim = 10000;
        final long t1 = System.currentTimeMillis();
        for (int i = 0; i < lim; i++) {
            list.add(new numberSet(cube(i)));
        }
        for (int i = 0; i < lim; i++) {
            numberSet c = list.get(i);
            int occ = 1;
            for (int j = i + 1; j < lim; j++) {
                if (list.get(j).equalsa(c)) {
                    occ++;
                }
            }
            if (occ == 5) {
                System.out.println(c.value);
                break;
            }
        }
        final long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    public static class numberSet {
        int[] occurences = new int[10];
        long value = 0;
        int length = 0;

        public numberSet(long n) {
            char[] array = Long.toString(n).toCharArray();
            length = array.length;
            for (char c : array) {
                occurences[Character.getNumericValue(c)]++;
            }
            value = n;
        }

        public boolean equalsa(numberSet object) {
            if (this.length != object.length) return false;
            for (int i = 0; i < 10; i++) {
                if (this.occurences[i] != object.occurences[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
