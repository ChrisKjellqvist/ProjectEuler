package problems30_39;

public class Problem39 {


    public static int numOfSolutions(int perimeter) {
        int a = 1;
        int b = 2;
        int count = 0;
        while (a < perimeter / 3) {
            if ((perimeter - a - b) * (perimeter - a - b) == a * a + b * b) {
                count++;
            }
            b++;
            if (a + b + Math.sqrt(a * a + b * b) > perimeter) {
                a++;
                b = a + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int highest = 0;
        int value = 0;
        final long t1 = System.currentTimeMillis();
        for (int i = 5; i <= 1000; i++) {
            int val = numOfSolutions(i);
            if (val > highest) {
                highest = val;
                value = i;
            }
        }
        final long t2 = System.currentTimeMillis();
        System.out.println(value + " " + (t2 - t1));
    }
}
