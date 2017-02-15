package Controllers;

import Models.Actuators;
import Models.CarStatus;
import Models.UltraSonic;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author by Group4 on 2017-01-27.
 */
public class Navigation implements NavigationInterface {
    private int POSITION = 0;
    private int IS_EMPTY_COUNTER = 0;

    public int[] carStatus = {POSITION, IS_EMPTY_COUNTER};
    private int[] parkingPlaces = new int[501];
    public boolean isParked = false;
    private boolean drivingForward = false;
    private Actuators actuators;
    private UltraSonic ultraSonic;
    private CarStatus cStatus;

    public Navigation() {

        actuators = new Actuators();
        ultraSonic = new UltraSonic();
        cStatus = new CarStatus();

    }

    public int[] moveForward() {
        if (cStatus.whereIs(carStatus) < 500 && !isParked) {  // Added so that it doesn't move past 500
            if (!drivingForward) {
                drivingForward = true;
                if (carStatus[1] > 0) carStatus[1] = 1;
                else carStatus[1] = 0;
            }
            carStatus[0] += 1;  // Increments the position of the car
            if (isEmpty() == 1) {
                carStatus[1]++;
                if (carStatus[1] == 5) {
                    parkingPlaces[cStatus.whereIs(carStatus)] = cStatus.whereIs(carStatus);
                    parkingPlaces[cStatus.whereIs(carStatus) - 1] = cStatus.whereIs(carStatus);
                    parkingPlaces[cStatus.whereIs(carStatus) - 2] = cStatus.whereIs(carStatus);
                    parkingPlaces[cStatus.whereIs(carStatus) - 3] = cStatus.whereIs(carStatus);
                    parkingPlaces[cStatus.whereIs(carStatus) - 4] = cStatus.whereIs(carStatus);
                }
            } else {
                carStatus[1] = 0;
                parkingPlaces[cStatus.whereIs(carStatus)] = 0;
            }
        }
        return carStatus;       // Return the status of the car
    }

    public int[] moveBackward() {
        if (cStatus.whereIs(carStatus) > 1 && !isParked) {     // Added so that it doesn't move past 0
            if (drivingForward) {
                drivingForward = false;
                if (carStatus[1] > 0) carStatus[1] = 1;
                else carStatus[1] = 0;
            }
            carStatus[0] -= 1;  // Decrements the position of the car
            if (isEmpty() == 1) {
                carStatus[1]++;
                if (carStatus[1] == 5) {
                    parkingPlaces[cStatus.whereIs(carStatus)] = cStatus.whereIs(carStatus);
                    parkingPlaces[cStatus.whereIs(carStatus) + 1] = cStatus.whereIs(carStatus);
                    parkingPlaces[cStatus.whereIs(carStatus) + 2] = cStatus.whereIs(carStatus);
                    parkingPlaces[cStatus.whereIs(carStatus) + 3] = cStatus.whereIs(carStatus);
                    parkingPlaces[cStatus.whereIs(carStatus) + 4] = cStatus.whereIs(carStatus);
                }
            } else {
                carStatus[1] = 0;
                parkingPlaces[cStatus.whereIs(carStatus)] = 0;
            }
        }
        return carStatus;       // Return the status of the car
    }

    public void park() {
        int i = cStatus.whereIs(carStatus);                       // Initialize basic counter
        if (!(parkingPlaces[cStatus.whereIs(carStatus)] == 0) && cStatus.whereIs(carStatus) != parkingPlaces[cStatus.whereIs(carStatus)]) {
            if (cStatus.whereIs(carStatus) < parkingPlaces[cStatus.whereIs(carStatus)]) {
                while (cStatus.whereIs(carStatus) != parkingPlaces[cStatus.whereIs(carStatus)] && !isParked) {
                    moveForward();
                }
                if (cStatus.whereIs(carStatus) == parkingPlaces[cStatus.whereIs(carStatus)]) isParked = true;
            } else {
                while (cStatus.whereIs(carStatus) != parkingPlaces[cStatus.whereIs(carStatus)] && !isParked) {
                    moveBackward();
                }
                if (cStatus.whereIs(carStatus) == parkingPlaces[cStatus.whereIs(carStatus)]) isParked = true;
            }
        } else if (cStatus.whereIs(carStatus) != 0 && cStatus.whereIs(carStatus) == parkingPlaces[cStatus.whereIs(carStatus)]) {
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
            if (cStatus.whereIs(carStatus) != 500) moveForward();
        }
    }

    public int isEmpty() {
        //simulate random sensor data
        int k = 0;
        int sensor1, badSensor, total1 = 0, total2 = 0, readingToReturn;
        while (k < 5) {
            sensor1 = ThreadLocalRandom.current().nextInt(0, 200);
            badSensor = ThreadLocalRandom.current().nextInt(200, 300);
            total1 += sensor1;
            total2 += badSensor;
            k++;
        }
        int i = cStatus.whereIs(carStatus);
        if ((i > 495 && i < 501) || (i > 30 && i < 36)) {       // Hard coded "empty" space 31 - 35 and 495 - 500
            return 1;           // 1 == empty
        } else {
            if ((total1 / 5) > 200) { //sensor1 providing unusable values
                readingToReturn = total2 / 5;
                return readingToReturn;
            } else if ((total2 / 5) > 200) {   //sensor2 providing unusable values
                readingToReturn = total1 / 5;
                return readingToReturn;
            }

            // Store the position of the car
        }

        return 0;

    }
}
