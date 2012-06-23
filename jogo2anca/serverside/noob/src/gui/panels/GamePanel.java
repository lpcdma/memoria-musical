package gui.panels;

import gui.frames.MainFrame;
import gui.util.BotaoMoeda;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class GamePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	JPanel panelMoedas = new JPanel();
	JScrollPane scroll = new JScrollPane();
	JLabel lblC = new JLabel("CE");
	JLabel lblE = new JLabel("ER");
	JLabel lblNada = new JLabel("<HTML> N A <BR> D <BR> A </HTML>");
	int money = 0;
	int dinheiroApostado = 0;
	JLabel lblDinheiroApostado = new JLabel("0,50");
	JLabel lblDinheiroPossuido = new JLabel("0,75");
	JLabel lblHoras = new JLabel("30s");
	ArrayList<BotaoMoeda> listMoedas5 = new ArrayList<BotaoMoeda>();
	ArrayList<BotaoMoeda> listMoedas10 = new ArrayList<BotaoMoeda>();
	
	public GamePanel() {
	//	JViewport view  = new JViewport();
	//	view.setViewSize(new Dimension(300,200));
	//	scroll.setViewportView(view);
		this.setLayout(null);
		//this.setBounds(0,0,712,372);
		this.setPreferredSize(new Dimension(712, 376));
		createLblImage();
		JPanel panelControl = createPanelControl();

		JPanel panelYourMoney = createPanelYourMoney(panelControl);

		createLblVoceTem(panelYourMoney);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		panelYourMoney.add(panel, gbc_panel);
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

		lblC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblC = new GridBagConstraints();
		gbc_lblC.anchor = GridBagConstraints.EAST;
		gbc_lblC.insets = new Insets(0, 0, 0, 5);
		gbc_lblC.gridx = 0;
		gbc_lblC.gridy = 2;
		panelApostar.add(lblC, gbc_lblC);

		lblE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblE = new GridBagConstraints();
		gbc_lblE.anchor = GridBagConstraints.WEST;
		gbc_lblE.gridx = 1;
		gbc_lblE.gridy = 2;
		panelApostar.add(lblE, gbc_lblE);

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
		lblHoras.setBounds(23, 25, 40, 37);


		panelRelogio.add(lblHoras);
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 21));

		JLabel lblQuantoVocVai = new JLabel("Quanto você vai apostar?");
		lblQuantoVocVai.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblQuantoVocVai.setBounds(230, 239, 245, 21);
		add(lblQuantoVocVai);

		JPanel panelRodada = createPanelRodada();

		createLblRodada(panelRodada);

		createLblRodada1(panelRodada);

		createLblRodada2(panelRodada);

		createLblRodada3(panelRodada);

		createLblRodada4(panelRodada);

		createLblRodada5(panelRodada);

		createLblRodada6(panelRodada);

		this.update();
	}

	private void addListeners(){
		lblC.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
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
		lblNada.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
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

	}

	private JPanel createPanelCheckAposta(JPanel panelApostar) {
		JPanel panelCheckAposta = new JPanel();
		GridBagConstraints gbc_panelCheckAposta = new GridBagConstraints();
		gbc_panelCheckAposta.gridwidth = 2;
		gbc_panelCheckAposta.anchor = GridBagConstraints.NORTH;
		gbc_panelCheckAposta.insets = new Insets(0, 0, 5, 0);
		gbc_panelCheckAposta.gridx = 0;
		gbc_panelCheckAposta.gridy = 1;
		panelApostar.add(panelCheckAposta, gbc_panelCheckAposta);
		panelCheckAposta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		return panelCheckAposta;
	}

	private void createPanelVoceEstaApostando(JPanel panelApostar) {
		JLabel lblVocEstApostando = new JLabel("<html> Voc\u00EA est\u00E1 <br> apostando </html>");
		lblVocEstApostando.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblVocEstApostando = new GridBagConstraints();
		gbc_lblVocEstApostando.anchor = GridBagConstraints.SOUTH;
		gbc_lblVocEstApostando.insets = new Insets(0, 0, 5, 0);
		gbc_lblVocEstApostando.gridwidth = 2;
		gbc_lblVocEstApostando.gridx = 0;
		gbc_lblVocEstApostando.gridy = 0;
		panelApostar.add(lblVocEstApostando, gbc_lblVocEstApostando);
	}

	private JPanel createPanelApostar(JPanel panelControl) {
		JPanel panelApostar = new JPanel();
		panelApostar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelApostar.setBounds(605, 0, 107, 108);
		panelControl.add(panelApostar);
		GridBagLayout gbl_panelApostar = new GridBagLayout();
		gbl_panelApostar.columnWidths = new int[]{65, 57, 0};
		gbl_panelApostar.rowHeights = new int[]{40, 29, 0, 0};
		gbl_panelApostar.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelApostar.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelApostar.setLayout(gbl_panelApostar);
		return panelApostar;
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
		JLabel label_2 = new JLabel("6");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 6;
		panelRodada.add(label_2, gbc_label_2);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	private void createLblRodada5(JPanel panelRodada) {
		JLabel label_1 = new JLabel("5");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 5;
		panelRodada.add(label_1, gbc_label_1);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	private void createLblRodada4(JPanel panelRodada) {
		JLabel label = new JLabel("4");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTHWEST;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 1;
		gbc_label.gridy = 4;
		panelRodada.add(label, gbc_label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	private void createLblRodada3(JPanel panelRodada) {
		JLabel lblRodada3 = new JLabel("3");
		GridBagConstraints gbc_lblRodada3 = new GridBagConstraints();
		gbc_lblRodada3.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblRodada3.insets = new Insets(0, 0, 5, 0);
		gbc_lblRodada3.gridx = 1;
		gbc_lblRodada3.gridy = 3;
		panelRodada.add(lblRodada3, gbc_lblRodada3);
		lblRodada3.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	private void createLblRodada2(JPanel panelRodada) {
		JLabel lblRodada2 = new JLabel("2");
		GridBagConstraints gbc_lblRodada2 = new GridBagConstraints();
		gbc_lblRodada2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblRodada2.insets = new Insets(0, 0, 5, 0);
		gbc_lblRodada2.gridx = 1;
		gbc_lblRodada2.gridy = 2;
		panelRodada.add(lblRodada2, gbc_lblRodada2);
		lblRodada2.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	private void createLblRodada1(JPanel panelRodada) {
		JLabel lblRodada1 = new JLabel("1");
		GridBagConstraints gbc_lblRodada1 = new GridBagConstraints();
		gbc_lblRodada1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblRodada1.insets = new Insets(0, 0, 5, 0);
		gbc_lblRodada1.gridx = 1;
		gbc_lblRodada1.gridy = 1;
		panelRodada.add(lblRodada1, gbc_lblRodada1);
		lblRodada1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	private void createLblRodada(JPanel panelRodada) {
		JLabel lblRodada = new JLabel("Rodada");
		GridBagConstraints gbc_lblRodada = new GridBagConstraints();
		gbc_lblRodada.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblRodada.insets = new Insets(0, 0, 5, 0);
		gbc_lblRodada.gridwidth = 2;
		gbc_lblRodada.gridx = 0;
		gbc_lblRodada.gridy = 0;
		panelRodada.add(lblRodada, gbc_lblRodada);
		lblRodada.setFont(new Font("Tahoma", Font.BOLD, 19));
	}

	private JPanel createPanelRodada() {
		JPanel panelRodada = new JPanel();
		panelRodada.setBounds(27, 26, 72, 192);
		add(panelRodada);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{33, 0, 0};
		gbl_panel_1.rowHeights = new int[]{23, 22, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelRodada.setLayout(gbl_panel_1);
		return panelRodada;
	}

	private void createLblVoceTem(JPanel panelYourMoney) {
		JLabel lblVoceTem = new JLabel("Você tem");
		lblVoceTem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblVoceTem = new GridBagConstraints();
		gbc_lblVoceTem.anchor = GridBagConstraints.SOUTH;
		gbc_lblVoceTem.insets = new Insets(0, 0, 5, 0);
		gbc_lblVoceTem.gridx = 0;
		gbc_lblVoceTem.gridy = 0;
		panelYourMoney.add(lblVoceTem, gbc_lblVoceTem);
	}

	private JPanel createPanelYourMoney(JPanel panelControl) {
		JPanel panelYourMoney = new JPanel();
		panelYourMoney.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelYourMoney.setBounds(0, 0, 98, 108);
		panelControl.add(panelYourMoney);
		GridBagLayout gbl_panelYourMoney = new GridBagLayout();
		gbl_panelYourMoney.columnWidths = new int[]{111, 0};
		gbl_panelYourMoney.rowHeights = new int[]{46, 0, 0};
		gbl_panelYourMoney.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelYourMoney.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelYourMoney.setLayout(gbl_panelYourMoney);
		return panelYourMoney;
	}

	private JPanel createPanelControl() {
		JPanel panelControl = new JPanel();
		panelControl.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelControl.setBounds(0, 268, 712, 108);
		panelControl.setLayout(null);
		add(panelControl);
		
		JLabel lblTU = new JLabel("<html> T U <br> D O </html>");
		lblTU.setBounds(563, 50, 33, 41);
		panelControl.add(lblTU);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(96, 0, 462, 108);
		panelControl.add(scroll);
		return panelControl;
	}

	private void createLblImage() {
		JLabel lblImagem = new JLabel("Imagem");
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setBounds(264, -37, 156, 161);
		add(lblImagem);
	}
	
	public void addDinheiro(int valor){
		dinheiroApostado = dinheiroApostado+valor;
		if(dinheiroApostado % 10 == 0){
			this.lblDinheiroApostado.setText(String.valueOf((double) dinheiroApostado/100)+"0");			
		}
		else{
			this.lblDinheiroApostado.setText(String.valueOf((double) dinheiroApostado/100));					
		}
	}
	
	public void update(){
		int contador = 0;
		int altura = 49;
		this.money = 400; // atualizar
		lblDinheiroApostado.setText("0.00");
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				long tempoInicial = System.currentTimeMillis();			
				boolean funcionando = true;
				int tamanhoFonte = 25;
				int contador = 30*1000;
				Font fontInicial = getFont();
				lblHoras.setFont(new Font(fontInicial.getFontName(), fontInicial.getStyle(), tamanhoFonte));
				lblHoras.setForeground(Color.BLUE);
				try {
					long lol = 0;		
					while(funcionando){

						lol = (((tempoInicial+contador) - System.currentTimeMillis())/1000);
						lblHoras.setText(Long.toString(lol,10));
						
						if(lol <= 0){
						//	window.perdeu();
						}
						Thread.sleep(950);
					}
				}
				catch (InterruptedException e) {System.out.println("merda");}

			}
		});
		thread.start();
		
		if(money % 10 == 0){
			this.lblDinheiroPossuido.setText(String.valueOf((double) money/100)+"0");			
		}
		else{
			this.lblDinheiroPossuido.setText(String.valueOf((double) money/100));					
		}
		
		int aux = money;
		int ref = 0;
		scroll.setViewportView(panelMoedas);

		this.panelMoedas.removeAll();
	
		if(money == 5){
			panelMoedas.add(new BotaoMoeda(5));
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
			panelMoedas.add(new BotaoMoeda(10));
			aux = aux-10;
			contador++;
			if(contador >= 9){
				altura = altura + 49;
				contador = 0;
			}
		}
		contador = 0;
		while(aux > 0){
			panelMoedas.add(new BotaoMoeda(5));
			aux = aux-5;
			contador++;
			if(contador >= 8){
				altura = altura + 54;
				contador = 0;
			}
		}
		panelMoedas.setPreferredSize(new Dimension(200,altura));
	}

	protected void nextScreen() {
		MainFrame.getInstance().update(new TurnPanel());

	}
}
