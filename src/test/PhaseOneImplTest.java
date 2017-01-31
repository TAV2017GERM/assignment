
import implementation.PhaseOneImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;

/**
 * implementation.PhaseOneImpl Tester.
 *
 * @author GeoffreyC
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
     * @throws Exception
     */
    @Test
    public void testMoveForwardOOB() throws Exception {
        int i = phaseOne.whereIs();
        for(int j = 0; j<501; j++){
            phaseOne.moveForward();
        }
        Assert.assertEquals(500,phaseOne.whereIs());
    }

    /**
     * Method: MoveBackward()
     */
    @Test
    public void testMoveBackwardOnce() throws Exception {
        int i = phaseOne.whereIs();
        phaseOne.moveBackward();
        Assert.assertEquals(i-1, phaseOne.whereIs());
    }
    @Test
    public void testMoveBackwardOOB() throws Exception {
        int i = phaseOne.whereIs();
        phaseOne.moveBackward();
        Assert.assertEquals(0, phaseOne.whereIs());
    }
    /**
     * Method: Park()
     */
    @Test
    public void testPark() throws Exception {
//TODO: Test goes here... 
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
    }

    /**
     * Method: isEmpty()
     */
    @Test
    public void testIsEmpty() throws Exception {
        //Assert.assertEquals(phaseOne.isEmpty(), false);
       // Assert.assertEquals(instanceOf(int.class),phaseOne.isEmpty());
        Assert.assertEquals(1,phaseOne.isEmpty());
    }

} 
