package problems50_59;

public class Problem55 {
    public static void main(String[] args) {
        final long t1 = System.currentTimeMillis();
        System.out.println(getAnswer());
        final long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    public static int getAnswer() {
        int count = 0;
        for (int i = 1; i < 10000; i++) {
            long c = i;
            boolean isPal = false;
            for (int j = 0; j < 100; j++) {
                c += reverse(c);
                if (isPalindrome(c)) {
                    isPal = true;
                    j += 131;
                }
            }
            if (!isPal) {
                count++;
            }
        }
        return count;
    }

    public static long reverse(long n) {
        long answer = 0;
        int len = (int) Math.log10(n);
        for (int i = 0; i <= len; i++) {
            int digit = (int) (n / pow10(len - i));
            n -= digit * pow10(len - i);
            answer += digit * pow10(i);
        }
        return answer;
    }


    public static long pow10(int n) {
        long answer = 1;
        for (int i = 0; i < n; i++) {
            answer *= 10;
        }
        return answer;
    }

    public static boolean isPalindrome(long n) {
        String a = Long.toString(n);
        String b = "";
        for (int i = 0; i < a.length(); i++) {
            b += a.substring(a.length() - i - 1, a.length() - i);
        }
        return a.equals(b);
    }
}
