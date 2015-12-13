package problems20_29;

public class Problem28 {
    public static void main(String args[]) {
        System.out.println(diagonalAdd(1001));
    }

    public static int diagonalAdd(int s) {
        int sum = 1;
        int x = 1;
        for (int i = 2; i < s; i += 2) {
            for (int j = 0; j < 4; j++) {
                x += i;
                System.out.println("X from " + (x - i) + " to " + x);
                sum += x;
            }
        }
        return sum;
    }
}
