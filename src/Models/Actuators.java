package Models;

/**
 * @author Group 4 on 2/13/17.
 */
public class Actuators implements ActuatorsInterface {

    /**
     * Increase the position of the car
     *
     * @param position
     * @return the current position of the car
     */
    @Override
    public int moveForward(int position) {
        if (position >= 0 && position < 500) {
            position++;
        }
        return position;
    }

    /**
     * Decrease the position of the car
     *
     * @param position
     * @return the current position of the car
     */
    @Override
    public int moveBackward(int position) {
        if (position > 0 && position <= 500) {
            position--;
        }
        return position;
    }

}
