public class PitStop {

    public void enterPitStop(Car car) {
        if (car.isDamagedCrossPitStop) {
            car.pitStopPause = 2;
        }
    }

    public void exitPitStop(Car car) {
        car.isDamaged = false;
        car.realSpeed += car.strength * 5;
    }

}
