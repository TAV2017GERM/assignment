package Models;

/**
 * @author Group 4 on 2/13/17.
 */
public class CarStatus implements CarStatusInterface{
    private int[] status;

    public CarStatus() {
        status = new int[501];
    }

    /**
     * Sets the index holding the car position in the status array
     * @param position
     */
    public void setCarPosition(int position) {
        if (position > 0 && position < 501) {
            status[0] = position;
        }
    }

    /**
     * This method returns the current position of the car in the street as well as its situation
     * (whether it is parked or not).
     *
     * @return the current position of the car
     */
    public int whereIs() {
        return status[0];
    }

    /**
     * Registers the value resulting from sensor data on a scanned potential parking place
     * @param i
     */
    public void registerParkingPlaces(int i) {

        if (i == 1 && status[whereIs()] == 0) {
            status[whereIs()] = whereIs();
            status[whereIs() - 1] = whereIs();
            status[whereIs() - 2] = whereIs();
            status[whereIs() - 3] = whereIs();
            status[whereIs() - 4] = whereIs();

        } else if (i == -1 && status[whereIs()] == 0){
            status[whereIs()] = whereIs();
            status[whereIs() + 1] = whereIs();
            status[whereIs() + 2] = whereIs();
            status[whereIs() + 3] = whereIs();
            status[whereIs() + 4] = whereIs();

        } else if (i == 0){
            status[whereIs()] = 0;

        }
    }

    /**
     * Returns the current status of parking place availability
     *
     * @param position
     * @return the CarStatus of this position
     */
    public int fetchParkingPlace(int position) {
        if (position < 1 || position > 500) throw new IllegalArgumentException();
        else return status[position];
    }

    /**
     * Returns the current status of the car
     *
     * @return CarStatus
     */
    public int[] getCarStatus(){
        return status;
    }
}
