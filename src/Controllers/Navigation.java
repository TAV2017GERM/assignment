package Controllers;

import Models.Actuators;
import Models.CarStatus;
import Models.UltraSonic;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author by Group4 on 2017-01-27.
 */
public class Navigation implements NavigationInterface {
     boolean isParked;
    private boolean drivingForward;
     int IS_EMPTY_COUNTER;



    private Actuators actuators;
    private UltraSonic ultraSonic;
    private CarStatus cStatus;

    public Navigation() {
        IS_EMPTY_COUNTER = 0;
        isParked = false;
        drivingForward = false;
        actuators = new Actuators();
        ultraSonic = new UltraSonic();
        cStatus = new CarStatus();

    }

    public int[] moveForward() {
        if (cStatus.whereIs() < 500 && !isParked) {  // Added so that it doesn't move past 500
            if (!drivingForward) {
                drivingForward = true;
                if (IS_EMPTY_COUNTER > 0) IS_EMPTY_COUNTER = 1;
                else IS_EMPTY_COUNTER = 0;
            }
            int carPos = cStatus.whereIs();
            int newCarPos = actuators.moveForward(carPos);          // Increments the position of the car

            cStatus.setCarPosition(newCarPos);

            if (isEmpty() == 1) {
                IS_EMPTY_COUNTER++;
                if (IS_EMPTY_COUNTER == 5) {
                    cStatus.registerParkingPlaces(1);
                }
            } else {
                IS_EMPTY_COUNTER = 0;
                cStatus.registerParkingPlaces(0);
            }
        }
        return cStatus.getCarStatus();       // Return the status of the car
    }

    public int[] moveBackward() {
        if (cStatus.whereIs() > 1 && !isParked) {     // Added so that it doesn't move past 0
            if (drivingForward) {
                drivingForward = false;
                if (IS_EMPTY_COUNTER > 0)IS_EMPTY_COUNTER = 1;
                else IS_EMPTY_COUNTER = 0;
            }

            int carPos = cStatus.whereIs();
            int newCarPos = actuators.moveForward(carPos);          // Increments the position of the car

            cStatus.setCarPosition(newCarPos);

            if (isEmpty() == 1) {
                IS_EMPTY_COUNTER++;
                if (IS_EMPTY_COUNTER == 5) {
                    cStatus.registerParkingPlaces(-1);
                }
            } else {
                IS_EMPTY_COUNTER = 0;
                cStatus.registerParkingPlaces(0);
            }
        }
        return cStatus.getCarStatus();       // Return the status of the car
    }

    public void park() {
        int carPos = cStatus.whereIs();                       // Initialize basic counter
        if (!(cStatus.fetchParkingPlace(carPos) == 0) && carPos != cStatus.fetchParkingPlace(carPos)) {
            if (carPos < cStatus.fetchParkingPlace(carPos)) {
                while (cStatus.whereIs() != cStatus.fetchParkingPlace(carPos) && !isParked) {
                    moveForward();
                }
                if (cStatus.whereIs() == cStatus.fetchParkingPlace(carPos)) isParked = true;
            } else {
                while (cStatus.whereIs() != cStatus.fetchParkingPlace(carPos) && !isParked) {
                    moveBackward();
                }
                if (cStatus.whereIs() == cStatus.fetchParkingPlace(carPos)) isParked = true;
            }
        } else if (cStatus.whereIs() != 0 && cStatus.whereIs() == cStatus.fetchParkingPlace(carPos)) {
            isParked = true;        // Set the parking state of the car to parked (true)
        } else {
            do
            {                            // Do While loop for iterating 500 times or until 5 consecutive free spaces are registered
                moveForward();              // Move the car 1 meter and returns the status of the car
                if (IS_EMPTY_COUNTER == 5) {    // Check if there is enough spaces (5) to park the car or not
                    isParked = true;        // Set the parking state of the car to parked (true)
                    IS_EMPTY_COUNTER = 0;       // Reset the IS_EMPTY_COUNTER of the car
                }
                carPos++;
            } while (carPos < 500 && !isParked);
        }
    }

    public void unPark() {
        if (isParked) {
            isParked = false;
            if (cStatus.whereIs() != 500) moveForward();
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
        int i = cStatus.whereIs();
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
