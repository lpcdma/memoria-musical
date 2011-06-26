package testes;
import java.io.File;


public class SoundPiece {
	
	private File audioFile;
	private int id;
	private SoundPiece pair;
	
	public SoundPiece(String path, int id){
		this.setAudioFile(new File(path));
		this.setId(id);
	}
	
	public SoundPiece(String path, int id, SoundPiece pair){
		this.setAudioFile(new File(path));
		this.setId(id);
		this.setPair(pair);
	}

	void setAudioFile(File audioFile) {
		this.audioFile = audioFile;
	}

	File getAudioFile() {
		return audioFile;
	}

	void setId(int id) {
		this.id = id;
	}

	int getId() {
		return id;
	}

	void setPair(SoundPiece pair) {
		this.pair = pair;
	}

	SoundPiece getPair() {
		return pair;
	}
}
