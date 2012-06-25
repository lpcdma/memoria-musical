package basic;

import negocio.core.Constantes;

public class FundoAposta {
	
	private int[] valorRealPorRodada = {0,0,0,0,0,0};
	private int[] valorArredondadoPorRodada = {0,0,0,0,0,0};
	
	public void apostarRodada(int rodada, int valor){
		if(rodada > 0 && rodada < valorRealPorRodada.length){
			valorRealPorRodada[rodada-1] += valor;
		}
	}
	
	public int calcularRetorno(int rodada){
		double retorno = 0;
		if(rodada > 0 && rodada < valorRealPorRodada.length){
			if(valorArredondadoPorRodada[rodada-1]>0){
				retorno = valorArredondadoPorRodada[rodada-1] / Constantes.NUM_JOGADORES;
			}else{
				retorno = valorRealPorRodada[rodada-1] * 2;
				if((retorno/Constantes.NUM_JOGADORES) % 5 == 0){
					retorno = retorno / Constantes.NUM_JOGADORES;
				}
				else{
					double valor = retorno / Constantes.NUM_JOGADORES;
					valor = Math.ceil(valor);
					if(valor % 5 == 0){
						retorno = valor;
					}
					else{
						for(int i = 1; i <= 4; i++){
							valor = valor + 1.0;
							if(valor % 5 == 0){
								retorno = valor;
								break;
							}
						}
					}
				}
				valorArredondadoPorRodada[rodada-1] = (int)retorno * Constantes.NUM_JOGADORES;
				valorRealPorRodada[rodada-1] = valorRealPorRodada[rodada-1] * 2;
			}
		}
		return (int)retorno;
	}
	
	public int[] getValorRealPorRodada(){
		return this.valorRealPorRodada;
	}
	
	public int[] getValorArredondadoPorRodada(){
		return this.valorArredondadoPorRodada;
	}
	
	public int calculaAcrescimo(int rodada){
		if(rodada > 0 && rodada < valorRealPorRodada.length){
			return valorArredondadoPorRodada[rodada-1] - valorRealPorRodada[rodada-1];
		}
		return 0;
	}
	
}
