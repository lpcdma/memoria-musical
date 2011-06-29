package excecoes;

public class SomInvalidoException extends Exception{

	private static final long serialVersionUID = -519807011993468589L;

	public SomInvalidoException(String nomeArquivo) {
		super(String.format("O som passado (%s) é inválido.",nomeArquivo));
	}
}
