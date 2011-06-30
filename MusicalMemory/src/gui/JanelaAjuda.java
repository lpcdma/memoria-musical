package gui;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.*;

public class JanelaAjuda extends JFrame{
	
	private JTextPane texto = null;
	
	public JanelaAjuda() {
		super("Ajuda");

		initialize();
		//this.setLocationByPlatform(true);
		this.setVisible(true);


	}
	
	private void initialize() {

		this.setResizable(false);
		this.add(getTextPane(), null);
		this.setSize(500, 350);
		this.centralizarJanela();

	}
	
	private JTextPane getTextPane() {
		if (texto == null) {
			texto = new JTextPane();
			texto.setText("Musical Memory \n\nNeste divertido desafio voc� tem o objetivo de encontrar os pares de sons iguais. Mas aten��o, " +
					"alguns sons est�o alterados por filtros!\n\nComo jogar:\n\nPara iniciar uma nova partida, voc� deve clicar no bot�o iniciar na tela principal." +
					" Em seguida, escolha se deseja jogar com ou sem coringas. Coringas s�o utilizados para transformar sons que possuem um filtro aplicado a ele. " +
					"Ap�s isso a partida se iniciar�. Voc� deve encontrar os pares de sons que s�o iguais " +
					"para marcar pontos e passar de fase.\nMas aten��o, alguns sons est�o" +
					" mascarados por filtros! Caso necessite de uma ajuda, as cartas coringas est�o a sua disposi��o. Ao solicitar sua ajuda, voc� deve escolher" +
					" qual dos filtros voc� acha que foi usado para mascarar aquele som e seleciona-lo. Caso escolha o filtro correto, poder� ouvir o som original" +
					" e encontrar o par correspondente. Ap�s revelar todos os pares iguais, uma nova fase mais dificil se iniciar�. Tente chegar at� a fase final" +
					" e mostre que voc� � fera na mem�ria musical ;)");
			texto.setEditable(false);
			texto.setBounds(new Rectangle(10, 10, 200, 200));
		}
		return texto;
	}
	
	
	public void centralizarJanela(){

		Dimension dim = this.getToolkit().getScreenSize();      
		int x = (int) (dim.getWidth()  - this.getSize().getWidth() ) / 2;
		int y = (int) (dim.getHeight() - this.getSize().getHeight()) / 2;
		this.setLocation(x,y);

	}
	
	public static void main(String[] args) {
		new JanelaAjuda();
	}

}
