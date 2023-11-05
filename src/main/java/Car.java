

abstract public class Car {
	private int speed;
	private int strength;
	
	public Car(int speed, int strength) {
		this.speed = speed;
		this.strength = strength;
	}
	
	public Car() {
		this(0, 0);
	}

	public double getLocation() {
		throw new UnsupportedOperationException("not implemented yet");
	}
	
	public String toString() {
		throw new UnsupportedOperationException("not implemented yet");
	}
	
}
