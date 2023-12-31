package main;
import lombok.extern.slf4j.Slf4j;

import java.util.InputMismatchException;
import java.util.Scanner;

@Slf4j
public class SimulationDriverC {

    /**
     * Holds the String that a user should enter to specify a RaceCar type car.
     */
    public static final String TYPE_RACE_CAR = "R";

    /**
     * Holds the String that a user should enter to specify a FormulaOne type car.
     */
    public static final String TYPE_FORMULA_ONE = "F";

    /**
     * Holds the String that a user should enter to specify a SportsCar type car.
     */
    public static final String TYPE_SPORTS_CAR = "S";

    /**
     * Value to signify a default stat value.
     */
    public static final int DEFAULT_STAT_VAL = 0;

    public static void main(String[] args) {
        RaceTrack track = new RaceTrack();
        track.setCars(getSomeCars());
        log.info("The race has started!");
        track.run();
    }

    /**
     * Runs a short program that allows the user to set up the simulation for part B. The user will be prompted to
     * set up some number of Cars using the format outlined on the PDF.
     *
     * @return an array of Cars constructed by the user
     */
    public static Car[] getSomeCars() {
        log.info("Welcome to the Need for Speed Simulator!\n\nFor each Car: enter the speed, strength, and car type separated by a space.\nTo create a RaceCar use " + TYPE_RACE_CAR + ", to create a FormulaOne use " + TYPE_FORMULA_ONE + " or to create a SportsCar use " + TYPE_SPORTS_CAR + ".\nIf you want to construct a default Car of some type, enter " + DEFAULT_STAT_VAL + " for the speed and strength.\n");
        Scanner consoleRdr = new Scanner(System.in);
        boolean waitingForValidIn = true;
        int numCars = 0;
        do {
            log.info("How many Cars would you like to enter in the race? ");
            try {
                numCars = consoleRdr.nextInt();
            } catch (InputMismatchException e) {
                log.info("Non-integer values are not allowed.");
                consoleRdr.nextLine();
            }
            if (numCars >= 0) {
                waitingForValidIn = false;
            } else {
                log.info("Number of cars being created must be a nonnegative number.");
            }
        } while (waitingForValidIn);
        waitingForValidIn = true;
        Car[] cars = new Car[numCars];

        // all inputs will have only 3 characters, no more no less!
        for (int i = 0; i < numCars; i++) {
            do {
                log.info("Car #" + (i + 1) + ": ");
                try {
                    int speed = consoleRdr.nextInt();
                    int strength = consoleRdr.nextInt();
                    String carType = consoleRdr.next();
                    if (speed == DEFAULT_STAT_VAL && strength == DEFAULT_STAT_VAL) {
                        switch (carType) {
                            case TYPE_SPORTS_CAR -> {
                                cars[i] = new SportsCar();
                                waitingForValidIn = false;
                            }
                            case TYPE_FORMULA_ONE -> {
                                cars[i] = new FormulaOne();
                                waitingForValidIn = false;
                            }
                            case TYPE_RACE_CAR -> {
                                cars[i] = new RaceCar();
                                waitingForValidIn = false;
                            }
                            default -> log.info("Invalid car type: " + carType);
                        }
                    } else if (speed > DEFAULT_STAT_VAL && strength > DEFAULT_STAT_VAL) {
                        switch (carType) {
                            case TYPE_SPORTS_CAR -> {
                                cars[i] = new SportsCar(speed, strength);
                                waitingForValidIn = false;
                            }
                            case TYPE_FORMULA_ONE -> {
                                cars[i] = new FormulaOne(speed, strength);
                                waitingForValidIn = false;
                            }
                            case TYPE_RACE_CAR -> {
                                cars[i] = new RaceCar(speed, strength);
                                waitingForValidIn = false;
                            }
                            default -> log.info("Invalid car type: " + carType);
                        }
                    } else {
                        log.info("Speed and strength stats must either both be " + DEFAULT_STAT_VAL + " or both positive values.");
                    }
                } catch (InputMismatchException e) {
                    log.info("Non-integer values are not allowed.");
                    consoleRdr.nextLine();
                }
            } while (waitingForValidIn);
            waitingForValidIn = true;
        }
        consoleRdr.close();
        return cars;
    }


}
