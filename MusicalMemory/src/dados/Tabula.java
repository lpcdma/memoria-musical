package dados;

public class Tabula {

	private Som som;
	private Tabula par;
	private int id;

	public Tabula(Som som, int id, Tabula par) {
		this.som = som;
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

	@Override
	public boolean equals(Object obj) {
		boolean ehIgual = false;
		
		if(obj != null) {
			Tabula outra = (Tabula) obj;
			if(outra instanceof Tabula) {
				ehIgual = (this.id == outra.getId());
			}
		}
		return ehIgual;
	}
}
