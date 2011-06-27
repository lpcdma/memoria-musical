package dados.filtros;

import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;

import dados.Som;

public class FiltroEcho extends FilterInputStream {
	
	protected FiltroEcho(InputStream arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	private short[] delayBuffer;
	private int delayBufferPos;
	private float decay;
	
	
	public Som filtrar(Som somOriginal) {
		AudioInputStream stream = somOriginal.getStream();
		byte[] samples = this.getSamples(stream); 
		return null;
	}
	
	//Transforma stream em byte[]
	 private byte[] getSamples(AudioInputStream audioStream) {
		 AudioFormat format = audioStream.getFormat();
		 //Número de bytes a serem lidos
		 int length = (int) (audioStream.getFrameLength() * format.getFrameSize());
		 
		 //Leitura dos bytes
		 byte[] samples = new byte[length];
		 DataInputStream is = new DataInputStream(audioStream);
		 try {
			 is.readFully(samples);
		 } catch (IOException ex) {}

		 return samples;
	 }
	 //Extensão do buffer apos passagem do filtro
	 private int getRemainingSize() {
		 float finalDecay = 0.01f;
		 // derived from Math.pow(decay,x) <= finalDecay
		 int numRemainingBuffers = (int) Math.ceil(Math.log(finalDecay)
				 / Math.log(decay));
		 int bufferSize = delayBuffer.length * 2;

		 return bufferSize * numRemainingBuffers;
	 }
	 
	 private void filter(byte[] samples, int offset, int length) {

		 for (int i = offset; i < offset + length; i += 2) {
			 // update the sample
			 short oldSample = getSample(samples, i);
			 short newSample = (short) (oldSample + decay * delayBuffer[delayBufferPos]);
			 setSample(samples, i, newSample);

			 // update the delay buffer
			 delayBuffer[delayBufferPos] = newSample;
			 delayBufferPos++;
			 if (delayBufferPos == delayBuffer.length) {
				 delayBufferPos = 0;
			 }
		 }
	 }
	 
	 private short getSample(byte[] buffer, int position) {
		 return (short) (((buffer[position + 1] & 0xff) << 8) | (buffer[position] & 0xff));
	 }
	 
	 private void setSample(byte[] buffer, int position, short sample) {
		 buffer[position] = (byte) (sample & 0xff);
		 buffer[position + 1] = (byte) ((sample >> 8) & 0xff);
	 }
	 

}
