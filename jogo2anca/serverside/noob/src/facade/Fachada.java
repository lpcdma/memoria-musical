package facade;

import java.util.ArrayList;
import java.util.List;
import gui.entidades.*;
import sfs2x.client.SmartFox;
import sfs2x.client.requests.ExtensionRequest;

import basic.Resposta;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import negocio.core.*;
import cliente.*;
import basic.*;

public class Fachada {
	
	public SmartFox sfsClient;
	private static Fachada instance = null;
	ComunicacaoServidor comunicacao = null;
	private ControladorJogo control;
	private TestExtension extension;
	
	public static Fachada getInstance(){
		if(instance == null){
			instance = new Fachada();
		}
		return instance;
	}
	
	private Fachada() {
		sfsClient = ComunicacaoServidor.sfsClient;
		comunicacao = new ComunicacaoServidor();
		control = new ControladorJogo(new TestExtension(), GameState.FORM_INIT);
	}
	
	public void enviarFormularioInicial(String sexo, String classeRenda, String curso, int idade){
		comunicacao.enviarFormularioInicial(sexo,classeRenda,curso,idade);
	}
	
	public void enviarFormularioFinal(List<Resposta> respostas){
		comunicacao.enviarFormularioFinal(respostas);		
	}
	
	public void enviarAposta(int rodada, int valor){
		comunicacao.enviarAposta(rodada,valor);		
	}
	
	public void iniciar(){
		
	}
	
	public Relatorio exibirRelatorio(){
		return null;
	}
	
	public RelatorioFinal exibirRelatorioFinal(){
		return null;
	}
	
	public ArrayList<Pergunta> exibirPerguntas(){
		return null;
	}
	
	public int getPlayerID(){
		return 0;
	}
	
	
}
