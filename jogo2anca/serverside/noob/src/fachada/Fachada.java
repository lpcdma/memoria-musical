package fachada;

import entidades.FormularioFinal;
import entidades.InfoPlayer;
import entidades.Resultados;
import entidades.ResultadosFinais;
import stubs.Negocio;

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

	public boolean passarTurno() {
		return true;
	}

	public InfoPlayer getInfoPlayer() {
		return negocio.getInfoPlayer();
	}
	
	public void addInfoPlayer(InfoPlayer info){
		negocio.addInfoPlayer(info);
	}

	public void enviarFormularioFinal(FormularioFinal formularioFinal) {
		// TODO Auto-generated method stub
		
	}
	
}
