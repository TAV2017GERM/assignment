package Controllers;

import Models.Actuators;
import Models.CarStatus;
import Models.UltraSonic;

import java.util.Observable;
import java.util.Observer;

/**
 * @author by Group4 on 2017-01-27.
 */
public class Navigation extends Observable implements NavigationInterface {
    boolean isParked;
    private boolean drivingForward;
    int IS_EMPTY_COUNTER;

    Actuators actuators;
    UltraSonic ultraSonic;
    UltraSonic ultraSonic2;
    CarStatus cStatus;

    public Navigation() {
        IS_EMPTY_COUNTER = 0;
        isParked = false;
        drivingForward = false;
        actuators = new Actuators();
        ultraSonic = new UltraSonic();
        ultraSonic2 = new UltraSonic();
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
                if (IS_EMPTY_COUNTER > 0) IS_EMPTY_COUNTER = 1;
                else IS_EMPTY_COUNTER = 0;
            }

            int carPos = cStatus.whereIs();
            int newCarPos = actuators.moveBackward(carPos);          // Increments the position of the car

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

        if (carPos == 0) {
            moveForward();
            park();
        } else {
            if (!(cStatus.fetchParkingPlace(carPos) == 0) && carPos != cStatus.fetchParkingPlace(carPos)) {
                if (carPos < cStatus.fetchParkingPlace(carPos)) {
                    while (cStatus.whereIs() != cStatus.fetchParkingPlace(carPos) && !isParked) {
                        moveForward();
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
        int sensor, sensor2, counter1 = 0, counter2 = 0, total1 = 0, total2 = 0, mean1, mean2, shared_mean = 0;
        int i = cStatus.whereIs();

        if ((i > 495 && i < 501) || (i > 30 && i < 36)) {       // Hard coded "empty" space 31 - 35 and 495 - 500
            return 1;           // 1 == empty
        }

        while (k < 5) {   // while loop that discards unusable values
            sensor = ultraSonic.getDistance();
            sensor2 = ultraSonic2.getDistance();

            if (sensor >= 0 && sensor <= 200) {
                total1 += sensor;
                counter1++;
            }
            if (sensor2 >= 0 && sensor2 <= 200) {
                total2 += sensor2;
                counter2++;
            }
            k++;
        }

        if (total1 != 0 && total2 != 0) {
            mean1 = total1 / counter1;  //mean value from valid readings from sensor1
            mean2 = total2 / counter2; //mean value from valid readings from sensor2
            shared_mean = (mean1 + mean2) / 2;  // mean value from both sensors
        } else if (total1 == 0 && total2 == 0) {
            return 0;
        } else if (total1 == 0) {
            shared_mean = total2 / counter2;
        } else {
            shared_mean = total1 / counter1;
        }


        if (shared_mean > 150) { //enough place to park
            return 1;
        } else {
            return 0;
        }
    }

//      Method is intended for UI class, it is not used yet.
//    @Override
//    public void update(Observable observable, Object o) {
//
//    }
}
