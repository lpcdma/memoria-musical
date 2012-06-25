package gui.panels;

import gui.entidades.InfoPlayer;
import gui.frames.MainFrame;
import gui.interfaces.PanelAbstract;
import gui.panels.auxPanels.RegistrationPanel;
import gui.util.Recursos;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;



public class FormInitPanel extends PanelAbstract{

	RegistrationPanel registrationPanel = new RegistrationPanel();
	JLabel lblNumeroJogador = new JLabel("N");

	public FormInitPanel() {
		this.setSize(Recursos.LARGURA_JANELA,Recursos.ALTURA_JANELA);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(38, 90, 321, 202);
		panel.setLayout(null);
		registrationPanel.desabilitar();
		registrationPanel.setBounds(10, 36, 305, 155);
		panel.add(registrationPanel);
		add(panel);

		JLabel lblJogador = new JLabel("Jogador #");
		lblJogador.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblJogador.setBounds(117, 11, 77, 28);
		panel.add(lblJogador);

		lblNumeroJogador.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNumeroJogador.setBounds(189, 18, 23, 14);
		panel.add(lblNumeroJogador);

		JButton btnNewButton = new JButton("Iniciar Rodada");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextScreen();
			}
		});
		btnNewButton.setBounds(434, 152, 207, 77);
		add(btnNewButton);

	}

	@Override
	public void nextScreen() {
		MainFrame.getInstance().update(GamePanel.getInstance());

	}

	@Override
	public void update() {
		InfoPlayer info = MainFrame.getInstance().getInfo();
		registrationPanel.setCampos(info);
		lblNumeroJogador.setText(info.getNumPlayer());
	}
}
