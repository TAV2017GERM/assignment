
import implementation.PhaseOneImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * implementation.PhaseOneImpl Tester.
 *
 * @author Group4
 * @version 1.0
 * @since <pre>Jan 30, 2017</pre>
 */
public class PhaseOneImplTest {

    PhaseOneImpl phaseOne;

    @Before
    public void before() throws Exception {
        phaseOne = new PhaseOneImpl();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: MoveForward()
     */
    @Test
    public void testMoveForwardOnce() throws Exception {
        int i = phaseOne.whereIs();
        phaseOne.moveForward();
        Assert.assertEquals(i + 1, phaseOne.whereIs());
    }

    /**
     * Method MoveForward()
     * Move 500 times,
     */
    @Test
    public void testMoveForwardOOB() throws Exception {
        int i = phaseOne.whereIs();
        for (int j = 0; j < 501; j++) {
            phaseOne.moveForward();
        }
        Assert.assertEquals(500, phaseOne.whereIs());
    }

    @Test
    public void testMoveForward500carStatus() throws Exception {

        for (int j = 0; j < 501; j++) {
            phaseOne.moveForward();
        }
        Assert.assertNotEquals(0, phaseOne.carStatus[1]);
    }

    @Test
    public void testMoveForwardParkStatus() throws Exception {
        int i[] = phaseOne.moveForward();
        Assert.assertEquals(phaseOne.isEmpty(), i[1]);
    }
    @Test
    public void testMoveForwardAfterParked() throws Exception {
     phaseOne.park();
     int i = phaseOne.carStatus[0];
     phaseOne.moveForward();
        Assert.assertEquals(i,phaseOne.whereIs());
    }

    /**
     * Method: MoveBackward()
     */
    @Test
    public void testMoveBackwardOnce() throws Exception {
        int i = phaseOne.whereIs();
        int j[] = phaseOne.moveBackward();
        Assert.assertEquals(i, j[0]);
    }

    @Test
    public void testMoveBackwardOOB() throws Exception {
        int i = phaseOne.whereIs();
        phaseOne.moveBackward();
        Assert.assertEquals(0, phaseOne.whereIs());
    }

    @Test
    public void testMoveBackwardParkStatus() throws Exception {
        int i[] = phaseOne.moveBackward();
        Assert.assertEquals(i[1],phaseOne.isEmpty());
    }

    /**
     * Method: Park()
     */
    @Test
    public void testParkCarMovedForward() throws Exception {
        int i = phaseOne.whereIs();
        phaseOne.park();
        int j = phaseOne.whereIs();
        Assert.assertTrue(j > i);
    }


    @Test
    public void testParkMoveFindParking() throws Exception {

        phaseOne.park();

        Assert.assertEquals(true, phaseOne.isParked);

    }
    @Test
    public void testParkStopAtParking() throws Exception {

        phaseOne.park();
        Assert.assertEquals(phaseOne.whereIs(), phaseOne.carStatus[0]);
        Assert.assertEquals(phaseOne.whereIs(), phaseOne.carStatus[0]);

    }

    /**
     * Method: unPark()
     */
    @Test
    public void testUnPark() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: Wherels()
     */
    @Test
    public void testWhereIs() throws Exception {
        Assert.assertEquals(0, phaseOne.whereIs());
        Assert.assertThat(phaseOne.whereIs(), instanceOf(Integer.class));
    }

    /**
     * Method: isEmpty()
     */
    @Test
    public void testIsEmpty() throws Exception {

        Assert.assertThat(phaseOne.isEmpty(), instanceOf(Integer.class));
        Assert.assertTrue(String.valueOf(phaseOne.isEmpty()), phaseOne.isEmpty() == 1 || phaseOne.isEmpty() == 0);

    }

    @Test
    public void testIsEmptyMoveForwardOnce() throws Exception {

        Assert.assertTrue(String.valueOf(phaseOne.isEmpty()), phaseOne.isEmpty() == 1 || phaseOne.isEmpty() == 0);

    }

} 
