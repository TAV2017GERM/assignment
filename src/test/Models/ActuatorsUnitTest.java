package Models;

import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.IllegalFormatCodePointException;


/**
 * Controllers.Navigation Tester.
 *
 * @author Group4
 * @version 1.0
 * @since <pre>Feb 16, 2017</pre>
 */
public class ActuatorsUnitTest {
    private Actuators actuator;
    @Before
    public void before() throws Exception {
      actuator = new Actuators();
    }

    @Test
    public void testMoveForward() {
        int pos = 0;
        for(int i = 0; i<500;i++){
            pos = actuator.moveForward(pos);

        }

    }

    @Test
    public void testMoveBackward() {

    }

}