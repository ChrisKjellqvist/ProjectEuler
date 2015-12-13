package problems60_69;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem67 {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input_files/triangle.txt"));
        int[][] array = new int[100][100];
        int l = 0;
        for (int i = 0; i < 100; i++) {
            l++;
            for (int j = 0; j < l; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        int m = 100;
        for (int i = 98; i >= 0; i--) {
            m--;
            for (int j = 0; j < m; j++) {
                if (array[i + 1][j] > array[i + 1][j + 1]) {
                    array[i][j] += array[i + 1][j];
                } else {
                    array[i][j] += array[i + 1][j + 1];

                }
            }
        }
        System.out.println(array[0][0]);
        sc.close();
    }

}
