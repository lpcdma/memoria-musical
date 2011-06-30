package dados.filtros;

public class FiltroSawtooth extends Filtro {

	private short[] lastSample = new short[128];
	private int samplesFiltered = 0;
	private int pos = 0;

	@Override
	public void filter(byte[] samples, int offset, int length) {
		for (int i = offset; i < offset + length; i += 2) {
			
			short oldSample = getSample(samples, i);
			short newSample;
			
			if(samplesFiltered<lastSample.length){
				newSample = oldSample; 
			}
			else{
				newSample = (short) (oldSample + lastSample[pos]);
			}
			
			setSample(samples, i, newSample);
			
			lastSample[pos] = oldSample;
			pos++;
			if (pos == lastSample.length) {
				pos = 0;
			}
			
			samplesFiltered++;
		}
	}

}
