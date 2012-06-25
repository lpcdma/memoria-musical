package handlers;

import java.util.ArrayList;
import java.util.List;


import basic.Player;

import com.smartfoxserver.v2.annotations.Instantiation;
import com.smartfoxserver.v2.annotations.Instantiation.InstantiationMode;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

import negocio.core.Constantes;
import negocio.core.TestExtension;


@Instantiation(InstantiationMode.SINGLE_INSTANCE)
public class ApostaReqHandler extends BaseClientRequestHandler {

	@Override
	public void handleClientRequest(User user, ISFSObject arg1) {
		// TODO Auto-generated method stub
		
		int rodada = arg1.getInt("rodada");
		int valor = arg1.getInt("valor");
		boolean todosApostaram = true;
		int posicaoJogadorLista = 0;
		List<Player> listaJogadores = ((TestExtension)getParentExtension()).getJogadores();
		List<User> listaSFSUsers = new ArrayList<User>();
		for(int i = 0; i < listaJogadores.size(); i++){
			if(listaJogadores.get(i).getId() == user.getId()){
				listaJogadores.get(i).setValorApostadoRodada(valor, rodada);
				listaJogadores.get(i).setJogouRodadaAtual(true);
				posicaoJogadorLista = i;
			}
			listaSFSUsers.add(listaJogadores.get(i).getSfsUser());
			todosApostaram &= listaJogadores.get(i).getJogouRodadaAtual();
		}
		
		((TestExtension)getParentExtension()).apostarFundo(rodada, valor);
		((TestExtension)getParentExtension()).atualizarJogador(posicaoJogadorLista, listaJogadores.get(posicaoJogadorLista));
		
		if(todosApostaram){
			//((TestExtension)getParentExtension()).calcularRetornoEEnviar(rodada, listaSFSUsers);
			((TestExtension)getParentExtension()).startRodada(listaSFSUsers, Constantes.APOSTA_HANDLER);
		}
		else{
			((TestExtension)getParentExtension()).waitPlayers(user);
		}
		
// no cliente o contador apos contar 30 segundos deve fazer uma submissao
// com valor 0
		
	}

}
