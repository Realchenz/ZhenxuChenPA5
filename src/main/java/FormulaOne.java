/**
 * FormulaOne class, extends Car
 *
 * @see Car
 */
public class FormulaOne extends Car {
    /**
     * Constructor for FormulaOne
     *
     * @param speed    speed must be between 30 and 70
     * @param strength strength must be between 3 and 5
     */
    public FormulaOne(int speed, int strength) {
        if (speed < 30)
            this.speed = 30;
        else this.speed = Math.min(speed, 70);
        if (strength < 3)
            this.strength = 3;
        else this.strength = Math.min(strength, 5);
        this.location = 0.0;
        this.realSpeed = this.speed;
    }

    public FormulaOne() {
        super(50, 4);
    }

    @Override
    public String toString() {
        return "FormulaOne" + super.toString();
    }

}
