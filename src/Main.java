import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        System.out.println("Escolha o modo de uso do programa:");
        System.out.println("1. Versão Console");
        System.out.println("2. Versão GUI");
        System.out.print("Escolha uma opção: ");

        while (true) {
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
                scanner.nextLine();
            }
        }

        switch (opcao) {
            case 1:
                rodarVersaoConsole();
                break;
            case 2:
                AgendaGUI gui = new AgendaGUI();
                gui.iniciar();
                break;
            default:
                System.out.println("Opção inválida! Saindo...");
                break;
        }

        scanner.close();
    }

    public static void rodarVersaoConsole() {
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
            while (!scanner.hasNextInt()) {
                System.out.println("Opção inválida! Insira um número.");
                scanner.nextLine();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();
                    gerenciador.adicionarContato(new Contato(nome, telefone, email));
                    System.out.println("Contato adicionado com sucesso!");
                    break;
                case 2:
                    gerenciador.listarContatos();
                    break;
                case 3:
                    System.out.print("Digite o nome do contato a ser atualizado: ");
                    String nomeParaAtualizar = scanner.nextLine();
                    if (gerenciador.contatoExiste(nomeParaAtualizar)) {
                        System.out.print("Digite o novo nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Digite o novo telefone: ");
                        String novoTelefone = scanner.nextLine();
                        System.out.print("Digite o novo email: ");
                        String novoEmail = scanner.nextLine();


                        gerenciador.atualizarContato(nomeParaAtualizar, novoNome, novoTelefone, novoEmail);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
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
        } while (opcao != 0);

        scanner.close();
    }
}
