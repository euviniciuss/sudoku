public class Main {
    public static void main(String[] args) {
        Matriz sudoku = new Matriz();
        User usuario = new User();

        usuario.perguntarNome();

        System.out.println("Está é o tabuleiro gerado para você jogar!");
        sudoku.imprimirMatriz();

        System.out.println(" ");

        while (true) {
            sudoku.jogada();
            if (sudoku.getProsseguir() == false) {
                break;
            };
        }

        System.out.println("===========================================================");
        System.out.println("Muito obrigado por jogar conosco " + usuario.getNome() + "!");
        System.out.println("===========================================================");

    }
}
