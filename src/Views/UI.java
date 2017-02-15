package Views;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Group 4 on 2/13/17.
 */
public class UI extends  Observable implements Observer{
    private JFrame frame;
    private JButton driveFwd;
    private JButton driveBkd;
    private JButton park;
    private JLabel feed;

    @Override
    public void update(Observable observable, Object o) {

    }
}
