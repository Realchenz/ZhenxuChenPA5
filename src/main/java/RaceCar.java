public class RaceCar extends Car {

    public RaceCar(int speed, int strength) {
        super(speed, strength);
    }

    public RaceCar() {
        super(40, 3);
    }

    @Override
    public double getLocation() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "RaceCar: " + super.toString();
    }
}
