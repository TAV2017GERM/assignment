package Controllers;

import Models.Actuators;
import Models.UltraSonic;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Controllers.Navigation Tester.
 *
 * @author Group4
 * @version 1.0
 * @since <pre>Feb 16, 2017</pre>
 */
public class IntegrationTest {
    private Navigation phaseOne;

    @Mock private Actuators actuators;
    @Mock private UltraSonic ultraSonicFront;
    @Mock private UltraSonic ultraSonicBack;

    @Before
    public void setUp() throws Exception {
        phaseOne = new Navigation();
        MockitoAnnotations.initMocks(this);
        phaseOne.actuators = this.actuators;
        phaseOne.ultraSonic2 = this.ultraSonicBack;
        phaseOne.ultraSonic = this.ultraSonicFront;
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMoveForwardParkUnpark() throws Exception {
        for (int i = 0; i < 501; i++) {
            if (i == 500) {
                Mockito.when(actuators.moveForward(i)).thenReturn(i);
            } else {
                Mockito.when(actuators.moveForward(i)).thenReturn(i + 1);
            }
        }
        for (int j = 500; j > 0; j--) {
            if (j == 1) {
                Mockito.when(actuators.moveBackward(j)).thenReturn(j);
            } else {
                Mockito.when(actuators.moveBackward(j)).thenReturn(j - 1);
            }
        }
        for (int k = 0; k < 501; k++){
            if ((k > 400 && k < 406) || (k > 50 && k < 56)){
                Mockito.when(ultraSonicFront.getDistance()).thenReturn(150);
                Mockito.when(ultraSonicBack.getDistance()).thenReturn(150);
                phaseOne.moveForward();
            } else{
                Mockito.when(ultraSonicFront.getDistance()).thenReturn(10);
                Mockito.when(ultraSonicBack.getDistance()).thenReturn(10);
                phaseOne.moveForward();
            }
        }


        for (int l = 500; l > 250; l--){
            if (l > 400 && l < 406){
                Mockito.when(ultraSonicFront.getDistance()).thenReturn(150);
                Mockito.when(ultraSonicBack.getDistance()).thenReturn(150);
                phaseOne.moveBackward();
            } else{
                Mockito.when(ultraSonicFront.getDistance()).thenReturn(10);
                Mockito.when(ultraSonicBack.getDistance()).thenReturn(10);
                phaseOne.moveBackward();
            }
        }

        phaseOne.park();

        assertEquals(true, phaseOne.isParked);
        assertEquals(405, phaseOne.cStatus.whereIs());


    }


}