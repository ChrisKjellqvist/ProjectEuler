package problems40_49;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem42 {

    static ArrayList<Integer> triangleNumbers = generateTriangleNumbers(1000);
    static char[] Letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z'};

    public static ArrayList<Integer> generateTriangleNumbers(int lim) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int count = 1;
        int n = 1;
        while (n < lim) {
            n = count * (count + 1) / 2;
            answer.add(n);
            count++;
        }
        System.out.println("done");
        return answer;
    }

    public static int findValueOfLetter(char Letter) {
        for (int i = 0; i < 26; i++) {
            if (Letters[i] == Letter) {
                return i + 1;
            }
        }
        return 0;
    }

    public static int evaluateWord(String n) {
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += findValueOfLetter(n.charAt(i));
        }
        return sum;
    }

    public static void main(String args[]) throws FileNotFoundException {
        File input = new File("input_files/p042_words.txt");
        Scanner sc = new Scanner(input);
        String inputString = sc.next();
        StringBuffer finalString = new StringBuffer();
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == ',') {
                finalString.append(" ");
            } else if (inputString.charAt(i) != '"') {
                finalString.append(inputString.charAt(i));
            }
        }
        String sc2String = finalString.toString();
        Scanner sc2 = new Scanner(sc2String);

        int count = 0;
        while (sc2.hasNext()) {
            if (triangleNumbers.contains(evaluateWord(sc2.next()))) {
                count++;
                System.out.println(count);
            }
        }
        System.out.println(count);
        sc2.close();
        sc.close();
    }
}
