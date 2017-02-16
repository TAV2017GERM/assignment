package Models;

import Controllers.Navigation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Array;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

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
        carStatus.registerParkingPlaces(1);
        verify(carStatus, times(1)).registerParkingPlaces(1);


    }

    @Test
    public void testFetchParkingPlace() throws Exception {
        Mockito.when(carStatus.fetchParkingPlace(2)).thenReturn(2);
        assertEquals(2, carStatus.fetchParkingPlace(2));
    }
    @Test
    public void testGetCarStatus() throws Exception {
        carStatus.getCarStatus();
        int[] dummy = new int[1];
        doReturn(dummy).when(carStatus).getCarStatus();
        verify(carStatus, times(1)).getCarStatus();
        Assert.assertEquals(dummy,carStatus.getCarStatus());
    }

}