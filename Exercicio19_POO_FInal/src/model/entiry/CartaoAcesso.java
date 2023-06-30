package model.entiry;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class CartaoAcesso {
	private String numeroCartao;
	private Date dataValidade;
	private double limiteCredito;
	private double saldoDisponivel;
	private String nome;
	private int id;


	
	
	public CartaoAcesso(int id, String numeroCartao, Date data,double limite, String nome) {
		this.id = id;
		this.numeroCartao = numeroCartao;
		this.dataValidade = data;
		this.limiteCredito = limite;
		this.nome = nome;
	}
	
	public CartaoAcesso() {
		
	}
	
	


	public int getId() {
		return id;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}


	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}


	public Date getDataValidade() {
		return dataValidade;
	}


	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}


	public double getLimiteCredito() {
		return limiteCredito;
	}


	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}


	public double getSaldoDisponivel() {
		return saldoDisponivel;
	}


	public void setSaldoDisponivel(double saldoDisponivel) {
		this.saldoDisponivel = saldoDisponivel;
	}
	
	
	public double consultarSaldoDisponivel() {
		return saldoDisponivel;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	

}
