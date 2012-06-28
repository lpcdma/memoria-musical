package cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import negocio.core.Constantes;

import basic.Pergunta;
import basic.Resposta;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.exceptions.SFSException;

import sfs2x.client.SmartFox;
import sfs2x.client.core.BaseEvent;
import sfs2x.client.core.IEventListener;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.User;
import sfs2x.client.requests.CreateRoomRequest;
import sfs2x.client.requests.ExtensionRequest;
import sfs2x.client.requests.JoinRoomRequest;
import sfs2x.client.requests.RoomExtension;
import sfs2x.client.requests.RoomSettings;



public class ComunicacaoServidor implements IEventListener {
	
	public static SmartFox sfsClient;
	
	public ComunicacaoServidor(){
		sfsClient = new SmartFox(true);
		sfsClient.addEventListener(SFSEvent.CONNECTION, this);
		sfsClient.addEventListener(SFSEvent.EXTENSION_RESPONSE, this);
		sfsClient.addEventListener(SFSEvent.ROOM_JOIN, this);
	}
	
	//FIXME
	//adicionei os parâmetros.
	public void enviarFormularioInicial(String sexo, String classeRenda, String curso, int idade){
		ISFSObject obj = new SFSObject();
		obj.putUtfString("sexo", sexo);
		obj.putUtfString("classeRenda", classeRenda);
		obj.putUtfString("cursoUniversitario", curso);
		obj.putInt("idade", idade);
		sfsClient.send(new ExtensionRequest("formInit", obj, sfsClient.getLastJoinedRoom()));
	}
	
	
	public void enviarFormularioFinal(List<Resposta> respostas){
		ISFSObject obj = new SFSObject();
		
		obj.putInt("numResp", respostas.size());	
		
		for(int i = 0; i < respostas.size(); i++){
			obj.putInt("idPerg"+i, respostas.get(i).getPergunta().getId());
			obj.putUtfString("perg"+i, respostas.get(i).getPergunta().getPergunta());
			obj.putUtfString("resp"+i, respostas.get(i).getResposta());			
		}
		
		sfsClient.send(new ExtensionRequest("formEnd", obj, sfsClient.getLastJoinedRoom()));		
	}
	
	//FIXME
	//adicionei os parâmetros
	public void enviarAposta(int rodada, int valor){
		ISFSObject obj = new SFSObject();
		obj.putInt("rodada", rodada);
		obj.putInt("valor", valor);
		sfsClient.send(new ExtensionRequest("aposta", obj, sfsClient.getLastJoinedRoom()));
	}
	
	public void iniciarNovaRodada(){
		ISFSObject obj = new SFSObject();
		obj.putBool("comecar", true);
		sfsClient.send(new ExtensionRequest("iniciarNovaRodada", obj, sfsClient.getLastJoinedRoom()));
	}
	
	public void conectarServidor(final String ip, final int porta){
		final SmartFox sfs = sfsClient;
	    new Thread() {
	        @Override
	        public void run() {
	            sfs.connect(ip, porta);
	        }
	    }.start();
	}

	@Override
	public void dispatch(final BaseEvent event) throws SFSException {
		// TODO Auto-generated method stub
		if (event.getType().equalsIgnoreCase(SFSEvent.EXTENSION_RESPONSE))
		{
			ISFSObject resObj = new SFSObject();
			resObj = (ISFSObject) event.getArguments().get("params");
			String comando = event.getArguments().get("cmd").toString();
			
			if(comando.equals("comecarRodada")){
				List<Pergunta> perguntas = null; //NESSA PORRA TERÁ PERGUNTAS FINAIS
				int tipoRodada = resObj.getInt("rodada");
				int numRodada = resObj.getInt("numRodada");;
				int lucro = 0; //NESSA PORRA TEM O LUCRO DA RODADA
				int apostado = 0; //NESSA PORRA TEM O TOTAL APOSTADO NA RODADA
				
				Map<String, Integer> resultadoFinal = null; //NESSA PORRA TERÁ ID E VALOR
				
				User user = (User)event.getArguments().get("user");//NESSA PORRA TEM O ID
				
					
				switch(tipoRodada){
				case Constantes.INICIO_RODADA:
					//PODE COMEÇAR NOVA RODADA
					//cliente deve começar uma nova rodada, com contador de tempo etc...
					numRodada = resObj.getInt("numRodada");
					break;
				case Constantes.APOSTAS:
					//CHEGARAM OS RESULTADOS
					//deve mostrar na tela esses resultados e deve ter um botao para "iniciar nova rodada"
					//a nova rodada só começa quando todo mundo apertar em "iniciar nova rodada"
					//o cliente é avisado que todo mundo apertou no case Constates.INICIO_RODADA
					lucro = resObj.getInt("lucro");
					apostado = resObj.getInt("apostado");
					//O resultado completo só virá quando for a última rodada
					if(numRodada >= Constantes.LIMITE_RODADAS){
						resultadoFinal = new HashMap<String, Integer>();
						int numJogadores = resObj.getInt("numJogadores");
						for(int i=0; i<numJogadores; i++){
							resultadoFinal.put(resObj.getInt("idJogador"+i).toString(), resObj.getInt("valorFinal"+i));							
						}
					}
					break;
				case Constantes.FORM_END:
					//PODE MOSTRAR FORMULARIO FINAL
					//quando o numRodada >= Constantes.LIMITE_RODADAS os resultados finais são mostrados
					//entao vai ter um botao "preencher formulario final", a resposta a essa ação será este case
					perguntas = new ArrayList<Pergunta>();
					int numPerguntas = resObj.getInt("numPerg");
					int idPergunta = 0;
					String pergunta;
					for(int i=0; i < numPerguntas; i++){
						idPergunta = resObj.getInt("idPerg"+i);
						pergunta = resObj.getUtfString("perg"+i);
						perguntas.add(new Pergunta(idPergunta, pergunta));
					}
					break;
					
				}
			}else if(comando.equals("esperaPlayers")){
				//MANDA ESPERAR A PORRA DA MERDA
				//quando recebe esse evento, deve mandar o povo esperar
			}
				    	
		}
		else if(event.getType().equalsIgnoreCase(SFSEvent.CONNECTION))
        {
            if(event.getArguments().get("success").equals(true))
            {
            	List<Room> salas = sfsClient.getRoomList();
            	if(salas.size() == 0){
            		
            		RoomExtension extension = new RoomExtension("test","negocio.core.TestExtension");
        			RoomSettings settings = new RoomSettings("room");
        			settings.setGroupId("game");
        			settings.setGame(true);
        			settings.setMaxUsers(4);
        			settings.setMaxSpectators(0);
        			settings.setExtension(extension);
        			
        			sfsClient.send(new CreateRoomRequest(settings, true, sfsClient.getLastJoinedRoom()));            	
            	}
            	sfsClient.send(new JoinRoomRequest("room"));
            }
            else
            {
            	//AVISA QUE NAO CONECTOU
            }
        }
		else if(event.getType().equalsIgnoreCase(SFSEvent.ROOM_JOIN)){
			//MOSTRA A PORRA DO FORMULARIO
			//quando recebe este evento deve mostrar a tela para preencher formulario inicial
		}
        
	}
	
	
}
