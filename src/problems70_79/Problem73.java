package problems70_79;

/**
 * Created by chris on 7/27/15.
 */
public class Problem73 {
    static final int LIM = 12000;

    public static void main(String[] args) {
        int results = 0;
        for (int i = 2; i <= 12000; i++) {
            for (int j = i / 3 + 1; ((double) j) / ((double) i) < 1.0 / 2.0; j++) {
                if (GCD(j, i) == 1) {
                    results++;
                }
            }
        }
        System.out.println(results);
    }

    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
}

