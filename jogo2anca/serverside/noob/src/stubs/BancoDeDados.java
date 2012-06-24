package stubs;

import java.util.ArrayList;

import entidades.InfoPlayer;
import entidades.Resultados;
import entidades.ResultadosFinais;


public class BancoDeDados {

	ArrayList<Resultados> resultados;
	ResultadosFinais rstFinais;
	InfoPlayer info;
	
	public BancoDeDados() {
		resultados = new ArrayList<Resultados>();
	}
	
	public void apostar(int valor) {
		resultados.add(new Resultados(valor,valor*2/4));
	}

	public Resultados getResultados(int rodada) {
		return resultados.get(rodada-1);
	}

	public ResultadosFinais getResultadoFinais() {
		int valorApostado = 0;
		
		for (int i = 0; i < resultados.size(); i++) {
			valorApostado = valorApostado + resultados.get(i).getQtdRecebida();
		}
		
		rstFinais = new ResultadosFinais(valorApostado,0,0,0);
		
		return rstFinais;
	}

	public void addInfoPlayer(InfoPlayer info) {
		this.info = info;
	}

	public InfoPlayer getInfoPlayer() {
		return info;
	}

}
