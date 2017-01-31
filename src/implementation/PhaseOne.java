package implementation;

/**
 * @author by Geoffrey on 2017-01-27.
 */
public interface PhaseOne {

    /**
     Description: Moves the car 1 meter forward. Returns the current position of the car and the status of the status of
     the detected parking places up till now.

     Pre-condition: 0<= Position < 500; isParked = false;

     Post-condition: 0 <= Position <= 500, is_empty status;

     Test-cases: TODO

     */
    public int[] moveForward();

    /**
     isEmpty: This method queries the two ultrasound sensors at least 5 times and filters the noise in their results
     and returns the distance to the nearest object in the right hand side. If one sensor is detected to continuously
     return very noisy output, it should be completely disregarded.

     Pre-condition: sensors are on and feeding data

     Post-Condition: int distance to target
     */
    public int isEmpty();

    /**
     Description: Method that behaves as MoveForward, with the difference that it moves the car 1 meter backwards.

     Pre-condition:int: Position != 0; isParked = false;

     Post-condition:  0<= Position < 500

     Test-cases: TODO

     */
    public int[] moveBackward();

    /**
     Description:  It moves the car to the beginning of the current 5 meter free stretch of parking place,
     if it is already detected or moves the car forwards towards the end of the street until such a stretch is detected.
     Then it performs a pre-programmed reverse parallel parking maneuver.

     Pre-condition:int: isParked = false;

     Post-condition:  isParked = true; canPark = false;

     Test-cases: TODO

     */
    public void park();

    /**
     UnPark: It moves the car forward (and to left) to front of the parking place, if it is parked.

     Pre-condition: boolean isParked = true;

     Post-condition isParked = false, canPark = true;

     Test-cases: TODO

     */
    public boolean unPark();


    /**
     Description:  This method returns the current position of the car in the street as well as its situation
     (whether it is parked or not).

     Pre-condition:int: nothing relevant to this method;

     Post-condition:  return position and isParked;

     Test-cases: TODO

     */
    public int whereIs();
    //TODO today

}
