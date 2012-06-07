package core;

import com.smartfoxserver.v2.entities.User;

public class Player {
	
	private static final int VALOR_INICIAL = 30;
	
	private User sfsUser;
	private int id;
	private int[] valoresFinaisPorRodada = {0,0,0,0,0,0};
	private int[] valoresIniciaisPorRodada = {VALOR_INICIAL,0,0,0,0,0};
	private int[] valoresApostadosPorRodada = {0,0,0,0,0,0};
	private boolean jogouRodadaAtual = false;
	
	public Player(int id, User sfsUser){
		this.setId(id);
		this.sfsUser = sfsUser;
	}
	
	public void setValorFinalRodada(int valor, int rodada){		
		if(rodada > 0 && rodada < valoresFinaisPorRodada.length){
			valoresFinaisPorRodada[rodada] = valor;
		}
	}
	
	public int getValorFinalRodada(int rodada){
		if(rodada > 0 && rodada < valoresFinaisPorRodada.length){
			return valoresFinaisPorRodada[rodada];
		}
		else{
			return 0;
		}
	}
	
	public void setValorInicialRodada(int valor, int rodada){
		if(rodada > 0 && rodada < valoresIniciaisPorRodada.length){
			valoresIniciaisPorRodada[rodada] = valor;
		}
	}
	
	public int getValorInicialRodada(int rodada){
		if(rodada > 0 && rodada < valoresIniciaisPorRodada.length){
			return valoresIniciaisPorRodada[rodada];
		}
		else{
			return 0;
		}
	}

	public void setSfsUser(User sfsUser) {
		this.sfsUser = sfsUser;
	}

	public User getSfsUser() {
		return sfsUser;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setJogouRodadaAtual(boolean jogouRodadaAtual) {
		this.jogouRodadaAtual = jogouRodadaAtual;
	}

	public boolean getJogouRodadaAtual() {
		return jogouRodadaAtual;
	}

	public void setValorApostadoRodada(int valor, int rodada) {
		if(rodada > 0 && rodada < valoresApostadosPorRodada.length){
			valoresApostadosPorRodada[rodada] = valor;
		}
	}

	public int getValorApostadoRodada(int rodada) {
		if(rodada > 0 && rodada < valoresApostadosPorRodada.length){
			return valoresApostadosPorRodada[rodada];
		}
		else{
			return 0;
		}
	}
 }
