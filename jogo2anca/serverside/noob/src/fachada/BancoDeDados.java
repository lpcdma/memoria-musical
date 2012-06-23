package fachada;

import java.util.ArrayList;

import gui.util.Resultados;
import gui.util.ResultadosFinais;

public class BancoDeDados {

	ArrayList<Resultados> resultados;
	ResultadosFinais rstFinais;
	int aposta = 0;
	
	public BancoDeDados() {
		resultados = new ArrayList<Resultados>();
	}
	
	public void apostar(int valor) {
		aposta = valor + aposta;
		resultados.add(new Resultados(aposta,aposta*4/2));
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

}
