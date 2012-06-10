package handlers;

import java.util.ArrayList;
import java.util.List;

import negocio.core.Constantes;
import negocio.core.TestExtension;
import basic.Player;

import com.smartfoxserver.v2.annotations.Instantiation;
import com.smartfoxserver.v2.annotations.Instantiation.InstantiationMode;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

@Instantiation(InstantiationMode.SINGLE_INSTANCE)
public class IniciarNovaRodadaHandler extends BaseClientRequestHandler {

	@Override
	public void handleClientRequest(User user, ISFSObject params) {
		// TODO Auto-generated method stub
		boolean ok = params.getBool("comecar");
		List<Player> listaJogadores = ((TestExtension)getParentExtension()).getJogadores();
		List<User> listaSFSUsers = new ArrayList<User>();
		boolean todosAceitaram = true;
		for(int i = 0; i < listaJogadores.size(); i++){
			if(listaJogadores.get(i).getId() == user.getId()){
				listaJogadores.get(i).setIniciarNovaRodada(ok);				
			}
			listaSFSUsers.add(listaJogadores.get(i).getSfsUser());
			todosAceitaram &= listaJogadores.get(i).getIniciarNovaRodada();
		}
		
		if(todosAceitaram){
			((TestExtension)getParentExtension()).startRodada(listaSFSUsers, Constantes.INIT_RODADA_HANDLER);
		}
		else{
			((TestExtension)getParentExtension()).waitPlayers(user);
		}
		
	}

}
