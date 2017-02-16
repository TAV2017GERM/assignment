package Models;

/**
 * @author Group 4 on 2/13/17.
 */
public interface CarStatusInterface {


    /**
     * Description: Sets the index holding the car position in the status array
     * <p>
     * Pre-condition: status array instantiated;
     * <p>
     * Post-condition: array[0] updated;
     * <p>
     * Test-cases:
     */
    void setCarPosition(int position);

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

    /**
     * Description: Registers the value resulting from sensor data on a scanned potential parking place
     * <p>
     * Pre-condition: parkingPlaces array instantiated;
     * <p>
     * Post-condition: parkingPlaces array updated;
     * <p>
     * Test-cases:
     */
    void registerParkingPlaces(int i);

    /**
     * Description: Returns the current status of parking place availability
     * <p>
     * Pre-condition: status array instantiated and populated;
     * <p>
     * Post-condition: return parking place availability;
     * <p>
     * Test-cases:
     */
    int fetchParkingPlace(int position);

    int[] getCarStatus();

}
