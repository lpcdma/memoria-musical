package negocio;

import repositorio.RepositorioDeSons;
import dados.Som;

public class ControladorSom {

	private static ControladorSom instancia;
	private RepositorioDeSons repositorio;
	
	private ControladorSom() {
		this.repositorio = RepositorioDeSons.getRepositorio();
		this.repositorio.carregarSons();
	}
	
	public Som aplicarFiltro(Som somOriginal){
		Som somFiltrado = null;
		
		return somFiltrado;
	}
	
//	public boolean compararSons(){
//		boolean iguais = false;
////		if (som1.equals(som2)) {
////			iguais = true;
////		}
//		return iguais; 
//	}
	
	public static ControladorSom getControladorSom() {
		if (ControladorSom.instancia == null) {
			ControladorSom.instancia = new ControladorSom();
		}
		return ControladorSom.instancia;
	}
}
