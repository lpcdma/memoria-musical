package dados;

/**
 * Um tabuleiro eh feito de tabulas.
 */
public class Tabula {

	private Som som;
	private int id;

	public Tabula(Som som, int id) {
		this.som = som;
		this.id = id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
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
			if(obj instanceof Tabula) {
				Tabula tab = (Tabula) obj;
				ehIgual = (this.id == tab.getId());
			}
		}
		return ehIgual;
	}
}
