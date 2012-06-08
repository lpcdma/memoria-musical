package gui.panels;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Color;

public class RegistrationPanel extends JPanel {
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public RegistrationPanel() {
		setForeground(Color.BLACK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 81, 62, 0, 67, 28, 14, 0};
		gridBagLayout.rowHeights = new int[]{38, 29, 34, 29, 25, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblPorFavorPreencha = new JLabel("Por favor, preencha o seguinte formulário :");
		lblPorFavorPreencha.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		GridBagConstraints gbc_lblPorFavorPreencha = new GridBagConstraints();
		gbc_lblPorFavorPreencha.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblPorFavorPreencha.insets = new Insets(0, 0, 5, 0);
		gbc_lblPorFavorPreencha.gridwidth = 6;
		gbc_lblPorFavorPreencha.gridx = 1;
		gbc_lblPorFavorPreencha.gridy = 0;
		add(lblPorFavorPreencha, gbc_lblPorFavorPreencha);
		
		JLabel lblNome = new JLabel("Sexo:           ");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.WEST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);
		
		JComboBox comboBoxSexo = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		add(comboBoxSexo, gbc_comboBox);
		comboBoxSexo.addItem("Masculino");
		comboBoxSexo.addItem("Feminino");
		
		JLabel lblIdade = new JLabel("Idade: ");
		GridBagConstraints gbc_lblIdade = new GridBagConstraints();
		gbc_lblIdade.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdade.gridx = 4;
		gbc_lblIdade.gridy = 1;
		add(lblIdade, gbc_lblIdade);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 1;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(4);
		
		
		JLabel lblCursoUniver = new JLabel("<html>Curso <br> Universit\u00E1rio: </html>");
//		lblCursoUniver.setEditable(false);
//		lblCursoUniver.setLineWrap(true);
		GridBagConstraints gbc_lblCursoUniversitrio = new GridBagConstraints();
		gbc_lblCursoUniversitrio.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblCursoUniversitrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblCursoUniversitrio.gridx = 1;
		gbc_lblCursoUniversitrio.gridy = 2;
		add(lblCursoUniver, gbc_lblCursoUniversitrio);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.SOUTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 4;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblClasseEconmica = new JLabel("<html> Classe <br> Econ\u00F4mica: </html>");
		GridBagConstraints gbc_lblClasseEconmica = new GridBagConstraints();
		gbc_lblClasseEconmica.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblClasseEconmica.insets = new Insets(0, 0, 5, 5);
		gbc_lblClasseEconmica.gridx = 1;
		gbc_lblClasseEconmica.gridy = 3;
		add(lblClasseEconmica, gbc_lblClasseEconmica);
		
		JComboBox comboBoxClasseEcon = new JComboBox();
		comboBoxClasseEcon.addItem("Classe A");
		comboBoxClasseEcon.addItem("Classe B");
		comboBoxClasseEcon.addItem("Classe C");
		comboBoxClasseEcon.addItem("Classe D");
		comboBoxClasseEcon.addItem("Não desejo informar");
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 3;
		gbc_comboBox_1.anchor = GridBagConstraints.SOUTH;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 3;
		add(comboBoxClasseEcon, gbc_comboBox_1);

	}

}
