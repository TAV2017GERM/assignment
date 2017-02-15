package Models;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
class UltraSonicTest {
    @Mock
    UltraSonic USMock;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void measureDistance() {


    }

    @Test
    void getDistance() {

    }

}