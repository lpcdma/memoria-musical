package core;

import com.smartfoxserver.v2.annotations.Instantiation;
import com.smartfoxserver.v2.annotations.Instantiation.InstantiationMode;
import com.smartfoxserver.v2.core.ISFSEvent;
import com.smartfoxserver.v2.exceptions.SFSException;
import com.smartfoxserver.v2.extensions.BaseServerEventHandler;

@Instantiation(InstantiationMode.SINGLE_INSTANCE)
public class UserJoinRoomEvntHandler extends BaseServerEventHandler {

	private static final int MAX_USER = 4;
	
	
	@Override
	public void handleServerEvent(ISFSEvent arg0) throws SFSException {
		// TODO Auto-generated method stub
		
	}

}
