package main;
/**
 * This class represents a finish line.
 * <p>Any cars cross the finish line will not continue moving</p>
 *
 * @author Zhenxu Chen
 * @address zhenxuchen@brandeis.edu
 * @date Nov, 2023
 * @assignment PA5
 */
public class FinishLine {
    /**
     * the rank of the car
     */
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

    /**
     * Judge whether all cars finish laps
     * @param cars all participating cars
     * @return whether all cars finish laps
     */
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

