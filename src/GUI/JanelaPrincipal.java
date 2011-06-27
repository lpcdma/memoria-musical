package GUI;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import java.awt.Rectangle;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JLabel;
import javax.swing.JButton;

public class JanelaPrincipal extends JFrame{

	/**
	 * 
	 */
	public static int nivel = 15;

	private static final long serialVersionUID = 6956795457507815787L;
	
	private JMenuBar barraMenu;
	private JPanel panelPrincipal;
	private JMenu botaoIniciar;
	private JMenu menuAjuda;
	private PanelDoJogo panelJogo;
	private JMenuItem itemAjuda;
	private JMenuItem itemSobre;
	private Thread contador;
	ReentrantLock lock = new ReentrantLock();
	
	
	private String mensagemDeAjuda = "Te vira, malandro.";  //  @jve:decl-index=0:
	private String mensagemDeSobre = "Biribou";
	private JLabel relogio = null;
	private JButton botaoAjuda;
	private JMenuItem itemSair = null;
	private JMenuItem itemComecar = null;

	private JLabel labelIntro = null;

	//Construtor da Janela Principal do Sistema
	public JanelaPrincipal() {
		super("Jogo da Memória");
		initialize();
		this.setVisible(true);
	
	
	}
	//Método responsável por inicializar as variáveis

	private void initialize() {
		//this.setPreferredSize(new Dimension(469, 328));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(654, 557));
		this.setContentPane(getPanelPrincipal());
		this.setJMenuBar(getBarraMenu());     
		this.setListeners();
	}


	//Método para setar todos os listeners
	private void setListeners() {

		this.itemAjuda.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				itemAjudaActionPerformed(evt);
			}
		});
		this.botaoAjuda.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				botaoAjudaActionPerformed(evt);
			}
		});
		this.itemComecar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				itemComecarActionPerformed(evt);
			}
		});
		this.itemSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				itemSairActionPerformed(evt);
			}
		});
		this.itemSobre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				itemSobreActionPerformed(evt);
			}
		});

	}

	protected void botaoAjudaActionPerformed(ActionEvent evt) {
		Object[] possibleValues = { "1", "2", "3" };

		int resposta = JOptionPane.showOptionDialog(this,"Escolha um dos Coringas","Coringas",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,possibleValues,1);

	}

	protected void itemSairActionPerformed(ActionEvent evt) {
		System.exit(1);
	}

	protected void itemComecarActionPerformed(ActionEvent evt) {

		int resposta = JOptionPane.showConfirmDialog(this,"Deseja Coringas?","Iniciar o Jogo",JOptionPane.OK_CANCEL_OPTION);

		labelIntro.setVisible(false);
		panelJogo.setVisible(true);
		relogio.setVisible(true);
		this.getPanelJogo().inserirButoes(nivel);
		this.contador = new Thread(new Contador(relogio,nivel));
		contador.start();
		
		if(resposta == 0){
			botaoAjuda.setVisible(true);
			
		}
		else{
			botaoAjuda.setVisible(false);
		}
	}

	protected void itemSobreActionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(this, this.mensagemDeSobre,"Sobre",JOptionPane.INFORMATION_MESSAGE);	
	}

	protected void itemAjudaActionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(this, this.mensagemDeAjuda,"Ajuda",JOptionPane.INFORMATION_MESSAGE);	
	}

	private JMenuBar getBarraMenu() {
		if (barraMenu == null) {
			barraMenu = new JMenuBar();
			barraMenu.add(getMenu());
			barraMenu.add(getMenuAjuda());
		}
		return barraMenu;
	}

	private JPanel getPanelPrincipal() {
		if (panelPrincipal == null) {
			relogio = new JLabel();
			relogio.setBounds(new Rectangle(533, 21, 93, 82));
			relogio.setText("");
			relogio.setVisible(false);
			panelPrincipal = new JPanel();
			panelPrincipal.setLayout(null);
			panelPrincipal.add(getPanelJogo());
			panelPrincipal.add(relogio);
			panelPrincipal.add(getBotaoAjuda());
			panelPrincipal.add(getLabelIntro());
			Font curFont = relogio.getFont();
			relogio.setFont(new Font(curFont.getFontName(), curFont.getStyle(), 50));
		}
		return panelPrincipal;
	}

	private PanelDoJogo getPanelJogo() {
		if (panelJogo == null) {
			panelJogo = new PanelDoJogo();
			panelJogo.setLayout(null);
			panelJogo.setBounds(new Rectangle(19, 20, 505, 466));
			panelJogo.setVisible(false);
		}
		return panelJogo;
	}

	private JMenu getMenu() {
		if (botaoIniciar == null) {
			botaoIniciar = new JMenu("Iniciar");
			botaoIniciar.add(getItemComecar());
			botaoIniciar.add(getItemSair());
		}
		return botaoIniciar;
	}

	private JMenuItem getItemAjuda() {
		if (itemAjuda == null) {
			itemAjuda = new JMenuItem("Ajuda");
		}
		return itemAjuda;
	}

	private JMenu getMenuAjuda() {
		if (menuAjuda == null) {
			menuAjuda = new JMenu();
			menuAjuda.setText("Outros");
			menuAjuda.add(getItemAjuda());
			menuAjuda.add(getItemSobre());
		}
		return menuAjuda;
	}

	private JMenuItem getItemSobre() {
		if (itemSobre == null) {
			itemSobre = new JMenuItem("Sobre");
		}
		return itemSobre;
	}

	/**
	 * This method initializes botaoAjuda	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBotaoAjuda() {
		if (botaoAjuda == null) {
			botaoAjuda = new JButton();
			botaoAjuda.setBounds(new Rectangle(528, 137, 88, 24));
			botaoAjuda.setText("Coringas");
			botaoAjuda.setVisible(false);
		}
		return botaoAjuda;
	}

	/**
	 * This method initializes itemSair	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemSair() {
		if (itemSair == null) {
			itemSair = new JMenuItem("Sair");
		}
		return itemSair;
	}

	/**
	 * This method initializes itemComecar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemComecar() {
		if (itemComecar == null) {
			itemComecar = new JMenuItem("Iniciar Jogo");
		}
		return itemComecar;
	}

	/**
	 * This method initializes labelIntro	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getLabelIntro() {
		if (labelIntro == null) {
			labelIntro = new JLabel();
			labelIntro.setText("Devemos colocar alguma coisa aqui para inicializar o jogo - FALTA UM BACKGROUND");
			labelIntro.setBounds(new Rectangle(88, 98, 497, 219));
		}
		return labelIntro;
	}

	public static void main(String[] args) {
		new JanelaPrincipal();
	}
}  //  @jve:decl-index=0:visual-constraint="226,20"
