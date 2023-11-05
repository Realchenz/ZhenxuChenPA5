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

    public void tick() {
        logger.logNewTick();
        for (Car car : cars) {
            if (car.pitStopPause > 0) {
                car.pitStopPause--;
                if (car.pitStopPause == 0) {
                    pitStop.exitPitStop(car);
                    logger.logExitPit(car);
                    car.move();
                }
            } else if (!car.isFinished) car.move();
        }
        for (Car car : cars) {
            if (car.isFinished) continue;
            finishLine.enterFinishLine(car);
            if (car.isFinished) logger.logFinish(car, finishLine.getPlace());
        }
        for (Car car : cars) {
            if (car.isFinished) continue;
            pitStop.enterPitStop(car);
            if(car.pitStopPause == 2) {
                logger.logEnterPit(car);
            }
            car.isDamagedCrossPitStop = false;
        }
        checkCollision();
    }

    public void checkCollision() {
        int length = cars.length;
        for (int i = 0; i < length; i++) {
            if (cars[i].isFinished) continue;
            for (int j = i + 1; j < length; j++) {
                if (cars[j].isFinished) continue;
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

    /**
     * This method returns the logger instance used by this RaceTrack. You <b>SHOULD NOT</b> be using this method.
     *
     * @return logger with this track's events
     */
    public TrackLoggerC getLogger() {
        return logger;
    }

}
