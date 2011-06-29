package excecoes;

public class PoucasMusicasException extends Exception {

	private static final long serialVersionUID = -8325544538129844632L;

	public PoucasMusicasException(int numPecas) {
		super(String.format("O n�mero de sons carregados � insuficiente. " +
				"� necess�rio ter pelo menos %d sons para carregar devidamente o sistema.", numPecas));
	}
}
