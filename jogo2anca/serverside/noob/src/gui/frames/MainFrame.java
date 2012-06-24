package gui.frames;

import gui.interfaces.PanelAbstract;
import gui.panels.GamePanel;
import gui.panels.InitPanel;
import gui.util.Recursos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	
	private static MainFrame instance;
	private JPanel contentPane;
	private int rodada = 1;
	private int money = 0;
	private int jogador = 1;
	
	/**
	 * Create the frame.
	 */
	private MainFrame() {
		this.contentPane = new InitPanel();
		this.setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setBounds(200, 200, Recursos.LARGURA_JANELA, Recursos.ALTURA_JANELA);
		this.setVisible(true);
	}
	
	static public MainFrame getInstance(){
		if(instance == null){
			instance = new MainFrame();
		}
		return instance;
	}

	public void update(PanelAbstract gamePanel) {
		this.setContentPane(gamePanel);
		gamePanel.update();
		this.setVisible(true);
	}

	public void addDinheiro(int valor){
		if(this.getContentPane().getClass() == GamePanel.class){
			((GamePanel) this.getContentPane()).addDinheiro(valor);
		}
	}

	public int getRodada() {
		return this.rodada;
	}
	
	public void incRodada(){
		this.rodada++;
	}

	public int getMoney() {
		return money;
	}
	
	public void setMoney(int x) {
		this.money = x;
	}

	public int getJogador() {
		return jogador;
	}

	public void setJogador(int jogador) {
		this.jogador = jogador;
	}

}
