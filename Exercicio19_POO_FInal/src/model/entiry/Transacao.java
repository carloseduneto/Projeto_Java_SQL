package model.entiry;

public class Transacao {
	private double valor;
	private String estabelecimento;


	public Transacao(double valor, String estabelecimento) {
		this.valor = valor;
		this.estabelecimento = estabelecimento;
	}
	public Transacao() {
	}

	

	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getEstabelecimento() {
		return estabelecimento;
	}


	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
	
	
	

}
