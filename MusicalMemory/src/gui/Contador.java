package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Contador extends Thread{

	long contador;
	JLabel label;
	int nivel;
	boolean funcionando ;
	private boolean acabou = false;
	int tempo = 200;
	int penalidade = 20;
	int fatorMult = 1;
	public Font fontInicial;
	int labelX;
	JanelaPrincipal window;
	
	public Contador(JanelaPrincipal window,JLabel label,int nivel) {
		this.nivel = nivel;
		contador = setarContador(this.nivel);
		this.label = label;
		funcionando = true;
		fontInicial = JanelaPrincipal.fontPadrao;
		this.labelX = 547;
		this.window = window;
	}

	public void acabou(){
		this.acabou = true;
	}

	private long setarContador(int nivel) {
		if(nivel < 6){
			fatorMult = 1;
		}
		else if(nivel < 11){
			fatorMult = 2;
		}
		else if(nivel <= 15){
			fatorMult = 3;
		}
		
		if((nivel == 1) || (nivel == 6) || (nivel == 11)){
			return (tempo)*1000*fatorMult;
		}
		else if((nivel == 2) || (nivel == 7) || (nivel == 12)){
			return (tempo-penalidade)*1000*fatorMult;
		}
		else if((nivel == 3) || (nivel == 8) || (nivel == 13)){
			return (tempo-(penalidade*2))*1000*fatorMult;
		}
		else if((nivel == 4) || (nivel == 9) || (nivel == 14)){
			return (tempo-(penalidade*3))*1000*fatorMult;
		}
		else if((nivel == 5) || (nivel == 10) || (nivel == 15)){
			return (tempo-(penalidade*4))*1000*fatorMult;
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
		contador = setarContador(nivel);
		funcionando = true;
		int tamanhoFonte = 55;
		try {
			long lol = 0;		
			while(funcionando && !acabou){

				lol = (((tempoInicial+contador) - System.currentTimeMillis())/1000);
				label.setText(Long.toString(lol,10));
				if(Integer.parseInt(this.label.getText()) == 99){
					this.menorQue100();
				}
				else if(Integer.parseInt(this.label.getText()) == tempo){
					this.maiorQue100();
				}
				else if(Integer.parseInt(this.label.getText()) < 10){
					this.menorQue10();
					label.setFont(new Font(fontInicial.getFontName(), fontInicial.getStyle(), tamanhoFonte));
					label.setForeground(Color.RED);
					tamanhoFonte += 9;
				}
				if(lol <= 0){
					window.perdeu();
				}
				Thread.sleep(950);
			}
		}
		catch (InterruptedException e) {System.out.println("merda");}

	}

	private void menorQue10() {
		this.label.setLocation(labelX-=2,17);
		
	}

	private void maiorQue100() {
		this.label.setLocation(526,17);

	}

	private void menorQue100() {
		this.label.setLocation(539,17);
	}

}
