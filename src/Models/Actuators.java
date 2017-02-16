package Models;

/**
 * @author Group 4 on 2/13/17.
 */
public class Actuators implements ActuatorsInterface {

    @Override
    public int moveForward(int position) {
        if (position >= 0 && position < 500) {
            return position + 1;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int moveBackward(int position) {
        if (position > 0 && position <= 500) {
            return position - 1;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
