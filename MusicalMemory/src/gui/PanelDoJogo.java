package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;

public class PanelDoJogo extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8458509008566406420L;
	ArrayList<PecaDeMemoria> listaMemoria = null;  //  @jve:decl-index=0:
	private JLabel background2 = null;
	private JLabel relogio = null;
	private JButton botaoAjuda;
	
	public PanelDoJogo() {
		super();
		initialize();
	}

	private void initialize() {
		background2 = new JLabel();
		relogio = new JLabel();
		background2.setBounds(new Rectangle(0,0,637, 494));
		background2.setText("");

		
		relogio.setBounds(new Rectangle(533, 21, 93, 82));
		relogio.setText("");
		Font curFont = relogio.getFont();
		relogio.setForeground(Color.RED);
		relogio.setVisible(false);
		relogio.setFont(new Font(curFont.getFontName(), curFont.getStyle(), 50));
		this.add(relogio);
		this.add(getBotaoAjuda());
		this.add(background2);

		this.setLayout(null);
		listaMemoria = new ArrayList<PecaDeMemoria>();
		this.setLayout(null);
		this.setSize(new Dimension(637, 494));	
		this.setPreferredSize(new Dimension(637, 494));	
		this.setListeners();
	}
	
	private void setListeners() {
		this.botaoAjuda.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				botaoAjudaActionPerformed(evt);
			}
		});
		
	}
	
	public JButton getBotaoAjuda() {
		if (botaoAjuda == null) {
			botaoAjuda = new JButton();
			botaoAjuda.setBounds(new Rectangle(528, 137, 88, 24));
			botaoAjuda.setText("Coringas");
			botaoAjuda.setVisible(false);
		}
		return botaoAjuda;
	}
	
	protected void botaoAjudaActionPerformed(ActionEvent evt) {
		Object[] possibleValues = { "1", "2", "3" , "4" , "5"};

		int resposta = JOptionPane.showOptionDialog(this,"Escolha um dos Coringas","Coringas",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,possibleValues,1);

	}
	public JLabel getRelogio(){
		return relogio;
	}
	public void setarBackground(ImageIcon imagem){
		this.background2.setIcon(imagem);
	}

	public void inserirButoes(int nivel){
		this.removeAll();
		
		if(nivel <= 5){
			int x = 80;
			int y = 65;
			for (int i = 1; i <= 16; i++) {
				PecaDeMemoria novaPeca = new PecaDeMemoria(nivel);
				this.listaMemoria.add(novaPeca);
				this.add(novaPeca);
				novaPeca.setBounds(new Rectangle(x, y, 60, 60));
				x += 85;
				if(i % 4 == 0){
					y += 85;
					x = 80;
				}
			}
		}
		else if(nivel <= 10){
			int x = 40;
			int y = 25;
			for (int i = 1; i <= 24; i++) {
				if(i <= 20){
					PecaDeMemoria novaPeca = new PecaDeMemoria(nivel);
					this.listaMemoria.add(novaPeca);
					this.add(novaPeca);
					novaPeca.setBounds(new Rectangle(x, y, 60, 60));
					x += 80;
					if(i % 5 == 0){
						y += 80;
						x = 40;
					}
				}
				else{
					x += 30;
					PecaDeMemoria novaPeca = new PecaDeMemoria(nivel);
					this.listaMemoria.add(novaPeca);
					this.add(novaPeca);
					novaPeca.setBounds(new Rectangle(x, y, 60, 60));
					x += 60;
					if(i % 5 == 0){
						y += 80;
						x = 40;
					}
				}
			}

		}
		else if(nivel <= 15){
			int x = 25;
			int y = 10;
			for (int i = 1; i <= 36; i++) {
				PecaDeMemoria novaPeca = new PecaDeMemoria(nivel);
				this.listaMemoria.add(novaPeca);
				this.add(novaPeca);
				novaPeca.setBounds(new Rectangle(x, y, 60, 60));
				x += 75;
				if(i % 6 == 0){
					y += 75;
					x = 25;
				}
			}

		}
		this.add(relogio);
		this.add(getBotaoAjuda());
		this.add(background2);

	}


}  //  @jve:decl-index=0:visual-constraint="296,13"
