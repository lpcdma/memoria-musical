package dados.filtros;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import dados.Som;

public class FiltroEcho extends Filtro {

	private short[] delayBuffer = new short [44100];
	private int delayBufferPos;
	private float decay = .4f;

	public Som filtrar(Som somOriginal) {

		byte[] samples = somOriginal.getSamples();
		InputStream is = new ByteArrayInputStream(samples);
		is = new FiltroSomStream(is, this);
		Som retorno = somOriginal;

		int bufferSize = somOriginal.getFormat().getFrameSize() * Math.round(
				somOriginal.getFormat().getSampleRate() / 10);
		byte[] buffer = new byte[bufferSize];

		int nBytesCopied = 0;
		int posicao = 0;
		while(nBytesCopied != -1){
			try {
				nBytesCopied = is.read(buffer, 0, buffer.length);
			} catch (IOException e) {
				nBytesCopied = 0;
			}
			for(int i = 0; i<nBytesCopied && posicao<samples.length; i++, posicao++)
				samples[posicao] = buffer[i];
		}

		retorno.setSamples(samples);
		return retorno;
	}

	//Extensao do buffer apos passagem do filtro
	public int getRemainingSize() {
		float finalDecay = 0.01f;
		int numRemainingBuffers = (int) Math.ceil(Math.log(finalDecay) / Math.log(decay));
		int bufferSize = this.delayBuffer.length * 2;

		return (bufferSize * numRemainingBuffers);
	}

	public void filter(byte[] samples, int offset, int length) {
		/*
		 * Filters the sound samples to add an echo. The samples played are added to
		 * the sound in the delay buffer multipied by the decay rate. The result is
		 * then stored in the delay buffer, so multiple echoes are heard.
		 */
		for (int i = offset; i < offset + length; i += 2) {
			// update the sample
			short oldSample = getSample(samples, i);
			short newSample = (short) (oldSample + this.decay
					* this.delayBuffer[this.delayBufferPos]);
			setSample(samples, i, newSample);


			// update the delay buffer
			this.delayBuffer[this.delayBufferPos] = newSample;
			this.delayBufferPos++;
			if (this.delayBufferPos == this.delayBuffer.length) {
				this.delayBufferPos = 0;
			}
		}
	}

}
