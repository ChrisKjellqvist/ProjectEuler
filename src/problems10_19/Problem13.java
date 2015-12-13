package problems10_19;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Problem13 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input_files/p013_LargeSum.txt");
        Scanner sc = new Scanner(file);
        BigInteger butchered = new BigInteger("0");
        while (sc.hasNextLine()) {
            String a = sc.nextLine();
            butchered = butchered.add(new BigInteger(a));
        }
        String b = butchered.toString();
        System.out.println(b.substring(0, 10));
        sc.close();
    }
}
