import java.util.ArrayList;

public class Gerenciador {
    private ArrayList<Contato> contatos;

    public Gerenciador() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
        } else {
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
        }
    }

    public boolean contatoExiste(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public void atualizarContato(String nome, String novoNome, String novoTelefone, String novoEmail) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contato.setNome(novoNome);
                contato.setTelefone(novoTelefone);
                contato.setEmail(novoEmail);
                break;
            }
        }
    }

    public void deletarContato(String nome) {
        contatos.removeIf(contato -> contato.getNome().equalsIgnoreCase(nome));
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public Contato buscarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }
}
