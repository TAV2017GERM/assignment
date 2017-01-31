package implementation;

/**
 * @author by Geoffrey on 2017-01-27.
 */
public class PhaseOneImpl implements PhaseOne{
    private int[] carStatus = {0 , 0};
    private boolean isParked = false;



    public int[] moveForward() {
        return carStatus;
    }

    public int[] moveBackward() {

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
