package problems10_19;

/**
 * Created by chris on 2/28/15.
 */
public class Problem19 {
    public static void main(String[] args) {
        int day = 0;
        int[] monthLengths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int daysPassed = 0;
        int dayOfMonth = 0;
        int month = 0;
        int year = 1901;
        int count = 0;
        int yearLim = 365;
        while (year < 2001) {
            day++;
            dayOfMonth++;
            daysPassed++;
            //If a month passes
            if (dayOfMonth > monthLengths[month]) {
                dayOfMonth = 1;
                month++;
                if (month > 11) {
                    month = 0;
                }
            }

            //If a year passes
            if (daysPassed > yearLim) {
                daysPassed = 1;
                year++;
                if (year % 4 == 0 && year % 400 != 0) {
                    monthLengths[1] = 29;
                    yearLim = 366;
                } else {
                    monthLengths[1] = 28;
                    yearLim = 365;
                }
            }

            //If it's sunday
            if (day == 7) {
                if (dayOfMonth == 1) {
                    count++;
                }
                day = 0;
            }
        }
        System.out.println(count - 1);
    }
}
