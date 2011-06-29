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

import dados.Tabula;
import excecoes.SomInvalidoException;

public class PecaDeMemoria extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3060323556573736760L;
	Icon imagemNormal = null;
	Icon imagemPressed = null;
	Tabula tabula;
	PanelDoJogo jogo;
	
	public PecaDeMemoria(PanelDoJogo jogo,Tabula tabula) {
		super();
		this.tabula = tabula;
		this.jogo = jogo;
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

	public Tabula getTabula() {
		return tabula;
	}

	public void setTabula(Tabula tabula) {
		this.tabula = tabula;
	}

	public void mousePressedFora(MouseEvent e) {
		if(JanelaPrincipal.pecaAtual == null){
			JanelaPrincipal.pecaAtual = this;
			this.reproduzirSom();
			this.jogo.habilitarReplay();
		}
		else{
			boolean igual = this.getTabula().equals(JanelaPrincipal.pecaAtual.getTabula());
			this.reproduzirSom();
			this.jogo.desabilitarReplay();
			if(igual){
				this.setEnabled(false);
				JanelaPrincipal.pecaAtual.setEnabled(false);
				JanelaPrincipal.restantes -= 2;
				if(JanelaPrincipal.restantes == 0){
					jogo.passarLevel();
				}
			}
			else{
				JanelaPrincipal.pecaAtual = null;
			}
		}
	}

	public void mouseReleasedFora(MouseEvent e) {

	}

	public void mouseEnteredFora(MouseEvent e) {

	}

	public void mouseExitedFora(MouseEvent e) {

	}

	public void mouseClickedFora(MouseEvent e) {

	}

	public void reproduzirSom() {
		System.out.println("AHHH! #grito");
		try {
			tabula.getSom().tocarSom();
		} catch (SomInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
