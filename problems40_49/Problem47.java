package problems40_49;

import java.util.ArrayList;

public class Problem47 {
    static int size = 4;
    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        int a = 4;
        int b = 5;
        int c = 6;
        int d = 7;
        while (true) {
            if (isDistinct(a, b, c, d)) {
                break;
            }
            a++;
            b++;
            c++;
            d++;
            if (a % 10000 == 0) {
                System.out.println(a);
            }
        }
        System.out.println(a);
    }

    public static int[] factor(int n) {
        int a = n;
        int c = 2;
        int ind = 0;
        int[] factors = new int[size];

        while (a != 1) {
            if (a % c == 0) {
                if (ind >= factors.length) {
                    factors[0] = -1;
                    break;
                } else {
                    factors[ind] = 1;
                }
                while (a % c == 0) {
                    a /= c;
                    factors[ind] *= c;
                }
                ind++;
            } else {
                c++;
            }

        }
        return factors;
    }

    public static boolean isDistinct(int x, int y, int z, int z2) {
        list.clear();
        int[] a = factor(x);
        int[] b = factor(y);
        int[] c = factor(z);
        int[] d = factor(z2);
        if (a[size - 1] == 0 || c[size - 1] == 0 || b[size - 1] == 0
                || d[size - 1] == 0) {
            return false;
        }
        if (a[0] != -1 && b[0] != -1 && c[0] != -1 && d[0] != -1) {
        } else {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!list.contains(a[i])) {
                list.add(a[i]);
            } else {
                return false;
            }
        }
        for (int i = 0; i < size; i++) {
            if (!list.contains(b[i])) {
                list.add(b[i]);
            } else {
                return false;
            }
        }
        for (int i = 0; i < size; i++) {
            if (!list.contains(c[i])) {
                list.add(c[i]);
            } else {
                return false;
            }
        }
        for (int i = 0; i < size; i++) {
            if (!list.contains(d[i])) {
                list.add(d[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}
