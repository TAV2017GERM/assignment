package Views;

import Controllers.Navigation;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author by raphael on 2/15/17.
 */
public class UI extends Observable implements Observer {
    private JButton park;
    private JPanel panelMain;
    private JButton driveBkd;
    private JButton driveFwd;
    private JLabel feed;
    private JProgressBar progressBar;
    private boolean parked;

    public UI() {

        parked = false;
        park.setBackground(Color.GREEN);
        Navigation navigation = new Navigation();
        this.addObserver(navigation);
        navigation.addObserver(this);

        park.addActionListener(actionEvent -> {
            if (!parked) {
                setChanged();
                notifyObservers("Park");
            } else {
                setChanged();
                notifyObservers("Unpark");
            }
        });
        driveBkd.addActionListener(actionEvent -> {
            if (!parked) {
                setChanged();
                notifyObservers("Drive Bkd");
            }
        });
        driveFwd.addActionListener(actionEvent -> {
            if (!parked) {
                setChanged();
                notifyObservers("Drive Fwd");
            }
        });
    }

    private void setFeed(int[] carStatus, boolean b) {
        if (!b) {
            int pos = carStatus[0];
            int parkingPlaces = 0;
            int places = 0;
            for (int i = 1; i < carStatus.length; i++) {
                if (carStatus[i] != 0) parkingPlaces += 1;
                else parkingPlaces = 0;
                if (parkingPlaces == 5) places += 1;
            }

            feed.setText("        Car is at position " + pos + " found " + places + " parking places.");
            progressBar.setValue(pos);
            progressBar.setStringPainted(true);
            progressBar.setString(String.valueOf(pos));
        } else {
            feed.setText("                                Parked                              ");
            park.setText("Unpark");
            parked = true;

        }
    }

    @Override
    public void update(Observable observable, Object o) {
        if (o.equals("Parked")) {
            setFeed(null, true);
            park.setBackground(Color.RED);
        } else {
            park.setText("Park");
            park.setBackground(Color.GREEN);
            parked = false;
            int[] status = (int[]) o;
            setFeed(status, false);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Parking System");
        frame.setContentPane(new UI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
