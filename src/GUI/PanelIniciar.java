package GUI;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JFormattedTextField;

public class PanelIniciar extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3335911689110045401L;
	private JRadioButton radioFacil = null;
	private JRadioButton radioMedio = null;
	private JRadioButton radioDificil = null;
	private JLabel labelFacil = null;
	private JLabel labelMedio = null;
	private JLabel labelDificil = null;
	private JFormattedTextField textField = null;
	public PanelIniciar() {
		super();
		initialize();
		inicialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setLayout(null);
        this.setSize(new Dimension(324, 172));
        this.add(getRadioFacil(), null);
        this.add(getRadioMedio(), null);
        this.add(getRadioDificil(), null);
        this.add(getLabelFacil(), null);
        this.add(getLabelMedio(), null);
        this.add(getLabelDificil(), null);
        this.add(getTextField(), null);
			
	}

	private void inicialize() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * This method initializes radioFacil	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRadioFacil() {
		if (radioFacil == null) {
			radioFacil = new JRadioButton();
			radioFacil.setBounds(new Rectangle(230, 18, 21, 21));
		}
		return radioFacil;
	}

	/**
	 * This method initializes radioMedio	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRadioMedio() {
		if (radioMedio == null) {
			radioMedio = new JRadioButton();
			radioMedio.setBounds(new Rectangle(230, 58, 21, 21));
		}
		return radioMedio;
	}

	/**
	 * This method initializes radioDificil	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRadioDificil() {
		if (radioDificil == null) {
			radioDificil = new JRadioButton();
			radioDificil.setBounds(new Rectangle(230, 98, 21, 21));
		}
		return radioDificil;
	}

	/**
	 * This method initializes labelFacil	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getLabelFacil() {
		if (labelFacil == null) {
			labelFacil = new JLabel();
			labelFacil.setText("Fácil");
			labelFacil.setBounds(new Rectangle(255, 20, 35, 16));
		}
		return labelFacil;
	}

	/**
	 * This method initializes labelMedio	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getLabelMedio() {
		if (labelMedio == null) {
			labelMedio = new JLabel();
			labelMedio.setText("Médio");
			labelMedio.setBounds(new Rectangle(255, 60, 35, 16));
		}
		return labelMedio;
	}

	/**
	 * This method initializes labelDificil	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getLabelDificil() {
		if (labelDificil == null) {
			labelDificil = new JLabel();
			labelDificil.setText("Difícil");
			labelDificil.setBounds(new Rectangle(255, 100, 35, 16));
		}
		return labelDificil;
	}

	/**
	 * This method initializes textField	
	 * 	
	 * @return javax.swing.JFormattedTextField	
	 */
	private JFormattedTextField getTextField() {
		if (textField == null) {
			textField = new JFormattedTextField();
			textField.setBounds(new Rectangle(18, 13, 200, 143));
			textField.setText("Testando a paradinha, de forma decente e não nojenta");
			textField.enableInputMethods(false);
		}
		return textField;
	}
}  //  @jve:decl-index=0:visual-constraint="229,52"
