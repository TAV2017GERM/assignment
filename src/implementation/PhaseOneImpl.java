package implementation;

/**
 * @author by Geoffrey on 2017-01-27.
 */
public class PhaseOneImpl implements PhaseOne {
    private int POSITION = 0;
    private int IS_EMPTY_COUNTER = 0;

    private int[] carStatus = {POSITION, IS_EMPTY_COUNTER};
    private boolean isParked = false;

    public int[] moveForward() {
        if (whereIs() < 500) {  // Added so that it doesn't move past 500
            carStatus[0] += 1;  // Increments the position of the car

        }
        return carStatus;       // Return the status of the car
    }

    public int[] moveBackward() {
        if (whereIs() > 0) {     // Added so that it doesn't move past 0
            carStatus[0] -= 1;  // Decrements the position of the car
        }
        return carStatus;       // Return the status of the car
    }

    public void park() {
        moveForward();
    }

    public boolean unPark() {

        return isParked;        // Return the parking status
    }

    public int whereIs() {
        return carStatus[0];    // Return the position of the car
    }

    public int isEmpty() {

//        return (int) (Math.random() * 2);
        return 0;      // Returns the integer o
    }
}
