
import implementation.PhaseOneImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void testMoveForward() throws Exception {
        int i = phaseOne.whereIs();
        phaseOne.moveForward();
        Assert.assertEquals(phaseOne.whereIs(), i + 1);
    }

    /**
     * Method: MoveBackward()
     */
    @Test
    public void testMoveBackward() throws Exception {
//TODO: Test goes here... 
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
        Assert.assertEquals(phaseOne.whereIs(), 0);
    }

    /**
     * Method: isEmpty()
     */
    @Test
    public void testIsEmpty() throws Exception {
//TODO: Test goes here...
    }


} 
