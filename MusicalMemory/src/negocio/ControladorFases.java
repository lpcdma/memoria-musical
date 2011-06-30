package negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import dados.Som;
import dados.Tabula;
import excecoes.FaseInvalidaException;
import excecoes.PoucasMusicasException;
import excecoes.SomInvalidoException;

public class ControladorFases {

	private static ControladorFases instancia;
	private ArrayList<Tabula> tabuleiro;
	
	private ControladorFases() {
		this.tabuleiro = new ArrayList<Tabula>(16);
	}
	
	private void carregarTabuleiro(int fase) throws FaseInvalidaException, PoucasMusicasException, SomInvalidoException {
		ArrayList<Som> trilhaSonora = new ArrayList<Som>(ControladorSom.getSons());
		Collections.shuffle(trilhaSonora);
		
		switch (fase) {
		case 1:
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 8, 0, 0);
			break;
		case 2:
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 8, 1, 0);
			break;
		case 3:
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 8, 2, 0);
			break;
		case 4:
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 8, 4, 1);
			break;
		case 5:
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 8, 4, 2);
			break;
		case 6:
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 12, 4, 0);
			break;
		case 7:
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 12, 5, 0);
			break;
		case 8:
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 12, 7, 1);
			break;
		case 9:
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 12, 7, 2);
			break;
		case 10:
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 12, 8, 3);
			break;
		case 11:
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 16, 6, 1);
			break;
		case 12:
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 16, 7, 1);
			break;
		case 13:
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 16, 9, 2);
			break;
		case 14:
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 16, 11, 3);
			break;
		case 15:
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 16, 14, 4);
			break;
		default:
			throw new FaseInvalidaException(fase);
		}
	}
	
	private ArrayList<Tabula> construirTabuleiro(ArrayList<Som> sons, int numPecas, int numFiltros, int numSeq) throws PoucasMusicasException {
		ArrayList<Tabula> tabulas = new ArrayList<Tabula>();
		
		Iterator<Som> iterador = sons.iterator();
		while (numPecas > 0) {
			Som som1 = iterador.next();
			tabulas.add(new Tabula(som1, numPecas));
			if (numFiltros > 0) {
				int qntIteracoes = numSeq;
				while(qntIteracoes > 0){
					Collections.shuffle(ControladorSom.getControladorSom().getFiltros());
					som1 = ControladorSom.getControladorSom().aplicarFiltro(som1, ControladorSom.filtros.get(0));
					qntIteracoes--;
				}
				if (numSeq > 1) {
					numSeq--;
				}
				numFiltros--;
			}
			tabulas.add(new Tabula(som1, numPecas));
			numPecas--;
		}
		
		if (tabulas.size() < (numPecas + 2)) {
			throw new PoucasMusicasException(numPecas);
		}
		
		Collections.shuffle(tabulas);
		return tabulas;
	}
	
	public ArrayList<Tabula> getTabuleiro(int fase) throws FaseInvalidaException, PoucasMusicasException, SomInvalidoException {
		this.carregarTabuleiro(fase);
		return this.tabuleiro;
	}

	public static ControladorFases getControladorFases() {
		if (ControladorFases.instancia == null) {
			ControladorFases.instancia = new ControladorFases();
		}
		return ControladorFases.instancia;
	}
	
}
