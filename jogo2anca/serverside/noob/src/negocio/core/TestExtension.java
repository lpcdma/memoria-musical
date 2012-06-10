package negocio.core;


import java.util.ArrayList;
import java.util.List;

import handlers.ApostaReqHandler;
import handlers.FormEndReqHandler;
import handlers.FormInitReqHandler;
import handlers.IniciarNovaRodadaHandler;
import handlers.UserJoinRoomEvntHandler;

import basic.FundoAposta;
import basic.Pergunta;
import basic.Player;

import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;

import dados.RepositorioJogo;

import negocio.core.Constantes;

public class TestExtension extends SFSExtension {
	
	public int rodadaCount;
	
	private List<Player> listaJogadores = new ArrayList<Player>(Constantes.NUM_JOGADORES);
	private FundoAposta fundoAposta = new FundoAposta();
	private RepositorioJogo repositorio = new RepositorioJogo();
	private List<Pergunta> perguntas = null;
	//private int userCount;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		rodadaCount = 0;
		//userCount = getParentRoom().getUserList().size();
		
		getParentRoom().setMaxUsers(Constantes.NUM_JOGADORES); // nao sei se funfa
				
		addRequestHandler("formInit", FormInitReqHandler.class);
		addRequestHandler("formEnd", FormEndReqHandler.class);
		addRequestHandler("aposta", ApostaReqHandler.class);
		addRequestHandler("iniciarNovaRodada", IniciarNovaRodadaHandler.class);
		addEventHandler(SFSEventType.USER_JOIN_ROOM, UserJoinRoomEvntHandler.class);
//	    addEventHandler(SFSEventType.USER_LEAVE_ROOM, OnUserGoneHandler.class);
	}
	
	@Override
	public void destroy(){
		super.destroy();
	}
	
	public void startRodada(List<User> players, String handler){
		ISFSObject resObj = new SFSObject();
		
		
		if(handler.equals(Constantes.USER_JOIN_HANDLER)){
			for (User user : players) {
				listaJogadores.add(new Player(user.getId(), user));
			}
			resObj.putInt("rodada", Constantes.FORM_INIT);
			rodadaCount = 1;// preencher form_init
		}
		else if(handler.equals(Constantes.FORM_INIT_HANDLER)){			
			resObj.putInt("rodada", Constantes.INICIO_RODADA);			
			resObj.putInt("numRodada", rodadaCount);
			rodadaCount = 2;
		}
		else if(handler.equals(Constantes.APOSTA_HANDLER)){
			//quando vier de aposta_handler add antes porque quer dizer que vai trocar de rodada
			rodadaCount++;
			resObj.putInt("rodada", Constantes.INICIO_RODADA);			
			resObj.putInt("numRodada", rodadaCount);			
		}
		else if(handler.equals(Constantes.INICIO_RODADA) && rodadaCount <= Constantes.LIMITE_RODADAS){
			//vindo de inicio não add porque continua na mesma rodada
			resObj.putInt("rodada", Constantes.APOSTAS);
			resObj.putInt("numRodada", rodadaCount);
		}
		else if(handler.equals(Constantes.INICIO_RODADA) && rodadaCount >= Constantes.LIMITE_RODADAS){
			resObj.putInt("rodada", Constantes.FORM_END);
			resObj.putClass("pergunta", (Object)this.getPerguntas());
		}
		send("comecarRodada", resObj, players);		
	}
	
	public void waitPlayers(User player){
		ISFSObject resObj = new SFSObject();
		send("esperaPlayers", resObj, player);
	}
	
	public List<Player> getJogadores(){
		return this.listaJogadores;
	}
	
	public void atualizarJogador(int posicao, Player player){
		this.listaJogadores.set(posicao, player);
	}
	
	public void apostarFundo(int rodada, int valor){
		this.fundoAposta.apostarRodada(rodada, valor);
	}
	
	private void setaNaoJogouRodada(){
		for (Player p : listaJogadores) {
			p.setJogouRodadaAtual(false);
		}
	}
	
	public void calcularRetornoEEnviar(int rodada, List<User> players){
		int lucro = this.fundoAposta.calcularRetorno(rodada); 	
		ISFSObject resObj = new SFSObject();
		resObj.putInt("lucro",lucro);
		resObj.putInt("rodada",rodada);
		this.setaNaoJogouRodada();
		send("lucroRodada", resObj, players);
	}
	
	public void gravarDados(boolean todosResponderam){
		if(todosResponderam){
			this.repositorio.inserirInformacoes(listaJogadores, fundoAposta);
		}
	}
	
	public List<Pergunta> getPerguntas(){
		if(perguntas == null){
			perguntas = repositorio.buscarPerguntas();			
		}		
		return perguntas;
		
	}
}
