import javax.swing.*;
import java.awt.*;

public class Apagar extends JPanel {
    public Apagar(Estrutura estrutura) {
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Remover registro");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        DefaultListModel<String> model = new DefaultListModel<>();

        for (String nome : Estrutura.dados) {
            model.addElement(nome);
        }

        JList<String> lista = new JList<>(model);

        JButton btnRemover = new JButton("Remover");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel botoes = new JPanel();
        botoes.add(btnRemover);
        botoes.add(btnCancelar);

        btnRemover.addActionListener(e -> {
            int index = lista.getSelectedIndex();

            if (index != -1) {
                Estrutura.dados.remove(index);
                estrutura.carregarLista();
            }
        });

        btnCancelar.addActionListener(e -> estrutura.carregarLista());

        add(titulo, BorderLayout.NORTH);
        add(new JScrollPane(lista), BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);
    }
}