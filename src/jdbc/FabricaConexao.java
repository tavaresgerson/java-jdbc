package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	public static Connection getConnection () {
		try {
			String host = "jdbc:postgresql://localhost:5432/curso_java";
			String user = "postgres";
			String pass = "postgres";
			
			return DriverManager.getConnection(host, user, pass);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
