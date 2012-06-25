package gui.panels;

import facade.Fachada;
import gui.frames.MainFrame;
import gui.interfaces.PanelAbstract;
import gui.util.BotaoMoeda;
import gui.util.Recursos;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.border.EtchedBorder;
import javax.swing.ScrollPaneConstants;

public class GamePanel extends PanelAbstract {

	/**
	 * Create the panel.
	 */
	
	ImageIcon image = new ImageIcon(Recursos.CAMINHO_IMAGENS+"copo.png");
	
	JLabel lblRodada1 = new JLabel("1");
	JLabel lblRodada2 = new JLabel("2");
	JLabel lblRodada3 = new JLabel("3");
	JLabel lblRodada4 = new JLabel("4");
	JLabel lblRodada5 = new JLabel("5");
	JLabel lblRodada6 = new JLabel("6");
	ArrayList<BotaoMoeda> listaMoedas = new ArrayList<BotaoMoeda>();
	boolean naoClicou = true;
	boolean funcionando = true;
	
	JLabel[] labels = new JLabel[6];
	Font fontPadrao = new Font("Tahoma", Font.PLAIN, 18);
	JPanel panelMoedas = new JPanel();
	JScrollPane scroll = new JScrollPane();
	JLabel lblC = new JLabel("CE");
	JLabel lblE = new JLabel("ER");
	JLabel lblNada = new JLabel("<HTML> N A <BR> D A </HTML>");
	JLabel lblTU = new JLabel("<html> T U <br> D O </html>");
	int money = 0;
	int dinheiroApostado = 0;
	int rodada = 1;
	JLabel lblDinheiroApostado = new JLabel("0,50");
	JLabel lblDinheiroPossuido = new JLabel("0,75");
	JLabel lblHoras = new JLabel("30\r\n");
	ArrayList<BotaoMoeda> listMoedas5 = new ArrayList<BotaoMoeda>();
	ArrayList<BotaoMoeda> listMoedas10 = new ArrayList<BotaoMoeda>();
	static GamePanel instance = null;
	private JPanel panelYourMoney_1;
	private JPanel panelApostar_1;
	private JPanel panelRodada_1;

	static public GamePanel getInstance(){
		if(instance == null){
			instance = new GamePanel();
		}
		return instance;
	}

	private GamePanel() {
		
		money = Recursos.DINHEIRO_INICIAL_CENTAVOS;
		MainFrame.getInstance().setMoney(money);
		labels[0] = lblRodada1;
		labels[1] = lblRodada2;
		labels[2] = lblRodada3;
		labels[3] = lblRodada4;
		labels[4] = lblRodada5;
		labels[5] = lblRodada6;

		this.setLayout(null);

		this.setPreferredSize(new Dimension(Recursos.LARGURA_JANELA, Recursos.ALTURA_JANELA));
		createLblImage();
		JPanel panelControl = createPanelControl();

		JPanel panelYourMoney = createPanelYourMoney(panelControl);

		createLblVoceTem(panelYourMoney);

		JPanel panel = new JPanel();
		panel.setBounds(15, 48, 68, 31);
		panelYourMoney.add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		createLblRS(panel);

		createLblDinheiroPossuido(panel);

		JPanel panelApostar = createPanelApostar(panelControl);

		createPanelVoceEstaApostando(panelApostar);

		JPanel panelCheckAposta = createPanelCheckAposta(panelApostar);

		JLabel lblR = new JLabel("R$");
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCheckAposta.add(lblR);

		lblDinheiroApostado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCheckAposta.add(lblDinheiroApostado);
		lblC.setBounds(36, 78, 17, 19);

		lblC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelApostar.add(lblC);
		lblE.setBounds(58, 78, 17, 19);

		lblE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelApostar.add(lblE);

		lblNada.setBackground(new Color(153, 153, 255));
		lblNada.setBounds(563, 11, 33, 39);
		panelControl.add(lblNada);

		JPanel panelRelogio = new JPanel();
		panelRelogio.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.BLACK, null));
		panelRelogio.setBounds(609, 26, 82, 66);
		add(panelRelogio);
		panelRelogio.setLayout(null);

		JLabel lblTempo = new JLabel("TEMPO");
		lblTempo.setBounds(16, 7, 50, 17);
		panelRelogio.add(lblTempo);
		lblTempo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHoras.setBounds(27, 25, 28, 37);


		panelRelogio.add(lblHoras);
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 21));

		JLabel lblQuantoVocVai = new JLabel("Quanto você vai apostar?");
		lblQuantoVocVai.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblQuantoVocVai.setBounds(205, 239, 245, 21);
		add(lblQuantoVocVai);

		JPanel panelRodada = createPanelRodada();

		createLblRodada(panelRodada);

		createLblRodada1(panelRodada);

		createLblRodada2(panelRodada);

		createLblRodada3(panelRodada);

		createLblRodada4(panelRodada);

		createLblRodada5(panelRodada);

		createLblRodada6(panelRodada);

		this.addListeners();

	}

	private void addListeners(){
		lblC.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				naoClicou = false;
				funcionando = false;
				nextScreen();
			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		lblE.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				for (BotaoMoeda moeda : listaMoedas) {
					if(moeda.isClicked()){
						moeda.setClicked(false);
					}
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		lblNada.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				for (BotaoMoeda moeda : listaMoedas) {
					if(moeda.isClicked()){
						moeda.setClicked(false);
					}
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});

		lblTU.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				for (BotaoMoeda moeda : listaMoedas) {
					if(!moeda.isClicked()){
						moeda.setClicked(true);
					}
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});


	}

	private JPanel createPanelCheckAposta(JPanel panelApostar) {
		JPanel panelCheckAposta = new JPanel();
		panelCheckAposta.setBounds(21, 42, 64, 31);
		panelApostar.add(panelCheckAposta);
		panelCheckAposta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		return panelCheckAposta;
	}

	private void createPanelVoceEstaApostando(JPanel panelApostar) {
		panelApostar_1.setLayout(null);
		JLabel lblVocEstApostando = new JLabel("<html> Voc\u00EA est\u00E1 <br> apostando </html>");
		lblVocEstApostando.setBounds(24, 5, 59, 32);
		lblVocEstApostando.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelApostar.add(lblVocEstApostando);
	}

	private JPanel createPanelApostar(JPanel panelControl) {
		panelApostar_1 = new JPanel();
		panelApostar_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelApostar_1.setBounds(605, 0, 107, 108);
		panelControl.add(panelApostar_1);
		return panelApostar_1;
	}

	private void createLblDinheiroPossuido(JPanel panel) {
		panel.add(lblDinheiroPossuido);
		lblDinheiroPossuido.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}

	private void createLblRS(JPanel panel) {
		JLabel lblRS = new JLabel("R$ ");
		panel.add(lblRS);
		lblRS.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}

	private void createLblRodada6(JPanel panelRodada) {
		lblRodada6.setBounds(31, 163, 10, 22);
		panelRodada.add(lblRodada6);
		lblRodada6.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	private void createLblRodada5(JPanel panelRodada) {
		lblRodada5.setBounds(31, 136, 10, 22);
		panelRodada.add(lblRodada5);
		lblRodada5.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	private void createLblRodada4(JPanel panelRodada) {
		lblRodada4.setBounds(31, 109, 10, 22);
		panelRodada.add(lblRodada4);
		lblRodada4.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	private void createLblRodada3(JPanel panelRodada) {
		lblRodada3.setBounds(31, 82, 10, 22);
		panelRodada.add(lblRodada3);
		lblRodada3.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	private void createLblRodada2(JPanel panelRodada) {
		lblRodada2.setBounds(31, 55, 10, 22);
		panelRodada.add(lblRodada2);
		lblRodada2.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	private void createLblRodada1(JPanel panelRodada) {
		lblRodada1.setBounds(31, 28, 10, 22);
		panelRodada.add(lblRodada1);
		lblRodada1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	private void createLblRodada(JPanel panelRodada) {
		panelRodada_1.setLayout(null);
		JLabel lblRodada = new JLabel("Rodada");
		lblRodada.setBounds(0, 0, 72, 23);
		panelRodada.add(lblRodada);
		lblRodada.setFont(new Font("Tahoma", Font.BOLD, 19));
	}

	private JPanel createPanelRodada() {
		panelRodada_1 = new JPanel();
		panelRodada_1.setBounds(27, 26, 72, 192);
		add(panelRodada_1);
		return panelRodada_1;
	}

	private void createLblVoceTem(JPanel panelYourMoney) {
		panelYourMoney_1.setLayout(null);
		JLabel lblVoceTem = new JLabel("Você tem");
		lblVoceTem.setBounds(16, 23, 66, 20);
		lblVoceTem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelYourMoney.add(lblVoceTem);
	}

	private JPanel createPanelYourMoney(JPanel panelControl) {
		panelYourMoney_1 = new JPanel();
		panelYourMoney_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelYourMoney_1.setBounds(0, 0, 98, 108);
		panelControl.add(panelYourMoney_1);
		return panelYourMoney_1;
	}

	private JPanel createPanelControl() {
		JPanel panelControl = new JPanel();
		panelControl.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelControl.setBounds(0, 268, 712, 108);
		panelControl.setLayout(null);
		add(panelControl);

		lblTU.setBounds(563, 50, 33, 41);
		panelControl.add(lblTU);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(96, 0, 462, 108);
		panelControl.add(scroll);
		return panelControl;
	}

	private void createLblImage() {
		JLabel lblImagem = new JLabel("Imagem");
		lblImagem.setText("");
		lblImagem.setIcon(image);
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setBounds(269, 11, 172, 220);
		add(lblImagem);
	}

	public void addDinheiro(int valor){
		dinheiroApostado = dinheiroApostado+valor;
		this.lblDinheiroApostado.setText(Recursos.converterParaReal(dinheiroApostado));			
	}

	public void update(){
		naoClicou = true;
		funcionando = true;
		for (int i = 0; i < labels.length; i++) {
			labels[i].setFont(fontPadrao);
			labels[i].setForeground(Color.BLACK);
		}

		rodada = MainFrame.getInstance().getRodada();
		JLabel labelAtt = labels[rodada-1];
		labelAtt.setForeground(Color.RED);
		Font font = labelAtt.getFont();
		labelAtt.setFont(new Font(font.getName(), Font.BOLD, 20));
		lblDinheiroApostado.setText("0.00");
		Thread thread = setRelogio();
		thread.start();
		int altura = organizarPanelDinheiro();
		panelMoedas.setPreferredSize(new Dimension(200,altura));
	}

	private int organizarPanelDinheiro() {

		int contador = 0;
		int altura = 49;
		money = MainFrame.getInstance().getMoney();
		dinheiroApostado = 0;
		this.lblDinheiroPossuido.setText(Recursos.converterParaReal(money));			

		int aux = money;
		int ref = 0;
		scroll.setViewportView(panelMoedas);

		this.panelMoedas.removeAll();
		this.listaMoedas.clear();

		if(money == 5){
			BotaoMoeda botao = new BotaoMoeda(5);
			listaMoedas.add(botao);
			panelMoedas.add(botao);
			aux = -1;
			altura = 0;
		}
		else 
			if(aux % 10 == 0){
				ref = aux/2;	
			}
			else {
				ref = (aux-5)/2;
			}
		while(aux > ref){
			BotaoMoeda botao = new BotaoMoeda(10);
			listaMoedas.add(botao);
			panelMoedas.add(botao);
			aux = aux-10;
			contador++;
			if(contador >= 9){
				altura = altura + 49;
				contador = 0;
			}
		}
		contador = 0;
		while(aux > 0){
			BotaoMoeda botao = new BotaoMoeda(5);
			listaMoedas.add(botao);
			panelMoedas.add(botao);
			aux = aux-5;
			contador++;
			if(contador >= 7){
				altura = altura + 54;
				contador = 0;
			}
		}
		return altura;
	}

	private Thread setRelogio() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				long tempoInicial = System.currentTimeMillis();			
				int tamanhoFonte = 25;
				int contador = Recursos.TEMPO_DE_JOGO_SEGUNDOS*1000;
				Font fontInicial = getFont();
				lblHoras.setFont(new Font(fontInicial.getFontName(), fontInicial.getStyle(), tamanhoFonte));
				lblHoras.setForeground(Color.BLUE);
				try {
					long lol = 0;		
					while(funcionando){

						lol = (((tempoInicial+contador) - System.currentTimeMillis())/1000);
						lblHoras.setText(Long.toString(lol,10));

						if(lblHoras.getText() == "9"){
							lblHoras.setLocation(45, lblHoras.getY());
						}

						if(lol <= 0 && funcionando){
							funcionando = false;
						}
						Thread.sleep(950);
					}

					if(naoClicou){
						nextScreen();
					}
				}
				catch (InterruptedException e) {System.out.println("merda");}

			}
		});
		return thread;
	}

	public void nextScreen() {
		if(MainFrame.getInstance().getRodada() < 6){
			int moneyApostado = Recursos.converterParaInt(lblDinheiroApostado.getText());
			Fachada.getInstance().enviarAposta(MainFrame.getInstance().getRodada(),moneyApostado);
			MainFrame.getInstance().setMoney(MainFrame.getInstance().getMoney()-moneyApostado);
			MainFrame.getInstance().update(TurnPanel.getInstance());
		}
		else{
			MainFrame.getInstance().update(ResultPanel.getInstance());
		}
	}
}
