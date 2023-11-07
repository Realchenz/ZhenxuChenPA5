package main;

import lombok.Getter;

/**
 * This class represents a super class for all car classes.
 *
 * @author Zhenxu Chen
 * @address zhenxuchen@brandeis.edu
 * @date Nov, 2023
 * @assignment PA5
 * @version 1.0
 */
public abstract class Car {
    /**
     * the nominal speed of the car
     */
    protected int speed;
    /**
     * the real speed of the car
     */
    protected int realSpeed;
    /**
     * the strength of the car
     */
    protected int strength;
    @Getter
    protected double location;
    protected int laps = 0;
    /**
     * the pause time of the car when it is in the pit stop
     */
    protected int pitStopPause = 0;
    protected boolean isDamaged = false;
    protected boolean isFinished = false;
    /**
     * whether the car is damaged when it cross the pit stop
     */
    protected boolean isDamagedCrossPitStop = false;

    /**
     * Constructor:
     *
     * @param speed    the speed of the car
     * @param strength the strength of the car
     */
    protected Car(int speed, int strength) {
        this.speed = speed;
        this.strength = strength;
        this.location = 0.0;
    }

    /**
     * No-arg constructor:
     */
    protected Car() {
        this(0, 0);
    }
    @Override
    public String toString() {
        return speed + "/" + strength;
    }

    /**
     * <p>1.This method is used to move the car</p>
     * <p>2.The car will move forward by its real speed</p>
     * <p>3.If the car cross the pit stop and it is damaged, it will stop at the pit stop</p>
     * <p>4.If the car moves forward by its real speed and its location is greater than 100, it will move back to the start line</p>
     */
    public void move() {
        location = location + realSpeed;
        if (location >= 75 && isDamaged) {
            isDamagedCrossPitStop = true;
            setLocation(75);
        }
        if (location >= 100) {
            location = location - 100;
            laps++;
        }
    }

    /**
     * This method is used to change the real speed of the car when it is damaged
     */
    public void collide() {
        isDamaged = true;
        realSpeed -= strength * 5;
    }

    public void setLocation(double i) {
        location = i;
    }

}
