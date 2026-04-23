import javax.swing.*;
import java.awt.*;

public class Lista extends JPanel {
    private JList<String> lista;

    public Lista(Estrutura estrutura) {
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Lista de registros");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        lista = new JList<>();
        atualizarLista();

        add(titulo, BorderLayout.NORTH);
        add(new JScrollPane(lista), BorderLayout.CENTER);
    }

    public void atualizarLista() {
        DefaultListModel<String> model = new DefaultListModel<>();

        for (String nome : Estrutura.dados) {
            model.addElement(nome);
        }

        lista.setModel(model);
    }
}