package gui.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import entidades.FormularioFinal;
import fachada.Fachada;
import gui.frames.MainFrame;
import gui.interfaces.PanelAbstract;
import gui.util.Recursos;

public class ThanksPanel extends PanelAbstract {
	private static ThanksPanel instance;
	
	
	
	JLabel[] labels = new JLabel[4];

	/**
	 * Create the panel.
	 */
	private ThanksPanel() {
		
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

	public static ThanksPanel getInstance() {
		if(instance == null){
			instance = new ThanksPanel();
		}
		return instance;
	}

	@Override
	public void nextScreen() {
		Fachada.getInstance().enviarFormularioFinal(new FormularioFinal());
		MainFrame.getInstance().update(new ThanksPanel());
	}
	
}
