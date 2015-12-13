package problems30_39;

public class Problem32 {
    public static void main(String args[]) {
        int n = 1000;
        Long sum = 0L;
        while (n < 10000) {
            int[] info = divisors(n);
            if (findSize(info) == -1) {
                n++;
                info = divisors(n);
            }
            String[] possibilities = new String[findSize(info)];
            for (int i = 0; i < findSize(info); i++) {
                possibilities[i] = n + "" + info[i + 1] + "" + (n / info[i + 1]);
            }
            boolean foo = true;
            for (int i = 0; i < possibilities.length; i++) {
                if (isPandigital(possibilities[i]) && foo) {
                    sum += n;
                    foo = false;
                }
            }
            n++;

        }
        System.out.println(sum);

    }

    public static boolean isPandigital(String foo) {
        boolean[] numbers = new boolean[10];
        if (foo.length() != 9) return false;
        for (int i = 0; i < 9; i++) {
            int c = Character.getNumericValue((foo.charAt(i)));
            if (numbers[c] || c == 0) {
                return false;
            } else {
                numbers[c] = true;
            }
        }
        return true;

    }

    public static int[] divisors(int n) {
        int[] big = new int[n];
        int index = 0;
        for (int i = 2; i < (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                big[index] = i;
                index++;
            }
        }

        return big;
    }

    public static int findSize(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                return i - 1;
            }
        }
        return -1;
    }
}
