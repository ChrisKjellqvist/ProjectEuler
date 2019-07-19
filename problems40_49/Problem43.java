package problems40_49;

public class Problem43 {
    public static void main(String[] args) {
        long sum = 0;
        final long t1 = System.currentTimeMillis();
        for (long i = 1023456789; i < 9876543210L; i += 1) {
            if (subString(i, 1, 4) % 2 == 0) {
                if (subString(i, 7, 10) % 17 == 0) {
                    if (subString(i, 5, 8) % 11 == 0) {
                        if (subString(i, 4, 7) % 7 == 0) {
                            if (subString(i, 3, 6) % 5 == 0) {
                                if (subString(i, 2, 5) % 3 == 0) {
                                    if (subString(i, 6, 9) % 13 == 0) {
                                        if (isPandigital(i)) {
                                            sum += i;
                                            System.out.println(i);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                i += 1 * pow(10, 6);
            }
        }
        final long t2 = System.currentTimeMillis();
        System.out.println("time is " + (t2 - t1) / 1e3 + "\n" + sum);
    }

    public static boolean isPandigital(long n) {
        boolean[] foo = new boolean[10];
        for (int i = 0; i < 10; i++) {
            int a = (int) subString(n, i, i + 1);
            if (foo[a] == true) return false;
            else foo[a] = true;
        }
        return true;
    }

    public static long subString(long n, int a, int b) {
        if (n < 100000000) {
            return -233;
        }
        long x = n / pow(10, 10 - a);
        n -= x * pow(10, 10 - a);
        n /= pow(10, (10 - a) - (b - a));
        return n;
    }

    public static long pow(int n, int exp) {
        long ans = 1;
        for (int i = 0; i < exp; i++) {
            ans *= n;
        }
        return ans;
    }
}
