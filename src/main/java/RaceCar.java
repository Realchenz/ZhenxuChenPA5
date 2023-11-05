public class RaceCar extends Car {

    public RaceCar(int speed, int strength) {
        if (speed < 30)
            this.speed = 30;
        else this.speed = Math.min(speed, 55);
        if (strength < 2)
            this.strength = 2;
        else this.strength = Math.min(strength, 4);
        this.location = 0.0;
    }

    public RaceCar() {
        super(40, 3);
    }

    @Override
    public String toString() {
        return "RaceCar" + super.toString();
    }

}
