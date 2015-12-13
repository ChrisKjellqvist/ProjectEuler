package problems1_9;

public class Problem9 {
    public static void main(String[] args) {
        for (int a = 1; a < 500; a++) {
            for (int b = 1; b < 500; b++) {
                double c = Math.sqrt(a * a + b * b);
                if (a + b + c == 1000) {
                    System.out.println(a * b * c);
                }
            }
        }
    }
}

