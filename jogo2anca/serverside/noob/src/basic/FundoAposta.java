package basic;

import core.Constantes;

public class FundoAposta {
	
	private int[] valorRealPorRodada = {0,0,0,0,0,0};
	private int[] valorArredondadoPorRodada = {0,0,0,0,0,0};
	
	public void apostarRodada(int rodada, int valor){
		if(rodada > 0 && rodada < valorRealPorRodada.length){
			valorRealPorRodada[rodada] += valor;
		}
	}
	
	public int calcularRetorno(int rodada){
		double retorno = 0;
		if(rodada > 0 && rodada < valorRealPorRodada.length){
			if(valorArredondadoPorRodada[rodada]>0){
				retorno = valorArredondadoPorRodada[rodada] / Constantes.NUM_JOGADORES;
			}else{
				retorno = valorRealPorRodada[rodada]/Constantes.NUM_JOGADORES;
				retorno = Math.ceil(retorno);
				valorArredondadoPorRodada[rodada] = (int)retorno * Constantes.NUM_JOGADORES;
			}
		}
		return (int)retorno;
	}
	
}
