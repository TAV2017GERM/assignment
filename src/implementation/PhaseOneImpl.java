package implementation;

/**
 * @author by Geoffrey on 2017-01-27.
 */
public class PhaseOneImpl implements PhaseOne{
    private int POSITION = 0;
    private int IS_EMPTY_COUNTER = 0;

    private int[] carStatus = {POSITION , IS_EMPTY_COUNTER};
    private boolean isParked = false;

    public int[] moveForward() {
        if (whereIs() < 500) {  // Added so that it doesn't move past 500
            carStatus[0] += 1;  // Incremets the position of the car
        }
        return carStatus;
    }

    public int[] moveBackward() {
        if (whereIs() > 0){
            carStatus[0] -= 1;
        }
        return carStatus;
    }

    public void park() {

    }

    public boolean unPark() {

        return isParked;
    }

    public int whereIs() {
        return carStatus[0];
    }

    public boolean isEmpty() {

        return false;
    }
}
