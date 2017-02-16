package Models;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Group 4 on 2/13/17.
 */
public class UltraSonic implements UltraSonicInterface {
     int distance;

    public UltraSonic() {
        this.distance = -1;
    }

    @Override
    public void measureDistance() {
        this.distance = ThreadLocalRandom.current().nextInt(0, 300);
        System.out.println(this.distance+"this");
    }

    @Override
    public int getDistance() {
        measureDistance();
        return this.distance;
    }
}
