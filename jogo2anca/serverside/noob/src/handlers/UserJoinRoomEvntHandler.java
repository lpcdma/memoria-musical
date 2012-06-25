package handlers;

import java.util.List;


import com.smartfoxserver.v2.annotations.Instantiation;
import com.smartfoxserver.v2.annotations.Instantiation.InstantiationMode;
import com.smartfoxserver.v2.core.ISFSEvent;
import com.smartfoxserver.v2.core.SFSEventParam;
import com.smartfoxserver.v2.entities.Room;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.exceptions.SFSException;
import com.smartfoxserver.v2.extensions.BaseServerEventHandler;

import negocio.core.Constantes;
import negocio.core.TestExtension;


@Instantiation(InstantiationMode.SINGLE_INSTANCE)
public class UserJoinRoomEvntHandler extends BaseServerEventHandler {

	
	//lembrar de no cliente setar o maximo da sala = 4
	@Override
	public void handleServerEvent(ISFSEvent arg0) throws SFSException {
		// TODO Auto-generated method stub
		
		Room room = (Room) arg0.getParameter(SFSEventParam.ROOM);
		User user = (User) arg0.getParameter(SFSEventParam.USER);
		List<User> usuarios = room.getPlayersList();
		if(usuarios.size()==Constantes.NUM_JOGADORES){
			((TestExtension)room.getExtension()).criaPlayer(usuarios);
		}
		else if(usuarios.size() > Constantes.NUM_JOGADORES){
			room.removeUser(user);
		}
	}

}
