import implementation.PhaseOne;
import implementation.PhaseOneImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* implementation.PhaseOneImpl Tester.
* 
* @author GeoffreyC
* @since <pre>Jan 30, 2017</pre> 
* @version 1.0 
*/ 
public class PhaseOneImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: MoveForward() 
* 
*/ 
@Test
public void testMoveForward() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: MoveBackward() 
* 
*/ 
@Test
public void testMoveBackward() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: Park() 
* 
*/ 
@Test
public void testPark() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: unPark() 
* 
*/ 
@Test
public void testUnPark() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: Wherels() 
* 
*/ 
@Test
public void testWhereIs() throws Exception {
    PhaseOneImpl phaseOne = new PhaseOneImpl();
    Assert.assertEquals(phaseOne.whereIs(), 0);
} 

/** 
* 
* Method: isEmpty() 
* 
*/ 
@Test
public void testIsEmpty() throws Exception { 
//TODO: Test goes here...
} 


} 
