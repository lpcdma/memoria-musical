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

	public static Font fontPadrao = new Font(Font.SANS_SERIF, Font.BOLD, 50);  //  @jve:decl-index=0:
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
	public static String coringaAtual = "";  //  @jve:decl-index=0:

	public static int coringasCont;
	ImageIcon backImage;
	ReentrantLock lock = new ReentrantLock();


	private String mensagemDeAjuda = "Te vira, malandro.";  //  @jve:decl-index=0:
	private String mensagemDeSobre = "Biribou";


	private JMenuItem itemSair = null;
	private JMenuItem itemComecar = null;

	private JLabel labelIntro = null;

	private JLabel backgroundInicial = null;

	private JButton butaoTeste = null;
	
	private JButton botaoInit = null;

	//Construtor da Janela Principal do Sistema
	public JanelaPrincipal() {
		super("Musical Memory");

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
		this.setResizable(false);
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
		butaoTeste.setVisible(true);
		this.panelJogo.setarBackground(backgrounds.get(nivel-1));
		if(nivel > 10){
			this.panelJogo.getRelogio().setForeground(Color.RED);
		}
		else{
			this.panelJogo.getRelogio().setForeground(new Color(60,195,67));
		}

	}

	public void esconderTudo(boolean sim){
		this.getPanelJogo().setVisible(!sim);
		this.labelIntro.setVisible(sim);
	}

	public void perdeu(){
		this.contador.acabou();
		JOptionPane.showMessageDialog(null,"Perdeu!");
		this.backgroundInicial.setIcon(backImage);
		this.getPanelJogo().setVisible(false);
		this.getPanelJogo().getBotaoAjuda().setVisible(false);
		this.getPanelJogo().getRelogio().setVisible(false);
		this.getPanelJogo().getRelogio().setFont(fontPadrao);
	}

	public void passarLevel(){

		if(nivel == 15){
			this.contador.acabou();
			JOptionPane.showMessageDialog(this,"Você ganhou!");
			this.backgroundInicial.setIcon(backImage);
			this.getPanelJogo().setVisible(false);
			this.getPanelJogo().getBotaoAjuda().setVisible(false);
			this.getPanelJogo().getRelogio().setVisible(false);
			this.getPanelJogo().getRelogio().setFont(fontPadrao);
			
		}
		else{
			this.contador.acabou();

			JOptionPane.showMessageDialog(this,"Você completou o nível " + nivel + " restando " +this.getPanelJogo().getRelogio().getText() +" segundos!","Parabéns!",JOptionPane.INFORMATION_MESSAGE);
		//	intervalo();
			nivel++;
			inicializarTabuleiro();
			

		}
	}

	private void intervalo() {
		long tempoInicial = System.currentTimeMillis();

		long timer = 1l;
		esconderTudo(true);

		while(timer < 4){
			timer = ((System.currentTimeMillis() - tempoInicial)/1000);
			if(timer == 0){
				
			}
			else if(timer == 1){

			}
			else if(timer == 2){

			}
			else if(timer == 3){
				labelIntro.setText(timer+"");
			}			
		}

		esconderTudo(false);
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
		this.botaoInit.addActionListener(new ActionListener(){
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

		botaoInit.setVisible(false);
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
		coringasCont = 4;
		this.getPanelJogo().getRelogio().setFont(fontPadrao);
		this.getPanelJogo().setJokerNeutro();
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
			backgroundInicial.setBounds(new Rectangle(0, 1, 651, 510));
			backgroundInicial.setIcon(backImage);


			panelPrincipal = new JPanel();

			panelPrincipal.setLayout(null);
			panelPrincipal.add(getPanelJogo());


			panelPrincipal.add(getLabelIntro());
			panelPrincipal.add(backgroundInicial, null);
			panelPrincipal.add(getButaoTeste(), null);
			panelPrincipal.add(getBotaoIniciar(), null);


		}
		return panelPrincipal;
	}

	private PanelDoJogo getPanelJogo() {
		if (panelJogo == null) {
			panelJogo = new PanelDoJogo(this);
			panelJogo.setLayout(null);
			panelJogo.setBounds(new Rectangle(0, 0,700, 620));
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
			labelIntro.setFont(new Font("Verdana",Font.BOLD,40));
			labelIntro.setForeground(Color.WHITE);
			labelIntro.setText("Musical Memory");
			labelIntro.setBounds(new Rectangle(140, 50, 497, 219));
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
			butaoTeste.setVisible(false);
			butaoTeste.setBounds(new Rectangle(603, 173, 19, 17));
		}
		return butaoTeste;
	}
	
	private JButton getBotaoIniciar() {
		if (botaoInit == null) {
			botaoInit = new JButton("Iniciar");
			botaoInit.setBounds(new Rectangle(280, 230, 100, 30));
		}
		return botaoInit;
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
