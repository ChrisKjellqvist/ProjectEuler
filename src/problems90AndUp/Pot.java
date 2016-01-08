package problems90AndUp;

import java.util.ArrayList;

/**
 * Created by chris on 1/2/16.
 */
public class Pot {
    ArrayList<Ball> pot = new ArrayList<>();
    int size;

    public Pot(int size) {
        for (int i = 0; i < size; i++) {
            pot.add(new Ball(i % 7));
        }
        this.size = size;
    }

    private int chooseBall() {
        int index = (int) (Math.random() * (size));
        Ball chosen = pot.get(index);
        pot.remove(index);
        size -= 1;
        return chosen.getID();
    }

    public int chooseColors(int n) {
        int[] ar = new int[7];
        for (int i = 0; i < n; i++) {
            ar[chooseBall()]++;
        }
        int colors = 0;
        for (int a : ar) {
            if (a != 0) {
                colors++;
            }
        }
        return colors;
    }
}