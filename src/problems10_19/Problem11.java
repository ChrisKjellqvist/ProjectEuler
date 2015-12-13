package problems10_19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author chris
 *         In the 20×20 grid below, four numbers along a diagonal line
 *         have been marked in red. Refer to the p011_numbers.txt The product of
 *         these numbers is 26 × 63 × 78 × 14 = 1788696.
 *         <p/>
 *         What is the greatest product of four adjacent numbers in the same
 *         direction (up, down, left, right, or diagonally) in the 20×20 grid?
 */

public class Problem11 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input_files/p011_numbers.txt");
        Scanner sc = new Scanner(file);
        int highest = 0;
        int[][] array = new int[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                array[j][i] = sc.nextInt();
            }
        }
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                int right = array[i][j] * array[i + 1][j] * array[i + 2][j] * array[i + 3][j];
                int down = array[i][j] * array[i][j + 1] * array[i][j + 2] * array[i][j + 3];
                int diag1 = array[i][j] * array[i + 1][j + 1] * array[i + 2][j + 2] * array[i + 3][j + 3];
                int diag2 = 0;
                if (i > 3) {
                    diag2 = array[i][j] * array[i - 1][j + 1] * array[i - 2][j + 2] * array[i - 3][j + 3];
                }
                if (right > highest) {
                    highest = right;
                }
                if (down > highest) {
                    highest = down;
                }
                if (diag1 > highest) {
                    highest = diag1;
                }
                if (diag2 > highest) {
                    highest = diag2;
                }
            }
        }
        System.out.println(highest);
        sc.close();
    }
}
