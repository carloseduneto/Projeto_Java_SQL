package model.entiry;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import SistemaDeCartao.GeradorDeString;
import model.dao.CartaoDAO;

public class Titular {
	private String nomeTitular;
	private String documentoTitular;
	private ArrayList<Cartao> cartoes;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCartoes(ArrayList<Cartao> cartoes) {
		this.cartoes = cartoes;
	}

	public Titular(String nomeTitular, String documentoTitular) {
		this.nomeTitular = nomeTitular;
		this.documentoTitular = documentoTitular;
		cartoes = new ArrayList<Cartao>();
	}
	
	public Titular() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Cartao criarCartao (double limite, int idTitular, String nome) {
		GeradorDeString numero = new GeradorDeString();
		String numeroDoCartao = numero.gerarStringAleatoria(16);
		System.out.println(numeroDoCartao);
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataDaquiTresAnos = dataAtual.plusYears(3);
		Cartao novoCartao = new Cartao(numeroDoCartao, dataDaquiTresAnos, limite);
		CartaoDAO cartaoDAO01 = new CartaoDAO();
		cartaoDAO01.inserir(novoCartao, idTitular, nome, limite);
		return novoCartao;
	}
	
	public Cartao criarCartaoAdicional (double limite, int idTitular,String nomeAdicional) {
		GeradorDeString numero = new GeradorDeString();
		String numeroDoCartao = numero.gerarStringAleatoria(16);
		System.out.println(numeroDoCartao);
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataDaquiTresAnos = dataAtual.plusYears(3);
		
		Cartao cartaoAdicional = new Cartao(numeroDoCartao, dataDaquiTresAnos, limite, nomeAdicional);
		
		CartaoDAO cartaoDAO01 = new CartaoDAO();
		cartaoDAO01.inserir(cartaoAdicional, idTitular, nomeAdicional, limite);
		return cartaoAdicional;
		
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public ArrayList<Cartao> getCartoes() {
		return cartoes;
	}

	public void setCartoes(Cartao cartao) {
		this.cartoes.add(cartao);
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getDocumentoTitular() {
		return documentoTitular;
	}

	public void setDocumentoTitular(String documentoTitular) {
		this.documentoTitular = documentoTitular;
	}

	public String getCpf() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
