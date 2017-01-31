package implementation;

/**
 * @author by Geoffrey on 2017-01-27.
 */
public class PhaseOneImpl implements PhaseOne{
    private int[] carStatus = {0 , 0};
    private boolean isParked = false;

    public int[] moveForward() {
        if (whereIs() < 500) {
            carStatus[0] += 1;
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

    public int isEmpty() {
    int i = 0;
        return i;
    }
}
