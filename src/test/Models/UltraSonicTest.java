package Models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;


/**
 * Controllers.Navigation Tester.
 *
 * @author Group4
 * @version 1.0
 * @since <pre>Feb 15, 2017</pre>
 */

@RunWith(MockitoJUnitRunner.class)
public class UltraSonicTest {
    @Mock
    private
    UltraSonic USMock;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(USMock);

    }

    @Test
    public void testMeasureDistance() {

        USMock.measureDistance();

        Mockito.verify(USMock, times(1)).measureDistance();
        UltraSonic us = new UltraSonic();
        us.distance = -1;
        us.measureDistance();
        Assert.assertNotEquals(-1,us.distance);
    }

    @Test
    public void testGetDistance() {

        Mockito.when(USMock.getDistance()).thenReturn(0);
        Assert.assertEquals(0, USMock.getDistance());

    }

}