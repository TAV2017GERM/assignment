package Controllers;

import Models.Actuators;
import Models.UltraSonic;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.*;

/**
 * Controllers.Navigation Tester.
 *
 * @author Group4
 * @version 1.0
 * @since <pre>Feb 16, 2017</pre>
 */
public class IntegrationTest {
    @Mock
    private Actuators actuators;
    @Mock
    private UltraSonic ultraSonic;
    @Mock
    private UltraSonic ultraSonic2;
    @InjectMocks
    Navigation phaseOne;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
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

        phaseOne.park();
        assertEquals(35, phaseOne.cStatus.whereIs());
        assertEquals(true, phaseOne.isParked);

        phaseOne.unPark();

        assertEquals(36, phaseOne.cStatus.whereIs());
        assertEquals(false, phaseOne.isParked);

        for (int i = 36; i < 501; i++) {

            if ((i + 1) > 400 && (i + 1) < 406 || (i + 1) > 0 && (i + 1) < 6) {
                Mockito.when(ultraSonic.getDistance()).thenReturn(150);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(150);
                phaseOne.moveForward();
            } else if ((i + 1) == 40) {
                Mockito.when(ultraSonic.getDistance()).thenReturn(300);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(300);
                phaseOne.moveForward();
            } else if ((i + 1) == 41) {
                Mockito.when(ultraSonic.getDistance()).thenReturn(300);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(10);
                phaseOne.moveForward();
            } else if ((i + 1) == 42) {
                Mockito.when(ultraSonic.getDistance()).thenReturn(10);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(300);
                phaseOne.moveForward();
            } else {
                Mockito.when(ultraSonic.getDistance()).thenReturn(10);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(10);
                phaseOne.moveForward();
            }
        }

        for (int k = 500; k > 491; k--) {
            Mockito.when(ultraSonic.getDistance()).thenReturn(10);
            Mockito.when(ultraSonic2.getDistance()).thenReturn(10);
            Mockito.when(actuators.moveBackward(k)).thenReturn(k - 1);
            phaseOne.moveBackward();
        }

        assertEquals(491, phaseOne.cStatus.whereIs());
        Mockito.when(ultraSonic.getDistance()).thenReturn(10);
        Mockito.when(ultraSonic2.getDistance()).thenReturn(10);
        Mockito.when(actuators.moveForward(491)).thenReturn(492);
        phaseOne.moveForward();


        assertEquals(492, phaseOne.cStatus.whereIs());
        Mockito.when(ultraSonic.getDistance()).thenReturn(10);
        Mockito.when(ultraSonic2.getDistance()).thenReturn(10);
        Mockito.when(actuators.moveBackward(492)).thenReturn(491);
        phaseOne.moveBackward();

        assertEquals(491, phaseOne.cStatus.whereIs());

        for (int l = 491; l < 501; l++) {
            Mockito.when(ultraSonic.getDistance()).thenReturn(10);
            Mockito.when(ultraSonic2.getDistance()).thenReturn(10);
            Mockito.when(actuators.moveForward(l)).thenReturn(l + 1);
            phaseOne.moveForward();
        }

        assertEquals(500, phaseOne.cStatus.whereIs());

        for (int j = 500; j > 401; j--) {

            if (j == 1) {
                Mockito.when(actuators.moveBackward(j)).thenReturn(j);
            } else {
                Mockito.when(actuators.moveBackward(j)).thenReturn(j - 1);
            }

            if ((j - 1) > 400 && (j - 1) < 406 || (j - 1) > 50 && (j - 1) < 56) {
                Mockito.when(ultraSonic.getDistance()).thenReturn(150);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(150);
                phaseOne.moveBackward();
            } else {
                Mockito.when(ultraSonic.getDistance()).thenReturn(10);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(10);
                phaseOne.moveBackward();
            }
        }

        phaseOne.park();

        assertEquals(true, phaseOne.isParked);
        assertEquals(405, phaseOne.cStatus.whereIs());

        phaseOne.unPark();

        assertEquals(false, phaseOne.isParked);
        assertEquals(406, phaseOne.cStatus.whereIs());

        for (int l = 406; l < 501; l++) {
            Mockito.when(ultraSonic.getDistance()).thenReturn(10);
            Mockito.when(ultraSonic2.getDistance()).thenReturn(10);
            Mockito.when(actuators.moveForward(l)).thenReturn(l + 1);
            phaseOne.moveForward();
        }

        phaseOne.park();

        assertEquals(true, phaseOne.isParked);
        assertEquals(500, phaseOne.cStatus.whereIs());


    }


}