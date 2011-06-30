package dados.filtros;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import dados.Som;

public abstract class Filtro {

	public Som filtrar(Som somOriginal) {
		byte[] samples = somOriginal.getSamples();
		InputStream is = new ByteArrayInputStream(samples);
		is = new FiltroSomStream(is, this);
		Som retorno = somOriginal;
		
		int bufferSize = somOriginal.getFormat().getFrameSize()
							* Math.round(somOriginal.getFormat().getSampleRate() / 10);
		byte[] buffer = new byte[bufferSize];
		
		int nBytesCopied = 0;
		int posicao = 0;
		while(nBytesCopied != -1){
			try {
				nBytesCopied = is.read(buffer, 0, buffer.length);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i = 0; i<nBytesCopied && posicao<samples.length; i++, posicao++)
				samples[posicao] = buffer[i];
		}
		
				
		retorno.setSamples(samples);
		return retorno;
	}

	/**
	 * Gets the remaining size, in bytes, that this filter plays after the sound
	 * is finished. An example would be an echo that plays longer than it's
	 * original sound. This method returns 0 by default.
	 */
	public int getRemainingSize() {
		return 0;
	}

	/**
	 * Filters an array of samples. Samples should be in 16-bit, signed,
	 * little-endian format.
	 */
	public void filter(byte[] samples) {
		filter(samples, 0, samples.length);
	}

	/**
	 * Filters an array of samples. Samples should be in 16-bit, signed,
	 * little-endian format. This method should be implemented by subclasses.
	 */
	public abstract void filter(byte[] samples, int offset, int length);

	/**
	 * Convenience method for getting a 16-bit sample from a byte array. Samples
	 * should be in 16-bit, signed, little-endian format.
	 */
	public static short getSample(byte[] buffer, int position) {
		return (short) (((buffer[position + 1] & 0xff) << 8) | (buffer[position] & 0xff));
	}

	/**
	 * Convenience method for setting a 16-bit sample in a byte array. Samples
	 * should be in 16-bit, signed, little-endian format.
	 */
	public static void setSample(byte[] buffer, int position, short sample) {
		buffer[position] = (byte) (sample & 0xff);
		buffer[position + 1] = (byte) ((sample >> 8) & 0xff);
	}

}
