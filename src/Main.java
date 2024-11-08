import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gerenciador gerenciador = new Gerenciador();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nSistema de Agenda de Contatos");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Listar contatos");
            System.out.println("3. Atualizar contato");
            System.out.println("4. Deletar contato");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();
                    gerenciador.adicionarContato(new Contato(nome, telefone, email));
                    break;
                case 2:
                    gerenciador.listarContatos();
                    break;
                case 3:
                    System.out.print("Digite o nome do contato a ser atualizado: ");
                    String nomeParaAtualizar = scanner.nextLine();
                    gerenciador.atualizarContato(nomeParaAtualizar);
                    break;
                case 4:
                    System.out.print("Digite o nome do contato a ser deletado: ");
                    String nomeParaDeletar = scanner.nextLine();
                    gerenciador.deletarContato(nomeParaDeletar);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0); // Adicionada chave de fechamento aqui

        scanner.close();
    }
}
