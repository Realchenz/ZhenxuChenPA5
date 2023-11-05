abstract public class Car {
    protected int speed;
    protected int strength;
    protected double location;
    protected int laps = 0;
    protected int pitStopPause = 0;
    protected boolean isDamaged = false;
    protected boolean isFinished = false;
    protected boolean isDamagedCrossPitStop = false;

    protected Car(int speed, int strength) {
        this.speed = speed;
        this.strength = strength;
        this.location = 0.0;
    }

    public Car() {
        this(0, 0);
    }

    public double getLocation() {
        return location;
    }

    public String toString() {
        return speed + "/" + strength;
    }

    public void move() {
        location = location + speed;
        if (location >= 75 && isDamaged) {
            isDamagedCrossPitStop = true;
        }
        if (location >= 100) {
            location = location - 100;
            laps++;
        }
    }

    public void collide() {
        isDamaged = true;
        speed -= strength * 5;
    }
}
