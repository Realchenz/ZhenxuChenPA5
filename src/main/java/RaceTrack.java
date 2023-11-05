public class RaceTrack {
    private Car[] cars;
    private final FinishLine finishLine;
    private final PitStop pitStop;

    /**
     * DO NOT REMOVE THIS - you should be using this to log this track's events. For more see the assignment PDF / documentation for TrackLoggerB.java
     */
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
     * This method runs one tick. A tick moves every car a set distance
     * equal to its speed. If a car is damaged and passes the 75 unit mark during this tick, it enters the
     * pitstop. Upon exiting the pitstop, it starts at the 75 unit mark and immediately moves according to
     * its speed. After all the cars have moved their set distance, the Tick method should check for
     * collisions and deal with them appropriately.
     */
    public void tick() {
        logger.logNewTick();
        for (Car car : cars) {
            if (car.pitStopPause > 0) {
                car.pitStopPause--;
                if (car.pitStopPause == 0) {
                    pitStop.exitPitStop(car);
                    logger.logExitPit(car);
                }
            } else if (!car.isFinished) car.move();
        }
        for (Car car : cars) {
            if(car.isFinished) continue;
            finishLine.enterFinishLine(car);
            if(car.isFinished) logger.logFinish(car, finishLine.getPlace());
        }
        for (Car car : cars) {
            if (car.isDamagedCrossPitStop) {
                logger.logEnterPit(car);
                pitStop.enterPitStop(car);
                car.isDamagedCrossPitStop = false;
            }
        }
        checkCollision();
    }

    public void checkCollision() {
        int length = cars.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (cars[i].getLocation() == cars[j].getLocation() && cars[i].getLocation() != 75) {
                    logger.logDamaged(cars[i]);
                    cars[i].collide();
                    logger.logDamaged(cars[j]);
                    cars[j].collide();
                }
            }
        }
    }

    public void run() {
        int ticks = 0;
        if (cars == null) {
            throw new IllegalStateException("cars have not been set");
        }
        while (!finishLine.isRaceOver(cars)) {
            tick();
            ticks++;
        }
        int score = calculateScore(ticks);
        logger.logScore(score);
    }

    public int calculateScore(int ticks) {
        int score = 0;
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

    /**
     * This method returns the logger instance used by this RaceTrack. You <b>SHOULD NOT</b> be using this method.
     *
     * @return logger with this track's events
     */
    public TrackLoggerC getLogger() {
        return logger;
    }

}
