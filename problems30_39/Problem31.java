package problems30_39;

public class Problem31 {
    public static void main(String args[]) {
        int ways = 0;
        for (int a = 0; a <= 200; a += 200) {
            for (int b = a; b <= 200; b += 100) {
                for (int c = b; c <= 200; c += 50) {
                    for (int d = c; d <= 200; d += 20) {
                        for (int e = d; e <= 200; e += 10) {
                            for (int f = e; f <= 200; f += 5) {
                                for (int g = f; g <= 200; g += 2) {
                                    ways++;

                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ways);
    }
}
