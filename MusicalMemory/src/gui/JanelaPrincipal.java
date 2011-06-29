package gui;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JLabel;
import javax.swing.JButton;

import fachadaMemoria.SistemaMemoria;

public class JanelaPrincipal extends JFrame{

	/**
	 * 
	 */
	public static int nivel = 1;

	private static final long serialVersionUID = 6956795457507815787L;

	public static PecaDeMemoria pecaAtual;

	public static int restantes;
	private JMenuBar barraMenu;
	private JPanel panelPrincipal;
	private JMenu botaoIniciar;
	private JMenu menuAjuda;
	private PanelDoJogo panelJogo;
	private JMenuItem itemAjuda;
	private JMenuItem itemSobre;
	private Contador contador;
	private ArrayList<ImageIcon> backgrounds = new ArrayList<ImageIcon>();  //  @jve:decl-index=0:
	ImageIcon backImage;
	ReentrantLock lock = new ReentrantLock();


	private String mensagemDeAjuda = "Te vira, malandro.";  //  @jve:decl-index=0:
	private String mensagemDeSobre = "Biribou";


	private JMenuItem itemSair = null;
	private JMenuItem itemComecar = null;

	private JLabel labelIntro = null;

	private JLabel backgroundInicial = null;

	private JButton butaoTeste = null;

	//Construtor da Janela Principal do Sistema
	public JanelaPrincipal() {
		super("Jogo da Memória");

		initialize();
		//this.setLocationByPlatform(true);
		this.setVisible(true);


	}
	//Método responsável por inicializar as variáveis

	private void initialize() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//this.setPreferredSize(new Dimension(654, 557));
		this.initBGs();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(654, 557);
		this.setContentPane(getPanelPrincipal());
		this.setJMenuBar(getBarraMenu());     
		this.setListeners();
		this.centralizarJanela();
	
	}
	private void initBGs() {
		this.backgrounds.add(new ImageIcon("imagens\\backgrounds\\b1background.png"));
		this.backgrounds.add(new ImageIcon("imagens\\backgrounds\\b2background.png"));
		this.backgrounds.add(new ImageIcon("imagens\\backgrounds\\b3background.png"));
		this.backgrounds.add(new ImageIcon("imagens\\backgrounds\\b4background.png"));
		this.backgrounds.add(new ImageIcon("imagens\\backgrounds\\b5background.png"));
		this.backgrounds.add(new ImageIcon("imagens\\backgrounds\\b6background.png"));
		this.backgrounds.add(new ImageIcon("imagens\\backgrounds\\b7background.png"));
		this.backgrounds.add(new ImageIcon("imagens\\backgrounds\\b8background.png"));
		this.backgrounds.add(new ImageIcon("imagens\\backgrounds\\b9background.png"));
		this.backgrounds.add(new ImageIcon("imagens\\backgrounds\\b10background.png"));
		this.backgrounds.add(new ImageIcon("imagens\\backgrounds\\b11background.png"));
		this.backgrounds.add(new ImageIcon("imagens\\backgrounds\\b12background.png"));
		this.backgrounds.add(new ImageIcon("imagens\\backgrounds\\b13background.png"));
		this.backgrounds.add(new ImageIcon("imagens\\backgrounds\\b14background.png"));
		this.backgrounds.add(new ImageIcon("imagens\\backgrounds\\b15background.png"));
		this.backImage = new ImageIcon("imagens\\backgrounds\\initbackground.png");
	}

	public void setarCenario(){
		this.panelJogo.setarBackground(backgrounds.get(nivel-1));
		if(nivel > 10){
			this.panelJogo.getRelogio().setForeground(Color.RED);
		}
		else{
			this.panelJogo.getRelogio().setForeground(new Color(60,195,67));
		}
	
	}
	
	public void perdeu(){
		this.contador.acabou();
		JOptionPane.showMessageDialog(null,"Perdeu!");
		this.backgroundInicial.setIcon(backImage);
		this.getPanelJogo().setVisible(false);
		this.getPanelJogo().getBotaoAjuda().setVisible(false);
		this.getPanelJogo().getRelogio().setVisible(false);
	}
	
	public void passarLevel(){
		if(nivel == 15){
			this.contador.acabou();
			JOptionPane.showMessageDialog(this,"Você ganhou!");
			this.backgroundInicial.setIcon(backImage);
			this.getPanelJogo().setVisible(false);
			this.getPanelJogo().getBotaoAjuda().setVisible(false);
			this.getPanelJogo().getRelogio().setVisible(false);
		}
		else{
			this.contador.acabou();
			JOptionPane.showMessageDialog(this,"Você completou o nível " + nivel + " restando " +this.getPanelJogo().getRelogio().getText() +" segundos!","Parabéns!",JOptionPane.INFORMATION_MESSAGE);
			nivel++;
			inicializarTabuleiro();
		}
	}
	//Método para setar todos os listeners
	private void setListeners() {
		this.itemAjuda.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				itemAjudaActionPerformed(evt);
			}
		});

		this.butaoTeste.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				butaoTesteActionPerformed(evt);
			}
		});
		;
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

	protected void butaoTesteActionPerformed(ActionEvent evt) {
		this.passarLevel();
		
	}

	protected void itemSairActionPerformed(ActionEvent evt) {
		System.exit(1);
	}

	protected void itemComecarActionPerformed(ActionEvent evt) {

		int resposta = JOptionPane.showConfirmDialog(this,"Deseja Coringas?","Iniciar o Jogo",JOptionPane.YES_NO_CANCEL_OPTION);
		

		if(resposta == 0){
			this.getPanelJogo().getBotaoAjuda().setVisible(true);
			nivel = 1;
			inicializarTabuleiro();
		}
		else if(resposta == 1){
			this.getPanelJogo().getBotaoAjuda().setVisible(false);
			nivel = 1;
			inicializarTabuleiro();
		}
		else{
			
		}
	}

	private void inicializarTabuleiro() {
		this.setarCenario();
		labelIntro.setVisible(false);
		panelJogo.setVisible(true);
		this.panelJogo.getRelogio().setVisible(true);
		this.getPanelJogo().inserirButoes(nivel);
		if(contador!= null){
			this.contador.acabou();
		}
		this.contador = new Contador(this,this.panelJogo.getRelogio(),nivel);
		contador.start();
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
			backgroundInicial = new JLabel();
			backgroundInicial.setBounds(new Rectangle(0, 1, 637, 494));
			backgroundInicial.setIcon(backImage);
			
		
			panelPrincipal = new JPanel();

			panelPrincipal.setLayout(null);
			panelPrincipal.add(getPanelJogo());
			

			panelPrincipal.add(getLabelIntro());
			panelPrincipal.add(backgroundInicial, null);
			panelPrincipal.add(getButaoTeste(), null);


		}
		return panelPrincipal;
	}

	private PanelDoJogo getPanelJogo() {
		if (panelJogo == null) {
			panelJogo = new PanelDoJogo(this);
			panelJogo.setLayout(null);
			panelJogo.setBounds(new Rectangle(0, 0,637, 494));
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

	/**
	 * This method initializes butaoTeste	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButaoTeste() {
		if (butaoTeste == null) {
			butaoTeste = new JButton();
			butaoTeste.setBounds(new Rectangle(603, 173, 19, 17));
		}
		return butaoTeste;
	}
	
	public void centralizarJanela(){

		Dimension dim = this.getToolkit().getScreenSize();      
		int x = (int) (dim.getWidth()  - this.getSize().getWidth() ) / 2;
		int y = (int) (dim.getHeight() - this.getSize().getHeight()) / 2;
		this.setLocation(x,y);

	}

	public static void main(String[] args) {
		new JanelaPrincipal();
	}
}  //  @jve:decl-index=0:visual-constraint="226,20"
