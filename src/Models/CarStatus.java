package Models;

/**
 * @author Group 4 on 2/13/17.
 */
public class CarStatus {
    private int[] status;
    private int[] parkingPlaces = new int[501];

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

    public void registerParkingPlaces(int i) {

        parkingPlaces[whereIs()] = whereIs();
        parkingPlaces[whereIs() - 1] = whereIs();
        parkingPlaces[whereIs() - 2] = whereIs();
        parkingPlaces[whereIs() - 3] = whereIs();
        parkingPlaces[whereIs() - 4] = whereIs();
    }

    public int fetchParkingPlace(int position) {
        return status[position];
    }
    public int[] getCarStatus(){
        return status;
    }
}
