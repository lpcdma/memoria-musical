package GUI;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;

public class PanelDoJogo extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8458509008566406420L;
	ArrayList<PecaDeMemoria> listaMemoria = null;  //  @jve:decl-index=0:

	public PanelDoJogo() {
		super();
		initialize();
	}

	private void initialize() {
		this.setLayout(null);
		listaMemoria = new ArrayList<PecaDeMemoria>();
		this.setLayout(null);
		this.setSize(new Dimension(578, 551));	
		this.setPreferredSize(new Dimension(578, 551));	
	}

	public void inserirButoes(int nivel){
		if(nivel <= 5){
			int x = 80;
			int y = 65;
			for (int i = 1; i <= 16; i++) {
				PecaDeMemoria novaPeca = new PecaDeMemoria(nivel);
				this.listaMemoria.add(novaPeca);
				this.add(novaPeca);
				novaPeca.setBounds(new Rectangle(x, y, 60, 60));
				x += 85;
				if(i % 4 == 0){
					y += 85;
					x = 80;
				}
			}
		}
		else if(nivel <= 10){
			int x = 40;
			int y = 25;
			for (int i = 1; i <= 25; i++) {
				PecaDeMemoria novaPeca = new PecaDeMemoria(nivel);
				this.listaMemoria.add(novaPeca);
				this.add(novaPeca);
				novaPeca.setBounds(new Rectangle(x, y, 60, 60));
				x += 80;
				if(i % 5 == 0){
					y += 80;
					x = 40;
				}
			}
			
		}
		else if(nivel <= 15){
			int x = 25;
			int y = 10;
			for (int i = 1; i <= 36; i++) {
				PecaDeMemoria novaPeca = new PecaDeMemoria(nivel);
				this.listaMemoria.add(novaPeca);
				this.add(novaPeca);
				novaPeca.setBounds(new Rectangle(x, y, 60, 60));
				x += 75;
				if(i % 6 == 0){
					y += 75;
					x = 25;
				}
			}
			
		}
	}


}  //  @jve:decl-index=0:visual-constraint="296,13"
