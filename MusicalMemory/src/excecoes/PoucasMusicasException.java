package excecoes;

public class PoucasMusicasException extends Exception {

	private static final long serialVersionUID = -8325544538129844632L;

	public PoucasMusicasException(int numPecas) {
		super(String.format("O número de sons carregados é insuficiente. " +
				"É necessário ter pelo menos %d sons para carregar devidamente o sistema.", numPecas));
	}
}
