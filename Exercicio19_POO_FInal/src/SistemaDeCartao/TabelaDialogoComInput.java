package SistemaDeCartao;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.entiry.CartaoAcesso;
import model.entiry.Titular;

public class TabelaDialogoComInput {
	public static String leString2 (String outraCoisa) {
		String valor = JOptionPane.showInputDialog(null, outraCoisa);
		return valor;
	}
	
	public int leString3 (List<Titular> listaCartoes, String mensagem) {
		 // Dados iniciais da tabela

    	
        
        // Exemplo de iteração pela lista
        String[][] data = new String[listaCartoes.size()][3];
        int index = 0;

        for (Titular t : listaCartoes) {
        	int intId = t.getId();
        	String id = Integer.toString(intId);
			String nome = t.getNomeTitular();
			String documento= t.getDocumentoTitular();

            data[index] = new String[]{id, nome, documento};
            index++;
        }

        // Cabeçalhos das colunas
        String[] columnNames = {"Id", "Nome", "Documento"};

        // Criação do modelo da tabela
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Criação da tabela
        JTable table = new JTable(model);

        // Criação do painel de rolagem para a tabela
        JScrollPane scrollPane = new JScrollPane(table);

        /*
        // Criação do campo de entrada de texto
        JTextField textField = new JTextField(5);

        // Painel que contém tanto a tabela quanto o campo de entrada de texto
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        panel.add(new JLabel("Escolha cartão:"));
        panel.add(textField);
        
        

        // Exibe a caixa de diálogo personalizada
        int option = JOptionPane.showConfirmDialog(null, panel, "Usuários cadastrados",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        */
        
        
     // Criação do campo de entrada de texto
        JTextField textField = new JTextField(10);

        // Painel que contém a JLabel e o campo de entrada de texto
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel(mensagem));
        inputPanel.add(textField);

        // Painel principal que contém tanto a tabela quanto o painel de entrada
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(Box.createVerticalGlue(), BorderLayout.NORTH); // Adiciona um painel vazio no topo
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(inputPanel, BorderLayout.SOUTH);

        // Exibe a caixa de diálogo personalizada
        int option = JOptionPane.showConfirmDialog(null, panel, "Usuários cadastrados",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        String novoValorStr = null;
        int novoValor = 0;

        // Verifica se o botão OK foi pressionado
        if (option == JOptionPane.OK_OPTION) {
            novoValorStr = textField.getText();
            novoValor = Integer.parseInt(novoValorStr);
            System.out.println("Valor digitado: " + novoValor);
            // Lógica para adicionar o novo valor à tabela
            // Aqui, apenas adicionamos uma nova linha com o valor digitado
//            model.addRow(new Object[]{novoValor});
        }
        
//        // Verifica se o botão OK foi pressionado
//        if (option == JOptionPane.OK_OPTION) {
//            String novoValor = textField.getText();
//            // Lógica para adicionar o novo valor à tabela
//            // Aqui, apenas adicionamos uma nova linha com o valor digitado
//            model.addRow(new Object[]{novoValor});
//        }
		return novoValor;
	}
	
	public int leStringSemInputUsuarios (List<Titular> listaCartoes) {
		 // Dados iniciais da tabela

   	
       
       // Exemplo de iteração pela lista
       String[][] data = new String[listaCartoes.size()][3];
       int index = 0;

       for (Titular t : listaCartoes) {
       	int intId = t.getId();
       	String id = Integer.toString(intId);
			String nome = t.getNomeTitular();
			String documento= t.getDocumentoTitular();

           data[index] = new String[]{id, nome, documento};
           index++;
       }

       // Cabeçalhos das colunas
       String[] columnNames = {"Id", "Nome", "Documento"};

       // Criação do modelo da tabela
       DefaultTableModel model = new DefaultTableModel(data, columnNames);

       // Criação da tabela
       JTable table = new JTable(model);

       // Criação do painel de rolagem para a tabela
       JScrollPane scrollPane = new JScrollPane(table);

            
       
    // Criação do campo de entrada de texto
       JTextField textField = new JTextField(10);

       

       // Painel principal que contém tanto a tabela quanto o painel de entrada
       JPanel panel = new JPanel(new BorderLayout());
       panel.add(Box.createVerticalGlue(), BorderLayout.NORTH); // Adiciona um painel vazio no topo
       panel.add(scrollPane, BorderLayout.CENTER);
       

       // Exibe a caixa de diálogo personalizada
       int option = JOptionPane.showConfirmDialog(null, panel, "Usuários cadastrados",
               JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
       
       String novoValorStr = null;
       int novoValor = 0;

       // Verifica se o botão OK foi pressionado
       if (option == JOptionPane.OK_OPTION) {
           
           novoValor = 1;

       }else {
    	   novoValor = 0;
       }
       
       
       return novoValor;

		
	}
	
	
	public int leString4 (List<CartaoAcesso> listaCartoes, String mensagem) {
		 // Dados iniciais da tabela

   	
       
       // Exemplo de iteração pela lista
       String[][] data = new String[listaCartoes.size()][5];
       int index = 0;

       for (CartaoAcesso c : listaCartoes) {
       	int intId = c.getId();
       	String id = Integer.toString(intId);
       	
       	String numero = c.getNumeroCartao();
       	
       	Date validadeDate = c.getDataValidade();
       	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       	String validade = dateFormat.format(validadeDate);
       	
       	double doubleLimite= c.getLimiteCredito();
       	String limite = Double.toString(doubleLimite);
       	
		String nome = c.getNome();
			
			

           data[index] = new String[]{id, numero, validade, limite, nome};
           index++;
       }

       // Cabeçalhos das colunas
       String[] columnNames = {"Id", "Número Cartão", "Validade", "Limite", "Nome"};

       // Criação do modelo da tabela
       DefaultTableModel model = new DefaultTableModel(data, columnNames);

       // Criação da tabela
       JTable table = new JTable(model);

       // Criação do painel de rolagem para a tabela
       JScrollPane scrollPane = new JScrollPane(table);

       /*
       // Criação do campo de entrada de texto
       JTextField textField = new JTextField(5);

       // Painel que contém tanto a tabela quanto o campo de entrada de texto
       JPanel panel = new JPanel();
       panel.add(scrollPane);
       panel.add(new JLabel("Escolha cartão:"));
       panel.add(textField);
       
       

       // Exibe a caixa de diálogo personalizada
       int option = JOptionPane.showConfirmDialog(null, panel, "Usuários cadastrados",
               JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
       */
       
       
    // Criação do campo de entrada de texto
       JTextField textField = new JTextField(10);

       // Painel que contém a JLabel e o campo de entrada de texto
       JPanel inputPanel = new JPanel();
       inputPanel.add(new JLabel(mensagem));
       inputPanel.add(textField);

       // Painel principal que contém tanto a tabela quanto o painel de entrada
       JPanel panel = new JPanel(new BorderLayout());
       panel.add(Box.createVerticalGlue(), BorderLayout.NORTH); // Adiciona um painel vazio no topo
       panel.add(scrollPane, BorderLayout.CENTER);
       panel.add(inputPanel, BorderLayout.SOUTH);

       // Exibe a caixa de diálogo personalizada
       int option = JOptionPane.showConfirmDialog(null, panel, "Usuários cadastrados",
               JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
       
       String novoValorStr = null;
       int novoValor = 0;

       // Verifica se o botão OK foi pressionado
       if (option == JOptionPane.OK_OPTION) {
           novoValorStr = textField.getText();
           novoValor = Integer.parseInt(novoValorStr);
           System.out.println("Valor digitado: " + novoValor);
           // Lógica para adicionar o novo valor à tabela
           // Aqui, apenas adicionamos uma nova linha com o valor digitado
//           model.addRow(new Object[]{novoValor});
       }
       
//       // Verifica se o botão OK foi pressionado
//       if (option == JOptionPane.OK_OPTION) {
//           String novoValor = textField.getText();
//           // Lógica para adicionar o novo valor à tabela
//           // Aqui, apenas adicionamos uma nova linha com o valor digitado
//           model.addRow(new Object[]{novoValor});
//       }
		return novoValor;
	}
	
	
	public int leStringSemInputCartao (List<CartaoAcesso> listaCartoes) {
		 // Dados iniciais da tabela

  	
      
      // Exemplo de iteração pela lista
      String[][] data = new String[listaCartoes.size()][5];
      int index = 0;

      for (CartaoAcesso c : listaCartoes) {
      	int intId = c.getId();
      	String id = Integer.toString(intId);
      	
      	String numero = c.getNumeroCartao();
      	
      	Date validadeDate = c.getDataValidade();
      	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      	String validade = dateFormat.format(validadeDate);
      	
      	double doubleLimite= c.getLimiteCredito();
      	String limite = Double.toString(doubleLimite);
      	
		String nome = c.getNome();
			
			

          data[index] = new String[]{id, numero, validade, limite, nome};
          index++;
      }

      // Cabeçalhos das colunas
      String[] columnNames = {"Id", "Número Cartão", "Validade", "Limite", "Nome"};

   // Criação do modelo da tabela
      DefaultTableModel model = new DefaultTableModel(data, columnNames);

      // Criação da tabela
      JTable table = new JTable(model);

      // Criação do painel de rolagem para a tabela
      JScrollPane scrollPane = new JScrollPane(table);

           
      
   // Criação do campo de entrada de texto
      JTextField textField = new JTextField(10);

      

      // Painel principal que contém tanto a tabela quanto o painel de entrada
      JPanel panel = new JPanel(new BorderLayout());
      panel.add(Box.createVerticalGlue(), BorderLayout.NORTH); // Adiciona um painel vazio no topo
      panel.add(scrollPane, BorderLayout.CENTER);
      

      // Exibe a caixa de diálogo personalizada
      int option = JOptionPane.showConfirmDialog(null, panel, "Usuários cadastrados",
              JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
      
      String novoValorStr = null;
      int novoValor = 0;

      // Verifica se o botão OK foi pressionado
      if (option == JOptionPane.OK_OPTION) {
          
          novoValor = 1;

      }else {
   	   novoValor = 0;
      }
      
      
      return novoValor;
	}
	
	
	public int leStringSemLimite (List<CartaoAcesso> listaCartoes, String mensagem) {
		 // Dados iniciais da tabela

  	
      
      // Exemplo de iteração pela lista
      String[][] data = new String[listaCartoes.size()][5];
      int index = 0;

      for (CartaoAcesso c : listaCartoes) {
      	int intId = c.getId();
      	String id = Integer.toString(intId);
      	
      	String numero = c.getNumeroCartao();
      	
      	
		String nome = c.getNome();
			
			

          data[index] = new String[]{id, numero, nome};
          index++;
      }

      // Cabeçalhos das colunas
      String[] columnNames = {"Id", "Número Cartão", "Nome"};

      // Criação do modelo da tabela
      DefaultTableModel model = new DefaultTableModel(data, columnNames);

      // Criação da tabela
      JTable table = new JTable(model);

      // Criação do painel de rolagem para a tabela
      JScrollPane scrollPane = new JScrollPane(table);

      
      
      
   // Criação do campo de entrada de texto
      JTextField textField = new JTextField(10);

      // Painel que contém a JLabel e o campo de entrada de texto
      JPanel inputPanel = new JPanel();
      inputPanel.add(new JLabel(mensagem));
      inputPanel.add(textField);

      // Painel principal que contém tanto a tabela quanto o painel de entrada
      JPanel panel = new JPanel(new BorderLayout());
      panel.add(Box.createVerticalGlue(), BorderLayout.NORTH); // Adiciona um painel vazio no topo
      panel.add(scrollPane, BorderLayout.CENTER);
      panel.add(inputPanel, BorderLayout.SOUTH);

      // Exibe a caixa de diálogo personalizada
      int option = JOptionPane.showConfirmDialog(null, panel, "Usuários cadastrados",
              JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
      
      String novoValorStr = null;
      int novoValor = 0;

      // Verifica se o botão OK foi pressionado
      if (option == JOptionPane.OK_OPTION) {
          novoValorStr = textField.getText();
          novoValor = Integer.parseInt(novoValorStr);
          System.out.println("Valor digitado: " + novoValor);
          // Lógica para adicionar o novo valor à tabela
          // Aqui, apenas adicionamos uma nova linha com o valor digitado
//          model.addRow(new Object[]{novoValor});
      }
      
//      // Verifica se o botão OK foi pressionado
//      if (option == JOptionPane.OK_OPTION) {
//          String novoValor = textField.getText();
//          // Lógica para adicionar o novo valor à tabela
//          // Aqui, apenas adicionamos uma nova linha com o valor digitado
//          model.addRow(new Object[]{novoValor});
//      }
		return novoValor;
	}
	
	
    public static void main(String[] args) {
    	
    }
}
