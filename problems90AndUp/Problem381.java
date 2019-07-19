package problems90AndUp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * q
 * Created by chris on 2/6/16.
 */
public class Problem381 {
    static int kmin = 1;
    static int kmax = 5;

    public static long S(int p) {
        long acc = 1;
        for (int i = p - 1; i >= 2; i--) {
            acc = (acc) * i + 1;
        }
        int acc2 = 1;
        for (int i = p - 1 - kmax; i >= 2; i--) {
            acc2 = (acc2) * i + 1;
        }
        return acc - acc2;
    }

    public static ArrayList<Integer> sieveOfEratosthenes(int roof) {
        boolean[] ar = new boolean[roof];
        Arrays.fill(ar, true);
        ar[0] = false;
        ar[1] = false;
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 0; i < roof; i++) {
            if (ar[i]) {
                primes.add(i);
                for (int j = i * 2; j < roof; j += i) {
                    ar[j] = false;
                }
            }
        }
        return primes;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> primes = sieveOfEratosthenes(1000000);
        BufferedWriter wr = new BufferedWriter(new FileWriter(new File("output.txt")));
        wr.write("Vernier Format 2\nData from IntelliJ\nData Set\nSample Size\tTime\nN\tt\n#\ts\n");
        long t1;
        long t2;
        long prev = S(10000);
        for (int pr : primes) {
            t1 = System.nanoTime();
            S(pr);
            t2 = System.nanoTime();
            if ((t2 - t1) <= prev * 1.3 || (pr < 10000 && (t2 - t1) < 100000)) {
                wr.write(pr + "\t" + (t2 - t1) + "\n");
                prev = t2 - t1;
            }
        }
        wr.close();
    }
}
