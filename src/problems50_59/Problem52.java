package problems50_59;

public class Problem52 {
    public static void main(String[] args) {
        int a = 1;
        int b;
        while (true) {
            b = a * 2;
            if (isPermutationOf(a, b)) {
                b = a * 3;
                if (isPermutationOf(a, b)) {
                    b = a * 4;
                    if (isPermutationOf(a, b)) {
                        b = a * 5;
                        if (isPermutationOf(a, b)) {
                            b = a * 6;
                            if (isPermutationOf(a, b)) {
                                System.out.println(a);
                                break;
                            } else {
                                a++;
                            }
                        } else {
                            a++;
                        }
                    } else {
                        a++;
                    }
                } else {
                    a++;
                }
            } else {
                a++;
            }
        }

        if (a % 100000 == 0) {
            System.out.println(a);
        }

    }

    public static boolean isPermutationOf(int Inta, int Intb) {
        String a = Integer.toString(Inta);
        String b = Integer.toString(Intb);

        if (b.length() != a.length())
            return false;
        int len = a.length();
        for (int i = 0; i < len; i++) {
            if (contains(a, b.charAt(i))) {
                // b.delete(h, h + 1);
                // a.delete(0, 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean contains(String a, char b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b) {
                return true;
            }
        }
        return false;
    }
}
