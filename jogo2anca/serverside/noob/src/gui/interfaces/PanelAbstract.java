package gui.interfaces;

import javax.swing.JPanel;

public abstract class PanelAbstract extends JPanel{

	public PanelAbstract() {
		super();
	}

	public abstract void update();
	
	public abstract void nextScreen();
	
}
