package problems20_29;

import java.util.ArrayList;

public class Problem26 {
    final static int LIMIT = 1000;
    static ArrayList<Integer> x = new ArrayList<Integer>();

    public static void main(String args[]) {
        int h = 0;
        final long t1 = System.currentTimeMillis();
        for (int i = 2; i < LIMIT; i++) {
            if (i % 10 != 0) {
                int z = lenCycle(i);
                if (z > h) {
                    h = i;
                }
            }
        }
        final long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        System.out.println(h);
    }

    public static int lenCycle(int n) {
        double e;
        ArrayList<Integer> d = new ArrayList<Integer>();
        int c = 10;
        while (true) {
            e = c / n;
            e = Math.floor(e);
            x.add((int) e);
            if (e != 0) {
                c = c - (int) e * n;
            }
            c *= 10;
            d.add(c);

            if (c != 0) {
                if (countOcc(c, d) > 1) {
                    int[] i = findIndexes(c, d, -1);
                    return (i[1] - i[0]);
                }
            } else if (countOcc(0, d) > 3) {
                if (n < 10) {
                    return findIndexes(0, d, -1)[0];
                }
                if (n > 10) {
                    int i[] = findIndexes(0, d, 0);
                    return i[0] - i[1];
                }
                if (n > 100) {
                    @SuppressWarnings("unused")
                    int i[] = findIndexes(0, d, 1);
                }
            }
        }
    }

    public static int countOcc(int n, ArrayList<Integer> list) {
        int c = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == n) {
                c++;
            }
        }
        return c;
    }

    public static int[] findIndexes(int n, ArrayList<Integer> list, int exc) {
        int[] a = new int[2];
        int c = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == n && i > exc) {
                a[c] = i;
                if (a[1] != 0) {
                    return a;
                }
                c++;
            }
        }
        return a;
    }
}
