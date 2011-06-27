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
import javax.swing.JLabel;
import javax.swing.JButton;

public class JanelaPrincipal extends JFrame{

	/**
	 * 
	 */
	public static int nivel = 1;
	
	private static final long serialVersionUID = 6956795457507815787L;
	private JMenuBar barraMenu;
	private JPanel panelPrincipal;
	private JMenu botaoIniciar;
	private JMenu menuAjuda;
	private PanelDoJogo panelJogo;
	private JMenuItem itemAjuda;
	private JMenuItem itemSobre;
	private Contador contador;
	
	private String mensagemDeAjuda = "Te vira, malandro.";  //  @jve:decl-index=0:
	private String mensagemDeSobre = "Biribou";
	private JLabel relogio = null;
	private JButton botaoAjuda;
	private JMenuItem itemSair = null;
	private JMenuItem itemComecar = null;
	
	

	//Construtor da Janela Principal do Sistema
	public JanelaPrincipal() {
		super("Jogo da Memória");
		initialize();
		this.setVisible(true);
		this.contador = new Contador(relogio,nivel);
		contador.start();
		contador.run();

	}

	//Método responsável por inicializar as variáveis
	
	private void initialize() {
        //this.setPreferredSize(new Dimension(469, 328));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(660, 593));
        this.setContentPane(getPanelPrincipal());
        this.setJMenuBar(getBarraMenu());     
	    this.getPanelJogo().inserirButoes(nivel); // o parâmetro é o nível de dificuldade. Está aqui 2 só para testes
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
		Object[] possibleValues = { "Fácil", "Médio", "Difícil" };
		
		int resposta = JOptionPane.showOptionDialog(this,"Escolha","Iniciar Jogo",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,possibleValues,1);
		
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
			relogio.setBounds(new Rectangle(545, 18, 74, 73));
			relogio.setText("");
			panelPrincipal = new JPanel();
			panelPrincipal.setLayout(null);
		    panelPrincipal.add(getPanelJogo());
		    panelPrincipal.add(relogio);
		    panelPrincipal.add(getBotaoAjuda());
		    Font curFont = relogio.getFont();
		    relogio.setFont(new Font(curFont.getFontName(), curFont.getStyle(), 55));
		}
		return panelPrincipal;
	}
	
	private PanelDoJogo getPanelJogo() {
		if (panelJogo == null) {
			panelJogo = new PanelDoJogo();
			panelJogo.setLayout(null);
			panelJogo.setBounds(new Rectangle(19, 20, 505, 479));
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

	public static void main(String[] args) {
		new JanelaPrincipal();
	}
}  //  @jve:decl-index=0:visual-constraint="226,20"
