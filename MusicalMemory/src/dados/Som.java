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
			this.stream = AudioSystem.getAudioInputStream(this.audioFile);
			this.samples = this.generateSamples(this.stream);
			this.af = this.stream.getFormat();
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, this.af);
			this.line = (SourceDataLine) AudioSystem.getLine(info);
		} catch (UnsupportedAudioFileException e) {
			throw new SomInvalidoException(this.audioFile.getName());
		} catch (IOException e) {
			throw new SomInvalidoException(this.audioFile.getName());
		} catch (LineUnavailableException e) {
			throw new SomInvalidoException(this.audioFile.getName());
		}
	}

	//Transforma stream em byte[]
	private byte[] generateSamples(AudioInputStream stream) {
		AudioFormat format = stream.getFormat();
		//Numero de bytes a serem lidos
		int length = (int) (stream.getFrameLength() * format.getFrameSize());

		//Leitura dos bytes
		byte[] samples = new byte[length];
		DataInputStream is = new DataInputStream(stream);
		try {
			is.readFully(samples);
		} catch (IOException ex) {}

		return samples;
	}

	/**
	 * Reprodutor simples que suporta .wav.
	 * 
	 * @throws SomInvalidoException  Lancada caso haja erro na reproducao.
	 */
	public void tocarSom() throws SomInvalidoException {
		//Captura a linha de saida a ser utilizada para a reproducao
		try {
			this.line.open(this.af);
		} catch (LineUnavailableException e) {
			throw new SomInvalidoException(this.audioFile.getName());
		}

		//Checa se a linha esta ativa. So pode reproduzir um por vez.
		if(!this.line.isActive()){
			//Abre o canal para reproducao
			this.line.start();

			//Buffer de reproducao
			int nBytesWritten = 1;
			int posicao = 0;
			int tamanhoBuffer = this.af.getFrameSize()* Math.round(this.af.getSampleRate() / 10);
			int tamanhoSamples = this.samples.length;
			//Le parte do buffer e escreve na linha de saida ate nao haver mais o que escrever
			while(nBytesWritten > 0){
				if(posicao > tamanhoSamples - tamanhoBuffer - 1){
					tamanhoBuffer = tamanhoSamples - posicao;
					tamanhoBuffer = tamanhoBuffer / 4 * 4;
				}
				nBytesWritten = this.line.write(this.samples, posicao, tamanhoBuffer);
				posicao += nBytesWritten;
			}
			//Fecha a linha
			this.line.drain();
			this.line.close();
		}
	}

	public File getAudioFile() {
		return this.audioFile;
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
		return this.af;
	}

}
