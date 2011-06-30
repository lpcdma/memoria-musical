package repositorio;

import java.io.File;
import java.util.ArrayList;

import dados.Som;
import excecoes.SomInvalidoException;

public class RepositorioDeSons {

	private static final String diretorioMusicas = "musicas\\";
	private static ArrayList<Som> sons;
	
	private RepositorioDeSons() { }
	
	private static void carregarSons() throws SomInvalidoException {
		File diretorio = new File(RepositorioDeSons.diretorioMusicas);
		File[] lista = diretorio.listFiles();
		for (File arquivo : lista) {
			if (arquivo.isFile() && arquivo.getName().endsWith(".wav")) {
				RepositorioDeSons.sons.add(new Som(RepositorioDeSons.diretorioMusicas + arquivo.getName()));
			}
		}
	}
	
	public static ArrayList<Som> getSons() throws SomInvalidoException{
		if (RepositorioDeSons.sons == null) {
			RepositorioDeSons.sons = new ArrayList<Som>(40);
			RepositorioDeSons.carregarSons();
		}
		return RepositorioDeSons.sons;
	}
}
