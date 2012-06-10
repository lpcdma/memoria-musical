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
public class FormInitReqHandler extends BaseClientRequestHandler {

	@Override
	public void handleClientRequest(User user, ISFSObject params) {
		// TODO Auto-generated method stub
		char sexo = params.getUtfString("sexo").charAt(0);
		char classeRenda = params.getUtfString("classeRenda").charAt(0);
		String cursoUniversitario = params.getUtfString("cursoUniversitario");
		int idade = params.getInt("idade");
		
		
		List<Player> jogadores = ((TestExtension)getParentExtension()).getJogadores();
		List<User> listaSFSUsers = new ArrayList<User>();
		Player jogador = null;
		int posicao = 0;
		boolean todosResponderam = true;
		for(int i = 0; i<jogadores.size(); i++){			
			if(jogadores.get(i).getId() == user.getId()){
				jogador = jogadores.get(i);
				jogador.setIdade(idade);
				jogador.setSexo(sexo);
				jogador.setClasseRenda(classeRenda);
				jogador.setCursoUniversitario(cursoUniversitario);
				jogador.setJogouRodadaAtual(true);
				posicao = i;
			}
			listaSFSUsers.add(jogadores.get(i).getSfsUser());
			todosResponderam &= jogadores.get(i).getJogouRodadaAtual();
		}
		if(jogador != null){
			((TestExtension)getParentExtension()).atualizarJogador(posicao, jogador);
		}
		if(todosResponderam){
			((TestExtension)getParentExtension()).startRodada(listaSFSUsers, Constantes.FORM_INIT_HANDLER);
		}
		else{
			((TestExtension)getParentExtension()).waitPlayers(user);
		}
	}

}
