package fachadaMemoria;

import negocio.ControladorFases;
import negocio.ControladorSom;

public class SistemaMemoria {

	private static SistemaMemoria instancia;
	private ControladorSom controleSom;
	private ControladorFases controleFases;
	
	private SistemaMemoria() {
		this.controleSom = ControladorSom.getControladorSom();
		this.controleFases = ControladorFases.getControladorFases();
	}
	
	public static SistemaMemoria getSistema() {
		if (SistemaMemoria.instancia == null) {
			SistemaMemoria.instancia = new SistemaMemoria();
		}
		return SistemaMemoria.instancia;
	}
}
