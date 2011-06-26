import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Init {
	SourceDataLine line;
	AudioInputStream stream;
	AudioFormat af;
	
	public Init() {}
	
	public void playSoundPiece(SoundPiece sp){
		//Captura arquivo, transforma-o para formato de áudio manipulável
		//Captura a linha de saída a ser utilizada para a reprodução
		try {
			stream = AudioSystem.getAudioInputStream(sp.getAudioFile());
			AudioFormat af = stream.getFormat();
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
			line = (SourceDataLine) AudioSystem.getLine(info);
			line.open(af);
		}
		catch (UnsupportedAudioFileException e1) {}
		catch (IOException e1) {} 
		catch (LineUnavailableException e) {}
		
		//Checa se a linha está ativa. Só pode reproduzir um por vez.
		if(!line.isActive()){
			//Abre o canal para reprodução
			line.start();

			//Buffer de reprodução
			int nBytesRead = 0;
			byte[] outBf = new byte[128000];

			//Lê parte do buffer e escreve na linha de saída até não haver mais o que escrever
			while(nBytesRead != 1){

				try {
					nBytesRead = stream.read(outBf, 0, outBf.length);
				} catch (IOException e) {}

				if(nBytesRead >= 0){
					line.write(outBf, 0, outBf.length);
				}
			}
			//Fecha a linha.
			line.drain();
			line.close();
		}
	}
	
	public static void main(String[] args){
		new Init();
	}
	
}
