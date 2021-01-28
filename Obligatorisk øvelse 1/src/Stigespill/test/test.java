package Stigespill.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Stigespill.Brett;
import Stigespill.Brikke;
import Stigespill.Rute;
import Stigespill.Spiller;

class test {

	private Brett brett;
	private Spiller s1;

	@BeforeEach
	void setUp() throws Exception {

		brett = new Brett();
		brett.settBrett();

		s1 = new Spiller("Emilie", "Grønn", new Brikke("Grønn", brett.getRute(1), brett));

	}

	@Test
	void settBrettTest() {
		assertEquals(1, brett.getRute(2).getType());
		assertEquals(-1, brett.getRute(16).getType());
		assertEquals(0, brett.getRute(27).getType());

	}

	@Test
	void getRuteTest() {

		assertEquals(3, brett.getRute(3).getNummer());

	}

	@Test
	void flyttBrikkeTest() {

		/*
		 * s1.flytt(1); s2.flytt(46); assertEquals(38,
		 * s1.getBrikke().getRute().getNummer()); assertEquals(26,
		 * s2.getBrikke().getRute().getNummer());
		 */
	}

	@Test
	void innspurtTest() {

		boolean test1 = s1.getBrikke().innspurt(96);
		boolean test2 = s1.getBrikke().innspurt(93);

		assertEquals(true, test1);
		assertEquals(false, test2);
	}

	@Test
	void spesialruteTest() {

		int value1 = s1.getBrikke().spesialRute(brett.getRute(16));
		int value2 = s1.getBrikke().spesialRute(brett.getRute(1));
		int value3 = s1.getBrikke().spesialRute(brett.getRute(21));

		assertEquals(-1, value1);
		assertEquals(0, value2);
		assertEquals(1, value3);

	}
}
