package SistemaDeCartao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.dao.CartaoDAO;
import model.dao.TitularDAO;
import model.dao.TransacaoDAO;
import model.entiry.Cartao;
import model.entiry.CartaoAcesso;
import model.entiry.Titular;
import model.entiry.Transacao;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	//Fazer polimorfismo
	public static String leString() {
		Scanner input = new Scanner(System.in);
		//System.out.print(">> ");
		return input.nextLine();
	}
	
	
	
	//O emitir vai ficar aqui no Main
	//
	
	public static void mensagemConfirmacao(String mensagem, int tamanhoFonte) {
		Color corFonte = Color.GREEN;
	    UIManager.put("OptionPane.messageFont", UIManager.getFont("Label.font").deriveFont((float) tamanhoFonte));
	    UIManager.put("Label.foreground", corFonte);

	    JOptionPane.showMessageDialog(null, mensagem);

	    UIManager.put("OptionPane.messageFont", UIManager.getFont("Label.font")); // redefinindo o tamanho da fonte para o valor padrão
	    UIManager.put("Label.foreground", null); // redefinindo a cor da fonte para o valor padrão
	}
	
	public static String leString2 (String outraCoisa) {
		String valor = JOptionPane.showInputDialog(null, outraCoisa);
		return valor;
	}
	
	public static int metodoConsultarTodosTitulares(String mensagem) {
		TitularDAO pessoaDAO01 = new TitularDAO();
		List<Titular> listaPessoas = pessoaDAO01.consultarTudo();
		TabelaDialogoComInput exibir = new TabelaDialogoComInput();
		int opcao = 0;
		if(!listaPessoas.isEmpty()) {
			opcao = exibir.leString3(listaPessoas, mensagem);

			}else{
				mensagemConfirmacao("Não há registros!", 16);
		}
		return opcao;
	}
	public static int metodoConsultarTodosTitularesSemInput() {
		TitularDAO pessoaDAO01 = new TitularDAO();
		List<Titular> listaPessoas = pessoaDAO01.consultarTudo();
		TabelaDialogoComInput exibir = new TabelaDialogoComInput();
		int opcao = 0;
		if(!listaPessoas.isEmpty()) {
			opcao = exibir.leStringSemInputUsuarios(listaPessoas);
			
		}else{
			mensagemConfirmacao("Não há registros!", 16);
		}
		return opcao;
	}
	
	public static void metodoExibirLimite(double limite) {
	    String saida = "";
	    saida += "O limite atual: R$";
	    String strLimite = String.valueOf(limite);
	    saida += strLimite;
	    mensagemConfirmacao("Limite do Cartão R$"+strLimite, 16);;
	}

	
	public static int metodoExibirCartoes(int idTitular, String mensagem) {
		CartaoDAO cartaoDAO = new CartaoDAO();
		List<CartaoAcesso> cartoes = cartaoDAO.consultarCartoesTitulares(idTitular);
		TabelaDialogoComInput exibir = new TabelaDialogoComInput();
		int opcao = 0;
	
		if(!cartoes.isEmpty()) {
			opcao = exibir.leString4(cartoes, mensagem);
		}else {
			mensagemConfirmacao("Não há registros!", 16);
		}
		return opcao;
		
			}
	
	public static int metodoExibirCartoesSemInput(int idTitular) {
		CartaoDAO cartaoDAO = new CartaoDAO();
		List<CartaoAcesso> cartoes = cartaoDAO.consultarCartoesTitulares(idTitular);
		TabelaDialogoComInput exibir = new TabelaDialogoComInput();
		int opcao = 0;
	
		if(!cartoes.isEmpty()) {
			opcao = exibir.leStringSemInputCartao(cartoes);
		}else {
			mensagemConfirmacao("Não há registros!", 16);
		}
		return opcao;
		
			}
	
	public static int metodoExibirCartoesSemLimite(int idTitular, String mensagem) {
		CartaoDAO cartaoDAO = new CartaoDAO();
		List<CartaoAcesso> cartoes = cartaoDAO.consultarCartoesTitulares(idTitular);
		TabelaDialogoComInput exibir = new TabelaDialogoComInput();
		int opcao = 0;
	
		if(!cartoes.isEmpty()) {
			opcao = exibir.leStringSemLimite(cartoes, mensagem);
		}else {
			mensagemConfirmacao("Não há registros!", 16);
		}
		return opcao;
		
			}
	
		
	public static double metodoConsultaGastos(int idCartao) {
		TransacaoDAO transacao = new TransacaoDAO();
		List<Transacao> cartoes = transacao.consultarGastos(idCartao);
		
		
		double saida = 0;
		if(!cartoes.isEmpty()) {
			
		for(Transacao t: cartoes) {
			saida += t.getValor();
			
		
			
		}}else {
			saida = 0;
		}
		
		return saida;
		
			}
	
	public static void metodoExibirTransacaoes(int idCartao) {
		TransacaoDAO transacaoDAO = new TransacaoDAO();
		List<Transacao> transacoes = transacaoDAO.consultarTransacoes(idCartao);
		
		System.out.println(transacoes);
		
		String saida = "";
		if(!transacoes.isEmpty()) {
			saida += "Valor\t"+"Estabelecimento\t"+"\n";
			for(Transacao t: transacoes) {
				saida += t.getValor()+"\t";
				saida += t.getEstabelecimento()+"\n";
				
				
			}}else {
				saida = "Não há transações registradas!!!";
			}
		JOptionPane.showMessageDialog(null, new JTextArea(saida));
		
	}
	
	public static void metodoExibirCartoes2(int idTitular) {
		CartaoDAO cartaoDAO = new CartaoDAO();
		List<CartaoAcesso> cartoes = cartaoDAO.consultarCartoesTitulares(idTitular);
		
		String saida = "";
		if(!cartoes.isEmpty()) {
			saida += "ID\t"+"Nome\t"+"Número\t"+"\n";
			for(CartaoAcesso c: cartoes) {
				saida += c.getId()+"\t";
				saida += c.getNome()+"\t";
				saida += c.getNumeroCartao()+ "\n";
				
			}}else {
				saida = "Não há registros!!!";
			}
		JOptionPane.showMessageDialog(null, new JTextArea(saida));
		
	}


	public static void main(String[] args) {
		ArrayList<Titular> titulares = new ArrayList<Titular>(); 
		int opcao;
		
		do {
			String strOpcao = leString2(
					"💳 MENU CARTÃO\n"+
					"1- Cadastrar usuário\n"+
					"2- Emitir Cartão\n"+
					"3- Emitir Cartão adicional\n"+
					"4- Consultar Usuários\n"+
					"5- Consultar Cartões\n"+
					"6- Consultar Limite\n"+
					"7- Realizar Transação\n"+
					"8- Consultar Transações\n"+
					"9- Pagar Fatura\n"+
					"0- Sair\n"+
					"Digite: "
					);
			opcao = Integer.parseInt(strOpcao);
			
			switch (opcao) {
			case 1: {
				String nome = leString2("Insira o nome do titular: ");
				String documento = leString2("Insira o documento titular: ");
				Titular novoTitular = new Titular(nome, documento);
				
				
				TitularDAO titularDAO01 = new TitularDAO();
				titularDAO01.inserir(novoTitular);
				
				/*titulares.add(novoTitular);*/
				String mensagem = nome + " cadastrado com sucesso!!!";
				mensagemConfirmacao(mensagem , 16);
				
				
				System.out.println("Usuários cadastrados:");
				for (Titular t : titulares) {
					System.out.println("\u001B[34m"+t.getNomeTitular()+"\u001B[0m");
				}
				System.out.println(" ");
			break;
			}
			
			case 2:{
				
//				String idStr = leString2("Digite id: ");
//				int intUsuario = Integer.parseInt(idStr);
				int intUsuario = metodoConsultarTodosTitulares("Escolha o usuário: ");
				
				TitularDAO titularDAO01 = new TitularDAO();
				String nome = titularDAO01.consultarNome(intUsuario);
					
				Titular titular = new Titular();
				String limite = leString2("Insira o limite do cartão: ");
				Double doubleLimite = Double.parseDouble(limite);
				Cartao cartao = titular.criarCartao(doubleLimite, intUsuario, nome);
			
				String mensagem = "☑️ Cartão cadastrado com sucesso!!!";
				
				mensagemConfirmacao(mensagem, 16);
				break;
						
			}
			
			case 3:{
				
//				String idStr = leString2("Digite id: ");
//				int intUsuario = Integer.parseInt(idStr);
				int intUsuario = metodoConsultarTodosTitulares("Escolha o titular: ");
				
				TitularDAO titularDAO01 = new TitularDAO();
				Titular titular = new Titular();
				String limite = leString2("Insira o limite do cartão: ");
				Double doubleLimite = Double.parseDouble(limite);
				String nomeAdicional = leString2("Insira o nome do dependente:");				
				Cartao cartao = titular.criarCartao(doubleLimite, intUsuario, nomeAdicional);
				mensagemConfirmacao("Cartão adicionado com sucesso", 16);
				break;
			}
			
			case 4:{				
				metodoConsultarTodosTitularesSemInput();
				
				break;
			}
			
			case 5:{
				int intUsuario = metodoConsultarTodosTitulares("Escolha o usuário para consultar o cartão: ");
				
				metodoExibirCartoesSemInput(intUsuario);
				break;
			}
			
			
			case 6:{
				
//				String idStr = leString2("Escolha o usuário: ");
//				int intUsuario = Integer.parseInt(idStr);
				int intUsuario = metodoConsultarTodosTitulares("Escolha o usuário: ");
				
				

				int idCartao = metodoExibirCartoesSemLimite(intUsuario, "Escolha o cartão: ");
				
				CartaoDAO cartao = new CartaoDAO();
				double limite = cartao.consultarLimite(idCartao);
				metodoExibirLimite(limite);
				break;
			}
			
			
			case 7:{
				
				
//				String idStr = leString2("Escolha o usuário que fará o pagamento: ");
//				int intUsuario = Integer.parseInt(idStr);
				int intUsuario = metodoConsultarTodosTitulares("Escolha o usuário que fará o pagamento: ");
				
				
//				String idCartaoStr = leString2();
//				int idCartao = Integer.parseInt(idCartaoStr);
				int idCartao = metodoExibirCartoes(intUsuario,"Qual cartão será usado para fazer o pagamento?");
				
				String valorStr = leString2("Valor da compra:");
				double valor = Double.parseDouble(valorStr);
				String lugar = leString2("Estabelecimento:");
				CartaoDAO cartao = new CartaoDAO();
				double limite = cartao.consultarLimite(idCartao);
				if(limite == 0 || limite < valor) {
					mensagemConfirmacao("Transação não aceita", 16);
				}else {					
					TransacaoDAO transacao01 = new TransacaoDAO();
					transacao01.inserir(null, idCartao, lugar, valor);
					double novoLimite = limite - valor;		
					cartao.atualizarlimitinho(novoLimite, idCartao);
					mensagemConfirmacao("Transação aceita", 16);
				}
				break;
				
			}
			
		    case 8:{
		    	
//		    	String idStr = leString2("Escolha o usuário: ");
//		    	int intUsuario = Integer.parseInt(idStr);
		    	int intUsuario = metodoConsultarTodosTitulares("Escolha o usuário: ");
		    	
		    	
//		    	String idCartaoStr = leString2();
		    	int idCartao = metodoExibirCartoes(intUsuario,"Escolha o cartão: ");
		    	
		    	TransacaoDAO transacao = new TransacaoDAO();
		    	metodoExibirTransacaoes(idCartao);
		    	break;
		    }

			
			
			case 9:{
				int intUsuario = metodoConsultarTodosTitulares("Escolha o usuário: ");
		    	
		    	
//		    	String idCartaoStr = leString2();
		    	int idCartao = metodoExibirCartoes(intUsuario, "Escolha o cartão: ");
		    	CartaoDAO cartao = new CartaoDAO();
				double limite = cartao.consultarLimite(idCartao);
				double valorGasto = metodoConsultaGastos(idCartao);
				double total = limite + valorGasto;
				String escolha = leString2("Deseja Pagar Fatura\n"+
								"Valor Fatura R$"+valorGasto
								+"\n1-SIM"+"\n2-NÃO");
				int intOpcaoCartao = Integer.parseInt(escolha);
				
				if(intOpcaoCartao == 1) {
					cartao.atualizarlimitinho(total, idCartao);
					TransacaoDAO transacao = new TransacaoDAO();
					transacao.excluir(idCartao);
					mensagemConfirmacao("Fatura Paga!", 16);
					
				}else {
					mensagemConfirmacao("Reiniciando!", 16);
				}
				
				break;
			}
		
			default:
				System.out.println("Opção inválida!!!");
			}
			
		
			
		} while (opcao != 0);

	}

}

