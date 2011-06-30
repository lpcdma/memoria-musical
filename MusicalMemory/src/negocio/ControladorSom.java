package negocio;

import java.util.ArrayList;

import repositorio.RepositorioDeSons;
import dados.Som;
import dados.filtros.Filtro;
import dados.filtros.FiltroEcho;
import dados.filtros.FiltroPassaBaixa;
import dados.filtros.FiltroPassaTudo;
import dados.filtros.FiltroReverb;
import dados.filtros.FiltroReverse;
import dados.filtros.FiltroSawtooth;
import excecoes.SomInvalidoException;

public class ControladorSom {

	private static ControladorSom instancia;
	
	private final FiltroPassaBaixa filtroPassaBaixa;
	private final FiltroEcho filtroEcho;
	private final FiltroReverb filtroReverb;
	private final FiltroSawtooth filtroSawtooth;
	private final FiltroReverse filtroReverse;
	private final FiltroPassaTudo filtroPassaTudo;
	
	public static ArrayList<Filtro> filtros;
	
	private ControladorSom() {
		this.filtroPassaBaixa = new FiltroPassaBaixa();
		this.filtroEcho = new FiltroEcho();
		this.filtroReverb = new FiltroReverb();
		this.filtroSawtooth = new FiltroSawtooth();
		this.filtroReverse = new FiltroReverse();;
		this.filtroPassaTudo = new FiltroPassaTudo();;
		
		ControladorSom.filtros = new ArrayList<Filtro>();
		ControladorSom.filtros.add(this.filtroPassaBaixa);
		ControladorSom.filtros.add(this.filtroEcho);
		ControladorSom.filtros.add(this.filtroReverb);
		ControladorSom.filtros.add(this.filtroSawtooth);
		ControladorSom.filtros.add(this.filtroReverse);
		ControladorSom.filtros.add(this.filtroPassaTudo);
	}
	
	public Som aplicarFiltro(Som somOriginal, Filtro filtro){
		return filtro.filtrar(somOriginal);
	}
	
	public Som aplicarPassaBaixa(Som somOriginal){
		return this.aplicarFiltro(somOriginal, this.filtroPassaBaixa);
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

	public Som aplicarReverse(Som somOriginal){
		return this.aplicarFiltro(somOriginal, this.filtroReverse);
	}

	public Som aplicarPassaTudo(Som somOriginal){
		return this.aplicarFiltro(somOriginal, this.filtroPassaTudo);
	}
	
	public static ArrayList<Som> getSons() throws SomInvalidoException{
		return RepositorioDeSons.getSons();
	}
	
	public ArrayList<Filtro> getFiltros(){
		if (ControladorSom.filtros == null) {
			ControladorSom.getControladorSom();
		}
		return ControladorSom.filtros;
	}
	
	public static ControladorSom getControladorSom() {
		if (ControladorSom.instancia == null) {
			ControladorSom.instancia = new ControladorSom();
		}
		return ControladorSom.instancia;
	}
}
