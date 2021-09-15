import java.util.Scanner;

public class Matriz {
    private int linhas;
    private int colunas;
    private int[][] inicio_matriz;
    private int[][] matriz;
    private int[][] gabarito;
    private int escolha;
    private int linha_escolhida;
    private int coluna_escolhida;
    private boolean prosseguir;

    Scanner scan = new Scanner(System.in);

    public Matriz(){
      setLinhas(9);
      setColunas(9);
      setProsseguir(true);

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
            System.out.println("==================================");
            System.out.println("Escolha Inválida! Tente Novamente!");
            System.out.println("==================================");
        };

    };

    public void addNumber() {
        System.out.print("Informe a linha em que você deseja adicionar o número: ");
        this.linha_escolhida = scan.nextInt();
        System.out.print("Informe a coluna em que você deseja adicionar o número: ");
        this.coluna_escolhida = scan.nextInt();

        System.out.print("Informe o número que quer adicionar: ");
        this.escolha = scan.nextInt();

        if ((this.matriz[getLinha_escolhida()][getColuna_escolhida()] == 0) ) {
            if (escolha == this.gabarito[getLinha_escolhida()][getColuna_escolhida()]) {
                this.matriz[getLinha_escolhida()][getColuna_escolhida()] = escolha;

                System.out.println("================================");
                System.out.println(" Número adicionado com sucesso! ");
                System.out.println("================================");
                imprimirMatriz();
            } else {
                System.out.println("============================================================================================");
                System.out.println("A sua escolha de número é inválida de acordo com as regras do jogo! Tente com outro número!");
                System.out.println("============================================================================================");
            };
        } else {
            System.out.println("===============================================");
            System.out.println("Este lugar já está preenchido! Tente novamente");
            System.out.println("===============================================");
        };

    };

    public void removeNumber() {
        System.out.print("Informe a linha em que você deseja remover o número: ");
        this.linha_escolhida = scan.nextInt();
        System.out.print("Informe a coluna em que você deseja remover o número: ");
        this.coluna_escolhida = scan.nextInt();

        if (matriz[getLinha_escolhida()][getColuna_escolhida()] != 0) {
            if (inicio_matriz[getLinha_escolhida()][getColuna_escolhida()] == 0) {
                this.matriz[getLinha_escolhida()][getColuna_escolhida()] = 0;
                System.out.println("================================");
                System.out.println("  Número removido com sucesso!  ");
                System.out.println("================================");
                imprimirMatriz();
            } else {
                System.out.println("======================================================");
                System.out.println("Você não pode remover um número previamente atribuído!");
                System.out.println("======================================================");
            };
        } else {
            System.out.println("==============================================");
            System.out.println("Este lugar já está preenchido! Tente novamente");
            System.out.println("==============================================");
        };


    };

    private void gerarMatriz() {
        this.inicio_matriz = new int[][] {
                {9,4,0, 1,0,2, 0,5,8},
                {6,0,0, 0,5,0, 0,0,4},
                {0,0,2, 4,0,3, 1,0,0},
                {0,2,0, 0,0,0, 0,6,0},
                {5,0,8, 0,2,0, 4,0,1},
                {0,6,0, 0,0,0, 0,8,0},
                {0,0,1, 6,0,8, 7,0,0},
                {7,0,0, 0,4,0, 0,0,3},
                {4,3,0, 5,0,9, 0,1,2}
        };

        this.matriz = new int[][] {
            {9,4,0, 1,0,2, 0,5,8},
            {6,0,0, 0,5,0, 0,0,4},
            {0,0,2, 4,0,3, 1,0,0},
            {0,2,0, 0,0,0, 0,6,0},
            {5,0,8, 0,2,0, 4,0,1},
            {0,6,0, 0,0,0, 0,8,0},
            {0,0,1, 6,0,8, 7,0,0},
            {7,0,0, 0,4,0, 0,0,3},
            {4,3,0, 5,0,9, 0,1,2}
        };

        this.gabarito = new int[][] {
                {9,4,7, 1,6,2, 3,5,8},
                {6,1,3, 8,5,7, 9,2,4},
                {8,5,2, 4,9,3, 1,7,6},
                {1,2,9, 3,8,4, 5,6,7},
                {5,7,8, 9,2,6, 4,3,1},
                {3,6,4, 7,1,5, 2,8,9},
                {2,9,1, 6,3,8, 7,4,5},
                {7,8,5, 2,4,1, 6,9,3},
                {4,3,6, 5,7,9, 8,1,2}
        };

    }

    public void imprimirMatriz(){
        for ( int l = 0 ; l < this.linhas ; l++ ) {
            for ( int c = 0 ; c < this.colunas ; c++ ) {
                System.out.print( matriz[l][c] + "\t" );
            }
            System.out.println();
        }
    }

};
