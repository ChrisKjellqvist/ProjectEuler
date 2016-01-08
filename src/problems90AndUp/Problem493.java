package problems90AndUp;

import java.awt.*;

/**
 * Created by chris on 1/2/16.
 */
public class Problem493 {
    public static void main(String[] args) {
        Pot pot = new Pot(70);
        double sum = pot.chooseColors(20);
        int runs = 1;
        double changeThreshold = 0.000000001;
        double observedChange = (sum / runs) + 1;
        MessageBox update = new MessageBox("0");
        update.setPreferredSize(new Dimension(100, 100));
        update.setVisible(true);
        Toolkit a = Toolkit.getDefaultToolkit();

        while (true) {
            pot = new Pot(70);
            sum += pot.chooseColors(20);
            runs++;
            update.messageLabel.setText(sum / runs + "");
            a.sync();
        }
    }
}
