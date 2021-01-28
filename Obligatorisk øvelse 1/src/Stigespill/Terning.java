package Stigespill;

import java.util.Random;

public class Terning {

	private int value;

	/**
	 * her trilles en terning (mulig å få tall mellom 1-6)
	 * 
	 * @return et tall
	 */
	public int roll() {

		Random random = new Random(); /* <-- this is a constructor */
		value = random.nextInt(6) + 1;

		return value;
	}

}
