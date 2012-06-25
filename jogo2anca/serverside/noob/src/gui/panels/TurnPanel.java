package gui.panels;

import gui.entidades.Relatorio;
import facade.Fachada;
import gui.frames.MainFrame;
import gui.interfaces.PanelAbstract;
import gui.util.Recursos;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TurnPanel extends PanelAbstract  {

	JLabel lblN = new JLabel("N");
	JLabel lblValueForEach = new JLabel("11,11");
	JLabel lblStoragedValue = new JLabel("11,11");
	static TurnPanel instance = null;
	private JPanel panelResultado_1;

	/**
	 * Create the panel.
	 */

	static public TurnPanel getInstance(){
		if(instance == null){
			instance = new TurnPanel();
		}
		return instance;
	}

	private TurnPanel() {

		int larguraMain = Recursos.LARGURA_JANELA;
		this.setSize(new Dimension(larguraMain,Recursos.ALTURA_JANELA));
		setLayout(null);

		panelResultado_1 = new JPanel();
		panelResultado_1.setBounds(252, 48, 215, 178);
		this.add(panelResultado_1);

		panelResultado_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		createLblFimDaRodada(panelResultado_1);

		setLblN(panelResultado_1);

		createLblForamDepositados(panelResultado_1);

		createLblRS1(panelResultado_1);

		setLblStoragedValue(panelResultado_1);

		createLblNoCopo(panelResultado_1);

		createLblCadaUmGanha(panelResultado_1);

		createLblRS2(panelResultado_1);

		setLblValueForEach(panelResultado_1);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passarTurno();
			}
		});
		btnContinuar.setBounds(299, 282, 122, 49);
		add(btnContinuar);

	}

	private void setLblValueForEach(JPanel panelResultado) {
		lblValueForEach.setBounds(78, 139, 37, 19);
		lblValueForEach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResultado.add(lblValueForEach);
	}

	private void setLblStoragedValue(JPanel panelResultado) {
		lblStoragedValue.setBounds(78, 78, 37, 19);
		lblStoragedValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResultado.add(lblStoragedValue);
	}

	private void setLblN(JPanel panelResultado) {
		lblN.setBounds(177, 11, 15, 25);
		lblN.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelResultado.add(lblN);
	}

	private void createLblRS2(JPanel panelResultado) {
		JLabel lblRS2 = new JLabel("R$ ");
		lblRS2.setBounds(57, 139, 22, 19);
		lblRS2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResultado.add(lblRS2);
	}

	private void createLblCadaUmGanha(JPanel panelResultado) {
		JLabel lblCadaUmGanha = new JLabel("cada um ganha");
		lblCadaUmGanha.setBounds(40, 108, 108, 20);
		lblCadaUmGanha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelResultado.add(lblCadaUmGanha);
	}

	private void createLblNoCopo(JPanel panelResultado) {
		JLabel lblNoCopo = new JLabel("no copo");
		lblNoCopo.setBounds(118, 78, 52, 19);
		lblNoCopo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResultado.add(lblNoCopo);
	}

	private void createLblRS1(JPanel panelResultado) {
		JLabel lblRS1 = new JLabel("R$ ");
		lblRS1.setBounds(57, 78, 22, 19);
		lblRS1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelResultado.add(lblRS1);
	}

	private void createLblForamDepositados(JPanel panelResultado) {
		JLabel lblForamDepositados = new JLabel("Foram depositados");
		lblForamDepositados.setBounds(40, 47, 134, 20);
		lblForamDepositados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelResultado.add(lblForamDepositados);
	}

	private void createLblFimDaRodada(JPanel panelResultado) {
		panelResultado_1.setLayout(null);
		JLabel lblFimDaRodada = new JLabel("Fim da Rodada ");
		lblFimDaRodada.setBounds(20, 11, 157, 25);
		lblFimDaRodada.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelResultado.add(lblFimDaRodada);
	}

	public void nextScreen() {
		MainFrame.getInstance().update(GamePanel.getInstance());

	}

	public void update(){
		//FIXME
//		Resultados resultados = Fachada.getInstance()
//				.getResultados(MainFrame.getInstance().getRodada());
//		//	Thread thread = setRelogio();
//		//	thread.start();
//
//		this.lblN.setText(
//				MainFrame.getInstance().getRodada()+"");
//		this.lblStoragedValue.setText(
//				Recursos.converterParaReal(
//						resultados.getQtdApostada()));
//		this.lblValueForEach.setText(
//				Recursos.converterParaReal(
//						resultados.getQtdRecebida()));
//
//		MainFrame.getInstance().setMoney(
//				MainFrame.getInstance().getMoney() 
//				+ resultados.getQtdRecebida());
//
//		MainFrame.getInstance().incRodada();			
	}

	private void passarTurno(){

		nextScreen();
	}

	private Thread setRelogio() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				long tempoInicial = System.currentTimeMillis();			
				boolean funcionando = true;
				int contador = Recursos.TEMPO_PARA_PASSAR_DE_TELA_SEGUNDOS*1000;
				try {
					long lol = 0;		
					while(funcionando){
						lol = (((tempoInicial+contador) - System.currentTimeMillis())/1000);

						if(lol <= 0 && funcionando){
							funcionando = false;
						}
						Thread.sleep(950);
					}

					nextScreen();
				}
				catch (InterruptedException e) {System.out.println("merda");}
			}
		});
		return thread;
	}
}
