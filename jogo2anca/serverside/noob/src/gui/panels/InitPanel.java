package gui.panels;

import gui.frames.MainFrame;
import gui.interfaces.PanelAbstract;

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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class InitPanel extends PanelAbstract {

	/**
	 * Create the panel.
	 */
	public InitPanel() {
		
		this.setSize(MainFrame.getLargura(),MainFrame.getAltura());
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnInit = new JButton("Iniciar");
		btnInit.setBounds(291, 309, 137, 45);
		btnInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				initGame();
			}
		});
		setLayout(null);
		this.add(btnInit);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 61, 139));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(128, 43, 464, 232);
		add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnEraUmaVez = new JTextPane();
		txtpnEraUmaVez.setForeground(Color.WHITE);
		txtpnEraUmaVez.setEditable(false);
		txtpnEraUmaVez.setBounds(10, 11, 444, 210);
		panel.add(txtpnEraUmaVez);
		txtpnEraUmaVez.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtpnEraUmaVez.setBackground(new Color(72, 61, 139));
		txtpnEraUmaVez.setText("\r\nEra uma vez uma hist\u00F3ria dentro de uma hist\u00F3ria, e nessa hist\u00F3ria havia uma hist\u00F3ria que come\u00E7ava assim : era uma vez uma hist\u00F3ria dentro de uma hist\u00F3ria, e nessa hist\u00F3ria havia uma hist\u00F3ria que come\u00E7ava assim : era uma vez uma hist\u00F3ria dentro de uma hist\u00F3ria, e nessa hist\u00F3ria havia uma hist\u00F3ria que come\u00E7ava assim : era uma vez uma hist\u00F3ria dentro de uma hist\u00F3ria, e nessa hist\u00F3ria havia uma hist\u00F3ria que come\u00E7ava assim : era uma vez uma hist\u00F3ria dentro de uma hist\u00F3ria, e nessa hist\u00F3ria havia uma hist\u00F3ria que come\u00E7ava assim : era uma vez uma hist\u00F3ria dentro de uma hist\u00F3ria, e nessa hist\u00F3ria havia uma hist\u00F3ria que come\u00E7ava assim : era uma vez uma hist\u00F3ria dentro de uma hist\u00F3ria, e nessa hist\u00F3ria havia uma hist\u00F3ria que come\u00E7ava assim");
	}

	protected void initGame() {
		int resposta = JOptionPane.showConfirmDialog(this, new RegistrationPanel(), "Registro", JOptionPane.OK_CANCEL_OPTION);
		
		if(resposta == 0){
			MainFrame.getInstance().update(GamePanel.getInstance());
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nextScreen() {
		// TODO Auto-generated method stub
		
	}
}
