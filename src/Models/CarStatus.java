package Models;

/**
 * @author Group 4 on 2/13/17.
 */
public class CarStatus {
    private int[] status;

    private int IS_EMPTY_COUNTER;

    public CarStatus() {
        status = new int[501];
        IS_EMPTY_COUNTER = 0;
    }

    public int whereIs(int[] status) {
        return status[0];    // Return the position of the car
    }

    public void setCarPosition(int position) {
        status[0] = position;
    }

    public int whereIs() {
        return status[0];
    }

    public void registerParkingPlaces() {

    }

    public int fetchParkingPlace(int position) {
        return status[position];
    }
}
