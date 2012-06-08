package gui.panels;

import gui.frames.MainFrame;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;

public class ResultPanel extends JPanel {
	JLabel lblPlayer_1Voce = new JLabel("(você)");
	JLabel lblPlayer_2Voce = new JLabel("(você)");
	JLabel lblPlayer_3Voce = new JLabel("(você)");
	JLabel lblPlayer_4Voce = new JLabel("(você)");

	JLabel lblPlayer_1Valor = new JLabel("valor1");
	JLabel lblPlayer_2Valor = new JLabel("valor2");
	JLabel lblPlayer_3Valor = new JLabel("valor3");
	JLabel lblPlayer_4Valor = new JLabel("valor4");

	/**
	 * Create the panel.
	 */
	public ResultPanel() {
		
		
		int larguraMain = MainFrame.getLargura();
		this.setSize(new Dimension(MainFrame.getLargura(), larguraMain));
		setLayout(null);
		
		int largura = 200;
		
		JPanel panelResultado = new JPanel();
		panelResultado.setBounds(((larguraMain/2)-(largura/2)), 11, largura, 280);
		this.add(panelResultado);
		
		
		panelResultado.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{57, 13, 11, 48, 0};
		gridBagLayout.rowHeights = new int[]{38, 38, 32, 10, 32, 10, 32, 10, 32, 10};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelResultado.setLayout(gridBagLayout);

		JLabel lblResultadosFinais = new JLabel("Resultados Finais");
		lblResultadosFinais.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblResultadosFinais = new GridBagConstraints();
		gbc_lblResultadosFinais.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblResultadosFinais.gridwidth = 4;
		gbc_lblResultadosFinais.insets = new Insets(0, 0, 5, 0);
		gbc_lblResultadosFinais.gridx = 0;
		gbc_lblResultadosFinais.gridy = 0;
		panelResultado.add(lblResultadosFinais, gbc_lblResultadosFinais);
		
		JLabel lblJogador = new JLabel("Jogador 1");
		lblJogador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblJogador = new GridBagConstraints();
		gbc_lblJogador.anchor = GridBagConstraints.SOUTH;
		gbc_lblJogador.gridwidth = 2;
		gbc_lblJogador.insets = new Insets(0, 0, 5, 5);
		gbc_lblJogador.gridx = 0;
		gbc_lblJogador.gridy = 1;
		panelResultado.add(lblJogador, gbc_lblJogador);
		
				lblPlayer_1Voce.setFont(new Font("Tahoma", Font.PLAIN, 15));
				GridBagConstraints gbc_lblvoc = new GridBagConstraints();
				gbc_lblvoc.anchor = GridBagConstraints.SOUTH;
				gbc_lblvoc.insets = new Insets(0, 0, 5, 5);
				gbc_lblvoc.gridx = 2;
				gbc_lblvoc.gridy = 1;
				panelResultado.add(lblPlayer_1Voce, gbc_lblvoc);
				lblPlayer_1Voce.setVisible(false);

		JLabel lblPlayer_1RS = new JLabel("R$ ");
		lblPlayer_1RS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblR = new GridBagConstraints();
		gbc_lblR.insets = new Insets(0, 0, 5, 5);
		gbc_lblR.gridx = 0;
		gbc_lblR.gridy = 2;
		panelResultado.add(lblPlayer_1RS, gbc_lblR);

		lblPlayer_1Valor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.insets = new Insets(0, 0, 5, 5);
		gbc_lblValor.gridx = 1;
		gbc_lblValor.gridy = 2;
		panelResultado.add(lblPlayer_1Valor, gbc_lblValor);
		
		JLabel lblJogador_1 = new JLabel("Jogador 2");
		lblJogador_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblJogador_1 = new GridBagConstraints();
		gbc_lblJogador_1.gridwidth = 2;
		gbc_lblJogador_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblJogador_1.gridx = 0;
		gbc_lblJogador_1.gridy = 3;
		panelResultado.add(lblJogador_1, gbc_lblJogador_1);
		
		
				lblPlayer_2Voce.setFont(new Font("Tahoma", Font.PLAIN, 15));
				GridBagConstraints gbc_lblJogador1 = new GridBagConstraints();
				gbc_lblJogador1.insets = new Insets(0, 0, 5, 5);
				gbc_lblJogador1.gridx = 2;
				gbc_lblJogador1.gridy = 3;
				panelResultado.add(lblPlayer_2Voce, gbc_lblJogador1);
				lblPlayer_2Voce.setVisible(false);

		JLabel lblPlayer_2RS = new JLabel("R$");
		lblPlayer_2RS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblR_1 = new GridBagConstraints();
		gbc_lblR_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblR_1.gridx = 0;
		gbc_lblR_1.gridy = 4;
		panelResultado.add(lblPlayer_2RS, gbc_lblR_1);

		lblPlayer_2Valor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblValor_1 = new GridBagConstraints();
		gbc_lblValor_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblValor_1.gridx = 1;
		gbc_lblValor_1.gridy = 4;
		panelResultado.add(lblPlayer_2Valor, gbc_lblValor_1);
		
		JLabel lblJogador_2 = new JLabel("Jogador 3");
		lblJogador_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblJogador_2 = new GridBagConstraints();
		gbc_lblJogador_2.gridwidth = 2;
		gbc_lblJogador_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblJogador_2.gridx = 0;
		gbc_lblJogador_2.gridy = 5;
		panelResultado.add(lblJogador_2, gbc_lblJogador_2);
		
		
				lblPlayer_3Voce.setFont(new Font("Tahoma", Font.PLAIN, 15));
				GridBagConstraints gbc_label_1 = new GridBagConstraints();
				gbc_label_1.insets = new Insets(0, 0, 5, 5);
				gbc_label_1.gridx = 2;
				gbc_label_1.gridy = 5;
				panelResultado.add(lblPlayer_3Voce, gbc_label_1);
				lblPlayer_3Voce.setVisible(false);

		JLabel lblPlayer_3RS = new JLabel("R$");
		lblPlayer_3RS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblR_2 = new GridBagConstraints();
		gbc_lblR_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblR_2.gridx = 0;
		gbc_lblR_2.gridy = 6;
		panelResultado.add(lblPlayer_3RS, gbc_lblR_2);

		lblPlayer_3Valor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblValor_2 = new GridBagConstraints();
		gbc_lblValor_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblValor_2.gridx = 1;
		gbc_lblValor_2.gridy = 6;
		panelResultado.add(lblPlayer_3Valor, gbc_lblValor_2);
		
		JLabel lblJogador_3 = new JLabel("Jogador 4");
		lblJogador_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblJogador_3 = new GridBagConstraints();
		gbc_lblJogador_3.gridwidth = 2;
		gbc_lblJogador_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblJogador_3.gridx = 0;
		gbc_lblJogador_3.gridy = 7;
		panelResultado.add(lblJogador_3, gbc_lblJogador_3);
		
				lblPlayer_4Voce.setFont(new Font("Tahoma", Font.PLAIN, 15));
				GridBagConstraints gbc_label_2 = new GridBagConstraints();
				gbc_label_2.insets = new Insets(0, 0, 5, 5);
				gbc_label_2.gridx = 2;
				gbc_label_2.gridy = 7;
				panelResultado.add(lblPlayer_4Voce, gbc_label_2);
				lblPlayer_4Voce.setVisible(false);

		JLabel lblPlayer_4RS = new JLabel("R$");
		lblPlayer_4RS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 8;
		panelResultado.add(lblPlayer_4RS, gbc_lblNewLabel_1);

		lblPlayer_4Valor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblValor_3 = new GridBagConstraints();
		gbc_lblValor_3.anchor = GridBagConstraints.NORTH;
		gbc_lblValor_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblValor_3.gridx = 1;
		gbc_lblValor_3.gridy = 8;
		panelResultado.add(lblPlayer_4Valor, gbc_lblValor_3);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(319, 338, 89, 23);
		add(btnOk);

	}
	
	public void update(int nPlayer,Object dados){
		if(nPlayer == 1){
			lblPlayer_1Voce.setVisible(true);
		}
		else if(nPlayer == 2){
			lblPlayer_2Voce.setVisible(true);
		}
		else if(nPlayer == 3){
			lblPlayer_3Voce.setVisible(true);
		}
		else if(nPlayer == 4){
			lblPlayer_4Voce.setVisible(true);
		}

		this.lblPlayer_1Valor.setText("");
		this.lblPlayer_2Valor.setText("");
		this.lblPlayer_3Valor.setText("");
		this.lblPlayer_4Valor.setText("");

	}
}
