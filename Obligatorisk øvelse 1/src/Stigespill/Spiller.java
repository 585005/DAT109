package Stigespill;

public class Spiller {

	private String navn;
	private String farge;
	private Brikke brikke;

	public Spiller(String navn, String farge, Brikke brikke) {
		this.navn = navn;
		this.farge = farge;
		this.brikke = brikke;
	}

	/**
	 * finner sum av ruten brikken står på. Sender verdien videre slik at Brikken
	 * kan flytte antall plasser
	 * 
	 * @param sumTerning er verdien av terning
	 */
	public void flytt(int sumTerning) {
		int gammelPlass = brikke.getRute().getNummer();

		brikke.flyttBrikke(sumTerning, gammelPlass);

	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}

	public Brikke getBrikke() {
		return brikke;
	}

	public void setBrikke(Brikke brikke) {
		this.brikke = brikke;
	}

	@Override
	public String toString() {
		return "Spiller [navn=" + navn + ", brikke=" + brikke + "]";
	}

}
