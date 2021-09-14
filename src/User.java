import java.util.Scanner;

public class User {
    private String nome;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void perguntarNome() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Qual o nome do nosso jogador(a)? ");
        String user_nome = scan.nextLine();

        this.nome = user_nome;
    };

    public void imprimirNome() {
        System.out.println(this.nome);
    };
}
