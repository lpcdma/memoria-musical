package gui.panels;

import entidades.FormularioFinal;
import entidades.ResultadosFinais;
import fachada.Fachada;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormFinalPanel extends PanelAbstract {
	private static FormFinalPanel instance;
	
	JLabel[] labels = new JLabel[4];

	/**
	 * Create the panel.
	 */
	private FormFinalPanel() {
		
		int larguraMain = Recursos.LARGURA_JANELA;
		this.setSize(new Dimension(larguraMain, Recursos.ALTURA_JANELA));
		setLayout(null);

		JButton btnOk = new JButton("Enviar");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextScreen();
			}
		});
		btnOk.setBounds(319, 338, 89, 23);
		add(btnOk);

	}

	public void update(){
		

		

	}

	public static FormFinalPanel getInstance() {
		if(instance == null){
			instance = new FormFinalPanel();
		}
		return instance;
	}

	@Override
	public void nextScreen() {
		Fachada.getInstance().enviarFormularioFinal(new FormularioFinal());
		MainFrame.getInstance().update(ThanksPanel.getInstance());
	}
	
}
