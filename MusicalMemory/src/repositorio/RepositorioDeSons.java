package repositorio;

public class RepositorioDeSons {

	private static RepositorioDeSons instancia;
	
	private RepositorioDeSons() {
		
	}
	
	public void carregarSons(){
		
	}
	
	public static RepositorioDeSons getRepositorio() {
		if (RepositorioDeSons.instancia == null) {
			RepositorioDeSons.instancia = new RepositorioDeSons();
		}
		return RepositorioDeSons.instancia;
	}
}
