package implementation;

/**
 * @author by Geoffrey on 2017-01-27.
 */
public class PhaseOneImpl implements PhaseOne{
    private int[] carStatus = {0 , 0};
    private boolean isParked = false;



    public int[] MoveForward() {

        return carStatus;
    }

    public int[] MoveBackward() {

        return carStatus;
    }

    public void Park() {

    }

    public boolean unPark() {

        return isParked;
    }

    public int WhereIs() {

        return carStatus[0];
    }

    public boolean isEmpty() {

        return false;
    }
}
