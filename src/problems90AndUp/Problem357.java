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

    public static list<Integer> shortList() {
        list<Integer> a = new list<Integer>();
        list<Integer> b = new list<Integer>();
        for (int n : primes) {
            a.add(n - 1);
            b.add((n - 2) * 2);
        }
        list<Integer> merged = list.mergeBoth(a, b);
        int osize = merged.size();
        for (int i = 0; i < merged.size(); i++) {
            int c = merged.get(i);
            for (int j = 2; j < Math.sqrt(c); j++) {
                if (c % (j * j) == 0) {
                    merged.remove(i);
                    j = (int) Math.sqrt(c) + 5;
                    i--;
                }
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        list<Integer> merged = shortList();
        int s = merged.size();
        ArrayList<Integer> correct = new ArrayList<>();
        int ind = 0;
        int p = primes.get(0);
        double sq = Math.sqrt(lim);
        System.out.println("start");
        while(p<sq){
            merged = list.mergeByDivisor(merged, p);
            ind++;
            p = primes.get(ind);
        }
        System.out.println("finish");
        System.out.println((double)merged.size()/(double)s);
        factorize(1290);
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
        static list mergeBoth(list<Integer> a, list<Integer> b) {
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
        static list<Integer> mergeByDivisor (list<Integer> a, int n){
            list<Integer> temp2 = new list<Integer>();
            int ind = 0;
            int p = (primes.get(ind)-n)*n;
            while(p<lim){
                temp2.add(p);
                ind++;
                p = (primes.get(ind)-n)*n;
            }
            for (int i = 0; i < a.size(); i++) {
                if(a.get(i)%n==0){
                    if(!temp2.contains(a.get(i))){
                        a.remove(i);
                        i--;
                    }
                }
            }
            return a;
        }
    }
    public static void factorize(int n){
        int c = 2;
        while (n!=1){
            while(n%c==0){
                n/=c;
                System.out.print(c + " ");
            }
            c++;
        }
        System.out.println();
    }
}