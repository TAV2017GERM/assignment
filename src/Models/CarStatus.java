package Models;

/**
 * @author Group 4 on 2/13/17.
 */
public class CarStatus {
    private int[] status;

    public CarStatus() {
        status = new int[501];
    }

    public void setCarPosition(int position) {
        if (position > 0 && position < 501) {
            status[0] = position;
        }
    }

    public int whereIs() {
        return status[0];   // Return the position of the car
    }

    public void registerParkingPlaces(int i) {

        if (i == 1) {
            status[whereIs()] = whereIs();
            status[whereIs() - 1] = whereIs();
            status[whereIs() - 2] = whereIs();
            status[whereIs() - 3] = whereIs();
            status[whereIs() - 4] = whereIs();
        } else if (i == -1){
            status[whereIs()] = whereIs();
            status[whereIs() + 1] = whereIs();
            status[whereIs() + 2] = whereIs();
            status[whereIs() + 3] = whereIs();
            status[whereIs() + 4] = whereIs();
        } else{
            status[whereIs()] = 0;
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
