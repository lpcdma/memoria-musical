package negocio;

import repositorio.RepositorioDeSons;
import dados.Som;
import dados.filtros.Filtro;
import dados.filtros.FiltroEcho;
import dados.filtros.FiltroPassaAlta;
import dados.filtros.FiltroPassaBaixa;
import dados.filtros.FiltroReverb;
import dados.filtros.FiltroSawtooth;
import excecoes.SomInvalidoException;

public class ControladorSom {

	private static ControladorSom instancia;
	private RepositorioDeSons repositorio;
	
	private FiltroPassaBaixa filtroPassaBaixa;
	private FiltroPassaAlta filtroPassaAlta;
	private FiltroEcho filtroEcho;
	private FiltroReverb filtroReverb;
	private FiltroSawtooth filtroSawtooth;
	
	private ControladorSom() throws SomInvalidoException {
		this.repositorio = RepositorioDeSons.getRepositorio();
		this.repositorio.carregarSons();
		
		this.filtroPassaBaixa = new FiltroPassaBaixa();
		this.filtroPassaAlta = new FiltroPassaAlta();
		this.filtroEcho = new FiltroEcho();
		this.filtroReverb = new FiltroReverb();
		this.filtroSawtooth = new FiltroSawtooth();
	}
	
	private Som aplicarFiltro(Som somOriginal, Filtro filtro){
		return filtro.filtrar(somOriginal);
	}
	
	public Som aplicarPassaBaixa(Som somOriginal){
		return this.aplicarFiltro(somOriginal, this.filtroPassaBaixa);
	}

	public Som aplicarPassaAlta(Som somOriginal){
		return this.aplicarFiltro(somOriginal, this.filtroPassaAlta);
	}

	public Som aplicarReverb(Som somOriginal){
		return this.aplicarFiltro(somOriginal, this.filtroReverb);
	}

	public Som aplicarSawtooth(Som somOriginal){
		return this.aplicarFiltro(somOriginal, this.filtroSawtooth);
	}

	public Som aplicarEcho(Som somOriginal){
		return this.aplicarFiltro(somOriginal, this.filtroEcho);
	}

	public static ControladorSom getControladorSom() throws SomInvalidoException {
		if (ControladorSom.instancia == null) {
			ControladorSom.instancia = new ControladorSom();
		}
		return ControladorSom.instancia;
	}
}
