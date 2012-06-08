package basic;

public class Resposta {
	
	private Pergunta pergunta;
	private String resposta;
	
	public Resposta(Pergunta pergunta, String resposta){
		this.setPergunta(pergunta);
		this.setResposta(resposta);
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
}
