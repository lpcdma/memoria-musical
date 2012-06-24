package stubs;

import entidades.InfoPlayer;
import entidades.Resultados;
import entidades.ResultadosFinais;

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

	public void addInfoPlayer(InfoPlayer info) {
		banco.addInfoPlayer(info);
		
	}

	public InfoPlayer getInfoPlayer() {
		return banco.getInfoPlayer();
	}
	
}
