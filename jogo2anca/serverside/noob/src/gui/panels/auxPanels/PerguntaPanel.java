package gui.panels.auxPanels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.awt.Dimension;
import java.awt.Font;

public class PerguntaPanel extends JPanel{

	JLabel lblPergunta = null;
	int nPergunta;
	JTextPane resposta = new JTextPane();

	public PerguntaPanel(int i,String args) {
		this.setPreferredSize(new Dimension(330, 94));
		nPergunta = i;
		setLayout(null);
		lblPergunta = new JLabel(args);
		lblPergunta.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPergunta.setBounds(10, 8, 310, 14);
		add(lblPergunta);
		
		resposta.setBounds(10, 33, 310, 55);
		
		add(resposta);
		this.setVisible(true);

	}
	
	public String getPergunta() {
		return lblPergunta.getText();
	}

	public void setLblPergunta(JLabel lblPergunta) {
		this.lblPergunta = lblPergunta;
	}

	public String getResposta() {
		return resposta.getText();
	}
	
	public int getNum(){
		return nPergunta;
	}

}
