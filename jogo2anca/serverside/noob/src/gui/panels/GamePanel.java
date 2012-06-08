package gui.panels;

import gui.frames.MainFrame;

import javax.swing.JPanel;
import javax.swing.JLabel;
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

import javax.swing.border.EtchedBorder;

public class GamePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GamePanel() {
		
		this.setLayout(null);
		//this.setBounds(0,0,712,372);
		this.setPreferredSize(new Dimension(712,372));
		
		JLabel lblImagem = new JLabel("Imagem");
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setBounds(270, 67, 156, 161);
		add(lblImagem);
		
		JPanel panelControl = new JPanel();
		panelControl.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelControl.setBounds(0, 268, 712, 102);
		panelControl.setLayout(null);
		add(panelControl);
		
		JPanel panelYourMoney = new JPanel();
		panelYourMoney.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelYourMoney.setBounds(0, 0, 116, 102);
		panelControl.add(panelYourMoney);
		GridBagLayout gbl_panelYourMoney = new GridBagLayout();
		gbl_panelYourMoney.columnWidths = new int[]{111, 0};
		gbl_panelYourMoney.rowHeights = new int[]{46, 0, 0};
		gbl_panelYourMoney.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelYourMoney.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelYourMoney.setLayout(gbl_panelYourMoney);
		
		JLabel lblVocTem = new JLabel("Voc\u00EA tem");
		lblVocTem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblVocTem = new GridBagConstraints();
		gbc_lblVocTem.anchor = GridBagConstraints.SOUTH;
		gbc_lblVocTem.insets = new Insets(0, 0, 5, 0);
		gbc_lblVocTem.gridx = 0;
		gbc_lblVocTem.gridy = 0;
		panelYourMoney.add(lblVocTem, gbc_lblVocTem);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		panelYourMoney.add(panel, gbc_panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblRS = new JLabel("R$ ");
		panel.add(lblRS);
		lblRS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDinheiroPossuido = new JLabel("0,75");
		panel.add(lblDinheiroPossuido);
		lblDinheiroPossuido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panelMoedas = new JPanel();
		panelMoedas.setBounds(126, 11, 423, 80);
		panelControl.add(panelMoedas);
		
		JPanel panelApostar = new JPanel();
		panelApostar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelApostar.setBounds(587, 0, 125, 102);
		panelControl.add(panelApostar);
		GridBagLayout gbl_panelApostar = new GridBagLayout();
		gbl_panelApostar.columnWidths = new int[]{65, 57, 0};
		gbl_panelApostar.rowHeights = new int[]{40, 29, 0, 0};
		gbl_panelApostar.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelApostar.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelApostar.setLayout(gbl_panelApostar);
		
		JLabel lblVocEstApostando = new JLabel("<html> Voc\u00EA est\u00E1 <br> apostando </html>");
		lblVocEstApostando.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblVocEstApostando = new GridBagConstraints();
		gbc_lblVocEstApostando.anchor = GridBagConstraints.SOUTH;
		gbc_lblVocEstApostando.insets = new Insets(0, 0, 5, 0);
		gbc_lblVocEstApostando.gridwidth = 2;
		gbc_lblVocEstApostando.gridx = 0;
		gbc_lblVocEstApostando.gridy = 0;
		panelApostar.add(lblVocEstApostando, gbc_lblVocEstApostando);
		
		JPanel panelCheckAposta = new JPanel();
		GridBagConstraints gbc_panelCheckAposta = new GridBagConstraints();
		gbc_panelCheckAposta.gridwidth = 2;
		gbc_panelCheckAposta.anchor = GridBagConstraints.NORTH;
		gbc_panelCheckAposta.insets = new Insets(0, 0, 5, 0);
		gbc_panelCheckAposta.gridx = 0;
		gbc_panelCheckAposta.gridy = 1;
		panelApostar.add(panelCheckAposta, gbc_panelCheckAposta);
		panelCheckAposta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblR = new JLabel("R$");
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCheckAposta.add(lblR);
		
		JLabel lblDinheiroApostado = new JLabel("0,50");
		lblDinheiroApostado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCheckAposta.add(lblDinheiroApostado);
		
		JLabel lblC = new JLabel("CE");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblC = new GridBagConstraints();
		gbc_lblC.anchor = GridBagConstraints.EAST;
		gbc_lblC.insets = new Insets(0, 0, 0, 5);
		gbc_lblC.gridx = 0;
		gbc_lblC.gridy = 2;
		lblC.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				nextScreen();
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		panelApostar.add(lblC, gbc_lblC);
		
		JLabel lblE = new JLabel("ER");
		lblE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblE = new GridBagConstraints();
		gbc_lblE.anchor = GridBagConstraints.WEST;
		gbc_lblE.gridx = 1;
		gbc_lblE.gridy = 2;
		panelApostar.add(lblE, gbc_lblE);
		
		JLabel lblNewLabel_1 = new JLabel("<HTML> N <BR> A <BR> D <BR> A </HTML>");
		lblNewLabel_1.setBackground(new Color(153, 153, 255));
		lblNewLabel_1.setBounds(559, 11, 18, 80);
		panelControl.add(lblNewLabel_1);
		
		JPanel panelRelogio = new JPanel();
		panelRelogio.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelRelogio.setBounds(609, 26, 82, 66);
		add(panelRelogio);
		
		JLabel lblTempo = new JLabel("TEMPO");
		panelRelogio.add(lblTempo);
		lblTempo.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel = new JLabel("30s");
		panelRelogio.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		
		JLabel lblQuantoVocVai = new JLabel("Quanto voc\u00EA vai apostar?");
		lblQuantoVocVai.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblQuantoVocVai.setBounds(230, 239, 245, 21);
		add(lblQuantoVocVai);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(27, 26, 72, 192);
		add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{33, 0, 0};
		gbl_panel_1.rowHeights = new int[]{23, 22, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblRodada = new JLabel("Rodada");
		GridBagConstraints gbc_lblRodada = new GridBagConstraints();
		gbc_lblRodada.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblRodada.insets = new Insets(0, 0, 5, 0);
		gbc_lblRodada.gridwidth = 2;
		gbc_lblRodada.gridx = 0;
		gbc_lblRodada.gridy = 0;
		panel_1.add(lblRodada, gbc_lblRodada);
		lblRodada.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JLabel lblRodada1 = new JLabel("1");
		GridBagConstraints gbc_lblRodada1 = new GridBagConstraints();
		gbc_lblRodada1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblRodada1.insets = new Insets(0, 0, 5, 0);
		gbc_lblRodada1.gridx = 1;
		gbc_lblRodada1.gridy = 1;
		panel_1.add(lblRodada1, gbc_lblRodada1);
		lblRodada1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblRodada2 = new JLabel("2");
		GridBagConstraints gbc_lblRodada2 = new GridBagConstraints();
		gbc_lblRodada2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblRodada2.insets = new Insets(0, 0, 5, 0);
		gbc_lblRodada2.gridx = 1;
		gbc_lblRodada2.gridy = 2;
		panel_1.add(lblRodada2, gbc_lblRodada2);
		lblRodada2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblRodada3 = new JLabel("3");
		GridBagConstraints gbc_lblRodada3 = new GridBagConstraints();
		gbc_lblRodada3.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblRodada3.insets = new Insets(0, 0, 5, 0);
		gbc_lblRodada3.gridx = 1;
		gbc_lblRodada3.gridy = 3;
		panel_1.add(lblRodada3, gbc_lblRodada3);
		lblRodada3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label = new JLabel("4");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTHWEST;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 1;
		gbc_label.gridy = 4;
		panel_1.add(label, gbc_label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("5");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 5;
		panel_1.add(label_1, gbc_label_1);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("6");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 6;
		panel_1.add(label_2, gbc_label_2);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
	}

	protected void nextScreen() {
		MainFrame.getInstance().update(new TurnPanel());
		
	}
	
}
