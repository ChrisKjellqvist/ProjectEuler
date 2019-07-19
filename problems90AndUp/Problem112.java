package problems90AndUp;

/**
 * Created by chris on 5/26/15.
 */
public class Problem112 {
    public static boolean isBouncy(int num) {
        String conv = Integer.toString(num);
        if (num < 100) return false;
        boolean descends = false;
        boolean ascends = false;
        for (int i = 0; i < conv.length() - 1; i++) {
            int first = Character.getNumericValue(conv.charAt(i));
            int second = Character.getNumericValue(conv.charAt(i + 1));
            if (second > first) {
                ascends = true;
            } else if (first > second) {
                descends = true;
            }
        }

        return (ascends && descends);
    }

    public static void main(String[] args) {
        int Bouncies = 0;
        int total = 1;
        while (Bouncies != .99 * total) {
            boolean currentIsBouncy = isBouncy(total + 1);
            if (currentIsBouncy) Bouncies++;
            total++;
        }
        System.out.println("Bouncies: " + Bouncies);
        System.out.println("Total: " + total);

    }
}
