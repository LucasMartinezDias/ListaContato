import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaGUI {
    private Gerenciador gerenciador;
    private JFrame frame;
    private JTextArea areaContatos;
    private JTextField nomeField, telefoneField, emailField;
    private JList<String> listaContatos;
    private DefaultListModel<String> modelContatos;

    public AgendaGUI() {
        gerenciador = new Gerenciador();
        criarJanelaPrincipal();
    }

    public void iniciar() {
        SwingUtilities.invokeLater(() -> {
            frame.setVisible(true);
        });
    }

    private void criarJanelaPrincipal() {
        frame = new JFrame("Agenda de Contatos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("Telefone:"));
        telefoneField = new JTextField();
        panel.add(telefoneField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnAtualizar = new JButton("Atualizar");

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String telefone = telefoneField.getText();
                String email = emailField.getText();
                gerenciador.adicionarContato(new Contato(nome, telefone, email));
                atualizarAreaContatos();
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeSelecionado = listaContatos.getSelectedValue();
                if (nomeSelecionado != null && gerenciador.contatoExiste(nomeSelecionado)) {
                    String novoNome = nomeField.getText();
                    String novoTelefone = telefoneField.getText();
                    String novoEmail = emailField.getText();

                    gerenciador.atualizarContato(nomeSelecionado, novoNome, novoTelefone, novoEmail);
                    atualizarAreaContatos();
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um contato válido para atualizar.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonPanel.add(btnAdicionar);
        buttonPanel.add(btnAtualizar);

        modelContatos = new DefaultListModel<>();
        listaContatos = new JList<>(modelContatos);
        listaContatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaContatos.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String contatoSelecionado = listaContatos.getSelectedValue();
                if (contatoSelecionado != null) {
                    Contato contato = gerenciador.buscarContato(contatoSelecionado);
                    if (contato != null) {
                        nomeField.setText(contato.getNome());
                        telefoneField.setText(contato.getTelefone());
                        emailField.setText(contato.getEmail());
                    }
                }
            }
        });

        JScrollPane scrollLista = new JScrollPane(listaContatos);
        panel.add(new JLabel("Contatos:"));
        panel.add(scrollLista);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void atualizarAreaContatos() {
        modelContatos.clear();
        for (Contato contato : gerenciador.getContatos()) {
            modelContatos.addElement(contato.getNome());
        }
    }
}
