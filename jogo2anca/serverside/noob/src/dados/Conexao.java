package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static Connection conn;
	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Drive").newInstance();
			String url = "jdbc:mysql://localhost:3306/jogoaposta";
			String user = "root";
			String password = "pegael27";
			conn = DriverManager.getConnection(url,user,password);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
