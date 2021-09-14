import java.util.ArrayList;
import java.util.Random;

public class Matriz {
    private int linhas;
    private int colunas;
    private int[][] matriz;

    public Matriz(){
      setLinhas(9);
      setColunas(9);

      this.matriz = new int[getLinhas()][getColunas()];

      this.gerarMatriz();
    };

    // Linhas
    public int getLinhas() {
      return this.linhas;
    }
    public void setLinhas(int li) {
      this.linhas = li;
    }

    //Colunas
    public int getColunas() {
      return this.colunas;
    }
    public void setColunas(int co) {
      this.colunas = co;
    }

    private void gerarMatriz() {
      Random gerador = new Random();

      ArrayList<Integer> historic_elements = new ArrayList<>();

      int linha_aleatoria = 0;
      int coluna_aleatoria = 0;

      // gerar matriz
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
            }

            int numero_aleatorio = gerador.nextInt(10);

            if (historic_elements.indexOf(numero_aleatorio) < 0) {
              this.matriz[linha_aleatoria][coluna_aleatoria] = numero_aleatorio;
              historic_elements.add(numero_aleatorio);
            }
          }
        }
      }

    }

    public void imprimirMatriz(){
        for ( int l = 0 ; l < this.linhas ; l++ ) {
            for ( int c = 0 ; c < this.colunas ; c++ ) {
                System.out.print( matriz[l][c] + "\t" );
            }
            System.out.println();
        }
    }

    public void resetarMatriz() {
      this.gerarMatriz();
    };

};
