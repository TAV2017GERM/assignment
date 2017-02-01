package implementation;

import java.util.Stack;

/**
 * @author by Group4 on 2017-01-27.
 */
public class PhaseOneImpl implements PhaseOne {
    private int POSITION = 0;
    private int IS_EMPTY_COUNTER = 0;

    public int[] carStatus = {POSITION, IS_EMPTY_COUNTER};
    private Stack<Integer> parkingPlaces = new Stack<>();
    public boolean isParked = false;

    public int[] moveForward() {
        if (whereIs() < 500 && !isParked) {  // Added so that it doesn't move past 500
            carStatus[0] += 1;  // Increments the position of the car
            if (isEmpty() == 1) {
                carStatus[1]++;
                if (carStatus[1] == 5) parkingPlaces.push(whereIs());
            }
        }
        return carStatus;       // Return the status of the car
    }

    public int[] moveBackward() {
        if (whereIs() > 1 && !isParked) {     // Added so that it doesn't move past 0
            carStatus[0] -= 1;  // Decrements the position of the car
            if (isEmpty() == 1) {
                carStatus[1]++;
            }
        }
        return carStatus;       // Return the status of the car
    }

    public void park() {
        int i = whereIs();                       // Initialize basic counter
        if (!parkingPlaces.empty() && whereIs() == parkingPlaces.peek()) {
            isParked = true;        // Set the parking state of the car to parked (true)

        } else {
            do
            {                            // Do While loop for iterating 500 times or until 5 consecutive free spaces are registered

                moveForward();              // Move the car 1 meter and returns the status of the car
                if (carStatus[1] == 5) {    // Check if there is enough spaces (5) to park the car or not
                    isParked = true;        // Set the parking state of the car to parked (true)
                    carStatus[1] = 0;       // Reset the IS_EMPTY_COUNTER of the car
                }
                i++;
            } while (i < 500 && !isParked);
        }
    }

    public void unPark() {
        if (isParked) {
            isParked = false;
            if (whereIs() != 500) carStatus[0] += 1;
        }
    }

    public int whereIs() {
        return carStatus[0];    // Return the position of the car
    }

    public int isEmpty() {

//        return (int) (Math.random() * 2);
        // return 0;      // Returns the integer o
        int i = whereIs();      // Store the position of the car
        if ((i > 495 && i < 501) || (i > 30 && i < 36)) {       // Hard coded "empty" space 31 - 35
            return 1;           // 1 == empty
        }

        return 0;           // 0 != empty

    }
}
