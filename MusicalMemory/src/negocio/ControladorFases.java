package negocio;

public class ControladorFases {

	private static ControladorFases instancia;
	
	private ControladorFases() {
		
	}
	
	public static ControladorFases getControladorFases() {
		if (ControladorFases.instancia == null) {
			ControladorFases.instancia = new ControladorFases();
		}
		return ControladorFases.instancia;
	}
}
