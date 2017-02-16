package Views;

import Controllers.Navigation;

import javax.swing.*;
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

    public UI() {
        Navigation navigation = new Navigation();
        this.addObserver(navigation);
        navigation.addObserver(this);
        park.addActionListener(actionEvent -> {
            setChanged();
            notifyObservers("Park");
        });
        driveBkd.addActionListener(actionEvent -> {
            setChanged();
            notifyObservers("Drive Bkd");
        });
        driveFwd.addActionListener(actionEvent -> {
            setChanged();
            notifyObservers("Drive Fwd");
        });
    }

    private void setFeed(int[] carStatus, boolean b){
        if (!b) {
            int pos = carStatus[0];
            int parkingPlaces = 0;
            int places = 0;
            for (int i = 1; i < carStatus.length; i++) {
                if (carStatus[i] != 0) parkingPlaces += 1;
                else parkingPlaces = 0;

                if (parkingPlaces == 5) places += 1;
            }
            feed.setText(" Car is at position " + pos + " found " + places + " parking places.");
        } else {
            feed.setText("                         Parked                                     ");
        }
    }

    @Override
    public void update(Observable observable, Object o) {
        if (o.equals("Parked")){
            setFeed(null, true);
        } else {
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
