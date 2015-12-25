package problems80_89;

/**
 * Created by chris on 12/25/15.
 */
public class Problem85 {
    public static int numberOfRectangles(int w, int h){
        return (h*w*(w+1)*(h+1))/4;
    }

    public static void main(String[] args) {
        int rectangles = 0;
        int goal = 2000000;
        int closest = 10000000;
        int closestA = 0;
        for (int h = 1; h < Math.sqrt(goal); h++) {
            int w = 1;
            do {
                rectangles = numberOfRectangles(w, h);
                if(Math.abs(rectangles-goal)<closest){
                    closest = Math.abs(rectangles-goal);
                    closestA = w * h;
                }
                w++;
            } while (rectangles<goal*1.1);
        }
        System.out.println(closestA);
    }
}
