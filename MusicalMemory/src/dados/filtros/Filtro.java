package dados.filtros;

import dados.Som;

public abstract class Filtro implements Filtravel {
	
	public abstract Som filtrar(Som somOriginal);
	
}
