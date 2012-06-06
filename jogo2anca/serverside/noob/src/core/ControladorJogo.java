package core;

public class ControladorJogo extends Thread {

	private TestExtension extension = null;
	private GameState estadoJogo;
	
	public ControladorJogo(TestExtension extension, GameState estadoInicial){
		this.extension = extension;
		this.estadoJogo = estadoInicial;
	}
	
	public void run(){
		while(estadoJogo != GameState.END){
		
		}
	}
}
