package Models;

/**
 * @author Group 4 on 2/13/17.
 */
public class Actuators implements ActuatorsInterface {


    @Override
    public int moveForward(int position) {
        return position + 1;
    }

    @Override
    public int moveBackward(int position) {
        return position - 1;
    }

}
