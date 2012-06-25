package gui.panels.auxPanels;

import javax.swing.ComboBoxEditor;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;

import gui.entidades.InfoPlayer;



import java.awt.Color;

public class RegistrationPanel extends JPanel {

	private JTextField textIdade = new JTextField();
	private JTextField textCurso = new JTextField();
	JComboBox comboBoxSexo = new JComboBox();
	JLabel lblIdade = new JLabel("Idade: ");
	JComboBox comboBoxClasseEcon = new JComboBox();
	JLabel lblPorFavorPreencha = new JLabel("Por favor, preencha o seguinte formulário :");

	/**
	 * Create the panel.
	 */

	public RegistrationPanel() {

		this.setPreferredSize(new Dimension(305, 160));
		setForeground(Color.BLACK);
		setLayout(null);
		lblPorFavorPreencha.setBounds(10, 11, 269, 16);

		lblPorFavorPreencha.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		add(lblPorFavorPreencha);

		JLabel lblNome = new JLabel("Sexo:");
		lblNome.setBounds(10, 42, 61, 14);
		add(lblNome);
		comboBoxSexo.setBounds(94, 39, 98, 20);
		add(comboBoxSexo);
		comboBoxSexo.addItem("Masculino");
		comboBoxSexo.addItem("Feminino");
		lblIdade.setBounds(225, 42, 40, 14);
		add(lblIdade);
		textIdade.setBounds(266, 39, 29, 20);
		add(textIdade);
		textIdade.setColumns(4);

		JLabel lblCursoUniver = new JLabel("<html>Curso <br> Universit\u00E1rio: </html>");
		lblCursoUniver.setBounds(10, 67, 85, 28);
		add(lblCursoUniver);
		textCurso.setBounds(94, 76, 201, 20);
		add(textCurso);
		textCurso.setColumns(10);

		JLabel lblClasseEconmica = new JLabel("<html> Classe <br> Econ\u00F4mica: </html>");
		lblClasseEconmica.setBounds(10, 108, 71, 28);
		add(lblClasseEconmica);
		comboBoxClasseEcon.setBounds(94, 116, 201, 20);

		comboBoxClasseEcon.addItem("Classe A");
		comboBoxClasseEcon.addItem("Classe B");
		comboBoxClasseEcon.addItem("Classe C");
		comboBoxClasseEcon.addItem("Classe D");
		comboBoxClasseEcon.addItem("Não desejo informar");
		add(comboBoxClasseEcon);

	}

	public void desabilitar() {
		textCurso.setEnabled(false);
		textIdade.setEnabled(false);
		comboBoxClasseEcon.setEnabled(false);
		comboBoxSexo.setEnabled(false);
		lblPorFavorPreencha.setVisible(false);
	}

	public void setCampos(InfoPlayer infoPlayer) {
		textCurso.setText(infoPlayer.getCurso());
		textIdade.setText(infoPlayer.getIdade());
		comboBoxClasseEcon.removeAllItems();
		comboBoxClasseEcon.addItem(infoPlayer.getClasse());
		comboBoxSexo.removeAllItems();
		comboBoxSexo.addItem(infoPlayer.getSexo());

	}

	public InfoPlayer getPlayerInfo() {
		return new InfoPlayer(
				textCurso.getText()
				,textIdade.getText()
				,(String) comboBoxClasseEcon.getSelectedItem()
				,(String) comboBoxSexo.getSelectedItem());
	}

	public boolean isOk() {
		boolean notEmpty = 
				!textCurso.getText().equals("") &&
				!textIdade.getText().equals("");
		return notEmpty;
	}

}
