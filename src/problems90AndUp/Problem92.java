package problems90AndUp;

public class Problem92 {
    public static void main(String[] args) {
        int c = 0;
        for (int i = 2; i < 10000000; i++) {
            if (arrivesAt89(i)) {
                c++;
            }
        }
        System.out.println(c);
    }

    public static boolean arrivesAt89(int n) {
        while (n != 1 && n != 89) {
            n = squareDigitSum(n);
        }
        return n == 89;
    }

    public static int squareDigitSum(int n) {
        String cheese = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < cheese.length(); i++) {
            int j = Character.getNumericValue(cheese.charAt(i));
            sum += j * j;
        }
        return sum;
    }
}
