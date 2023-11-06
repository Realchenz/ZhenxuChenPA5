package main;
/**
 * PitStop class
 */
public class PitStop {
    /**
     * This method will make the car enter the pit stop
     * @param car the car to be entered
     */
    public void enterPitStop(Car car) {
        if (car.isDamagedCrossPitStop) {
            car.pitStopPause = 2;
        }
    }

    /**
     * This method will make the car exit the pit stop
     * @param car the car to be exited
     */
    public void exitPitStop(Car car) {
        car.isDamaged = false;
        car.realSpeed += car.strength * 5;
    }

}
