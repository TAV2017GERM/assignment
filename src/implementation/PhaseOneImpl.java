package implementation;

/**
 * @author by Geoffrey on 2017-01-27.
 */
public class PhaseOneImpl implements PhaseOne {
    private int POSITION = 0;
    private int IS_EMPTY_COUNTER = 0;

    public int[] carStatus = {POSITION, IS_EMPTY_COUNTER};
    public boolean isParked = false;

    public int[] moveForward() {
        if (whereIs() < 500) {  // Added so that it doesn't move past 500
            carStatus[0] += 1;  // Increments the position of the car
            if(isEmpty()==1){
                carStatus[1]++;
            }
        }
        return carStatus;       // Return the status of the car
    }

    public int[] moveBackward() {
        if (whereIs() > 0) {     // Added so that it doesn't move past 0
            carStatus[0] -= 1;  // Decrements the position of the car
        }
        return carStatus;       // Return the status of the car
    }

    public void park() {
        int i= 0;
        do {
            moveForward();
            if(IS_EMPTY_COUNTER==5){
                isParked = true;
                carStatus[1] = 1;
            }
            i++;
        }while(i<500);

    }

    public boolean unPark() {

        return isParked;        // Return the parking status
    }

    public int whereIs() {
        return carStatus[0];    // Return the position of the car
    }

    public int isEmpty() {

//        return (int) (Math.random() * 2);
       // return 0;      // Returns the integer o
        int i = whereIs();
        if(30>i && i<36){
            return 1;
        }else {
            return 0;
        }
    }
}
