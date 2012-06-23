package gui.frames;

import gui.panels.GamePanel;
import gui.panels.InitPanel;

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
	private static final int largura = 720;
	private static final int altura = 400;

	/**
	 * Create the frame.
	 */
	private MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setBounds(200, 200, largura, altura);
		this.setVisible(true);
		this.contentPane = new InitPanel();
		this.setContentPane(contentPane);
	}
	
	static public MainFrame getInstance(){
		if(instance == null){
			instance = new MainFrame();
		}
		return instance;
	}

	public void update(JPanel gamePanel) {
		getInstance().setContentPane(gamePanel);
		getInstance().setVisible(true);
	//	this.setSize(gamepanel.)
	}

	public void addDinheiro(int valor){
		if(this.getContentPane().getClass() == GamePanel.class){
			((GamePanel) this.getContentPane()).addDinheiro(valor);
		}
	}
	
	public static int getLargura() {
		return largura;
	}

	public static int getAltura() {
		return altura;
	}
	
}
