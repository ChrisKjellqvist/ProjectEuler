package problems30_39;

public class Problem33 {
    public static void main(String args[]) {
        int n = 0;
        int numer = 1;
        int denom = 1;
        int a = 11;
        int b = 12;
        final long t1 = System.currentTimeMillis();
        while (n < 4) {
            if (digitCancels(a, b)) {
                numer *= a;
                denom *= b;
                n++;
            }
            b++;
            if (b > 99) {
                a++;
                b = a + 1;
            }
        }
        final long t2 = System.currentTimeMillis();
        System.out.println("Answer is " + formatAnswer(numer, denom));
        System.out.println("Task completed in " + (t2 - t1) + "ms");
    }

    public static boolean digitCancels(double a, double b) {
        String stringA = Double.toString(a);
        String stringB = Double.toString(b);
        if (stringA.substring(0, 1).equals(stringB.substring(1, 2))) {
            return a / b == (Double.parseDouble(stringA.substring(1, 2)) / Double
                    .parseDouble(stringB.substring(0, 1)));
        } else if (stringA.substring(1, 2).equals(stringB.substring(0, 1))) {
            return a / b == (Double.parseDouble(stringA.substring(0, 1)) / Double
                    .parseDouble(stringB.substring(1, 2)));
        } else
            return false;
    }

    public static int[] divisors(int n) {
        int[] big = new int[n];
        int index = 0;
        int count = 2;
        int c = n;
        while (c != 1) {
            if (c % count == 0) {
                c = c / count;
                big[index] = count;
                index++;
            } else {
                count++;
            }
        }
        int[] small = new int[index];
        for (int i = 0; i < index; i++) {
            if (big[i] != 0) {
                small[i] = big[i];
            }
        }

        return small;
    }

    public static int formatAnswer(int a, int b) {
        int[] aFactors = divisors(a);
        int[] bFactors = divisors(b);
        int denom = b;
        for (int i = 0; i < aFactors.length; i++) {
            for (int j = 0; j < bFactors.length; j++) {
                if (aFactors[i] == bFactors[j]) {
                    denom /= aFactors[i];
                    aFactors[i] = -1;
                    bFactors[i] = -1;
                }
            }
        }
        return denom;

    }

}
