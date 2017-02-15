package Models;

/**
 * @author Group 4 on 2/13/17.
 */
public interface ActuatorsInterface  {

    /**
     * Description: Increase the position of the car
     * <p>
     * Pre-condition: position < 500
     * <p>
     * Post-condition: position <= 500
     * <p>
     * Test-cases:
     */
    void runFwd();

    /**
     * Description: Decrease the position of the car
     * <p>
     * Pre-condition: position > 0
     * <p>
     * Post-condition: position =< 0
     * <p>
     * Test-cases:
     */
    void runBkd();

}
