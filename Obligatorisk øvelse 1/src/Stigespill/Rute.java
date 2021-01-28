package Stigespill;

public class Rute {

	private int nummer;
	private int type;
	private int ny;

	public Rute(int nummer, int type) {
		this.nummer = nummer;
		this.type = type;
	}

	public Rute(int nummer, int type, int ny) {
		this.nummer = nummer;
		this.type = type;
		this.ny = ny;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getNy() {
		return ny;
	}

	public void setNy(int ny) {
		this.ny = ny;
	}

	@Override
	public String toString() {
		return "Rute [nummer=" + nummer + ", type=" + type + ", ny=" + ny + "]";
	}

}
