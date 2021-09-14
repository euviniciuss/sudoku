import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Random gerador = new Random();

        final int qtd_linha = 9;
        final int qtd_coluna = 9;
        int[][] tabela = new int[qtd_linha][qtd_coluna];

        ArrayList<Integer> historic_elements = new ArrayList<>();

        int linha_aleatoria = 0;
        int coluna_aleatoria = 0;

        for (int quadrante = 1; quadrante <= 9; quadrante++) {
            historic_elements.clear();
            for (int linha = 0; linha <= 2; linha++) {
                for (int coluna = 0; coluna <= 2; coluna++) {
                    // Verificando qual quadrante é para atribuir números a linhas e colunas
                    if (quadrante == 1) {
                        linha_aleatoria = gerador.nextInt(2);  // gerar linha de 0 a 2;
                        coluna_aleatoria = gerador.nextInt(2); // gerar coluna de 0 a 2;
                    } else if (quadrante == 2) {
                        linha_aleatoria = gerador.nextInt(2); // gerar linha de 0 a 2
                        coluna_aleatoria = gerador.nextInt(3) + 3; // gerar coluna de 3 a 5
                    } else if (quadrante == 3) {
                        linha_aleatoria = gerador.nextInt(2);  // gerar linha de 0 a 2
                        coluna_aleatoria = gerador.nextInt(3) + 6; // gerar coluna de 6 a 8
                    } else if (quadrante == 4) {
                        linha_aleatoria = gerador.nextInt(3) + 3; // gerar linha de 3 a 5;
                        coluna_aleatoria = gerador.nextInt(2); // gerar coluna de 0 a 2;
                    } else if (quadrante == 5) {
                        linha_aleatoria = gerador.nextInt(3) + 3; // gerar linha de 3 a 5;
                        coluna_aleatoria = gerador.nextInt(3) + 3; // gerar coluna de 3 a 5
                    } else if (quadrante == 6) {
                        linha_aleatoria = gerador.nextInt(3) + 3; // gerar linha de 3 a 5;
                        coluna_aleatoria = gerador.nextInt(3) + 6; // gerar coluna de 6 a 8
                    } else if (quadrante == 7) {
                        linha_aleatoria = gerador.nextInt(3) + 6; // gerar linha de 6 a 8;
                        coluna_aleatoria = gerador.nextInt(2); // gerar coluna de 0 a 2;
                    } else if (quadrante == 8) {
                        linha_aleatoria = gerador.nextInt(3) + 6; // gerar linha de 6 a 8;
                        coluna_aleatoria = gerador.nextInt(3) + 3; // gerar coluna de 3 a 5
                    } else if (quadrante == 9) {
                        linha_aleatoria = gerador.nextInt(3) + 6; // gerar linha de 6 a 8;
                        coluna_aleatoria = gerador.nextInt(3) + 6; // gerar linha de 6 a 8;
                    } else {
                        System.out.println("Inválido!");
                    };

                    int numero_aleatorio = gerador.nextInt(10);

                    if (historic_elements.indexOf(numero_aleatorio) < 0) {
                        tabela[linha_aleatoria][coluna_aleatoria] = numero_aleatorio;
                        historic_elements.add(numero_aleatorio);
                    };
                };
            };
        };

        System.out.println(Arrays.toString(tabela[0]));
        System.out.println(Arrays.toString(tabela[1]));
        System.out.println(Arrays.toString(tabela[2]));
        System.out.println(Arrays.toString(tabela[3]));
        System.out.println(Arrays.toString(tabela[4]));
        System.out.println(Arrays.toString(tabela[5]));
        System.out.println(Arrays.toString(tabela[6]));
        System.out.println(Arrays.toString(tabela[7]));
        System.out.println(Arrays.toString(tabela[8]));
        // System.out.println("*----------------------------*");
    };

}
