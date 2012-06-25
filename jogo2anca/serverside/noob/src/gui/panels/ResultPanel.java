package gui.panels;

import gui.entidades.RelatorioFinal;
import facade.Fachada;
import gui.frames.MainFrame;
import gui.interfaces.PanelAbstract;
import gui.util.Recursos;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import java.awt.SystemColor;
import java.awt.Color;

public class ResultPanel extends PanelAbstract {
	private static ResultPanel instance;
	JLabel lblPlayer_1Voce = new JLabel("(você)");
	JLabel lblPlayer_2Voce = new JLabel("(você)");
	JLabel lblPlayer_3Voce = new JLabel("(você)");
	JLabel lblPlayer_4Voce = new JLabel("(você)");

	JLabel[] labels = new JLabel[4];

	JLabel lblPlayer_1Valor = new JLabel("valor1");
	JLabel lblPlayer_2Valor = new JLabel("valor2");
	JLabel lblPlayer_3Valor = new JLabel("valor3");
	JLabel lblPlayer_4Valor = new JLabel("valor4");

	/**
	 * Create the panel.
	 */
	private ResultPanel() {

		int larguraMain = Recursos.LARGURA_JANELA;
		this.setSize(new Dimension(larguraMain, Recursos.ALTURA_JANELA));
		setLayout(null);

		int largura = 200;

		JPanel panelResultado = new JPanel();
		panelResultado.setBounds(260, 23, 200, 287);
		this.add(panelResultado);

		panelResultado.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelResultado.setLayout(null);

		JLabel lblResultadosFinais = new JLabel("Resultados Finais");
		lblResultadosFinais.setBounds(12, 11, 176, 25);
		lblResultadosFinais.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelResultado.add(lblResultadosFinais);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(37, 47, 126, 52);
		panelResultado.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblJogador = new JLabel("Jogador 1");
		lblJogador.setBounds(10, 5, 64, 19);
		panel_3.add(lblJogador);
		lblJogador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlayer_1Valor.setBounds(42, 29, 39, 19);
		panel_3.add(lblPlayer_1Valor);

		lblPlayer_1Valor.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblPlayer_1RS = new JLabel("R$ ");
		lblPlayer_1RS.setBounds(20, 29, 22, 19);
		panel_3.add(lblPlayer_1RS);
		lblPlayer_1RS.setFont(new Font("Tahoma", Font.PLAIN, 15));

		labels[0] = lblPlayer_1Voce;
		labels[1] = lblPlayer_1Voce;
		labels[2] = lblPlayer_1Voce;
		labels[3] = lblPlayer_1Voce;
		lblPlayer_1Voce.setBounds(79, 5, 43, 19);
		panel_3.add(lblPlayer_1Voce);

		lblPlayer_1Voce.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(37, 101, 126, 52);
		panelResultado.add(panel_2);
		panel_2.setLayout(null);
		lblPlayer_2Valor.setBounds(42, 29, 39, 19);
		panel_2.add(lblPlayer_2Valor);

		lblPlayer_2Valor.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblJogador_1 = new JLabel("Jogador 2");
		lblJogador_1.setBounds(10, 5, 64, 19);
		panel_2.add(lblJogador_1);
		lblJogador_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblPlayer_2RS = new JLabel("R$");
		lblPlayer_2RS.setBounds(20, 29, 17, 19);
		panel_2.add(lblPlayer_2RS);
		lblPlayer_2RS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlayer_2Voce.setBounds(79, 5, 43, 19);
		panel_2.add(lblPlayer_2Voce);

		lblPlayer_2Voce.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JPanel panel = new JPanel();
		panel.setBounds(37, 155, 126, 52);
		panelResultado.add(panel);
		panel.setLayout(null);

		JLabel lblJogador_2 = new JLabel("Jogador 3");
		lblJogador_2.setBounds(10, 5, 64, 19);
		panel.add(lblJogador_2);
		lblJogador_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlayer_3Voce.setBounds(79, 5, 43, 19);
		panel.add(lblPlayer_3Voce);

		lblPlayer_3Voce.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblPlayer_3RS = new JLabel("R$");
		lblPlayer_3RS.setBounds(20, 29, 17, 19);
		panel.add(lblPlayer_3RS);
		lblPlayer_3RS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlayer_3Valor.setBounds(42, 29, 39, 19);
		panel.add(lblPlayer_3Valor);

		lblPlayer_3Valor.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(37, 209, 126, 52);
		panelResultado.add(panel_1);
		panel_1.setLayout(null);



		JLabel lblJogador_3 = new JLabel("Jogador 4");
		lblJogador_3.setBounds(10, 5, 64, 19);
		panel_1.add(lblJogador_3);
		lblJogador_3.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblPlayer_4RS = new JLabel("R$");
		lblPlayer_4RS.setBounds(20, 29, 17, 19);
		panel_1.add(lblPlayer_4RS);
		lblPlayer_4RS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlayer_4Valor.setBounds(42, 29, 39, 19);
		panel_1.add(lblPlayer_4Valor);

		lblPlayer_4Valor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlayer_4Voce.setBounds(79, 5, 43, 19);
		panel_1.add(lblPlayer_4Voce);

		lblPlayer_4Voce.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlayer_4Voce.setVisible(false);
		lblPlayer_3Voce.setVisible(false);
		lblPlayer_2Voce.setVisible(false);
		lblPlayer_1Voce.setVisible(false);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextScreen();
			}
		});
		btnOk.setBounds(315, 334, 89, 23);
		add(btnOk);

	}

	public void update(){

		labels[MainFrame.getInstance().getJogador()-1].setVisible(true);


		RelatorioFinal resultFinais = Fachada.getInstance().exibirRelatorioFinal();

		this.lblPlayer_1Valor.setText(resultFinais.getDinheiroPlayer_1());
		this.lblPlayer_2Valor.setText(resultFinais.getDinheiroPlayer_2());
		this.lblPlayer_3Valor.setText(resultFinais.getDinheiroPlayer_3());
		this.lblPlayer_4Valor.setText(resultFinais.getDinheiroPlayer_4());

	}

	public static ResultPanel getInstance() {
		if(instance == null){
			instance = new ResultPanel();
		}
		return instance;
	}

	@Override
	public void nextScreen() {
		
		MainFrame.getInstance().update(FormFinalPanel.getInstance());

	}

}
