package model.entiry;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cartao {
	private String numeroCartao;
	private LocalDate dataValidade;
	private double limiteCredito;
	private double saldoDisponivel;
	private String nomeAdicional;
	private ArrayList<Transacao> transacao;
	private int id;


	public Cartao(String numeroCartao, LocalDate dataDaquiTresAnos,double limite) {
		this.numeroCartao = numeroCartao;
		this.dataValidade = dataDaquiTresAnos;
		this.limiteCredito = limite;	
		transacao = new ArrayList<Transacao>();
	}
	
	public Cartao(String numeroCartao, LocalDate dataDaquiTresAnos,double limite, String nomeAdicional) {
		this.numeroCartao = numeroCartao;
		this.dataValidade = dataDaquiTresAnos;
		this.limiteCredito = limite;
		this.nomeAdicional = nomeAdicional;
		transacao = new ArrayList<Transacao>();
	}
	
	


	public int getId() {
		return id;
	}

	public void setTransacao(ArrayList<Transacao> transacao) {
		this.transacao = transacao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}


	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}


	public LocalDate getDataValidade() {
		return dataValidade;
	}


	public void setDataValidade(LocalDate dataValidade) {
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
	
	public void realizarTransacao(double valor, String estabelecimento) {
		if(valor>limiteCredito) {
			System.out.println("Transação recusada");
		}else {
			limiteCredito -= valor;
			System.out.println("Compra no valor de R$"+valor+" realizada com sucesso!");
			Transacao novaTransacao = new Transacao(valor, estabelecimento);
			transacao.add(novaTransacao);
		}
		
	}
	
	public void efetuarPagamento(double valor) {
		saldoDisponivel = saldoDisponivel + valor;
		System.out.println("O pagamneto no valor de"+ saldoDisponivel + "realizado com sucesso");
	}
	
	public double consultarSaldoDisponivel() {
		return saldoDisponivel;
	}

	public String getNomeAdicional() {
		return nomeAdicional;
	}

	public void setNomeAdicional(String nomeAdicional) {
		this.nomeAdicional = nomeAdicional;
	}

	public ArrayList<Transacao> getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao.add(transacao);
	}

	

}
