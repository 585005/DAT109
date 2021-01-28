package Stigespill;

public class Brikke {

	private String farge;
	private Rute rute;
	private Brett brett;
	final private static int MAAL = 100;

	public Brikke(String farge, Rute rute, Brett brett) {
		this.farge = farge;
		this.rute = rute;
		this.brett = brett;

	}

	/**
	 * flytter brikke etter hvor mye man triller på terning, sjekker om man landet
	 * på spesialrute eller om spilleren havner akkurat på rute 100 for å vinne
	 * 
	 * @param sumTerning  er hva man trillet på terning
	 * @param gammelPlass er plassen brikken sto på
	 */
	public void flyttBrikke(int sumTerning, int gammelPlass) {

		int nyPlass = sumTerning + gammelPlass;

		if (nyPlass <= 100) {
			rute = brett.getRute(nyPlass);

			if (nyPlass == 100 || rute.getNummer() == 80) {
				rute = brett.getRute(MAAL);
				System.out.println("\n" + "GRATULERER, DU VANT SPILLET!" + "\n");
				setRute(rute);
			} else if (spesialRute(rute) == 1) {
				int nyRute = brett.getRute(nyPlass).getNy();
				rute = brett.getRute(rute.getNy());
				System.out
						.println("Du havnet på en stige, du er flyttet fra rute " + (nyPlass) + " til rute " + (nyRute));
				setRute(rute);

			} else if (spesialRute(rute) == -1) {
				int nyRute = brett.getRute(nyPlass).getNy();
				rute = brett.getRute(rute.getNy());
				System.out
						.println("Du havnet på en slange, du er flyttet fra rute " + (nyPlass) + " til rute " + (nyRute));
				setRute(rute);

			} else {
				System.out.println("Du er flyttet fra rute " + gammelPlass + " til rute " + rute.getNummer());
				setRute(rute);
			}
		} else {

			if (innspurt(gammelPlass)) {
				maal(nyPlass);
			}

		}
	}

	/**
	 * sjekker om spiller treffer akkurat rute 100, hvis sum er større blir brikken
	 * stående på plassen
	 * 
	 * @param nySum er den nye summen (gammel plass + ny plass)
	 */
	public void maal(int nySum) {
		int sum = nySum - 100;
		if (nySum > 100) {
			System.out.println("Du havner " + sum + " trekk utenfor brettet. Du må treffe akkurat på 100 for å vinne!");
		}
	}

	/**
	 * sjekker om spiller er mindre enn 6 trekk fra mål
	 * 
	 * @param nummer
	 * @return
	 */
	public boolean innspurt(int nummer) {

		if (nummer >= 94) {
			return true;
		}
		return false;
	}

	/**
	 * sjekker om du landet på en spesialrute
	 * 
	 * @param rute
	 * @return 1 hvis du landet på en stige, -1 hvis du landet på en slange
	 */
	public int spesialRute(Rute rute) {
		int type = rute.getType();
		int sum = 0;

		if (type == 1) {
			sum = 1;
		}
		if (type == -1) {
			sum = -1;
		}
		return sum;
	}

	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}

	public Rute getRute() {
		return rute;
	}

	public void setRute(Rute rute) {
		this.rute = rute;
	}

	public Brett getBrett() {
		return brett;
	}

	public void setBrett(Brett brett) {
		this.brett = brett;
	}

	@Override
	public String toString() {
		return "Brikke [farge=" + farge + ", rute=" + rute + "]";
	}

}
