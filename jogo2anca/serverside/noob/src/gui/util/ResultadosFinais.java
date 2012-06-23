package gui.util;

public class ResultadosFinais {

	int dinheiroPlayer_1 = 0;
	int dinheiroPlayer_2 = 0;
	int dinheiroPlayer_3 = 0;
	int dinheiroPlayer_4 = 0;

	public ResultadosFinais(int dinP1,int dinP2,int dinP3,int dinP4) {
		dinheiroPlayer_1 = dinP1;
		dinheiroPlayer_2 = dinP2;
		dinheiroPlayer_3 = dinP3;
		dinheiroPlayer_4 = dinP4;
	}

	public String getDinheiroPlayer_1() {
		return Recursos.converterParaReal(dinheiroPlayer_1);
	}

	public String getDinheiroPlayer_2() {
		return Recursos.converterParaReal(dinheiroPlayer_2);
	}


	public String getDinheiroPlayer_3() {
		return Recursos.converterParaReal(dinheiroPlayer_3);
	}


	public String getDinheiroPlayer_4() {
		return Recursos.converterParaReal(dinheiroPlayer_4);
	}


}
