package Stigespill;

public class Kopp {

	private Terning terning;

	public Kopp() {

		terning = new Terning();
	}

	/**
	 * triller terning
	 * 
	 * @return et tall mellom 1-6
	 */
	public int getSum() {
		return terning.roll();
	}

}
