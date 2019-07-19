package problems50_59;

public class Problem58 {

    public static void main(String[] args) {
        double count = 1;
        double total = 1;
        double fraction = count / total;
        int l = 0;
        while (fraction >= .1) {
            l++;
            if (isPrime(quadOne(l))) {
                count++;
            }
            if (isPrime(quadTwo(l))) {
                count++;
            }
            if (isPrime(quadThree(l))) {
                count++;
            }
            total += 4;
            fraction = count / total;
        }
        System.out.println(2 * l + 1);
    }

    private static int quadOne(final int n) {
        return (4 * n * n) - 2 * n + 1;
    }

    private static int quadTwo(final int n) {
        return 4 * n * n + 1;
    }

    private static int quadThree(final int n) {
        return 4 * n * n + 2 * n + 1;
    }

    public static boolean isPrime(int n) {
        int mod = n % 6;
        if (mod != 5 && mod != 1) {
            return false;
        }
        if (n % 2 == 0) {
            return false;
        }
        double lim = (Math.ceil(Math.sqrt(n)));
        for (int i = 3; i <= lim; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
