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




    public void setCarPosition(int position) {
        status[0] = position;
    }

    public int whereIs() {
        return status[0];   // Return the position of the car
    }

    public void registerParkingPlaces(int i) {

        if (i == 1) {
            parkingPlaces[whereIs()] = whereIs();
            parkingPlaces[whereIs() - 1] = whereIs();
            parkingPlaces[whereIs() - 2] = whereIs();
            parkingPlaces[whereIs() - 3] = whereIs();
            parkingPlaces[whereIs() - 4] = whereIs();
        } else if (i == -1){
            parkingPlaces[whereIs()] = whereIs();
            parkingPlaces[whereIs() + 1] = whereIs();
            parkingPlaces[whereIs() + 2] = whereIs();
            parkingPlaces[whereIs() + 3] = whereIs();
            parkingPlaces[whereIs() + 4] = whereIs();
        } else{
            parkingPlaces[whereIs()] = 0;
        }
    }

    public int fetchParkingPlace(int position) {
        if (position < 1 || position > 500) throw new IllegalArgumentException();
        else return status[position];
    }
    public int[] getCarStatus(){
        return status;
    }
}
