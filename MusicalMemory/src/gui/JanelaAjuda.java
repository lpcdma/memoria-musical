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
			texto.setText("Musical Memory \n\nNeste divertido desafio você tem o objetivo de encontrar os pares de sons iguais. Mas atenção, " +
					"alguns sons estão alterados por filtros!\n\nComo jogar:\n\nPara iniciar uma nova partida, você deve clicar no botão iniciar na tela principal." +
					" Em seguida, escolha se deseja jogar com ou sem coringas. Coringas são utilizados para transformar sons que possuem um filtro aplicado a ele. " +
					"Após isso a partida se iniciará. Você deve encontrar os pares de sons que são iguais " +
					"para marcar pontos e passar de fase.\nMas atenção, alguns sons estão" +
					" mascarados por filtros! Caso necessite de uma ajuda, as cartas coringas estão a sua disposição. Ao solicitar sua ajuda, você deve escolher" +
					" qual dos filtros você acha que foi usado para mascarar aquele som e seleciona-lo. Caso escolha o filtro correto, poderá ouvir o som original" +
					" e encontrar o par correspondente. Após revelar todos os pares iguais, uma nova fase mais dificil se iniciará. Tente chegar até a fase final" +
					" e mostre que você é fera na memória musical ;)");
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
