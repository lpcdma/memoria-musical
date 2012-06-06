package core;

import java.util.List;

import sfs2x.extensions.games.battlefarm.utils.Commands;
import sfs2x.extensions.games.tris.OnUserGoneHandler;

import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;;

public class TestExtension extends SFSExtension {
	
	public int rodadaCount;
	private int userCount;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		rodadaCount = 0;
		userCount = getParentRoom().getUserList().size();
		
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
		++rodadaCount;
		resObj.putInt("rodada", rodadaCount);
		send("comecarRodada", resObj, players);		
	}
	
	public void waitPlayers(List<User> players){
		ISFSObject resObj = new SFSObject();
		send("esperaPlayers", resObj, players);
	}
}
