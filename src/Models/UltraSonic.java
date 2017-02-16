package Models;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Group 4 on 2/13/17.
 */
public class UltraSonic implements UltraSonicInterface {

    @Override
    public int measureDistance() {
        return ThreadLocalRandom.current().nextInt(0, 300);
    }

    @Override
    public int getDistance() {
        return measureDistance();
    }
}
