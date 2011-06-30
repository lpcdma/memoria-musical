package testes;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.*;
import javax.sound.midi.*;

import negocio.ControladorFases;
import repositorio.RepositorioDeSons;
import dados.Som;
import dados.Tabula;
import dados.filtros.FiltroEcho;
import excecoes.FaseInvalidaException;
import excecoes.PoucasMusicasException;
import excecoes.SomInvalidoException;

public class Init {
	SoundPiece[][] gameBoard;
	SourceDataLine line;
	AudioInputStream stream;
	AudioFormat af;
	Synthesizer synth;

	public Init() {}

	//Reprodutor simples que suporta .wav
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

	//Sintetizador simples de notas midi
	public void playMidiNote(int note, int vel, int dur){
		try {
			synth = MidiSystem.getSynthesizer();
			synth.open();
		} catch (MidiUnavailableException e) {}

		MidiChannel[]	channels = synth.getChannels();
		MidiChannel	channel = channels[0];
		channel.noteOn(note, vel);

		try {
			Thread.sleep(dur);
		} catch (InterruptedException e){}

		channel.noteOff(note);

		synth.close();
	}

	public static void main(String[] args){
		//new Init().playMidiNote(60, 100, 2000);

		ArrayList<Tabula> tab;
		try {

			tab = ControladorFases.getControladorFases().getTabuleiro(15);
//			System.out.println("Tamanho " + tab.size());
//			for (Tabula tabula : tab) {
//				System.out.println(tabula.getId());
//				tabula.getSom().tocarSom();
//			}
		} catch (FaseInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PoucasMusicasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SomInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
		ArrayList<Som> sommms = new ArrayList<Som>();

		for (int i = 0; i < 40; i++) {
			Som s = new Som();
			sommms.add(s);
		}
		RepositorioDeSons.sons = sommms;

		ControladorFases c = new ControladorFases();
		try {
			for (int i = 1; i <= 15; i++) {
				c.carregarTabuleiro(i);

				System.out.println("Fase " + i);
				for (Tabula t : c.getTabuleiro()) {
					System.out.print(t.getId());
					System.out.println("  " + t.getSom());
				}
				System.out.println();
			}
		} catch (FaseInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 */

	/*
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
	 */
}

