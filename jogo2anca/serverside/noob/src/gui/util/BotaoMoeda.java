package gui.util;

import gui.frames.MainFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BotaoMoeda extends JLabel{

	final String urlMoeda5 = "C:/Users/Uoji/Desktop/Monografia Bianca/Jogo2anca/Imagens/moeda52.png";
	final String urlMoeda10 = "C:/Users/Uoji/Desktop/Monografia Bianca/Jogo2anca/Imagens/moeda102.png";
	Icon image = null;
	int valor = 0;
	boolean clicked = false;

	public BotaoMoeda(int valor) {
		this.valor = valor;
		if(valor == 5){
			image = new ImageIcon(urlMoeda5);
		}
		else if(valor == 10){
			image = new ImageIcon(urlMoeda10);			
		}

		this.setIcon(image);

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				if(isClicked()){
					MainFrame.getInstance().addDinheiro(-getValor());
					setClicked(false);
				}
				else{				
					MainFrame.getInstance().addDinheiro(getValor());
					setClicked(true);
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
}
