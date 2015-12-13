package problems50_59;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem54 {
    static char[] values = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
    static int[] falsebool = {-1, -1};

    public static int findValue(char a) {
        for (int i = 0; i < 13; i++) {
            if (values[i] == a) {
                return i;
            }
        }
        return -1;
    }

    public static int[] isRF(String[] hand) {
        boolean[] RF = new boolean[5];
        char suit = hand[0].charAt(1);
        for (String a : hand) {
            if (a.charAt(1) != suit) {
                return falsebool;
            }
            if (a.charAt(0) == 'T') {
                RF[0] = true;
            } else if (a.charAt(0) == 'Q') {
                RF[2] = true;
            } else if (a.charAt(0) == 'J') {
                RF[1] = true;
            } else if (a.charAt(0) == 'K') {
                RF[3] = true;
            } else if (a.charAt(0) == 'A') {
                RF[4] = true;
            } else {
                return falsebool;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (!RF[i]) {
                RF[5] = false;
            }
        }
        if (RF[5]) {
            int[] answer = {9, HC(hand)};
            return answer;
        } else
            return falsebool;
    }

    public static int[] isSF(String[] hand) {
        char suit = hand[0].charAt(1);
        int[] SF = new int[5];
        int c = 0;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 5; j++) {
                if (hand[j].charAt(1) != suit) {
                    return falsebool;
                }
                if (hand[j].charAt(0) == values[i]) {
                    SF[c] = i;
                    if (c > 0 && SF[c - 1] != i - 1) {
                        return falsebool;
                    }
                    c++;
                }
            }
        }
        int[] answer = {8, HC(hand)};
        return answer;
    }

    public static int[] isFOK(String[] hand) {
        int[] values = new int[13];
        for (int i = 0; i < 5; i++) {
            values[findValue(hand[i].charAt(0))]++;
        }
        for (int i = 0; i < 13; i++) {
            if (values[i] == 4) {
                int[] answer = {7, i};
                return answer;
            }
        }
        return falsebool;
    }

    public static int[] isFH(String[] hand) {
        int[] values = new int[13];
        for (int i = 0; i < 5; i++) {
            values[findValue(hand[i].charAt(0))]++;
        }
        boolean pair = false;
        boolean TOK = false;
        int[] answer = {6, 0};
        for (int i = 0; i < 13; i++) {
            if (values[i] == 3) {
                TOK = true;
                answer[1] = i;
            } else if (values[i] == 2) {
                pair = true;
            }
        }
        if (TOK && pair) {
            return answer;
        } else {
            return falsebool;
        }
    }

    public static int[] isFl(String[] hand) {
        char suit = hand[0].charAt(1);
        for (int i = 0; i < 5; i++) {
            if (hand[i].charAt(1) != suit) {
                return falsebool;
            }
        }
        int[] answer = {5, HC(hand)};
        return answer;
    }

    public static int[] isSt(String[] hand) {
        int[] SF = new int[5];
        int c = 0;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 5; j++) {
                if (hand[j].charAt(0) == values[i]) {
                    SF[c] = i;
                    if (c > 0 && SF[c - 1] != i - 1) {
                        return falsebool;
                    }
                    c++;
                }
            }
        }
        int[] answer = {4, SF[4]};
        return answer;
    }

    public static int[] isTOK(String[] hand) {
        int[] values = new int[13];
        for (int i = 0; i < 5; i++) {
            values[findValue(hand[i].charAt(0))]++;
        }
        for (int i = 0; i < 13; i++) {
            if (values[i] == 3) {
                int[] answer = {3, i};
                return answer;
            }
        }
        return falsebool;
    }

    public static int[] isTP(String[] hand) {
        int[] values = new int[13];
        for (int i = 0; i < 5; i++) {
            values[findValue(hand[i].charAt(0))]++;
        }
        boolean first = true;
        for (int i = 0; i < 13; i++) {
            if (values[i] == 2) {
                if (first) {
                    first = false;
                } else {
                    int[] answer = {2, i};
                    return answer;
                }
            }
        }
        return falsebool;
    }

    public static int[] isPa(String[] hand) {
        int[] values = new int[13];
        for (int i = 0; i < 5; i++) {
            values[findValue(hand[i].charAt(0))]++;
        }
        for (int i = 0; i < 13; i++) {
            if (values[i] == 2) {
                int[] answer = {1, i};
                return answer;
            }
        }
        return falsebool;
    }

    public static int HC(String[] hand) {
        int highest = 0;
        for (String a : hand) {
            if (findValue(a.charAt(0)) > highest) {
                highest = findValue(a.charAt(0));
            }
        }
        return highest;
    }

    public static int[] valueOfHand(String[] hand) {
        int[] answer = new int[2];
        int[][] results = new int[10][2];
        results[9] = isRF(hand);
        results[8] = isSF(hand);
        results[7] = isFOK(hand);
        results[6] = isFH(hand);
        results[5] = isFl(hand);
        results[4] = isSt(hand);
        results[3] = isTOK(hand);
        results[2] = isTP(hand);
        results[1] = isPa(hand);
        results[0][0] = 0;
        results[0][1] = HC(hand);
        for (int i = 9; i >= 0; i--) {
            if (results[i][0] != -1) {
                answer = results[i];
                return answer;
            }
        }
        return falsebool;
    }

    public static boolean playerOneWins(String[] hand1, String[] hand2) {
        int[] a = valueOfHand(hand1);
        int[] b = valueOfHand(hand2);
        if (a[0] > b[0]) {
            return true;
        } else if (a[0] == b[0]) {
            return a[1] > b[1];
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("input_files/p054_poker.txt");
        Scanner sc = new Scanner(file);
        int count = 0;
        while (sc.hasNextLine()) {
            String[] bothHands = sc.nextLine().split(" ");
            String[][] hands = new String[2][5];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 5; j++) {
                    hands[i][j] = bothHands[i * 5 + j];
                }
            }
            if (playerOneWins(hands[0], hands[1])) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
