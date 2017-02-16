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
 * Created by mattias on 2017-02-16.
 */
public class IntegrationTest {
    @Mock private Actuators actuators;
    @Mock private UltraSonic ultraSonicFront;
    @Mock private UltraSonic ultraSonicBack;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMoveForwardParkUnpark() throws Exception {
        Mockito.when(actuators.moveForward(0)).thenReturn(1);
        Mockito.when(actuators.moveForward(500)).thenReturn(500);
        Mockito.when(ultraSonicFront.getDistance()).thenReturn(100);
        Mockito.when(ultraSonicBack.getDistance()).thenReturn(100);



    }

}