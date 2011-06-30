package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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

	ArrayList<ImageIcon> imagens = new ArrayList<ImageIcon>();  //  @jve:decl-index=0:
	Tabula tabula;
	PanelDoJogo jogo;
	boolean travou = false;

	public PecaDeMemoria(PanelDoJogo jogo,Tabula tabula) {
		super();
		this.tabula = tabula;
		this.jogo = jogo;
		imagens.add(new ImageIcon("imagens\\botoes\\bNeutro.png"));
		imagens.add(new ImageIcon("imagens\\botoes\\bPressed.png"));
		imagens.add(new ImageIcon("imagens\\botoes\\bAcerto.png"));
		imagens.add(new ImageIcon("imagens\\botoes\\bMNeutro.png"));
		imagens.add(new ImageIcon("imagens\\botoes\\bMPressed.png"));
		imagens.add(new ImageIcon("imagens\\botoes\\bMAcerto.png"));
		
		this.setNeutro();		
		this.setListeners();
	}

	

	private void setListeners() {
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				mousePressedFora(evt);
			}
			public void mouseReleased(MouseEvent evt) {
				mouseReleasedFora(evt);
			}
		});
	}
	
	
	public Tabula getTabula() {
		return tabula;
	}

	public void setTabula(Tabula tabula) {
		this.tabula = tabula;
	}

	public void setAcerto(){
		if(JanelaPrincipal.nivel == 15){
			this.setIcon(imagens.get(5));
		}else{
			this.setIcon(imagens.get(2));
		}
	}
	
	private void setNeutro() {
		if(JanelaPrincipal.nivel == 15){
			this.setIcon(imagens.get(3));
		}else{
			this.setIcon(imagens.get(0));
		}
	}
	
	private void setPressed() {
		if(JanelaPrincipal.nivel == 15){
			this.setIcon(imagens.get(4));
		}else{
			this.setIcon(imagens.get(1));
		}
	}
	
	public void mousePressedFora(MouseEvent e) {
		
		
		this.setPressed();
		if(JanelaPrincipal.pecaAtual == null){
			JanelaPrincipal.pecaAtual = this;
			this.reproduzirSom();
			this.jogo.habilitarReplay();
			this.travou = true;
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
				this.setAcerto();
				JanelaPrincipal.pecaAtual.setAcerto();
			}
			else{
				this.travou = false;
				JanelaPrincipal.pecaAtual = null;
			}
		}
	}

	public void mouseReleasedFora(MouseEvent e) {
		if(!travou){
			this.setNeutro();
		}
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
