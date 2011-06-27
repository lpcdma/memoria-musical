package fachadaMemoria;

import excecoes.SomInvalidoException;
import negocio.ControladorFases;
import negocio.ControladorSom;

public class SistemaMemoria {

	private static SistemaMemoria instancia;
	private ControladorSom controleSom;
	private ControladorFases controleFases;
	
	private SistemaMemoria() throws SomInvalidoException {
		this.controleSom = ControladorSom.getControladorSom();
		this.controleFases = ControladorFases.getControladorFases();
	}
	
	public static SistemaMemoria getSistema() throws SomInvalidoException {
		if (SistemaMemoria.instancia == null) {
			SistemaMemoria.instancia = new SistemaMemoria();
		}
		return SistemaMemoria.instancia;
	}
}
