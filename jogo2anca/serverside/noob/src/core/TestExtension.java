package core;

import sfs2x.extensions.games.tris.OnUserGoneHandler;

import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.extensions.SFSExtension;;

public class TestExtension extends SFSExtension {
	
	public int rodadaCount;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		rodadaCount = 0;
		
		addRequestHandler("formInit", FormInitReqHandler.class);
		addRequestHandler("formEnd", FormEndReqHandler.class);
		addRequestHandler("aposta", ApostaReqHandler.class);
		
//		addEventHandler(SFSEventType.USER_DISCONNECT, OnUserGoneHandler.class);
//	    addEventHandler(SFSEventType.USER_LEAVE_ROOM, OnUserGoneHandler.class);
	}
	
	@Override
	public void destroy(){
		super.destroy();
	}
}
