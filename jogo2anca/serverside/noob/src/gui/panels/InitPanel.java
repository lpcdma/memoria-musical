package gui.panels;

import gui.frames.MainFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InitPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public InitPanel() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		JButton btnInit = new JButton("Iniciar");
		btnInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				initGame();
			}
		});
		btnInit.setBounds(199, 160, 137, 45);
		this.add(btnInit);
	}

	protected void initGame() {
		int resposta = JOptionPane.showConfirmDialog(this, new RegistrationPanel(), "Registro", JOptionPane.OK_CANCEL_OPTION);
		
		if(resposta == 0){
			MainFrame.getInstance().update(new GamePanel());
		}
	}

}
