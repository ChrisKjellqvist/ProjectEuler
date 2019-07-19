package problems40_49;

public class Problem40 {
    public static void main(String args[]) {
        StringBuffer l = new StringBuffer(1000001);
        int c = 1;
        int lim = 1000;
        while (l.length() < 1000001) {
            l.append(c);
            c++;
            if (c > lim) {
                lim += 1000;
            }
        }
        int answer = 1;
        for (int i = 0; i < 7; i++) {
            int power = (int) Math.pow(10, i);
            answer *= Integer.parseInt(l.substring(power - 1, power));
        }
        System.out.println(answer);
    }
}