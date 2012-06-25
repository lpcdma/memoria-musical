package gui.panels;

import cliente.ComunicacaoServidor;
import gui.frames.MainFrame;
import gui.interfaces.PanelAbstract;
import gui.panels.auxPanels.RegistrationPanel;
import gui.util.Recursos;

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

public class ThanksPanel extends PanelAbstract {

	/**
	 * Create the panel.
	 */

	static ThanksPanel instance = null;

	private ThanksPanel() {

		this.setSize(Recursos.LARGURA_JANELA,Recursos.ALTURA_JANELA);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

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
		txtpnEraUmaVez.setText("Gostaria de agradecer a todos, principalmente aos magníficos programadores " +
				"que desenvolverem esse maravilhosos " +
				"software. Walter e Wellington. Em especial Wellington por que " +
				"essa gui tá muito fechante.");
	}

	@Override
	public void update() {

	}

	@Override
	public void nextScreen() {

	}

	public static ThanksPanel getInstance() {
		if(instance == null){
			instance = new ThanksPanel();
		}
		return instance;
	}

}
