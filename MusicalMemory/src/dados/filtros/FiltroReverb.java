package dados.filtros;

import java.io.IOException;

import dados.Som;

public class FiltroReverb extends Filtro {
	
	private FiltroPassaTudo fpt = new FiltroPassaTudo();
	
	@Override
	public Som filtrar(Som somOriginal) throws IOException {
		Som retorno = somOriginal;
		for(int i=0; i<=8; i++){
			retorno = fpt.filtrar(retorno);
		}
		return retorno;
	}

	@Override
	public void filter(byte[] samples, int offset, int length) {
		// TODO Auto-generated method stub
		
	}

}
