package Models;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Group 4 on 2/13/17.
 */
public class UltraSonic implements UltraSonicInterface {

    /**
     * Measure the distance to the nearest object with a range of 0 - 255
     * @return a distance
     */
    @Override
    public int measureDistance() {
        return ThreadLocalRandom.current().nextInt(0, 300);
    }

    /**
     * Return the latest distance recorded by messureDistance
     * @return a distance
     */
    @Override
    public int getDistance() {
        return measureDistance();
    }
}
