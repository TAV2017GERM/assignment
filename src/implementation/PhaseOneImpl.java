package implementation;

/**
 * @author by Group4 on 2017-01-27.
 */
public class PhaseOneImpl implements PhaseOne {
    private int POSITION = 0;
    private int IS_EMPTY_COUNTER = 0;

    public int[] carStatus = {POSITION, IS_EMPTY_COUNTER};
    private int[] parkingPlaces = new int[501];
    public boolean isParked = false;
    private boolean drivingForward = false;

    public int[] moveForward() {
        if (whereIs() < 500 && !isParked) { // Added so that it doesn't move past 500
            if (!drivingForward) {          // Check if the car is driving forward
                drivingForward = true;      // Change the direction of the car if its not driving forward

                if (carStatus[1] > 0)
                    carStatus[1] = 1;       // Set the IS_EMPTY_COUNTER of the car to 1 if its bigger than 0
                else
                    carStatus[1] = 0;       // Set the IS_EMPTY_COUNTER of the car to 0
            }
            carStatus[0] += 1;              // Increments the position of the car

            if (isEmpty() == 1) {           // Check if there is an available parking place
                carStatus[1]++;             // Increments IS_EMPTY_COUNTER if there is an available spot

                if (carStatus[1] == 5) {    // Check if the IS_EMPTY_COUNTER is equal to 5.

                    // Stores the parking place to parkingPlaces
                    parkingPlaces[whereIs()] = whereIs();
                    parkingPlaces[whereIs() - 1] = whereIs();
                    parkingPlaces[whereIs() - 2] = whereIs();
                    parkingPlaces[whereIs() - 3] = whereIs();
                    parkingPlaces[whereIs() - 4] = whereIs();
                }

            } else {                            // If there isn't an available parking place
                carStatus[1] = 0;               // Reset the IS_EMPTY_COUNTER
                parkingPlaces[whereIs()] = 0;   // Set this position in parkingPlaces to 0 (not free)
            }
        }
        return carStatus;       // Return the status of the car
    }

    public int[] moveBackward() {
        if (whereIs() > 1 && !isParked) {       // Added so that it doesn't move past 0
            if (drivingForward) {               // Check if the car is driving forward
                drivingForward = false;         // Change the direction of the car if it's driving forward

                if (carStatus[1] > 0)
                    carStatus[1] = 1;           // Set the IS_EMPTY_COUNTER of the car to 1 if its bigger than 0
                else
                    carStatus[1] = 0;           // Set the IS_EMPTY_COUNTER of the car to 0
            }
            carStatus[0] -= 1;                  // Decrements the position of the car

            if (isEmpty() == 1) {               // Check if there is an available parking place
                carStatus[1]++;                 // Increments IS_EMPTY_COUNTER if there is an available spot

                if (carStatus[1] == 5) {        // Check if the IS_EMPTY_COUNTER is equal to 5.

                    // Stores the parking place to parkingPlaces
                    parkingPlaces[whereIs()] = whereIs();
                    parkingPlaces[whereIs() + 1] = whereIs();
                    parkingPlaces[whereIs() + 2] = whereIs();
                    parkingPlaces[whereIs() + 3] = whereIs();
                    parkingPlaces[whereIs() + 4] = whereIs();
                }

            } else {                            // If there isn't an available parking place
                carStatus[1] = 0;               // Reset the IS_EMPTY_COUNTER
                parkingPlaces[whereIs()] = 0;   // Set this position in parkingPlaces to 0 (not free)
            }
        }
        return carStatus;       // Return the status of the car
    }

    public void park() {
        // Check if the car isn't at the first position and that it isn't parked
        if (!(parkingPlaces[whereIs()] == 0) && whereIs() != parkingPlaces[whereIs()]) {

            // TODO - WHAT IS THIS??? Don't know what to comment
            if (whereIs() < parkingPlaces[whereIs()]) {
                while (whereIs() != parkingPlaces[whereIs()] && !isParked) {
                    moveForward();
                }
                if (whereIs() == parkingPlaces[whereIs()]) isParked = true;
            } else {
                while (whereIs() != parkingPlaces[whereIs()] && !isParked) {
                    moveBackward();
                }
                if (whereIs() == parkingPlaces[whereIs()]) isParked = true;
            }
        } else if (whereIs() != 0 && whereIs() == parkingPlaces[whereIs()]) {
            isParked = true;                    // Set the parking state of the car to parked (true)
        } else {
            int i = whereIs();                  // Initialize basic counter
            do
            {                                   // Do While loop for iterating 500 times or until 5 consecutive free spaces are registered
                moveForward();                  // Move the car 1 meter and returns the status of the car
                if (carStatus[1] == 5) {        // Check if there is enough spaces (5) to park the car or not
                    isParked = true;            // Set the parking state of the car to parked (true)
                    carStatus[1] = 0;           // Reset the IS_EMPTY_COUNTER of the car
                }
                i++;
            } while (i < 500 && !isParked);
        }
    }

    public void unPark() {
        if (isParked) {                             // Check if car is parked
            isParked = false;                       // Make car unparked
            if (whereIs() != 500) moveForward();    // Move forward one click if the car is not at the end of the road
        }
    }

    public int whereIs() {
        return carStatus[0];    // Return the position of the car
    }

    public int isEmpty() {
        int i = whereIs();      // Store the position of the car

        // Simulation of parking places at 496-500 and 31-35. TODO - Integrate sensors, not part of PHASE ONE
        if ((i > 495 && i < 501) || (i > 30 && i < 36)) {
            return 1;           // 1 == empty
        }
        return 0;           // 0 != empty

    }
}
