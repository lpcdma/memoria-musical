package dados.filtros;

import dados.Som;

public class FiltroReverse extends Filtro {

	public Som filtrar(Som somOriginal){
		Som retorno = somOriginal;
		byte[] oldSamples = somOriginal.getSamples();
		byte[] newSamples = new byte[oldSamples.length];
		for(int i = 0, j = oldSamples.length-2; i< oldSamples.length-1; i+=2, j-=2){
			setSample(newSamples, j, getSample(oldSamples,i));
		}
		retorno.setSamples(newSamples);
		return retorno;
	}
	@Override
	public void filter(byte[] samples, int offset, int length) {}

}
