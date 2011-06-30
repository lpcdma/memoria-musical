package negocio;

import java.util.ArrayList;

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
	
	private final FiltroPassaBaixa filtroPassaBaixa;
	private final FiltroPassaAlta filtroPassaAlta;
	private final FiltroEcho filtroEcho;
	private final FiltroReverb filtroReverb;
	private final FiltroSawtooth filtroSawtooth;
	
	public static ArrayList<Filtro> filtros;
	
	private ControladorSom() {
		this.filtroPassaBaixa = new FiltroPassaBaixa();
		this.filtroPassaAlta = new FiltroPassaAlta();
		this.filtroEcho = new FiltroEcho();
		this.filtroReverb = new FiltroReverb();
		this.filtroSawtooth = new FiltroSawtooth();
		
		ControladorSom.filtros = new ArrayList<Filtro>();
		ControladorSom.filtros.add(this.filtroPassaBaixa);
		ControladorSom.filtros.add(this.filtroPassaAlta);
		ControladorSom.filtros.add(this.filtroEcho);
		ControladorSom.filtros.add(this.filtroReverb);
		ControladorSom.filtros.add(this.filtroSawtooth);
	}
	
	public Som aplicarFiltro(Som somOriginal, Filtro filtro){
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

	public static ArrayList<Som> getSons() throws SomInvalidoException{
		return RepositorioDeSons.getSons();
	}
	
	public static ControladorSom getControladorSom() {
		if (ControladorSom.instancia == null) {
			ControladorSom.instancia = new ControladorSom();
		}
		return ControladorSom.instancia;
	}
}
