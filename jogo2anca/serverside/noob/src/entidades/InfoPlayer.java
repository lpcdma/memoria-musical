package entidades;

public class InfoPlayer {

	String curso = "";
	String idade;
	int nPlayer;
	String classe = "";
	String sexo = "";
	
	public InfoPlayer(String curso, String idade, String classe, String sexo) {
		this.curso = curso;
		this.idade = idade;
		this.classe = classe;
		this.sexo = sexo;
		this.nPlayer = 1;
	}
	
	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}


	public String getIdade() {
		return idade+"";
	}


	public void setIdade(String idade) {
		this.idade = idade;
	}


	public String getNumPlayer() {
		return nPlayer+"";
	}


	public void setNumPlayer(int nPlayer) {
		this.nPlayer = nPlayer;
	}


	public String getClasse() {
		return classe;
	}


	public void setClasse(String classe) {
		this.classe = classe;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
