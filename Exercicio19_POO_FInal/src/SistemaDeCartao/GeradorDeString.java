package SistemaDeCartao;

import java.util.Random;

public class GeradorDeString {
    public static void main(String[] args) {
        String stringAleatoria = gerarStringAleatoria(16);
        System.out.println(stringAleatoria);
    }

    public static String gerarStringAleatoria(int tamanho) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            int digito = random.nextInt(10); // Gera um número aleatório de 0 a 9
            sb.append(digito);
        }

        return sb.toString();
    }
}
