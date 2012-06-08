package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import basic.Pergunta;


public class RepositorioJogo {
	
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return perguntas;
	}
	
	public void inserirJogadores(){
		
	}
	
	public void inserirJogador(){
		
	}
	
	public void inserirRodada(){
		
	}
	
	public void inserirAposta(){
				
	}
	
	public void inserirJogo(){
		
	}
	
	
}
