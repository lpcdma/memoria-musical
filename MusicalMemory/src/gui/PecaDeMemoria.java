package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.synth.SynthLookAndFeel;

public class PecaDeMemoria extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3060323556573736760L;
	Icon imagemNormal = null;
	Icon imagemPressed = null;

	public PecaDeMemoria(int nivel) {
		super();
		imagemNormal = new ImageIcon("imagens\\botoes\\imageBotao.png");
	//	imagemPressed = new ImageIcon("imagens\\botoes\\imageBotaoPressed.png");
		this.setIcon(imagemNormal);
        this.setListeners();
	}
	
	private void setListeners() {
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				mousePressedFora(evt);
			}
		});
	}

	public void mousePressedFora(MouseEvent e) {
		System.out.println("OPA CARAI!");
	}

	public void mouseReleasedFora(MouseEvent e) {

	}

	public void mouseEnteredFora(MouseEvent e) {

	}

	public void mouseExitedFora(MouseEvent e) {

	}

	public void mouseClickedFora(MouseEvent e) {

	}
}
