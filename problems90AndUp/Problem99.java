package problems90AndUp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by chris on 5/24/15.
 */
public class Problem99 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input_files/p099_base_exp.txt");
        Scanner sc = new Scanner(inputFile);
        ArrayList<String> input = new ArrayList<String>();
        while (sc.hasNext()) {
            input.add(sc.nextLine());
        }
        ArrayList<Double> answerValues = new ArrayList<Double>();
        for (String current : input) {
            String[] split = current.split(",");
            double first = Double.parseDouble(split[0]);
            double second = Double.parseDouble(split[1]);
            answerValues.add(second * Math.log(first));
        }
        double max = 0;
        int index = 0;
        for (int i = 0; i < answerValues.size(); i++) {
            if (answerValues.get(i) > max) {
                max = answerValues.get(i);
                index = i + 1;
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Index: " + index);
    }
}
