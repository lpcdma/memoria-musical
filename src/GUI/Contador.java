package GUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Contador extends Thread{

	long contador;
	JLabel label;

	public Contador(JLabel label,int nivel) {
		contador = setarContador(nivel);
		this.label = label;
	}

	private long setarContador(int nivel) {
		if((nivel == 1) || (nivel == 6) || (nivel == 11)){
			return 100*1000;
		}
		else if((nivel == 2) || (nivel == 7) || (nivel == 12)){
			return 90*1000;
		}
		else if((nivel == 3) || (nivel == 8) || (nivel == 13)){
			return 80*1000;
		}
		else if((nivel == 4) || (nivel == 9) || (nivel == 14)){
			return 70*1000;
		}
		else if((nivel == 5) || (nivel == 10) || (nivel == 15)){
			return 60*1000;
		}
		else if(nivel == 999){
			return 5*1000;
		}
		else {
			return 150*1000;
		}
		
	}

	public void run(){
		long tempoInicial = System.currentTimeMillis();
		try {
			long lol = 0;
			boolean funcionando = true;
			while(funcionando){
				Thread.sleep(1000);
				lol = (((tempoInicial+contador) - System.currentTimeMillis())/1000);
				if(lol <= 0){
					JOptionPane.showMessageDialog(null,"Perdeu!");
					funcionando = false;
				}
				label.setText(Long.toString(lol,10));
			}
		}

		catch (InterruptedException e) {}

	}
}
