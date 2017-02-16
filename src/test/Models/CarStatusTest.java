package Models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * @author Group4
 * @version 1.0
 * @since <pre>Feb 15, 2017</pre>
 */
@RunWith(MockitoJUnitRunner.class)
public class CarStatusTest {
    @Mock private CarStatus carStatus;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetCarPosition() throws Exception {
        carStatus.setCarPosition(0);
        assertEquals(0, carStatus.whereIs());
    }

    @Test
    public void testWhereIs() throws Exception {
        Mockito.when(carStatus.whereIs()).thenReturn(0);
        assertEquals(0,carStatus.whereIs());
    }

    @Test
    public void testRegisterParkingPlaces() throws Exception {

    }

    @Test
    public void testFetchParkingPlace() throws Exception {

    }

}