package problems90AndUp;

import java.awt.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chris on 5/27/15.
 */
public class Problem357 {
    final static int lim = 100000002;
    static BigInteger sum = new BigInteger("1");
    static ArrayList<Integer> primes = sieve(lim);
    static boolean[] rawArray;

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
        rawArray = array;
        return returning;
    }

    public static list<Integer> shortList() {
        list<Integer> a = new list<Integer>();
        list<Integer> b = new list<Integer>();
        for (int n : primes) {
            a.add(n - 1);
            b.add((n - 2) * 2);
        }
        list<Integer> merged = list.merge(a, b);
        for (int i = 0; i < merged.size(); i++) {
            int c = merged.get(i);
            for (int j = 2; j < Math.sqrt(c); j++) {
                if (c % (j * j) == 0) {
                    merged.remove(i);
                    j = c;
                    i--;
                }
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        list<Integer> merged = shortList();
        for (int a: merged){
            if(isPrimeGenerating(a)){
                sum = new BigInteger(Integer.toString(a)).add(sum);
            }
        }
        System.out.println(sum);

    }

    public static boolean isPrimeGenerating(int n) {
        double sq = Math.sqrt(n);
        for (int a = 3; a < sq; a++) {
            if (n % a == 0) {
                if (!rawArray[a + (n / a)]) {
                    return false;
                }
            }
        }
        return true;
    }

    static class list<T> extends ArrayList<T> {
        static list merge(list<Integer> one, list<Integer> two) {
            list<Integer> merged = new list<>();
            int s1 = one.size();
            int s2 = two.size();
            int a;
            int b;
            int i = 0;
            int j = 0;

            while(i < one.size()) {
                a = one.get(i);
                b = two.get(j);
                while (a < b) {
                    i++;
                    if(i+1>s1) return merged;
                    else {
                        a = one.get(i);
                    }
                }
                if (a == b) {
                    merged.add(a);
                    i++;
                }
                j++;
                if(j+1>s2) return merged;
            }
            return merged;
        }
    }
}