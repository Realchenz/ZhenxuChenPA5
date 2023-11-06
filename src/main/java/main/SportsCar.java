package main;
/**
 * SportsCar class, extends Car
 *
 * @see Car
 */
public class SportsCar extends Car {
    /**
     * Constructor for SportsCar
     *
     * @param speed    speed must be between 20 and 45
     * @param strength strength must be between 1 and 3
     */
    public SportsCar(int speed, int strength) {
        if (speed >= 20 && speed <= 45)
            this.speed = speed;
        else
            throw new IllegalArgumentException("speed must be between 20 and 45");
        if (strength >= 1 && strength <= 3)
            this.strength = strength;
        else
            throw new IllegalArgumentException("strength must be between 0 and 10");
        this.location = 0.0;
        this.realSpeed = this.speed;
    }

    public SportsCar() {
        super(30, 2);
    }

    @Override
    public String toString() {
        return "SportsCar" + super.toString();
    }

}
