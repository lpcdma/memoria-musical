package fachada;

import gui.util.Resultados;
import gui.util.ResultadosFinais;

public class Negocio {

	BancoDeDados banco = new BancoDeDados();

	public void apostar(int valor) {
		banco.apostar(valor);
		
	}

	public Resultados getResultados(int rodada) {
		return banco.getResultados(rodada);

	}

	public ResultadosFinais getResultadoFinais() {
		return banco.getResultadoFinais();
		
	}
	
}
