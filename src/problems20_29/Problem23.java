package problems20_29;

public class Problem23 {
    static java.util.ArrayList<Integer> abunNums = new java.util.ArrayList<Integer>();
    static java.util.ArrayList<Integer> answers = new java.util.ArrayList<Integer>();

    public static void main(String args[]) {
        for (int count = 12; count < 28123; count++) {
            if (isAbundant(count)) {
                abunNums.add(count);
            }
        }
        doProblem();
    }

    public static void doProblem() {
        int sum = 0;
        int counter = 0;
        for (int y = 0; y < abunNums.size(); y++) {

            for (int x = counter; x < abunNums.size(); x++) {
                if (!answers.contains(abunNums.get(x) + abunNums.get(y))) {
                    answers.add(abunNums.get(x) + abunNums.get(y));
                }
            }
            counter++;
        }
        for (int x = 1; x <= 28123; x++)
            if (!answers.contains(x)) {
                sum = sum + x;
                answers.add(x);
            }
        System.out.println(sum);
    }

    public static boolean isAbundant(double n) {
        double sum = 1;
        for (double x = 2; x <= Math.floor(Math.sqrt(n)); x++) {
            if (n % x == 0) {
                sum = sum + x;
                if (x != Math.sqrt(n)) {
                    sum = sum + (n / x);
                }
            }
        }
        return sum > n;
    }
}