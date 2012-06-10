package dados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import negocio.core.Constantes;

import basic.FundoAposta;
import basic.Pergunta;
import basic.Player;
import basic.Resposta;


public class RepositorioJogo {
	
	int id_jogo;
	
	public RepositorioJogo(){}
	
	public List<Pergunta> buscarPerguntas(){
		Connection con = Conexao.getConnection();
		String url = "select * from pergunta";
		List<Pergunta> perguntas = new ArrayList<Pergunta>();
		try {
			PreparedStatement st = con.prepareStatement(url);
			ResultSet rs = st.executeQuery();
			int idPergunta = 0;
			String pergunta = "";
			while(rs.next()){
				idPergunta = rs.getInt("id_pergunta");
				pergunta = rs.getString("pergunta");
				perguntas.add(new Pergunta(idPergunta, pergunta));
			}			
		} catch (SQLException e) {}
		Conexao.closeConnection();
		return perguntas;
	}
	
	public void inserirInformacoes(List<Player> players, FundoAposta fundo){
		this.inserirJogo();	
		for (Player player : players) {
			this.inserirJogador(player);
		}
		this.inserirFundo(fundo);
	}
	
	private void inserirJogador(Player player){
		String url = "insert into jogador (id_jogador_sfs, sexo, idade, cursoUniversitario, classeRenda) values (?,?,?,?,?)";
		Connection con = Conexao.getConnection();
		boolean inseriuJogador = false;
		try {
			PreparedStatement st = con.prepareStatement(url);
			st.setInt(0, player.getId());
			st.setString(1, player.getSexo()+"");
			st.setInt(2, player.getIdade());
			st.setString(3, player.getCursoUniversitario());
			st.setString(4, player.getClasseRenda()+"");
			inseriuJogador = st.execute();
		} catch (SQLException e) {}
		
		if(inseriuJogador){
			try{
				PreparedStatement st = con.prepareStatement("select max(id_jogador) from jogador");
				ResultSet rs = st.executeQuery();
				int id_jogador = -1;
				if(rs.next()){
					id_jogador = rs.getInt(0);
				}
				if(id_jogador > 0){
					
					this.inserirRespostas(player, id_jogador, st, con);
					
					this.inserirRodadas(st, con);
					
					this.inserirApostas(player, id_jogador, st, con);
				}
			} catch (SQLException e){}
		}
		Conexao.closeConnection();
	}
	
	private void inserirRespostas(Player player, int id_jogador, PreparedStatement st, Connection con) throws SQLException{
		List<Resposta> respostas = player.getRespostas();
		String urlInsertRespostas = "insert into resposta(id_jogador, id_pergunta, resposta) values(?,?,?)";					
		for (Resposta resposta : respostas) {
			st = con.prepareStatement(urlInsertRespostas);
			st.setInt(0, id_jogador);
			st.setInt(1, resposta.getPergunta().getId());
			st.setString(2, resposta.getResposta());
			st.execute();
		}
	}
	
	private void inserirRodadas(PreparedStatement st, Connection con) throws SQLException{
		String urlInsertRodada = "insert into rodada(id_jogo, num_rodada) values(?,?)";
		for(int i = 1; i<= Constantes.LIMITE_RODADAS; i++){
			st = con.prepareStatement(urlInsertRodada);
			st.setInt(0, id_jogo);
			st.setInt(1, i);
			st.execute();
		}
	}
	
	private void inserirApostas(Player player, int id_jogador, PreparedStatement st, Connection con) throws SQLException{
		String urlInsertAposta = "insert into aposta(id_jogador, id_jogo, num_rodada, valor_inicial, valor_final, valor_aposta)";
		int[] valoresApostadosRodada = player.getvaloresApostadosPorRodada();
		int[] valoresIniciaisRodada = player.getvaloresIniciaisPorRodada();
		int[] valoresFinaisRodada = player.getvaloresFinaisPorRodada();
		for(int i=0; i<valoresApostadosRodada.length; i++){
			st = con.prepareStatement(urlInsertAposta);
			st.setInt(0, id_jogador);
			st.setInt(1, id_jogo);
			st.setInt(2, i+1);
			st.setInt(3, valoresIniciaisRodada[i]);
			st.setInt(4, valoresFinaisRodada[i]);
			st.setInt(5, valoresApostadosRodada[i]);
			st.execute();
		}
	}
	
	private void inserirFundo(FundoAposta fundo){
		Connection con = Conexao.getConnection();
		String url = "insert into fundo (id_jogo) values (?)";
		try {
			PreparedStatement st = con.prepareStatement(url);
			st.setInt(0, id_jogo);
			boolean inseriu = st.execute();
			
			if(inseriu){
				String urlInserirFundoRodada = "insert into fundo_rodada(num_rodada, id_jogo_rodada, id_jogo_fundo, valor_real, valor_arredondado, valor_acrescido) values()";
				int[] valorRealPorRodada = fundo.getValorRealPorRodada();
				int[] valorArredondadoPorRodada = fundo.getValorArredondadoPorRodada();
				for(int i = 1; i<=valorRealPorRodada.length; i++){
					st = con.prepareStatement(urlInserirFundoRodada);
					st.setInt(0, i);
					st.setInt(1, id_jogo);
					st.setInt(2, id_jogo);
					st.setInt(3, valorRealPorRodada[i]);
					st.setInt(4, valorArredondadoPorRodada[i]);
					st.setInt(5, fundo.calculaAcrescimo(i));
					st.execute();
				}
			}
		} catch (SQLException e) {}
		Conexao.closeConnection();
	}
	
	private void inserirJogo(){
		Connection con = Conexao.getConnection();
		String url = "insert into jogo (data_jogo, qtd_moedas_init) values (?,?)";
		int retorno = -1;
		try {
			PreparedStatement st = con.prepareStatement(url);
			st.setDate(0, new Date(System.currentTimeMillis()));
			st.setInt(1, Constantes.VALOR_INICIAL);
			boolean inseriu = st.execute();
			
			if(inseriu){
				st = con.prepareStatement("select max(id_jogo) from jogo");
				ResultSet rs = st.executeQuery();
				if(rs.next()){
					retorno = rs.getInt(0);
				}
			}
		} catch (SQLException e) {}
		id_jogo = retorno;
		Conexao.closeConnection();
	}
	
	
}
