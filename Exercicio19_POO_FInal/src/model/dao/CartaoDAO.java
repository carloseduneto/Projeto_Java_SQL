package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.entiry.Cartao;
import model.entiry.CartaoAcesso;
import model.entiry.Titular;


public class CartaoDAO {

	public void inserir(Cartao novoCartaoDeCredito, int idTitular, String nome, double limite) {
	    ConectaBD conexao = new ConectaBD();
	    String sql = "INSERT INTO cartao (numero, validade, nome,  limite, idTitular) VALUES (?,?,?,?, ?)";
	    try (PreparedStatement prepararFrase = conexao.getConexao().prepareStatement(sql)) {
	        prepararFrase.setString(1, novoCartaoDeCredito.getNumeroCartao());
	        prepararFrase.setDate(2, Date.valueOf(novoCartaoDeCredito.getDataValidade()));
	        prepararFrase.setString(3, nome);
	        prepararFrase.setDouble(4 , limite);
	        prepararFrase.setInt(5, idTitular);
	        prepararFrase.execute();
	        
	    } catch (SQLException e) {
	        System.out.println("Erro ao inserir o cartão: " + e.getMessage());
	    } finally {
	        conexao.fecharConexao();
	    }
	}



    

    
    public List<CartaoAcesso> consultarCartoesTitulares(int idTitular){
    	ConectaBD conexao = new ConectaBD();
    	String sql = "SELECT * FROM cartao WHERE idTitular = ?;";
    	
    	TitularDAO titularDAO01 = new TitularDAO();
		String titular = titularDAO01.consultarNome(idTitular);
    	
    	List<CartaoAcesso> lista = new LinkedList<CartaoAcesso>();
    	try {
			PreparedStatement frase = conexao.getConexao().prepareStatement(sql);
			frase.setInt(1, idTitular);
			ResultSet resultado = frase.executeQuery();
			CartaoAcesso cartao;
			while(resultado.next()) {
				cartao = new CartaoAcesso();
				int idCartao = resultado.getInt("idCartao");
				String numero = resultado.getString("numero");
				Date data = resultado.getDate("validade");
				String nome = resultado.getString("nome");
				double limite = resultado.getDouble("limite");
				
				
				cartao.setId(idCartao);
				cartao.setNumeroCartao(numero);
				cartao.setDataValidade(data);
				cartao.setNome(nome);
				cartao.setLimiteCredito(limite);
				lista.add(cartao);
				
			}
			
    	} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    	
    	return lista;
    }
    
    public double consultarLimite(int id) {
		ConectaBD con = new ConectaBD();
		String sql = "SELECT * FROM cartao WHERE idCartao = ?;";
		double limite = 0;
		try {
		PreparedStatement pst = con.getConexao().prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			limite = rs.getDouble("limite");
			
		}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return limite;
		
		
}
    
    public void atualizarlimitinho(double novoLimite, int idCartao) {
        ConectaBD conexao = new ConectaBD();
        String sql = "UPDATE cartao SET limite = ? WHERE idCartao = ?;";
        try {
            PreparedStatement prepararFrase = conexao.getConexao().prepareStatement(sql);
            prepararFrase.setDouble(1, novoLimite);
            prepararFrase.setInt(2, idCartao);
            prepararFrase.executeUpdate();
            System.out.println("Limite atualizado!!!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o limite: " + e.getMessage());
        } finally {
            conexao.fecharConexao();
        }
    }


	

	
}
