package gui.panels;

import gui.entidades.RelatorioFinal;
import facade.Fachada;
import gui.frames.MainFrame;
import gui.interfaces.PanelAbstract;
import gui.util.Recursos;
import basic.Resposta;
import basic.Pergunta;

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
import java.util.ArrayList;

import javax.swing.SwingConstants;
import gui.panels.auxPanels.PerguntaPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;


public class FormFinalPanel extends PanelAbstract {
	private static FormFinalPanel instance;
	
	JLabel[] labels = new JLabel[4];

	/**
	 * Create the panel.
	 */
	JPanel panelPerguntas = new JPanel();
	ArrayList<PerguntaPanel> perguntasAL = new ArrayList<PerguntaPanel>();
	ArrayList<Resposta> respostas = new ArrayList<Resposta>();
	
	
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
		btnOk.setBounds(316, 343, 89, 23);
		add(btnOk);
		
		panelPerguntas.setBounds(190, 35, 340, 299);
		add(panelPerguntas);
		panelPerguntas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPorFavorPreencha = new JLabel("Por favor, preencha os dados abaixo :");
		lblPorFavorPreencha.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorFavorPreencha.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPorFavorPreencha.setBounds(180, 11, 360, 23);
		add(lblPorFavorPreencha);

	}

	public void update(){
		
		ArrayList<Pergunta> perguntas = Fachada.getInstance().exibirPerguntas();
		
		int contador = 0;
		for (Pergunta pergunta : perguntas) {
			PerguntaPanel perg = new PerguntaPanel(++contador,pergunta.getPergunta());
			perguntasAL.add(perg);
			panelPerguntas.add(perg);			
		}
	
	}

	public static FormFinalPanel getInstance() {
		if(instance == null){
			instance = new FormFinalPanel();
		}
		return instance;
	}

	@Override
	public void nextScreen() {
		for (PerguntaPanel pergunta : perguntasAL) {
			respostas.add(new Resposta(new Pergunta(pergunta.getNum(),pergunta.getPergunta()),pergunta.getResposta())); 
		}
		Fachada.getInstance().enviarFormularioFinal(respostas);
		MainFrame.getInstance().update(ThanksPanel.getInstance());
	}
	
	
}
