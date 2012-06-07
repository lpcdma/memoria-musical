package negocio.core;


import java.util.ArrayList;
import java.util.List;

import negocio.handlers.ApostaReqHandler;
import negocio.handlers.FormEndReqHandler;
import negocio.handlers.FormInitReqHandler;

import sfs2x.extensions.games.tris.OnUserGoneHandler;

import basic.FundoAposta;
import basic.Player;

import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;

import negocio.core.Constantes;

public class TestExtension extends SFSExtension {
	
	public int rodadaCount;
	
	private List<Player> listaJogadores = new ArrayList<Player>(Constantes.NUM_JOGADORES);
	private FundoAposta fundoAposta = new FundoAposta();
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
//		addRequestHandle("iniciarNovaRodada", IniciarNovaRodadaReqHandler.class);
		addEventHandler(SFSEventType.USER_JOIN_ROOM, OnUserGoneHandler.class);
//	    addEventHandler(SFSEventType.USER_LEAVE_ROOM, OnUserGoneHandler.class);
	}
	
	@Override
	public void destroy(){
		super.destroy();
	}
	
	public void startRodada(List<User> players){
		ISFSObject resObj = new SFSObject();
		
		if(rodadaCount == 0){
			for (User user : players) {
				listaJogadores.add(new Player(user.getId(), user));
			}
			resObj.putInt("rodada", Constantes.FORM_INIT);
			rodadaCount++;
		}
		else if(rodadaCount > 0 && rodadaCount < Constantes.LIMITE_RODADAS){
			resObj.putInt("rodada", Constantes.FORM_END);
			resObj.putInt("numRodada", rodadaCount);
		}
		else{
			resObj.putInt("rodada", Constantes.APOSTAS);
			rodadaCount++;
		}		
		send("comecarRodada", resObj, players);		
	}
	
	public void waitPlayers(List<User> players){
		ISFSObject resObj = new SFSObject();
		send("esperaPlayers", resObj, players);
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
	
	public void calcularRetornoEEnviar(int rodada, List<User> players){
		int lucro = this.fundoAposta.calcularRetorno(rodada); 	
		ISFSObject resObj = new SFSObject();
		resObj.putInt("lucro",lucro);
		resObj.putInt("rodada",rodada);
		send("lucroRodada", resObj, players);
		rodadaCount++;
	}
}
