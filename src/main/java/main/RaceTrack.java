package main;

import lombok.Getter;

/**
 * This class represents a racetrack that hold cars and racetrack components. The racetrack class will also run
 * the race itself as a simulation game.
 *
 * @author Zhenxu Chen
 * @address zhenxuchen@brandeis.edu
 * @date Nov, 2023
 * @assignment PA5
 * @version 1.0
 */
public class RaceTrack {
    private Car[] cars;
    private final FinishLine finishLine;
    private final PitStop pitStop;

    /**
     * DO NOT REMOVE THIS - you should be using this to log this track's events. For more see the assignment PDF / documentation for TrackLoggerB.java
     * -- GETTER --
     *  This method returns the logger instance used by this RaceTrack. You <b>SHOULD NOT</b> be using this method.
     *
     * @return logger with this track's events

     */
    @Getter
    private final TrackLoggerC logger;

    public RaceTrack() {
        logger = new TrackLoggerC(); // DO NOT REMOVE THIS LINE
        finishLine = new FinishLine();
        pitStop = new PitStop();
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    /**
     * This method will move all the cars on the track forward by one tick. It will also check for collisions and
     * log events to the logger.
     */
    public void tick() {
        logger.logNewTick();  //Creates a new tick log
        for (Car car : cars) {
            //If the car is in the pit stop, it will not move
            if (car.pitStopPause > 0) {
                car.pitStopPause--;
                if (car.pitStopPause == 0) {
                    pitStop.exitPitStop(car);
                    //If the car is leaving the pit stop, it will log the event
                    logger.logExitPit(car);
                    car.move(); //After the car leave the pit stop, it will move
                }
            } else if (!car.isFinished) car.move();
        }
        //If the car is finished, it will not enter the finish line
        for (Car car : cars) {
            if (car.isFinished) continue;
            finishLine.enterFinishLine(car); //Judge whether the car is entering the finish line
            if (car.isFinished) logger.logFinish(car, finishLine.getPlace());
        }
        for (Car car : cars) {
            if (car.isFinished) continue;
            pitStop.enterPitStop(car); //Judge whether the car is entering the pit stop
            if (car.pitStopPause == 2) { //If the car is entering the pit stop, it will log the event
                logger.logEnterPit(car);
            }
            car.isDamagedCrossPitStop = false;
        }
        checkCollision();
    }

    /**
     * This method will check for collisions between cars and log events to the logger.
     */
    public void checkCollision() {
        int length = cars.length;
        for (int i = 0; i < length; i++) {
            if (cars[i].isFinished) continue;
            for (int j = i + 1; j < length; j++) {
                if (cars[j].isFinished) continue;
                //If two cars are in the same location, and they are not at pit stop, they will collide
                if (cars[i].getLocation() == cars[j].getLocation() && cars[i].getLocation() != 75) {
                    if (!cars[i].isDamaged) { //If the car is damaged, it will not collide
                        logger.logDamaged(cars[i]);
                        cars[i].collide();
                    }
                    if (!cars[j].isDamaged) {
                        logger.logDamaged(cars[j]);
                        cars[j].collide();
                    }
                }
            }
        }
    }

    /**
     * Begin the simulation
     */
    public void run() {
        int ticks = 0;
        if (cars == null) {
            throw new IllegalStateException("cars have not been set");
        }
        //Judge whether the game is over
        while (!finishLine.isRaceOver(cars)) {
            tick();
            ticks++;
        }
        int score = calculateScore(ticks);
        logger.logScore(score);
    }

    /**
     * This method will calculate the score of the game
     * @param ticks the number of ticks
     * @return the score of the game
     */
    public int calculateScore(int ticks) {
        int score = 1000;
        for (Car car : cars) {
            if (car instanceof SportsCar) {
                score += 200;
            } else if (car instanceof FormulaOne) {
                score += 100;
            } else if (car instanceof RaceCar) {
                score += 150;
            }
        }
        score -= ticks * 20;
        return score;
    }

}
