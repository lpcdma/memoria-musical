package dados;

/**
 * Um tabuleiro eh feito de tabulas.
 */
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

	public boolean ehParDe(Tabula par){
		return (this.par.getId() == par.getId());
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean ehIgual = false;
		
		if(obj != null) {
			if(obj instanceof Tabula) {
				Tabula tab = (Tabula) obj;
				ehIgual = (this.id == tab.getId());
			}
		}
		return ehIgual;
	}
}
