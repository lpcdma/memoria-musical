package fachada;

import gui.util.Resultados;
import gui.util.ResultadosFinais;

public class Fachada {

	static Fachada instance = null;
	Negocio negocio = new Negocio();
	
	private Fachada() {

	}
	
	static public Fachada getInstance(){
		if(instance == null){
			instance = new Fachada();
		}
		return instance;
	}
	
	public void apostar(int valor){
		negocio.apostar(valor);
	}

	public Resultados getResultados(int rodada) {
		return negocio.getResultados(rodada);
	}

	public ResultadosFinais getResultadosFinais() {
		return negocio.getResultadoFinais();
		
	}
	
}
