public class FormulaOne extends Car {
    public FormulaOne(int speed, int strength) {
        if (speed < 30)
            this.speed = 30;
        else this.speed = Math.min(speed, 70);
        if (strength < 3)
            this.strength = 3;
        else this.strength = Math.min(strength, 5);
        this.location = 0.0;
    }

    public FormulaOne() {
        super(50, 4);
    }

    @Override
    public String toString() {
        return "FormulaOne" + super.toString();
    }

}
