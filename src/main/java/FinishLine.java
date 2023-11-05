public class FinishLine {
    private int place = 0;

    public void enterFinishLine(Car car) {
        if (car.laps >= 10) {
            place++;
            car.isFinished = true;
        }

    }

    public boolean finished() {
        return true;
    }

    public boolean isRaceOver(Car[] cars) {
        for (Car car : cars) {
            if (!car.isFinished) {
                return false;
            }
        }
        return finished();
    }

    public int getPlace() {
        return place;
    }
}

