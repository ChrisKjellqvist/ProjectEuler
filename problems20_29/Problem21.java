package problems20_29;

/**
 * Created by chris on 2/28/15.
 */
public class Problem21 {
    public static void main(String[] args) {
        boolean[] hasBeenCounted = new boolean[10000];
        int sum = 0;
        for (int i = 1; i < 10000; i++) {
            if (!hasBeenCounted[i]) {
                int a = d(i);
                int b = d(a);
                if (b == i && i != a) {
                    sum += a + b;
                    hasBeenCounted[i] = true;
                    hasBeenCounted[a] = true;
                    System.out.println(i + " " + a);
                }
            }
        }
        System.out.println(sum);
    }

    public static int d(int n) {
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i + (n / i);
            }
        }
        return sum;
    }
}
