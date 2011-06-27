package negocio;

import java.util.ArrayList;

import dados.Tabula;

public class ControladorFases {

	private static ControladorFases instancia;
	private ArrayList<Tabula> tabuleiro;
	
	private ControladorFases() {
		this.tabuleiro = new ArrayList<Tabula>(16);
	}
	
	public void carregarTabuleiro(int fase){
		
	}
	
	public static ControladorFases getControladorFases() {
		if (ControladorFases.instancia == null) {
			ControladorFases.instancia = new ControladorFases();
		}
		return ControladorFases.instancia;
	}
}
