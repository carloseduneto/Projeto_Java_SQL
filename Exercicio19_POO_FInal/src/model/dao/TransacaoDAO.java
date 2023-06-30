package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import model.entiry.Cartao;
import model.entiry.CartaoAcesso;
import model.entiry.Titular;
import model.entiry.Transacao;

public class TransacaoDAO {

	public void inserir(Transacao trasacao, int idCartao, String estabelecimento, double valor) {
	    ConectaBD conexao = new ConectaBD();
	    String sql = "INSERT INTO transacao (valor, estabelecimento,  idCartao) VALUES (?,?,?)";
	    try (PreparedStatement prepararFrase = conexao.getConexao().prepareStatement(sql)) {
	        prepararFrase.setDouble(1, valor);
	        prepararFrase.setString(2, estabelecimento);
	        prepararFrase.setInt(3, idCartao);
	        prepararFrase.execute();
	        System.out.println("Transação inserida com sucesso");
	        
	    } catch (SQLException e) {
	        System.out.println("Erro ao inserir o cartão: " + e.getMessage());
	    } finally {
	        conexao.fecharConexao();
	    }
	}



    public List<Transacao> consultarGastos(int idCartao){
    	ConectaBD conexao = new ConectaBD();
    	String sql = "SELECT * FROM transacao WHERE idCartao = ?;";
    	
    	List<Transacao> lista = new LinkedList<Transacao>();
    	try {
			PreparedStatement frase = conexao.getConexao().prepareStatement(sql);
			frase.setInt(1, idCartao);
			ResultSet resultado = frase.executeQuery();
			Transacao transacao;
			while(resultado.next()) {
				transacao = new Transacao();
				double valor = resultado.getDouble("valor");
				String estabelecimento = resultado.getString("estabelecimento");
	
				transacao.setValor(valor);
				transacao.setEstabelecimento(estabelecimento);
				lista.add(transacao);
				
			}
			
    	} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    	
    	return lista;
    }
    
    public void excluir(int idCartao) {
    	TransacaoDAO TransacaoDAO = new TransacaoDAO();
    	ConectaBD conexao = new ConectaBD();
    	String sql = "DELETE FROM transacao WHERE idCartao= ?;";
    	
    		try{
    			PreparedStatement frase = conexao.getConexao().prepareStatement(sql);
    			frase.setInt(1, idCartao);
    			frase.execute();
    		}catch (SQLException e) {
    			System.out.println(e.getMessage());
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

    public List<Transacao> consultarTransacoes(int idCartao){
    	ConectaBD conexao = new ConectaBD();
    	String sql = "SELECT * FROM transacao WHERE idCartao = ?;";
    	
    	
    	List<Transacao> lista = new LinkedList<Transacao>();
    	try {
    		PreparedStatement frase = conexao.getConexao().prepareStatement(sql);
    		frase.setInt(1, idCartao);
    		ResultSet resultado = frase.executeQuery();
    		Transacao transacao;
    		while(resultado.next()) {
    			transacao = new Transacao();
    			String estabelecimento = resultado.getString("estabelecimento");
    			double valor = resultado.getDouble("valor");
    			
    			
    			transacao.setEstabelecimento(estabelecimento);
    			transacao.setValor(valor);
    			
    			 lista.add(transacao);
    			
    		}
    		
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	return lista;
    }
    
    
	

	
}
