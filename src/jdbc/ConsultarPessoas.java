package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoas {
	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexao.getConnection();
		String sql = "SELECT * FROM pessoas WHERE nome ILIKE ?";

		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, "%Isabel%");
		ResultSet resultado = ps.executeQuery();
		
		List<Pessoa> pessoas = new ArrayList<>();

		while(resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");

			pessoas.add(new Pessoa(codigo, nome));
		}
		
		for(Pessoa p: pessoas) {
			System.out.println(p.getCodigo());
			System.out.println(p.getNome());
		}

		ps.close();
		conexao.close();
	}
}
