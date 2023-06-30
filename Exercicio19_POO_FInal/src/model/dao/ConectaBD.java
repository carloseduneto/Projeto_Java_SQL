package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBD {
	private Connection conexao;
	
	public ConectaBD() {
		String bancoDados = "sistemacartao2";
		String url = "jdbc:mariadb://localhost:3306/"+bancoDados;
		String usuario= "root";
		String senha = "";
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexão realizada");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public Connection getConexao() {
		
		return conexao;
	}

	public void fecharConexao() {
		// TODO Auto-generated method stub
		
	}

	

}
