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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;

import dados.Tabula;
import excecoes.FaseInvalidaException;
import excecoes.PoucasMusicasException;
import excecoes.SomInvalidoException;
import fachadaMemoria.SistemaMemoria;

public class PanelDoJogo extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8458509008566406420L;
	ArrayList<PecaDeMemoria> listaMemoria = null;  //  @jve:decl-index=0:
	private JLabel background2 = null;
	private JLabel relogio = null;
	private JLabel botaoJoker;
	private JLabel botaoReplay = null;
	private JanelaPrincipal window;
	private ArrayList<Tabula> tabulas;
	private ArrayList<ImageIcon> imagesJoker;  //  @jve:decl-index=0:
	private ArrayList<ImageIcon> imagesReplay;//  @jve:decl-index=0:
	private JLabel relogioBackgroud;

	public PanelDoJogo(JanelaPrincipal window) {
		super();
		this.window = window;
		initialize();
	}

	private void initialize() {
		background2 = new JLabel();
		ImageIcon relogioIcon = new ImageIcon("imagens//botoes//relogio2.png");

		imagesJoker = new ArrayList<ImageIcon>();
		imagesReplay = new ArrayList<ImageIcon>();

		imagesJoker.add(new ImageIcon("imagens//botoes//jokerPadrao.png"));
		imagesJoker.add(new ImageIcon("imagens//botoes//jokerPressed.png"));
		imagesJoker.add(new ImageIcon("imagens//botoes//jokerMPadrao.png"));
		imagesJoker.add(new ImageIcon("imagens//botoes//jokerMPressed.png"));

		imagesReplay.add(new ImageIcon("imagens//botoes//replayPadrao.png"));
		imagesReplay.add(new ImageIcon("imagens//botoes//replayPressed.png"));
		imagesReplay.add(new ImageIcon("imagens//botoes//replayPadrao.png"));
		imagesReplay.add(new ImageIcon("imagens//botoes//replayPressed.png"));

		relogio = new JLabel();

		relogioBackgroud = new JLabel();

		background2.setBounds(new Rectangle(0, 1, 651, 510));
		background2.setText("");

		relogio.setBounds(new Rectangle(525, 21, 110, 110));
		relogio.setText("");

		relogioBackgroud.setBounds(new Rectangle(510, 21, 110, 110));
		relogioBackgroud.setText("");
		relogioBackgroud.setIcon(relogioIcon);

		relogio.setForeground(Color.RED);
		relogio.setVisible(false);
		relogio.setFont(JanelaPrincipal.fontPadrao);

		this.add(relogio);
		this.add(getBotaoAjuda());
		this.add(getBotaoReplay());

		this.add(background2);

		this.setLayout(null);
		listaMemoria = new ArrayList<PecaDeMemoria>();
		this.setLayout(null);
		this.setSize(new Dimension(651, 510));	
		this.setPreferredSize(new Dimension(651, 510));	

		this.setListeners();
	}

	private void setListeners() {
		this.botaoJoker.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent evt) {
				botaoAjudaPressed(evt);
			}
			public void mouseReleased(MouseEvent evt) {
				botaoAjudaReleased(evt);
			}
		});
		this.botaoReplay.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent evt) {
				botaoReplayPressed(evt);
			}
			public void mouseReleased(MouseEvent evt) {
				botaoReplayReleased(evt);
			}
		});
	}

	protected void botaoReplayReleased(MouseEvent evt) {
		if(botaoReplay.isEnabled()){

			this.setReplayNeutro();
		}
	}

	protected void botaoReplayPressed(MouseEvent evt) {
		if(botaoReplay.isEnabled()){
			this.setReplayPressed();
			JanelaPrincipal.pecaAtual.reproduzirSom();
		}
	}

	protected void botaoAjudaReleased(MouseEvent evt) {


	}

	protected void botaoReplayActionPerformed(ActionEvent evt) {


	}

	public void desabilitarReplay(){
		this.botaoReplay.setEnabled(false);
	}
	public void habilitarReplay(){
		this.botaoReplay.setEnabled(true);
	}

	private JLabel getBotaoReplay() {
		if (botaoReplay == null) {
			botaoReplay = new JLabel();
			botaoReplay.setBounds(new Rectangle(523, 274, 70, 70));
			botaoReplay.setEnabled(false);
			this.setReplayNeutro();
		}
		return botaoReplay;
	}
	public JLabel getBotaoAjuda() {
		if (botaoJoker == null) {
			botaoJoker = new JLabel();
			botaoJoker.setBounds(new Rectangle(523, 153, 86, 86));
			botaoJoker.setVisible(false);
			this.setJokerNeutro();
		}
		return botaoJoker;
	}

	protected void botaoAjudaPressed(MouseEvent evt) {
		if(JanelaPrincipal.coringasCont != 0 && JanelaPrincipal.coringaAtual == ""){
			Object[] possibleValues = { "Echo", "Reverse", "Reverberation" ,"Passa-Baixo", "Passa-Tudo", "Pente"};
			this.setJokerPressed();
			int resposta = JOptionPane.showOptionDialog(this,"Escolha um dos Coringas","Coringas",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,possibleValues,1);
			JOptionPane.showMessageDialog(this,"Você ainda tem " + (JanelaPrincipal.coringasCont-1) + " coringas restantes.");
			this.setJokerNeutro();
			JanelaPrincipal.coringaAtual = (String) possibleValues[resposta];		
			JanelaPrincipal.coringasCont--;
		}
		else if(JanelaPrincipal.coringasCont == 0){
			JOptionPane.showMessageDialog(this,"Você não tem mais coringas.");
		}
		else{
			JOptionPane.showMessageDialog(this,"Use o coringa "+ JanelaPrincipal.coringaAtual + " antes.");
		}
	}
	public JLabel getRelogio(){
		return relogio;
	}

	public void setReplayNeutro() {
		if(JanelaPrincipal.nivel == 15){
			this.botaoReplay.setIcon(imagesReplay.get(2));
		}else{
			this.botaoReplay.setIcon(imagesReplay.get(0));
		}
	}
	public void setReplayPressed() {
		if(JanelaPrincipal.nivel == 15){
			this.botaoReplay.setIcon(imagesReplay.get(3));
		}else{
			this.botaoReplay.setIcon(imagesReplay.get(1));
		}
	}

	public void setJokerNeutro() {
		if(JanelaPrincipal.nivel == 15){
			this.botaoJoker.setIcon(imagesJoker.get(2));
		}else{
			this.botaoJoker.setIcon(imagesJoker.get(0));
		}
	}

	public void setJokerPressed() {
		if(JanelaPrincipal.nivel == 15){
			this.botaoJoker.setIcon(imagesJoker.get(3));
		}else{
			this.botaoJoker.setIcon(imagesJoker.get(1));
		}
	}

	public void setarBackground(ImageIcon imagem){
		this.background2.setIcon(imagem);
	}

	public void inserirButoes(int nivel){
		this.removeAll();
		try {
			this.tabulas = SistemaMemoria.getSistema().getTabuleiro(nivel);
		} catch (FaseInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SomInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PoucasMusicasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(nivel <= 5){
			int x = 80;
			int y = 65;
			JanelaPrincipal.restantes = 16;
			for (int i = 1; i <= 16; i++) {

				PecaDeMemoria novaPeca = new PecaDeMemoria(this,tabulas.get(i-1));
				//	PecaDeMemoria novaPeca = new PecaDeMemoria(this,null);
				this.listaMemoria.add(novaPeca);
				this.add(novaPeca);
				novaPeca.setBounds(new Rectangle(x, y, 70, 70));
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
			JanelaPrincipal.restantes = 24;
			for (int i = 1; i <= 24; i++) {
				if(i <= 20){
					PecaDeMemoria novaPeca = new PecaDeMemoria(this,tabulas.get(i-1));
					//		PecaDeMemoria novaPeca = new PecaDeMemoria(this,null);
					this.listaMemoria.add(novaPeca);
					this.add(novaPeca);
					novaPeca.setBounds(new Rectangle(x, y, 70, 70));
					x += 80;
					if(i % 5 == 0){
						y += 80;
						x = 40;
					}
				}
				else{
					x += 30;
					PecaDeMemoria novaPeca = new PecaDeMemoria(this,tabulas.get(i-1));
					//	PecaDeMemoria novaPeca = new PecaDeMemoria(this,null);
					this.listaMemoria.add(novaPeca);
					this.add(novaPeca);
					novaPeca.setBounds(new Rectangle(x, y, 70, 70));
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
			JanelaPrincipal.restantes = 36;
			for (int i = 1; i <= 36; i++) {
				PecaDeMemoria novaPeca = new PecaDeMemoria(this,tabulas.get(i-1));
				//	PecaDeMemoria novaPeca = new PecaDeMemoria(this,null);
				this.listaMemoria.add(novaPeca);
				this.add(novaPeca);
				novaPeca.setBounds(new Rectangle(x, y, 70, 70));
				x += 75;
				if(i % 6 == 0){
					y += 75;
					x = 25;
				}
			}

		}

		this.add(relogio);

		this.add(relogioBackgroud);

		this.add(getBotaoReplay());
		this.add(getBotaoAjuda());

		this.add(background2);
	}

	/**
	 * This method initializes botaoReplay	
	 * 	
	 * @return javax.swing.JButton	
	 */

	public void passarLevel(){
		window.passarLevel();
	}

}  //  @jve:decl-index=0:visual-constraint="296,13"
