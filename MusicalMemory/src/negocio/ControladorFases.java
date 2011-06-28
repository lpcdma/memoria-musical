package negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import repositorio.RepositorioDeSons;

import dados.Som;
import dados.Tabula;
import excecoes.FaseInvalidaException;

public class ControladorFases {

	private static ControladorFases instancia;
	private ArrayList<Tabula> tabuleiro;
	
	private ControladorFases() {
		this.tabuleiro = new ArrayList<Tabula>(16);
	}
	
	private void carregarTabuleiro(int fase) throws FaseInvalidaException{
		ArrayList<Som> trilhaSonora = new ArrayList<Som>(RepositorioDeSons.sons);
		Collections.shuffle(trilhaSonora);
		
		/*
		 	agrupar níveis
		 	lvl 1 = 1/4
			lvl 2 = 1/3
			lvl 3 = 1/2
			lvl 4 = 2/3
			lvl 5 = 3/4
		 */
		
		if (fase >= 1 && fase <= 5) {
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 8);
		} else if (fase >= 6 && fase <= 10) {
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 12);
		} else if (fase >= 11 && fase <= 15) {
			this.tabuleiro = this.construirTabuleiro(trilhaSonora, 18);
		} else {
			throw new FaseInvalidaException();
		}
	}
	
	private ArrayList<Tabula> construirTabuleiro(ArrayList<Som> sons, int quantidade) {
		ArrayList<Tabula> tabulas = new ArrayList<Tabula>();
		
		Iterator<Som> iterador = sons.iterator();
		while (iterador.hasNext() && quantidade > 0) {
			Som som1 = iterador.next();
			tabulas.add(new Tabula(som1, quantidade));
			Som som2 = iterador.next();
			tabulas.add(new Tabula(som2, quantidade));
			quantidade--;
		}
		Collections.shuffle(tabulas);
		return tabulas;
	}
	
	public ArrayList<Tabula> getTabuleiro(int fase) throws FaseInvalidaException {
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
