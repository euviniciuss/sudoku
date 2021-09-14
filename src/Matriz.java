import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Matriz {
    private int linhas;
    private int colunas;
    private int[][] matriz;
    private int escolha;
    private int linha_escolhida;
    private int coluna_escolhida;
    private boolean prosseguir;

    Scanner scan = new Scanner(System.in);

    public Matriz(){
      setLinhas(9);
      setColunas(9);
      setProsseguir(true);

      this.matriz = new int[getLinhas()][getColunas()];

      this.gerarMatriz();
    };

    // Getters E Setters
    public int getLinhas() {
      return this.linhas;
    }
    public void setLinhas(int li) {
      this.linhas = li;
    }

    public int getColunas() {
      return this.colunas;
    }
    public void setColunas(int co) {
      this.colunas = co;
    }

    public int getEscolha() {
        return escolha;
    }
    public void setEscolha(int escolha) {
        this.escolha = escolha;
    }

    public int getLinha_escolhida() {
        return linha_escolhida;
    }
    public void setLinha_escolhida(int linha_escolhida) {
        this.linha_escolhida = linha_escolhida;
    }

    public int getColuna_escolhida() {
        return coluna_escolhida;
    }
    public void setColuna_escolhida(int coluna_escolhida) {
        this.coluna_escolhida = coluna_escolhida;
    }

    public boolean getProsseguir() {
        return prosseguir;
    }
    public void setProsseguir(boolean prosseguir) {
        this.prosseguir = prosseguir;
    }

    // Métodos
    public void jogada() {
        System.out.println("----- Suas opções -----");
        System.out.println("[1] Adicionar um número ");
        System.out.println("[2] Remover um número ");
        System.out.println("[3] Ver tabuleiro ");
        System.out.println("[4] Parar de jogar");
        System.out.print("Oque você deseja fazer? ");
        this.escolha = scan.nextInt();

        if (this.escolha == 1){
            addNumber();
        } else if (this.escolha == 2) {
            removeNumber();
        } else if (this.escolha == 3) {
            imprimirMatriz();
        } else if (this.escolha == 4) {
            System.out.println("================================");
            System.out.println("      Encerrando o jogo       ");
            System.out.println("================================");
            setProsseguir(false);
        } else {
            System.out.println("Escolha Inválida! Tente Novamente!");
        };

    };

    public void addNumber() {
        System.out.print("Informe a linha em que você deseja adicionar o número: ");
        this.linha_escolhida = scan.nextInt();
        System.out.print("Informe a coluna em que você deseja adicionar o número: ");
        this.coluna_escolhida = scan.nextInt();

        System.out.print("Informe o número que quer adicionar: ");
        this.escolha = scan.nextInt();

        if (matriz[getLinha_escolhida()][getColuna_escolhida()] == 0) {
            this.matriz[getLinha_escolhida()][getColuna_escolhida()] = escolha;
            System.out.println("================================");
            System.out.println(" Número adicionado com sucesso! ");
            System.out.println("================================");
            imprimirMatriz();
        } else {
            System.out.println("Este lugar já está preenchido! Tente novamente");
        };

    };

    public void removeNumber() {
        System.out.print("Informe a linha em que você deseja remover o número: ");
        this.linha_escolhida = scan.nextInt();
        System.out.print("Informe a coluna em que você deseja remover o número: ");
        this.coluna_escolhida = scan.nextInt();

        if (matriz[getLinha_escolhida()][getColuna_escolhida()] != 0) {
            this.matriz[getLinha_escolhida()][getColuna_escolhida()] = 0;
            System.out.println("================================");
            System.out.println("  Número removido com sucesso!  ");
            System.out.println("================================");
            imprimirMatriz();
        } else {
            System.out.println("Este lugar já está preenchido! Tente novamente");
        };


    };

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
        System.out.println("Criando uma nova matriz...");
        this.gerarMatriz();
    };

};
