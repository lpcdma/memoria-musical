package core;

import java.util.ArrayList;
import java.util.List;

import sfs2x.extensions.games.tris.OnUserGoneHandler;

import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;;

public class TestExtension extends SFSExtension {
	
	public int rodadaCount;
	public static final int LIMITE_RODADAS = 6;
	public static final int FORM_INIT = 0;
	public static final int FORM_END = 2;
	public static final int APOSTAS = 1;
	public static final int NUM_JOGADORES = 4;
	private List<Player> listaJogadores = new ArrayList<Player>(NUM_JOGADORES);
	//private int userCount;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		rodadaCount = 0;
		//userCount = getParentRoom().getUserList().size();
		
		getParentRoom().setMaxUsers(4); // nao sei se funfa
				
		addRequestHandler("formInit", FormInitReqHandler.class);
		addRequestHandler("formEnd", FormEndReqHandler.class);
		addRequestHandler("aposta", ApostaReqHandler.class);
		
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
			resObj.putInt("rodada", FORM_INIT);
		}
		else if(rodadaCount > 0 && rodadaCount < LIMITE_RODADAS){
			resObj.putInt("rodada", FORM_END);
		}
		else{
			resObj.putInt("rodada", APOSTAS);
		}		
		send("comecarRodada", resObj, players);
		rodadaCount++;
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
}
