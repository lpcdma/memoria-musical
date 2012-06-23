package gui.util;

public class Recursos {
	
	public static final int TEMPO_DE_JOGO_SEGUNDOS = 5;
	public static final int TEMPO_PARA_PASSAR_DE_TELA_SEGUNDOS = 3;
	
	static public String converterParaReal(int centavos){
		String retorno = "";
		if(centavos % 10 == 0){
			retorno = (String.valueOf((double) centavos/100)+"0");			
		}
		else{
			retorno = (String.valueOf((double) centavos/100));					
		}
		return retorno;
	}

	public static int converterParaInt(String text) {
		double duplo = Double.parseDouble(text);
		return (int) duplo;
	}
	
}
