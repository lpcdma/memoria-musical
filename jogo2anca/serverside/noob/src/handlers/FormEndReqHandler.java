package handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import negocio.core.TestExtension;

import basic.Player;
import basic.Resposta;

import com.smartfoxserver.v2.annotations.Instantiation;
import com.smartfoxserver.v2.annotations.Instantiation.InstantiationMode;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

@Instantiation(InstantiationMode.SINGLE_INSTANCE)
public class FormEndReqHandler extends BaseClientRequestHandler {

	@Override
	public void handleClientRequest(User user, ISFSObject params) {
		// TODO Auto-generated method stub
		
		List<Resposta> respostas = (List<Resposta>)params.getClass("respostas");
		List<Player> jogadores = ((TestExtension)getParentExtension()).getJogadores();
		List<User> listaSFSUsers = new ArrayList<User>();
		Player jogador = null;
		int posicao = 0;
		boolean todosResponderam = true;
		for(int i = 0; i<jogadores.size(); i++){			
			if(jogadores.get(i).getId() == user.getId()){
				jogador = jogadores.get(i);
				jogador.setRespostas(respostas);
				jogador.setJogouRodadaAtual(true);
				posicao = i;
			}
			listaSFSUsers.add(jogadores.get(i).getSfsUser());
			todosResponderam &= jogadores.get(i).getJogouRodadaAtual();
		}
		if(jogador != null){
			((TestExtension)getParentExtension()).atualizarJogador(posicao, jogador);
		}
		
		((TestExtension)getParentExtension()).gravarDados(todosResponderam);			
		
	}

}
