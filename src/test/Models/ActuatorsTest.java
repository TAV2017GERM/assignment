package Models;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * Controllers.Navigation Tester.
 *
 * @author Group4
 * @version 1.0
 * @since <pre>Feb 15, 2017</pre>
 */

@RunWith(MockitoJUnitRunner.class)
public class ActuatorsTest {
    @Mock
    private
    Actuators actu;
    @Before
    public void setActu() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRunFwd() throws Exception {
        Mockito.when(actu.moveForward(0)).thenReturn(1);
        Mockito.when(actu.moveForward(500)).thenReturn(500);
        assertEquals(1, actu.moveForward(0));
        assertEquals(500, actu.moveForward(500));
    }

    @Test
    public void testRunBkd() throws Exception {
        Mockito.when(actu.moveBackward(0)).thenReturn(0);
        Mockito.when(actu.moveBackward(1)).thenReturn(0);
        assertEquals(0, actu.moveBackward(0));
        assertEquals(0, actu.moveBackward(1));
    }

}