package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NovaPessoa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Connection conexao = FabricaConexao.getConnection();
		
		System.out.println("Informe o nome");
		String nome = input.nextLine();

		try {
			String sql = "INSERT INTO pessoas (nome) VALUES (?)";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.execute();
			System.out.println(sql);
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		input.close();
	}

}
