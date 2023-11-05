public class PitStop {

    public void enterPitStop(Car car) {
        car.pitStopPause = 2;
    }

    public void exitPitStop(Car car) {
        car.isDamaged = false;
        car.speed += car.strength * 5;
    }

}
