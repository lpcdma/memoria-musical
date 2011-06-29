package excecoes;

public class FaseInvalidaException extends Exception{

	private static final long serialVersionUID = 8824593545499992647L;

	public FaseInvalidaException(int fase) {
		super(String.format("A fase passada (%d) é inválida.", fase));
	}
}
