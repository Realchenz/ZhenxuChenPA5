public class RaceTrack {
	private Car[] cars;
	private FinishLine finishLine;
	private PitStop pitStop;

	/**
	 * DO NOT REMOVE THIS - you should be using this to log this track's events. For more see the assignment PDF / documentation for TrackLoggerB.java
	 */
	private TrackLoggerC logger;
	
	public RaceTrack() {
		logger = new TrackLoggerC(); // DO NOT REMOVE THIS LINE

	}
	
	public void setCars(Car[] cars) {
		this.cars = cars;
	}

	/**
	 * This method runs one tick. A tick moves every car a set distance
	 * equal to its speed. If a car is damaged and passes the 75 unit mark during this tick, it enters the
	 * pitstop. Upon exiting the pitstop, it starts at the 75 unit mark and immediately moves according to
	 * its speed. After all the cars have moved their set distance, the Tick method should check for
	 * collisions and deal with them appropriately.
	 */
	public void tick() {
		throw new UnsupportedOperationException("not implemented yet");




	}
	
	public void checkCollision() {


	}
	
	public void run() {

	}
	
	public int calculatorScore(int ticks) {
		throw new UnsupportedOperationException("not implemented yet");
	}
	
	/**
	 * This method returns the logger instance used by this RaceTrack. You <b>SHOULD NOT</b> be using this method. 
	 * @return logger with this track's events 
	 */
	public TrackLoggerC getLogger() {
		return logger;
	}

}
