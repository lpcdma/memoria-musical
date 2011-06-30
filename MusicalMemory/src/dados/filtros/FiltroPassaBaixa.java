package dados.filtros;


public class FiltroPassaBaixa extends Filtro {
	
	private short lastSample = 0;

	@Override
	public void filter(byte[] samples, int offset, int length) {
		for (int i = offset; i < offset + length; i += 2) {
			 // atualiza o sample atual
			 short oldSample = getSample(samples, i);
			 short newSample = (short) ((oldSample * 0.5) + (lastSample * 0.5));
			 setSample(samples, i, newSample);


			 // guarda o último sample
			 lastSample = oldSample;
		 }

	}

}
