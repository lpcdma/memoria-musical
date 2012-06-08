package basic;

public class Pergunta {
	
	public Pergunta(int idPergunta, String pergunta) {
		this.setId(idPergunta);
		this.setPergunta(pergunta);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	private int id;
	private String pergunta;
}
