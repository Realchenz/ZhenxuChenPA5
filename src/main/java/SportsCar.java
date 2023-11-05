public class SportsCar extends Car {

    public SportsCar(int speed, int strength) {
        if(speed >= 20 && speed <= 45)
this.speed = speed;
        else
            throw new IllegalArgumentException("speed must be between 20 and 45")
        if(strength < 1 || strength > 3)
            throw new IllegalArgumentException("strength must be between 0 and 10");
    }

    public SportsCar() {
        super();
    }

    @Override
    public double getLocation() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "SportsCar: " + super.toString();
    }

}
