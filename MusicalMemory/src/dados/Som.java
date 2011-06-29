package dados;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import dados.filtros.FiltroEcho;

import excecoes.SomInvalidoException;

public class Som {

	private final File audioFile;
	private AudioInputStream stream;
	private AudioFormat af;
	private SourceDataLine line;
	private byte[] samples;

	public Som(String path) throws SomInvalidoException {
		this.audioFile = new File(path);
		try {
			//Captura arquivo, transforma-o para formato de audio manipulavel
			stream = AudioSystem.getAudioInputStream(this.getAudioFile());
			this.samples = this.generateSamples(stream);
			af = stream.getFormat();
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
			line = (SourceDataLine) AudioSystem.getLine(info);
		} catch (UnsupportedAudioFileException e) {
			throw new SomInvalidoException();
		} catch (IOException e) {
			throw new SomInvalidoException();
		} catch (LineUnavailableException e) {
			throw new SomInvalidoException();
		}
	}

	public File getAudioFile() {
		return this.audioFile;
	}

	//public AudioInputStream getStream() {
		//return stream;
	//}
	
	//Transforma stream em byte[]
	 private byte[] generateSamples(AudioInputStream stream) {
		 AudioFormat format = stream.getFormat();
		 //Número de bytes a serem lidos
		 int length = (int) (stream.getFrameLength() * format.getFrameSize());
		 
		 //Leitura dos bytes
		 byte[] samples = new byte[length];
		 DataInputStream is = new DataInputStream(stream);
		 try {
			 is.readFully(samples);
		 } catch (IOException ex) {}

		 return samples;
	 }
	 
	 public byte[] getSamples(){
		 return this.samples;
	 }
	 
	 public AudioInputStream getStream(){
		 return this.stream;
	 }
	 
	 public void setSamples(byte[] samples){
		 this.samples = samples;
	 }

	public AudioFormat getFormat() {
		return af;
	}

	/**
	 * Reprodutor simples que suporta .wav
	 * 
	 * @throws SomInvalidoException  Lancada caso haja erro na reproducao.
	 */
	public void tocarSom() throws SomInvalidoException{
		//Captura a linha de saida a ser utilizada para a reproducao
		try {
			line.open(af);
		} catch (LineUnavailableException e) {
			throw new SomInvalidoException();
		}

		//Checa se a linha esta ativa. So pode reproduzir um por vez.
		if(!line.isActive()){
			//Abre o canal para reproducao
			line.start();

			//Buffer de reproducao
			int nBytesWritten = 1;
			int posicao = 0;
			int tamanhoBuffer = af.getFrameSize()* Math.round(af.getSampleRate() / 10);
			int tamanhoSamples = samples.length;
			//Le parte do buffer e escreve na linha de saida ate nao haver mais o que escrever
			while(nBytesWritten > 0){
					if(posicao > tamanhoSamples - tamanhoBuffer - 1){
						tamanhoBuffer = tamanhoSamples - posicao;
						tamanhoBuffer = tamanhoBuffer / 4 * 4;
					}
					nBytesWritten = line.write(samples, posicao, tamanhoBuffer);
					posicao += nBytesWritten;
			}
			//Fecha a linha
			line.drain();
			line.close();
		}
	}
	
	public static void main(String[] args){
		try {
			Som a = new Som("C:\\Users\\Walter\\Desktop\\c.wav");
			FiltroEcho f = new FiltroEcho();
			//a.tocarSom();
			Som b = f.filtrar(a);
			b = f.filtrar(b);
			b.tocarSom();
		} catch (SomInvalidoException e) {
		} catch (IOException e) {
		}
	}
}
