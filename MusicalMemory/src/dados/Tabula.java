package dados;

public class Tabula {

	private Som som;
	private Tabula par;
	private int id;
	
	public Tabula(int id, Tabula par) {
		this.id = id;
		this.par = par;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setPar(Tabula par) {
		this.par = par;
	}

	public Tabula getPar() {
		return this.par;
	}

	public void setSom(Som som) {
		this.som = som;
	}

	public Som getSom() {
		return this.som;
	}
}
