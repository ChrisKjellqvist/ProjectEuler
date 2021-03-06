/**
 * Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:
 * Triangle 	  	Tn=n(n+1)/2 	  	1, 3, 6, 10, 15, ...
 * Pentagonal 	  	Pn=n(3n−1)/2 	  	1, 5, 12, 22, 35, ...
 * Hexagonal 	  	Hn=n(2n−1) 	  	1, 6, 15, 28, 45, ...
 * <p/>
 * It can be verified that T285 = P165 = H143 = 40755.
 * <p/>
 * Find the next triangle number that is also pentagonal and hexagonal.
 */
package problems40_49;

public class Problem45 {
    public static void main(String args[]) {
        int n = 0;

        long p = 0;
        long P = 0;

        long h = 0;
        long H = 0;

        while (n != 3) {
            h++;
            H = gen("H", h);

            while (P < H) {
                p++;
                P = gen("P", p);
            }
            if (P == H) {
                System.out.println(P);
                n++;
            }
        }
    }

    static long gen(String type, long n) {
        if (type.equals("T")) {
            return (n * (n + 1) / 2);
        }
        if (type.equals("H")) {
            return (n * (2 * n - 1));
        }
        if (type.equals("P")) {
            return (n * (3 * n - 1) / 2);
        } else {
            return 0;
        }
    }
}
