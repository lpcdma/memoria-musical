package dados.filtros;

public class FiltroPassaTudo extends Filtro {


	private short[] delayedSample = new short[11025];
	private short[] lastSample = new short[11025];
	private int samplesFiltered = 0;
	private int pos = 0;
	private float gain = .5f;


	@Override
	public void filter(byte[] samples, int offset, int length) {
		for (int i = offset; i < offset + length - 1; i += 2) {
			short oldSample = getSample(samples, i);
			short newSample;
			
			if(samplesFiltered<lastSample.length){
				newSample = oldSample; 
			}
			else{
				newSample = (short) ((oldSample * -gain) 
						+ lastSample[pos] +(gain * delayedSample[pos]));
			}
			
			setSample(samples, i, newSample);
			
			
			delayedSample[pos] = newSample;
			lastSample[pos] = oldSample;
			pos++;
			if (pos == delayedSample.length) {
				pos = 0;
			}
			
			samplesFiltered++;
		}
	}

}
