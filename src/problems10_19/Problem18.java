package problems10_19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by chris on 2/28/15.
 */
public class Problem18 {
    public static void main(String[] args) throws FileNotFoundException {
        File triangle = new File("input_files/p018_triangle.txt");
        Scanner sc = new Scanner(triangle);
        int[][] array = new int[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < i + 1; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        for (int i = 13; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int a = array[i + 1][j];
                int b = array[i + 1][j + 1];
                if (a > b) {
                    array[i][j] += a;
                } else {
                    array[i][j] += b;
                }
            }
        }
        System.out.println(array[0][0]);
        sc.close();
    }
}
