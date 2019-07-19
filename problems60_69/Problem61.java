package problems60_69;

import java.util.ArrayList;

/**
 * Created by chris on 4/18/15.
 */
public class Problem61 {
    static numbers nums = new numbers(10000);
    static String[] set = new String[6];
    static boolean[] taken = new boolean[6];

    public static void main(String args[]) {
        findSet(0);
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            System.out.println(set[i]);
            sum += Integer.parseInt(set[i]);
        }
        System.out.println("SUM = " + sum);
    }

    public static boolean findSet(int ind) {

        boolean check = true;
        for (int i = 1; i < ind; i++) {
            if (!(set[i].substring(0, 2).equals(set[i - 1].substring(2, 4)))) {
                check = false;
            }
        }
        if (!check) {
            return false;
        }
        if (ind == 6) {
            return set[5].substring(2, 4).equals(set[0].substring(0, 2));
        }
        for (int i = 0; i < 6; i++) {
            if (!taken[i]) {
                taken[i] = true;
                for (int j = 0; j < nums.list[i].size(); j++) {
                    set[ind] = nums.list[i].get(j);
                    if (findSet(ind + 1)) return true;
                }
            }
            taken[i] = false;
        }
        return false;

    }

    public static class numbers {
        ArrayList<String>[] list = new ArrayList[6];

        public numbers(int lim) {
            int count = 1;
            //Triangle Numbers
            list[0] = new ArrayList<String>();
            for (int i = (count * (count + 1)) / 2; i < lim; count++) {
                if (i > 1000) {
                    list[0].add(Integer.toString(i));
                }
                i = (count * (count + 1)) / 2;
            }
            //Square Numbers
            count = 0;
            list[1] = new ArrayList<String>();
            for (int i = count * count; i < lim; count++) {
                if (i > 1000) {
                    list[1].add(Integer.toString(i));
                }
                i = count * count;
            }
            //Pentagonal
            count = 0;
            list[2] = new ArrayList<String>();
            for (int i = count * (3 * count - 1) / 2; i < lim; count++) {
                if (i > 1000) {
                    list[2].add(Integer.toString(i));
                }
                i = count * (3 * count - 1) / 2;
            }
            //Hexagonal
            count = 0;
            list[3] = new ArrayList<String>();
            for (int i = count * (2 * count - 1); i < lim; count++) {
                if (i > 1000) {
                    list[3].add(Integer.toString(i));
                }
                i = count * (2 * count - 1);
            }
            //Heptagonal
            count = 0;
            list[4] = new ArrayList<String>();
            for (int i = count * (5 * count - 3) / 2; i < lim; count++) {
                if (i > 1000) {
                    list[4].add(Integer.toString(i));
                }
                i = count * (5 * count - 3) / 2;
            }
            //Octagonal
            count = 0;
            list[5] = new ArrayList<String>();
            for (int i = count * (3 * count - 2); i < lim; count++) {
                if (i > 1000) {
                    list[5].add(Integer.toString(i));
                }
                i = count * (3 * count - 2);
            }
        }
    }
}
