package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PecaDeMemoria extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3060323556573736760L;
	Icon imagemNormal = null;
	Icon imagemPressed = null;

	public PecaDeMemoria(int nivel) {
		super();
		imagemNormal = new ImageIcon("imageBotao.png");
		imagemPressed = new ImageIcon("imageBotaoPressed.png");
		this.setIcon(imagemNormal);
        this.setListeners();
        this.setBorder(null);
     //   Color transparente = new Color(1,1,1,1); 
    //    this.setBackground(transparente);
     //   this.setForeground(transparente);
	}

	private void setListeners() {
		this.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				botaoActionPerformed(evt);
			}
		});
	}

	protected void botaoActionPerformed(ActionEvent evt) {
		
	}

	public void mousePressed(MouseEvent e) {
		this.setIcon(imagemPressed);
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {

	}

}
