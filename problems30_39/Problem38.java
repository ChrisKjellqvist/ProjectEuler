package problems30_39;

public class Problem38 {
    public static void main(String args[]) {
        int highest = 192384576;
        for (int i = 1; i < 10000; i++) {
            String multiple = genMultiple(i);
            while (multiple == null) {
                i++;
                multiple = genMultiple(i);
            }
            if (isPandigital(genMultiple(i)) > highest) {
                highest = Integer.parseInt(genMultiple(i));
                System.out.println("Highest is now " + highest + " =-=-= " + i);
            }
        }
        System.out.println("Final answer is " + highest);
    }

    public static String genMultiple(int n) {
        StringBuffer a = new StringBuffer();
        int count = 0;
        while (a.length() < 9) {
            count++;
            a.append(n * count);
        }
        if (a.length() > 9 || count == 1) {
            return null;
        } else
            return a.toString();
    }

    public static int isPandigital(String foo) {
        boolean[] numbers = new boolean[10];
        if (foo.length() != 9) {
            return 0;
        }
        for (int i = 0; i < 9; i++) {
            int c = Character.getNumericValue((foo.charAt(i)));
            if (numbers[c] || c == 0) {
                return 0;
            } else {
                numbers[c] = true;
            }
        }
        return Integer.parseInt(foo);

    }
}
