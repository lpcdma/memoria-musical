package repositorio;

import java.io.File;
import java.util.ArrayList;

import dados.Som;
import excecoes.SomInvalidoException;

public class RepositorioDeSons {

	private static RepositorioDeSons instancia;
	private final String diretorioMusicas = "musicas\\";
	public static ArrayList<Som> sons;
	
	private RepositorioDeSons() {
		RepositorioDeSons.sons = new ArrayList<Som>(40);
	}
	
	public void carregarSons() throws SomInvalidoException {
		File diretorio = new File(this.diretorioMusicas);
		File[] lista = diretorio.listFiles();
		for (File arquivo : lista) {
			if (arquivo.isFile() && arquivo.getName().endsWith(".wav")) {
				RepositorioDeSons.sons.add(new Som(this.diretorioMusicas + arquivo.getName()));
			}
		}
	}
	
	public static RepositorioDeSons getRepositorio() {
		if (RepositorioDeSons.instancia == null) {
			RepositorioDeSons.instancia = new RepositorioDeSons();
		}
		return RepositorioDeSons.instancia;
	}
}
