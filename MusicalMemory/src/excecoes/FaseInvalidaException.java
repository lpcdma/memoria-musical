package excecoes;

public class FaseInvalidaException extends Exception{

	private static final long serialVersionUID = 8824593545499992647L;

	public FaseInvalidaException() {
		super("A fase passada é invalida.");
	}
}
