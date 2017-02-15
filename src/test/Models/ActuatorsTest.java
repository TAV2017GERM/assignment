package Models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

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
        MockitoAnnotations.initMocks(actu);
    }

    @Test
    public void testRunFwd() throws Exception {

    }

    @Test
    public void testRunBkd() throws Exception {

    }

}