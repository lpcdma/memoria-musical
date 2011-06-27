package excecoes;

public class SomInvalidoException extends Exception{

	private static final long serialVersionUID = -519807011993468589L;

	public SomInvalidoException() {
		super("O som passado é invalido.");
	}
}
