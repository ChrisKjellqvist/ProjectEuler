package problems80_89;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by chris on 4/28/15.
 */
public class Problem81 {
    public static int[][] fillTheArray(File a) throws FileNotFoundException {
        Scanner sc = new Scanner(a);
        int[][] array = new int[159][160];
        for (int i = 0; i < 80; i++) {
            for (int j = 0; j < 80; j++) {
                array[i + j][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 159; i++) {
            for (int j = 0; j < 160; j++) {
                if (array[i][j] == 0) {
                    array[i][j] = 10000000;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) throws FileNotFoundException {
        final long t1 = System.currentTimeMillis();
        int[][] array = fillTheArray(new File("input_files/p081_matrix.txt"));
        for (int i = 157; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int a = array[i + 1][j];
                int b = array[i + 1][j + 1];
                if (a < b) {
                    array[i][j] += a;
                } else {
                    array[i][j] += b;
                }
            }
        }
        final long t2 = System.currentTimeMillis();
        System.out.println(array[0][0]);
        System.out.println(t2 - t1);
    }

}
