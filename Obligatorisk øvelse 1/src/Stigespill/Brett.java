package Stigespill;

import java.util.ArrayList;

import java.util.List;

public class Brett {

	private List<Rute> brett;
	private List<Rute> slange;
	private List<Rute> stige;

	final private static int VANLIG = 0;
	final private static int SLANGE = -1;
	final private static int STIGE = 1;
	final private static int MAXANTALL = 100;

	public Brett() {

		brett = new ArrayList<Rute>();

	}

	/**
	 * henter ut en Rute med det gitte rutenummeret
	 * 
	 * @param nummeret til ruten
	 * @return ruten som har det rutenummeret
	 */
	public Rute getRute(int value) {
		for (Rute r : brett) {
			if (r.getNummer() == value) {
				return r;
			}
		}
		return null;
	}

	/**
	 * lager brettet ved å sette inn vanlige, stige eller slange ruter
	 */
	public void settBrett() {

		for (int i = 0; i < MAXANTALL; i++) {

			brett.add(i, new Rute(i + 1, VANLIG));
		}

		slange = slangeRute();
		stige = stigeRute();

		for (Rute sl : slange) {

			int v1 = sl.getNummer();

			brett.set(v1 - 1, new Rute(v1, SLANGE, sl.getNy()));
		}

		for (Rute st : stige) {

			int v2 = st.getNummer();

			brett.set(v2 - 1, new Rute(v2, STIGE, st.getNy()));
		}

	}

	/**
	 * @return en tabell av ruter som holder informasjon om hvilke ruter som er
	 *         slange
	 */
	private List<Rute> slangeRute() {

		slange = new ArrayList<Rute>();

		slange.add(new Rute(16, SLANGE, 5));
		slange.add(new Rute(47, SLANGE, 26));
		slange.add(new Rute(49, SLANGE, 11));
		slange.add(new Rute(56, SLANGE, 53));
		slange.add(new Rute(62, SLANGE, 18));
		slange.add(new Rute(64, SLANGE, 60));
		slange.add(new Rute(87, SLANGE, 24));
		slange.add(new Rute(93, SLANGE, 73));
		slange.add(new Rute(95, SLANGE, 75));
		slange.add(new Rute(98, SLANGE, 78));

		return slange;
	}

	/**
	 * @return en tabell av ruter som holder informasjon om hvilke ruter som er
	 *         stige
	 */
	private List<Rute> stigeRute() {

		stige = new ArrayList<Rute>();

		stige.add(new Rute(2, STIGE, 38));
		stige.add(new Rute(4, STIGE, 14));
		stige.add(new Rute(8, STIGE, 31));
		stige.add(new Rute(21, STIGE, 42));
		stige.add(new Rute(28, STIGE, 84));
		stige.add(new Rute(36, STIGE, 44));
		stige.add(new Rute(51, STIGE, 67));
		stige.add(new Rute(71, STIGE, 91));
		stige.add(new Rute(80, STIGE, 100));

		return stige;
	}

}