package dados;

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

	public Som(String path) throws SomInvalidoException {
		this.audioFile = new File(path);
		
		try {
			//Captura arquivo, transforma-o para formato de audio manipulavel
			this.stream = AudioSystem.getAudioInputStream(this.getAudioFile());
		} catch (UnsupportedAudioFileException e) {
			throw new SomInvalidoException();
		} catch (IOException e) {
			throw new SomInvalidoException();
		}
	}

	public File getAudioFile() {
		return this.audioFile;
	}

	public AudioInputStream getStream() {
		return stream;
	}

	/**
	 * Reprodutor simples que suporta .wav
	 * 
	 * @throws SomInvalidoException  Lancada caso haja erro na reproducao.
	 */
	public void tocarSom() throws SomInvalidoException{
		//Captura a linha de saida a ser utilizada para a reproducao
		SourceDataLine line;
		try {
			AudioFormat af = this.stream.getFormat();
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
			line = (SourceDataLine) AudioSystem.getLine(info);
			line.open(af);
		} catch (LineUnavailableException e) {
			throw new SomInvalidoException();
		}

		//Checa se a linha esta ativa. So pode reproduzir um por vez.
		if(!line.isActive()){
			//Abre o canal para reproducao
			line.start();

			//Buffer de reproducao
			int nBytesRead = 0;
			byte[] outBf = new byte[128000];

			//Le parte do buffer e escreve na linha de saida ate nao haver mais o que escrever
			while(nBytesRead != 1){

				try {
					nBytesRead = this.stream.read(outBf, 0, outBf.length);
				} catch (IOException e) {}

				if(nBytesRead >= 0){
					line.write(outBf, 0, outBf.length);
				}
			}
			//Fecha a linha
			line.drain();
			line.close();
		}
	}
}
