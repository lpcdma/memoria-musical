package basic;


import java.util.ArrayList;
import java.util.List;

import com.smartfoxserver.v2.entities.User;

import negocio.core.Constantes;


public class Player {
	
	private User sfsUser;
	private int id;
	private int[] valoresFinaisPorRodada = {0,0,0,0,0,0};
	private int[] valoresIniciaisPorRodada = {Constantes.VALOR_INICIAL,0,0,0,0,0};
	private int[] valoresApostadosPorRodada = {0,0,0,0,0,0};
	private boolean jogouRodadaAtual = false;
	private boolean iniciarNovaRodada = false;
	private char sexo;
	private	int idade;
	private String cursoUniversitario;
	private char classeRenda;
	
	private List<Resposta> respostas = new ArrayList<Resposta>();
	
	public Player(int id, User sfsUser){
		this.setId(id);
		this.sfsUser = sfsUser;
	}
	
	public Player(int id, User sfsUser, char sexo, int idade, String cursoUniversitario, char classeRenda){
		this.setId(id);
		this.sfsUser = sfsUser;
		this.setSexo(sexo);
		this.setIdade(idade);
		this.setCursoUniversitario(cursoUniversitario);
		this.setClasseRenda(classeRenda);
	}
	
	public void setValorFinalRodada(int valor, int rodada){		
		if(rodada > 0 && rodada < valoresFinaisPorRodada.length){
			valoresFinaisPorRodada[rodada] = valor;
		}
	}
	
	public int getValorFinalRodada(int rodada){
		if(rodada > 0 && rodada < valoresFinaisPorRodada.length){
			return valoresFinaisPorRodada[rodada];
		}
		else{
			return 0;
		}
	}
	
	public void setValorInicialRodada(int valor, int rodada){
		if(rodada > 0 && rodada < valoresIniciaisPorRodada.length){
			valoresIniciaisPorRodada[rodada] = valor;
		}
	}
	
	public int getValorInicialRodada(int rodada){
		if(rodada > 0 && rodada < valoresIniciaisPorRodada.length){
			return valoresIniciaisPorRodada[rodada];
		}
		else{
			return 0;
		}
	}

	public void setSfsUser(User sfsUser) {
		this.sfsUser = sfsUser;
	}

	public User getSfsUser() {
		return sfsUser;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setJogouRodadaAtual(boolean jogouRodadaAtual) {
		this.jogouRodadaAtual = jogouRodadaAtual;
	}

	public boolean getJogouRodadaAtual() {
		return jogouRodadaAtual;
	}

	public void setValorApostadoRodada(int valor, int rodada) {
		if(rodada > 0 && rodada < valoresApostadosPorRodada.length){
			valoresApostadosPorRodada[rodada] = valor;
		}
	}

	public int getValorApostadoRodada(int rodada) {
		if(rodada > 0 && rodada < valoresApostadosPorRodada.length){
			return valoresApostadosPorRodada[rodada];
		}
		else{
			return 0;
		}
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public char getSexo() {
		return sexo;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getIdade() {
		return idade;
	}

	public void setCursoUniversitario(String cursoUniversitario) {
		this.cursoUniversitario = cursoUniversitario;
	}

	public String getCursoUniversitario() {
		return cursoUniversitario;
	}

	public void setClasseRenda(char classeRenda) {
		this.classeRenda = classeRenda;
	}

	public char getClasseRenda() {
		return classeRenda;
	}
	
	public void addResposta(Pergunta pergunta, String resposta){
		respostas.add(new Resposta(pergunta, resposta));
	}
	
	public void setRespostas(List<Resposta> respostas){
		this.respostas = respostas;
	}
	
	public List<Resposta> getRespostas(){
		return this.respostas;
	}
	
	public int[] getvaloresFinaisPorRodada(){
		return this.valoresFinaisPorRodada;
	}
	public int[] getvaloresIniciaisPorRodada(){
		return this.valoresIniciaisPorRodada;
	}
	public int[] getvaloresApostadosPorRodada(){
		return this.valoresApostadosPorRodada;
	}

	public void setIniciarNovaRodada(boolean iniciarNovaRodada) {
		this.iniciarNovaRodada = iniciarNovaRodada;
	}

	public boolean getIniciarNovaRodada() {
		return iniciarNovaRodada;
	}
 }
