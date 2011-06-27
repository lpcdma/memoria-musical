package negocio;

import repositorio.RepositorioDeSons;
import dados.Som;
import dados.filtros.Filtro;
import excecoes.SomInvalidoException;

public class ControladorSom {

	private static ControladorSom instancia;
	private RepositorioDeSons repositorio;
	
	private ControladorSom() throws SomInvalidoException {
		this.repositorio = RepositorioDeSons.getRepositorio();
		this.repositorio.carregarSons();
	}
	
	public Som aplicarFiltro(Som somOriginal, Filtro filtro){
		return filtro.filtrar(somOriginal);
	}
	
	public static ControladorSom getControladorSom() throws SomInvalidoException {
		if (ControladorSom.instancia == null) {
			ControladorSom.instancia = new ControladorSom();
		}
		return ControladorSom.instancia;
	}
}
