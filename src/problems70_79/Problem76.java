package problems70_79;

/**
 * Created by chris on 4/2/15.
 */
public class Problem76 {
    static int globalcount = 0;
    static int lim = 100;

    public static int findTallest(int lim, int cSum, int cur) {
        if (cSum + cur <= lim) {
            return cur;
        } else {
            return lim - cSum;
        }
    }

    public static void doProblem(int cSum, int cur) {
        int tlim = findTallest(lim, cSum, cur);
        if (cSum == lim) {
            globalcount++;
        }
        for (int i = tlim; i >= 1; i--) {
            doProblem(cSum + i, i);
        }
    }

    public static void main(String[] args) {
        doProblem(0, lim - 1);
        System.out.println(globalcount);
    }
}