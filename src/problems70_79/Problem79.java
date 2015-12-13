package problems70_79;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem79 {
    public static void main(String[] args) throws FileNotFoundException {
        final long t1 = System.currentTimeMillis();
        doProblem();
        final long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    private static void doProblem() throws FileNotFoundException {
        File file = new File("input_files/p079.txt");
        Scanner sc = new Scanner(file);
        char[][] codes = new char[50][3];
        for (int i = 0; i < 50; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < 3; j++) {
                codes[i][j] = temp.charAt(j);
            }
        }
        sc.close();

        long count = 7;
        String code = Long.toString(count);
        boolean foundCorrect = false;
        int pow10 = 0;

        while (!foundCorrect) {
            foundCorrect = true;
            for (int i = 0; i < 50; i++) {
                boolean[] chars = new boolean[3];
                int n = 0;
                for (int j = 0; j < code.length(); j++) {
                    if (code.charAt(j) == (codes[i][n])) {
                        chars[n] = true;
                        if (chars[2]) {
                            j += 1000;
                        }
                        n++;
                    }
                }

                if (!(chars[0] && chars[1] && chars[2])) {
                    i += 1000;
                    foundCorrect = false;
                }
            }
            count++;
            if (code.charAt(0) != '7') {
                pow10++;
                count = (long) Math.pow(10, pow10) * 7;
            }
            code = Long.toString(count);
        }
        System.out.println(count - 1);

    }
}
