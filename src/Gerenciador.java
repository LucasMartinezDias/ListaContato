import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gerenciador {
    private List<Contato> contatos = new ArrayList<>();

    // Método para adicionar um contato
    public void adicionarContato(Contato contato) {
        contatos.add(contato);
        System.out.println("Contato adicionado com sucesso!");
    }

    // Método para listar todos os contatos
    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
        } else {
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
        }
    }

    // Método para atualizar um contato pelo nome
    public void atualizarContato(String nome) {
        Contato contato = buscarContatoPorNome(nome);
        if (contato != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o novo nome:");
            contato.setNome(scanner.nextLine());
            System.out.println("Digite o novo telefone:");
            contato.setTelefone(scanner.nextLine());
            System.out.println("Digite o novo email:");
            contato.setEmail(scanner.nextLine());
            System.out.println("Contato atualizado com sucesso!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    // Método para deletar um contato pelo nome
    public void deletarContato(String nome) {
        Contato contato = buscarContatoPorNome(nome);
        if (contato != null) {
            contatos.remove(contato);
            System.out.println("Contato deletado com sucesso!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    // Método auxiliar para encontrar um contato pelo nome
    private Contato buscarContatoPorNome(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }
}
