package problems20_29;

public class Problem22 {
    public static void main(String args[]) {
        int count = 0;
        long current = 123456789;
        while (count < 1000000) {
            if (perm(Long.toString(current))) {
                count++;
            }
            current++;
        }
        System.out.println(current);
    }

    static boolean perm(String n) {
        if (n.length() < 9)
            return false;
        if (n.length() == 9)
            n = "0" + n;
        boolean[] numbers = new boolean[10];
        for (int x = 0; x < n.length(); x++) {
            int a = Integer.parseInt(n.substring(x, x + 1));
            if (numbers[a] == true)
                return false;
            else
                numbers[a] = true;
        }
        for (int a = 0; a < 10; a++) {
            if (numbers[a] == false)
                return false;
        }
        return true;
    }
}
