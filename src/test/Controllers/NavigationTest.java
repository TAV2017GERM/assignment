package Controllers;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Controllers.Controller Tester.
 *
 * @author Group4
 * @version 1.0
 * @since <pre>Jan 30, 2017</pre>
 */
public class NavigationTest {

    private Navigation phaseOne;


    @Before
    public void before() throws Exception {
        phaseOne = new Navigation();

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: Wherels()
     */
    @Test
    public void testWhereIs() throws Exception {
        Assert.assertEquals(0, phaseOne.cStatus.whereIs());
        Assert.assertThat(phaseOne.cStatus.whereIs(), instanceOf(Integer.class));
    }

    /**
     * Method: MoveForward()
     */
    @Test
    public void testMoveForwardOnce() throws Exception {
        int i = phaseOne.cStatus.whereIs();
        int j[] = phaseOne.moveForward();

        Assert.assertEquals(i + 1, phaseOne.cStatus.whereIs());
    }

    /**
     * Method: MoveBackward()
     */
    @Test
    public void testMoveBackwardOnce() throws Exception {
        int i = phaseOne.cStatus.whereIs();
        int j[] = phaseOne.moveBackward();
        Assert.assertEquals(i, j[0]);
    }

    /**
     * Method MoveForward()
     * Move 500 times,
     */
    @Test
    public void testMoveForwardOOB() throws Exception {
        for (int j = 0; j < 600; j++) {
            phaseOne.moveForward();
        }
        Assert.assertEquals(500, phaseOne.cStatus.whereIs());
    }

    @Test
    public void testMoveBackwardOOB() throws Exception {
        phaseOne.moveForward();
        phaseOne.moveBackward();
        Assert.assertEquals(1, phaseOne.cStatus.whereIs());
    }

    /**
     * Method: isEmpty()
     */
    @Test
    public void testIsEmpty() throws Exception {
        Assert.assertThat(phaseOne.isEmpty(), instanceOf(Integer.class));
        Assert.assertTrue(String.valueOf(phaseOne.isEmpty()), phaseOne.isEmpty() > 0 || phaseOne.isEmpty() < 200);
    }

    @Test
    public void testMoveForwardParkStatus() throws Exception {
        int i[] = phaseOne.moveForward();
        Assert.assertEquals( 0, i[1]);
    }

    @Test
    public void testMoveBackwardParkStatus() throws Exception {
        int i[] = phaseOne.moveBackward();
        Assert.assertEquals(0, i[1]);

    }

    /**
     * Method: Park()
     */
    @Test
    public void testParkCarMovedForward() throws Exception {
        int i = phaseOne.cStatus.whereIs();
        phaseOne.park();
        int j = phaseOne.cStatus.whereIs();
        Assert.assertTrue(j > i);
    }

    @Test
    public void testMoveForward500carStatus() throws Exception {

        for (int j = 0; j < 501; j++) {
            phaseOne.moveForward();
        }
        Assert.assertNotEquals(0, phaseOne.IS_EMPTY_COUNTER);
    }

    @Test
    public void testParkMoveFindParking() throws Exception {
        phaseOne.cStatus.setCarPosition(1);
        phaseOne.park();

        Assert.assertEquals(true, phaseOne.isParked);

    }

    @Test
    public void testParkStopAtParking() throws Exception {
        phaseOne.park();
        Assert.assertEquals(phaseOne.cStatus.whereIs(), phaseOne.cStatus.whereIs());
    }

    @Test
    public void testMoveForwardAfterParked() throws Exception {
        phaseOne.park();
        int i = phaseOne.cStatus.whereIs();
        phaseOne.moveForward();
        Assert.assertEquals(i, phaseOne.cStatus.whereIs());
    }

    @Test
    public void testMoveBackwardAfterParked() throws Exception {
        phaseOne.park();
        int i = phaseOne.cStatus.whereIs();
        phaseOne.moveBackward();
        Assert.assertEquals(i, phaseOne.cStatus.whereIs());

    }

    /**
     * Method: unPark()
     */
    @Test
    public void testUnPark() throws Exception {
        phaseOne.park();
        phaseOne.unPark();
        Assert.assertEquals(false, phaseOne.isParked);
    }

    @Test
    public void testUnParkMoveForward() throws Exception {
        phaseOne.park();
        phaseOne.unPark();
        int i = phaseOne.cStatus.whereIs();
        phaseOne.moveForward();
        Assert.assertNotEquals(i, phaseOne.cStatus.whereIs());
    }

    @Test
    public void testUnParkMoveBackward() throws Exception {
        phaseOne.park();
        phaseOne.unPark();
        int i = phaseOne.cStatus.whereIs();
        phaseOne.moveBackward();
        Assert.assertNotEquals(i, phaseOne.cStatus.whereIs());
    }

    @Test
    public void testUnParkAt500() {
        phaseOne.park();
        phaseOne.unPark();
        phaseOne.park();
        Assert.assertEquals(500, phaseOne.cStatus.whereIs());
    }

    @Test
    public void testUnParkAt35() {
        phaseOne.park();
        phaseOne.unPark();
        Assert.assertEquals(36, phaseOne.cStatus.whereIs());
    }

    @Test
    public void testParkAfterMoveBackward() throws Exception {

        for (int i = 0; i < 500; i++) {
            phaseOne.moveForward();
        }
        for (int i = phaseOne.cStatus.whereIs(); i != 35; i--) {
            phaseOne.moveBackward();
        }
        phaseOne.park();
        Assert.assertEquals(35, phaseOne.cStatus.whereIs());
        Assert.assertEquals(true, phaseOne.isParked);

    }

    @Test
    public void testFinalTest() {
        phaseOne.park();
        Assert.assertEquals(35, phaseOne.cStatus.whereIs());
        Assert.assertEquals(true, phaseOne.isParked);
        phaseOne.unPark();
        Assert.assertEquals(36, phaseOne.cStatus.whereIs());
        Assert.assertEquals(false, phaseOne.isParked);
        phaseOne.park();
        Assert.assertEquals(500, phaseOne.cStatus.whereIs());
        Assert.assertEquals(true, phaseOne.isParked);
        phaseOne.unPark();
        Assert.assertEquals(500, phaseOne.cStatus.whereIs());
        Assert.assertEquals(false, phaseOne.isParked);
    }

} 
