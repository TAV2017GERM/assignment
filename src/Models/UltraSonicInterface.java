package Models;

/**
 * @author Group 4 on 2/13/17.
 */
public interface UltraSonicInterface {

    /**
     * Description: Measure the distance to the nearest object with a range of 0 - 255
     * <p>
     * Pre-condition: N/A
     * <p>
     * Post-condition: N/A
     * <p>
     * Test-cases:
     */
    void measureDistance();

    /**
     * Description: Return the latest distance recorded by messureDistance
     * <p>
     * Pre-condition: N/A
     * <p>
     * Post-condition: N/A
     * <p>
     * Test-cases:
     */
    int getDistance();
}
