package Controllers;

/**
 * @author by Group4 on 2017-01-27.
 */
interface ControllerInterface{

    /**
     * Description: Moves the car 1 meter forward. Returns the current position of the car and the status of the status of
     * the detected parking places up till now.
     * <p>
     * Pre-condition: 0<= Position < 500; isParked = false;
     * <p>
     * Post-condition: 0 <= Position <= 500, is_empty status;
     * <p>
     * Test-cases: testMoveForwardOnce, testMoveForwardOOB, testMoveForwardParkStatus, testParkCarMovedForward,
     * testMoveForward500carStatus, testParkMoveFindParking, testParkStopAtParking, testMoveForwardAfterParked,
     * testUnParkMoveForward, testFinalTest.
     */
    int[] moveForward();

    /**
     * isEmpty: This method queries the two ultrasound sensors at least 5 times and filters the noise in their results
     * and returns the distance to the nearest object in the right hand side. If one sensor is detected to continuously
     * return very noisy output, it should be completely disregarded.
     * <p>
     * Pre-condition: sensors are on and feeding data
     * <p>
     * Post-Condition: int distance to target
     * <p>
     * Test-cases: testIsEmpty, testMoveForwardParkStatus, testMoveBackwardParkStatus, testMoveForward500carStatus.
     */
    int isEmpty();

    /**
     * Description: Method that behaves as MoveForward, with the difference that it moves the car 1 meter backwards.
     * <p>
     * Pre-condition:int: Position != 0; isParked = false;
     * <p>
     * Post-condition:  0<= Position < 500
     * <p>
     * Test-cases: testMoveBackwardOnce, testMoveBackwardOOB, testMoveBackwardParkStatus, testMoveBackwardAfterParked,
     * testUnParkMoveBackward, testParkAfterMoveBackward, testFinalTest.
     */
    int[] moveBackward();

    /**
     * Description:  It moves the car to the beginning of the current 5 meter free stretch of parking place,
     * if it is already detected or moves the car forwards towards the end of the street until such a stretch is detected.
     * Then it performs a pre-programmed reverse parallel parking maneuver.
     * <p>
     * Pre-condition:int: isParked = false;
     * <p>
     * Post-condition:  isParked = true; canPark = false;
     * <p>
     * Test-cases: testParkCarMovedForward, testParkMoveFindParking, testParkStopAtParking, testMoveForwardAfterParked,
     * testMoveBackwardAfterParked, testUnParkMoveForward, testUnParkMoveBackward, testParkAfterMoveBackward, testFinalTest.
     */
    void park();

    /**
     * UnPark: It moves the car forward (and to left) to front of the parking place, if it is parked.
     * <p>
     * Pre-condition: boolean isParked = true;
     * <p>
     * Post-condition isParked = false, canPark = true;
     * <p>
     * Test-cases: testUnPark, testUnParkAt500, testUnParkAt35.
     */
    void unPark();


    /**
     * Description:  This method returns the current position of the car in the street as well as its situation
     * (whether it is parked or not).
     * <p>
     * Pre-condition:int: nothing relevant to this method;
     * <p>
     * Post-condition:  return position and isParked;
     * <p>
     * Test-cases: testWhereIs, testMoveForwardOnce, testMoveBackwardOnce, testMoveForwardOOB, testMoveBackwardOOB.
     */
    int whereIs();

}
