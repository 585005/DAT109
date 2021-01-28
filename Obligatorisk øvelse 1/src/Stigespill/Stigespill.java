package Stigespill;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;

public class Stigespill {

	private Kopp kopp;
	private Brett brett;
	private List<Spiller> spillere;
	private int antallSpillere;
	final private static int START = 1;

	public Stigespill() {

	}

	public Stigespill(List<Spiller> spillere, Kopp kopp) {
		this.spillere = spillere;
		this.kopp = new Kopp();

	}

	/**
	 * her settes spillet opp, antall spillere, liste med spillere, brett,
	 * registrering av spillere og det opprettes et Stigespill,
	 */
	public void setup() {


		spillere = new ArrayList<Spiller>();

		brett = new Brett();
		brett.settBrett();

		registrereSpillere(brett);

		Stigespill stigespill = new Stigespill(spillere, kopp);

		stigespill.play();
	}

	public void play() {

		runde();

	}

	/**
	 * her registreres spillere. og Spiller objekter blir opprettet
	 * 
	 * @param brett  er brettet de skal spille på
	 */
	private void registrereSpillere(Brett brett) {
		String navn;
		String farge;

		int index = 0;
		
		boolean validNumber = true;

		while (validNumber) {

			antallSpillere = Integer.parseInt(JOptionPane.showInputDialog("Hvor mange spillere? (mellom 2-4)"));
			if (antallSpillere >= 2 && antallSpillere <= 4) {
				validNumber = false;

			}
		}
		
		int number = antallSpillere;

		System.out.println("Registrerte spillere: ");

		while (number >= 1) {

			navn = JOptionPane.showInputDialog("Skriv inn Spiller " + (index + 1) + " sitt navn");
			farge = JOptionPane.showInputDialog("Skriv inn farge på brikke");

			Spiller spiller = new Spiller(navn, farge, new Brikke(farge, brett.getRute(START), brett));

			spillere.add(spiller);

			System.out.println(spiller);

			index++;
			number--;
		}
	}

	/**
	 * her spilles rundene
	 */
	private void runde() {

		int runde = 1;
		boolean spill = true;
		while (spill) {

			System.out.println("\n" + "____________________________________________");

			System.out.println("Runde nr " + runde + "\n");

			for (Spiller s : spillere) {

				System.out.println(s.getNavn() + " sin tur:");

				JOptionPane.showMessageDialog(null, s.getNavn() + ", trykk 'ok' for å trille terningen");

				int sumTerning = kopp.getSum();

				System.out.println("Verdi på terning: " + sumTerning + "\n");

				s.flytt(sumTerning);

				System.out.println(s);

				if (s.getBrikke().getRute().getNummer() == 100) {
					spill = false;
					System.out.println("Spillet er ferdig");
					JOptionPane.showMessageDialog(null, s.getNavn() + " VANT SPILLET! GRATULERER");
					return;
				}

			}
			runde++;
		}

	}

}
