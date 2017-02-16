package Models;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


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

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void testMoveForward() {
        int pos = 0;
        for (int i = 0; i < 500; i++) {
            pos = actuator.moveForward(pos);

        }

        Assert.assertEquals(500, actuator.moveForward(pos));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testMoveBackward() {
        int pos = 0;
        pos = actuator.moveBackward(pos);
        pos = actuator.moveForward(pos);

        Assert.assertEquals(0, actuator.moveBackward(pos));
    }

}