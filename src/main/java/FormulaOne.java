public class FormulaOne extends Car {
    public FormulaOne(int speed, int strength) {
        super(speed, strength);

    }

    public FormulaOne() {
        super(50, 4);

    }

    @Override
    public double getLocation() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "FormulaOne: " + super.toString();
    }

}
