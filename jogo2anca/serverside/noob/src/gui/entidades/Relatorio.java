package gui.entidades;

public class Relatorio {

	int qtdApostada;
	int qtdRecebida;
	
	public Relatorio(int qtdApostada, int qtdRecebida) {
		this.qtdApostada = qtdApostada;
		this.qtdRecebida = qtdRecebida;
	}
	
	public int getQtdApostada() {
		return qtdApostada;
	}

	public void setQtdApostada(int qtdApostada) {
		this.qtdApostada = qtdApostada;
	}

	public int getQtdRecebida() {
		return qtdRecebida;
	}

	public void setQtdRecebida(int qtdRecebida) {
		this.qtdRecebida = qtdRecebida;
	}
	
}
