import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Random gerador = new Random();

        final int qtd_linha = 3;
        final int qtd_coluna = 3;
        int[][] tabela = new int[qtd_linha][qtd_coluna];

        ArrayList<Integer> historic_elements = new ArrayList<>();

        for (int linha = 0; linha < qtd_linha; linha++) {
            System.out.println("----------------------------");
            for (int coluna = 0; coluna < qtd_coluna; coluna++) {
                int linha_aleatoria = gerador.nextInt(qtd_linha); // linha
                int coluna_aleatoria = gerador.nextInt(qtd_coluna); // coluna
                int numero_aleatorio = gerador.nextInt(9); // numero

                if (historic_elements.indexOf(numero_aleatorio) < 0) {
                    tabela[linha_aleatoria][coluna_aleatoria] = numero_aleatorio;
                    historic_elements.add(numero_aleatorio);

                    System.out.print("linha: " + linha_aleatoria);
                    System.out.print(", coluna: " + linha_aleatoria);
                    System.out.println(", numero: " + numero_aleatorio);
                };

            };
        };

        System.out.println(Arrays.toString(tabela[0]));
        System.out.println(Arrays.toString(tabela[1]));
        System.out.println(Arrays.toString(tabela[2]));
    }
}
