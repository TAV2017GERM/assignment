package Models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


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
    UltraSonic USMock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void measureDistance() {

    }

    @Test
    public void getDistanceTest() {

    Mockito.when(USMock.getDistance()).thenReturn(0);
    Assert.assertEquals(0,USMock.getDistance());

    }

}