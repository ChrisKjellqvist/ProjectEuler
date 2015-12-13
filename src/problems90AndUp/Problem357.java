package problems90AndUp;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chris on 5/27/15.
 */
public class Problem357 {
    final static int lim = 100000000;
    static long sum = 0;
    static ArrayList<Integer> primes = sieve(lim);

    public static ArrayList<Integer> sieve(int lim) {
        int i, j;
        ArrayList<Integer> returning = new ArrayList<Integer>();
        boolean[] array = new boolean[lim];
        Arrays.fill(array, true);
        array[0] = false;
        array[1] = false;
        for (i = 0; i < lim; i++) {
            if (array[i]) {
                returning.add(i);
                for (j = 2 * i; j < lim; j += i) {
                    array[j] = false;
                }
            }
        }
        return returning;
    }

    static boolean generatesPrimes(int n) {
        if (n == 1) {
            return false;
        }
        double lim = Math.sqrt(n);
        for (int i = 2; i <= lim; i++) {
            if (n % i == 0) {
                if (!primes.contains(i + (n / i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("1");
        list<Integer> a = new list<Integer>();
        list<Integer> b = new list<Integer>();
        for (int n : primes) {
            a.add(n - 1);
            b.add((n - 2) * 2);
        }


        System.out.println("2");
        list<Integer> merged = list.merge(a, b);


        System.out.println("3");
        int osize = merged.size();
        for (int i = 0; i < merged.size(); i++) {
            int c = merged.get(i);
            for (int j = 2; j < Math.sqrt(merged.get(i)); j++) {
                if (c % (j * j) == 0) {
                    merged.remove(i);
                    j = (int) Math.sqrt(merged.get(i)) + 5;
                    i--;
                }
            }
        }
        MessageBox box1 = new MessageBox("0");
        Toolkit kit = Toolkit.getDefaultToolkit();
        box1.setVisible(true);
        double size = merged.size();
        int[] mergedArray = new int[merged.size()];
        for (int i = 0; i < merged.size(); i++) {
            mergedArray[i] = merged.get(i);
        }
        int ind = 0;
        int asdf = 0;
        for (int i = 0; i < size; i++) {
            box1.messageLabel.setText(Double.toString((double) i / size));
            kit.sync();
            if (isPrimeGenerating(mergedArray[i])) {
                sum += mergedArray[i];
            } else {
                int u = mergedArray[i];
                for (int j = i; j < size; j++) {
                    if (mergedArray[j] % u == 0) {
                        mergedArray[j] = 4;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    public static boolean isPrimeGenerating(int n) {
        double sq = Math.sqrt(n);
        for (int a = 3; a < sq; a++) {
            if (n % a == 0) {
                if (!primes.contains(a + (n / a))) {
                    return false;
                }
            }
        }
        return true;
    }

    static class list<T> extends ArrayList<T> {
        static list merge(list<Integer> a, list<Integer> b) {
            list<Integer> merged = new list<Integer>();
            int[] vals = new int[2];
            int j = 0;
            int size = b.size();
            vals[1] = b.get(j);

            for (int i = 0; i < a.size(); i++) {
                vals[0] = a.get(i);
                vals[1] = b.get(j);
                if (vals[0] == vals[1]) {
                    merged.add(vals[0]);
                    j++;
                    continue;
                }
                while (!(vals[0] < vals[1])) {
                    if (j + 1 >= b.size()) {
                        return merged;
                    } else {
                        j++;
                        vals[1] = b.get(j);
                    }
                }

            }
            return merged;
        }
    }
}