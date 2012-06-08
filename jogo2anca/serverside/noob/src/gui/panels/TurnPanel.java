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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class TurnPanel extends JPanel {
	JLabel lblN = new JLabel("N");
	JLabel lblValueForEach = new JLabel("11,11");
	JLabel lblStoragedValue = new JLabel("11,11");
	/**
	 * Create the panel.
	 */
	public TurnPanel() {
		
		int larguraMain = MainFrame.getLargura();
		this.setSize(new Dimension(MainFrame.getLargura(), larguraMain));
		setLayout(null);
		
		
		
		int largura = 215;
		
		JPanel panelResultado = new JPanel();
		panelResultado.setBounds(((larguraMain/2)-(largura/2)), 26, largura, 218);
		this.add(panelResultado);
		
		
		
		panelResultado.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{28, 0, 0, 24, 38, 8, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelResultado.setLayout(gridBagLayout);
		
		JLabel lblFimDaRodada = new JLabel("Fim da Rodada ");
		lblFimDaRodada.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblFimDaRodada = new GridBagConstraints();
		gbc_lblFimDaRodada.gridwidth = 5;
		gbc_lblFimDaRodada.insets = new Insets(0, 0, 5, 5);
		gbc_lblFimDaRodada.gridx = 0;
		gbc_lblFimDaRodada.gridy = 1;
		panelResultado.add(lblFimDaRodada, gbc_lblFimDaRodada);
		

		lblN.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblN = new GridBagConstraints();
		gbc_lblN.insets = new Insets(0, 0, 5, 0);
		gbc_lblN.gridx = 5;
		gbc_lblN.gridy = 1;
		panelResultado.add(lblN, gbc_lblN);
		
		JLabel lblForamDepositados = new JLabel("Foram depositados");
		lblForamDepositados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblForamDepositados = new GridBagConstraints();
		gbc_lblForamDepositados.anchor = GridBagConstraints.WEST;
		gbc_lblForamDepositados.gridwidth = 4;
		gbc_lblForamDepositados.insets = new Insets(0, 0, 5, 5);
		gbc_lblForamDepositados.gridx = 1;
		gbc_lblForamDepositados.gridy = 3;
		panelResultado.add(lblForamDepositados, gbc_lblForamDepositados);
		
		JLabel lblR_1 = new JLabel("R$ ");
		lblR_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblR_1 = new GridBagConstraints();
		gbc_lblR_1.anchor = GridBagConstraints.WEST;
		gbc_lblR_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblR_1.gridx = 2;
		gbc_lblR_1.gridy = 4;
		panelResultado.add(lblR_1, gbc_lblR_1);
		
		lblStoragedValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 4;
		panelResultado.add(lblStoragedValue, gbc_label);
		
		JLabel lblNoCopo = new JLabel("no copo");
		lblNoCopo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNoCopo = new GridBagConstraints();
		gbc_lblNoCopo.anchor = GridBagConstraints.WEST;
		gbc_lblNoCopo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoCopo.gridx = 4;
		gbc_lblNoCopo.gridy = 4;
		panelResultado.add(lblNoCopo, gbc_lblNoCopo);
		
		JLabel lblCadaUmGanha = new JLabel("cada um ganha");
		lblCadaUmGanha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCadaUmGanha = new GridBagConstraints();
		gbc_lblCadaUmGanha.anchor = GridBagConstraints.WEST;
		gbc_lblCadaUmGanha.gridwidth = 4;
		gbc_lblCadaUmGanha.insets = new Insets(0, 0, 5, 5);
		gbc_lblCadaUmGanha.gridx = 1;
		gbc_lblCadaUmGanha.gridy = 5;
		panelResultado.add(lblCadaUmGanha, gbc_lblCadaUmGanha);
		
		JLabel lblR = new JLabel("R$ ");
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblR = new GridBagConstraints();
		gbc_lblR.anchor = GridBagConstraints.WEST;
		gbc_lblR.insets = new Insets(0, 0, 0, 5);
		gbc_lblR.gridx = 2;
		gbc_lblR.gridy = 6;
		panelResultado.add(lblR, gbc_lblR);
		
		lblValueForEach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 6;
		panelResultado.add(lblValueForEach, gbc_label_1);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(319, 331, 89, 23);
		btnOk.addMouseListener(new MouseListener() {
			
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
		add(btnOk);

	}
	
	protected void nextScreen() {
		MainFrame.getInstance().update(new ResultPanel());
	}

	public void update(int nRodada,double valorTotal,double valorForEach){
		this.lblN.setText(Integer.toString(nRodada));
		this.lblStoragedValue.setText(Double.toString(valorTotal));
		this.lblValueForEach.setText(Double.toString(valorForEach));
		
	}
	
}
