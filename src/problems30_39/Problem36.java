package problems30_39;

public class Problem36 {
    public static void main(String args[]) {
        int sum = 0;
        for (int i = 1; i < 1000000; i += 2) {
            if (isPalindrome(i) && isPalindrome(Integer.toBinaryString(i))) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static boolean isPalindrome(int n) {
        String a = Integer.toString(n);
        String b = "";
        for (int i = 0; i < a.length(); i++) {
            b += a.substring(a.length() - i - 1, a.length() - i);
        }
        return a.equals(b);
    }

    public static boolean isPalindrome(String s) {
        String a = s;
        String b = "";
        for (int i = 0; i < a.length(); i++) {
            b += a.substring(a.length() - i - 1, a.length() - i);
        }
        return a.equals(b);
    }
}
