package Controllers;

import Models.Actuators;
import Models.UltraSonic;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * Controllers.Navigation Tester.
 *
 * @author Group4
 * @version 1.0
 * @since <pre>Feb 16, 2017</pre>
 */
public class IntegrationTest {
    @Spy
    Navigation spy;
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
        spy = Mockito.spy(phaseOne);
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * Scenario:
     *      1.  Initialize automated parking assistance to park at the nearest parking place. At 35m
     *      2.  Unpark the car from that parking place to 36m.
     *      3.  Move the car to the end of the road. To 500m.
     *      4.  Back the car to 491m.
     *      5.  Move the car one step forward to 492m.
     *      6.  Back the car to 491m.
     *      7.  Move the car to 500m.
     *      8.  Move the car to 401m.
     *      9.  Initialize automated parking assistance to park at the nearest parking place. At 405m
     *      10. Unpark the car from that parking place to 36m.
     *      11. Move the car to 500m.
     *      12. Initialize automated parking assistance to park at the nearest parking place. At 500m
     *
     * @throws Exception
     */
    @Test
    public void testFullIntegrationScenario() throws Exception {
        for (int i = 0; i < 501; i++) {
            if (i == 500) {
                Mockito.when(actuators.moveForward(i)).thenReturn(i);
            } else {
                Mockito.when(actuators.moveForward(i)).thenReturn(i + 1);
            }
        }

        // 1
        phaseOne.park();
        assertEquals(35, phaseOne.cStatus.whereIs());
        assertEquals(true, phaseOne.isParked);

        // 2
        phaseOne.unPark();

        assertEquals(36, phaseOne.cStatus.whereIs());
        assertEquals(false, phaseOne.isParked);

        // 3
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

        // 4
        for (int k = 500; k > 491; k--) {
            Mockito.when(ultraSonic.getDistance()).thenReturn(10);
            Mockito.when(ultraSonic2.getDistance()).thenReturn(10);
            Mockito.when(actuators.moveBackward(k)).thenReturn(k - 1);
            phaseOne.moveBackward();
        }

        // 5
        assertEquals(491, phaseOne.cStatus.whereIs());
        Mockito.when(ultraSonic.getDistance()).thenReturn(10);
        Mockito.when(ultraSonic2.getDistance()).thenReturn(10);
        Mockito.when(actuators.moveForward(491)).thenReturn(492);
        phaseOne.moveForward();

        // 6
        assertEquals(492, phaseOne.cStatus.whereIs());
        Mockito.when(ultraSonic.getDistance()).thenReturn(10);
        Mockito.when(ultraSonic2.getDistance()).thenReturn(10);
        Mockito.when(actuators.moveBackward(492)).thenReturn(491);
        phaseOne.moveBackward();

        assertEquals(491, phaseOne.cStatus.whereIs());

        // 7
        for (int l = 491; l < 501; l++) {
            Mockito.when(ultraSonic.getDistance()).thenReturn(10);
            Mockito.when(ultraSonic2.getDistance()).thenReturn(10);
            Mockito.when(actuators.moveForward(l)).thenReturn(l + 1);
            phaseOne.moveForward();
        }

        assertEquals(500, phaseOne.cStatus.whereIs());

        // 8
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

        // 9
        phaseOne.park();

        assertEquals(true, phaseOne.isParked);
        assertEquals(405, phaseOne.cStatus.whereIs());

        // 10
        phaseOne.unPark();

        assertEquals(false, phaseOne.isParked);
        assertEquals(406, phaseOne.cStatus.whereIs());

        // 11
        for (int l = 406; l < 501; l++) {
            Mockito.when(ultraSonic.getDistance()).thenReturn(10);
            Mockito.when(ultraSonic2.getDistance()).thenReturn(10);
            Mockito.when(actuators.moveForward(l)).thenReturn(l + 1);
            phaseOne.moveForward();
        }

        // 12
        phaseOne.park();

        assertEquals(true, phaseOne.isParked);
        assertEquals(500, phaseOne.cStatus.whereIs());


    }

    /**
     * Scenario:
     *      1.  Initialize automated parking assistance to park at the nearest parking place. At 35m
     *      2.  Unpark the car from that parking place to 36m.
     *      3.  Move the car to the end of the road. To 500m.
     *      4.  Back the car to 491m.
     *      5.  Move the car one step forward to 492m.
     *      6.  Back the car to 491m.
     *      7.  Move the car to 500m.
     *      8.  Move the car to 401m.
     *      9.  Initialize automated parking assistance to park at the nearest parking place. At 405m
     *      10. Unpark the car from that parking place to 36m.
     *      11. Move the car to 500m.
     *
     * @throws Exception
     */
    @Test
    public void testFullIntegrationScenarioWithOneFailingSensor() throws Exception {
        for (int i = 0; i < 501; i++) {
            if (i == 500) {
                Mockito.when(actuators.moveForward(i)).thenReturn(i);
            } else {
                Mockito.when(actuators.moveForward(i)).thenReturn(i + 1);
            }
        }

        // 3
        for (int i = 0; i < 501; i++) {

            if ((i + 1) > 50 && (i + 1) < 56) {
                Mockito.when(ultraSonic.getDistance()).thenReturn(-1);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(150);
                phaseOne.moveForward();
            } else if ((i + 1) == 40) {
                Mockito.when(ultraSonic.getDistance()).thenReturn(-1);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(300);
                phaseOne.moveForward();
            } else if ((i + 1) == 41) {
                Mockito.when(ultraSonic.getDistance()).thenReturn(-1);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(300);
                phaseOne.moveForward();
            } else if ((i + 1) == 42) {
                Mockito.when(ultraSonic.getDistance()).thenReturn(-1);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(300);
                phaseOne.moveForward();
            } else if (((i + 1) > 495 && (i + 1) < 501) || ((i + 1) > 30 && (i + 1) < 36)) {

                phaseOne.moveForward();
            }else {
                Mockito.when(ultraSonic.getDistance()).thenReturn(-1);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(10);
                phaseOne.moveForward();
            }
        }

        assertEquals(500, phaseOne.cStatus.whereIs());


        // 8
        for (int j = 500; j > 0; j--) {

            if (j == 1) {
                Mockito.when(actuators.moveBackward(j)).thenReturn(j);
            } else {
                Mockito.when(actuators.moveBackward(j)).thenReturn(j - 1);
            }

            if ((j - 1) > 50 && (j - 1) < 56) {
                Mockito.when(ultraSonic.getDistance()).thenReturn(-1);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(150);
                phaseOne.moveBackward();
            } else if ((j - 1) == 40) {
                Mockito.when(ultraSonic.getDistance()).thenReturn(-1);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(300);
                phaseOne.moveBackward();
            } else if ((j - 1) == 41) {
                Mockito.when(ultraSonic.getDistance()).thenReturn(-1);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(300);
                phaseOne.moveBackward();
            } else if ((j - 1) == 42) {
                Mockito.when(ultraSonic.getDistance()).thenReturn(-1);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(300);
                phaseOne.moveBackward();
            } else if (((j - 1) > 495 && (j - 1) < 501) || ((j - 1) > 30 && (j - 1) < 36)) {
                doReturn(0).when(spy).isEmpty();
                phaseOne.moveBackward();
            }else {
                Mockito.when(ultraSonic.getDistance()).thenReturn(-1);
                Mockito.when(ultraSonic2.getDistance()).thenReturn(10);
                phaseOne.moveBackward();
            }
        }

        // 9
        phaseOne.park();

        assertEquals(true, phaseOne.isParked);
        assertEquals(500, phaseOne.cStatus.whereIs());

    }


}