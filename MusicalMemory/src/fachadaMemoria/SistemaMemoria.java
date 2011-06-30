package fachadaMemoria;

import java.util.ArrayList;

import dados.Som;
import dados.Tabula;

import excecoes.FaseInvalidaException;
import excecoes.PoucasMusicasException;
import excecoes.SomInvalidoException;
import negocio.ControladorFases;
import negocio.ControladorSom;

/**
 * Sistema controlador do jogo da memoria.
 */
public class SistemaMemoria {

	private static SistemaMemoria instancia;
	private ControladorSom controleSom;
	private ControladorFases controleFases;
	
	private SistemaMemoria() {
		this.controleSom = ControladorSom.getControladorSom();
		this.controleFases = ControladorFases.getControladorFases();
	}
	
	/**
	 * Usa o curinga referente ao filtro Passa-Baixa.
	 * 
	 * @param somOriginal	- Som da tabula a ser filtrado.
	 */
	public void usarCuringaPassaBaixa(Som somOriginal){
		this.controleSom.aplicarPassaBaixa(somOriginal);
	}

	/**
	 * Usa o curinga referente ao filtro Echo.
	 * 
	 * @param somOriginal	- Som da tabula a ser filtrado.
	 */
	public void usarCuringaEcho(Som somOriginal){
		this.controleSom.aplicarEcho(somOriginal);
	}

	/**
	 * Usa o curinga referente ao filtro Sawtooth.
	 * 
	 * @param somOriginal	- Som da tabula a ser filtrado.
	 */
	public void usarCuringaSawtooth(Som somOriginal){
		this.controleSom.aplicarSawtooth(somOriginal);
	}

	/**
	 * Usa o curinga referente ao filtro Reverb.
	 * 
	 * @param somOriginal	- Som da tabula a ser filtrado.
	 */
	public void usarCuringaReverb(Som somOriginal){
		this.controleSom.aplicarReverb(somOriginal);
	}
	
	/**
	 * Usa o curinga referente ao filtro Reverse.
	 * 
	 * @param somOriginal	- Som da tabula a ser filtrado.
	 */
	public void usarCuringaReverse(Som somOriginal){
		this.controleSom.aplicarReverse(somOriginal);
	}
	
	/**
	 * Usa o curinga referente ao filtro Passa-Tudo.
	 * 
	 * @param somOriginal	- Som da tabula a ser filtrado.
	 */
	public void usarCuringaPassaTudo(Som somOriginal){
		this.controleSom.aplicarPassaTudo(somOriginal);
	}
	
	/**
	 * Recupera o tabuleiro contendo as tabulas de cada fase.
	 * 
	 * @param fase						- Fase a qual se deseja obter
	 * 									o tabuleiro.
	 * 
	 * @return							<code>ArrayList</code> de <code>Tabula</code>
	 * 									representando o tabuleiro.
	 * 
	 * @throws FaseInvalidaException	Lancada caso a fase passada seja invalida.
	 * @throws PoucasMusicasException 	Lancada caso nao haja sons suficientes para alimentar o sistema.
	 * @throws SomInvalidoException 	Lancada caso seja encontrado Som invalido.
	 */
	public ArrayList<Tabula> getTabuleiro(int fase) throws FaseInvalidaException, PoucasMusicasException, SomInvalidoException{
		return this.controleFases.getTabuleiro(fase);
	}
	
	/**
	 * Recupera a instancia atual do sistema.
	 * 
	 * @return							<code>SistemaMemoria</code> representando
	 * 									o sistema controlador do jogo de memoria.
	 * 
	 */
	public static SistemaMemoria getSistema() {
		if (SistemaMemoria.instancia == null) {
			SistemaMemoria.instancia = new SistemaMemoria();
		}
		return SistemaMemoria.instancia;
	}
}
