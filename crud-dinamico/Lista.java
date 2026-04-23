import javax.swing.*;
import java.awt.*;

public class Lista extends JPanel {
    private JList<String> lista;

    public Lista(Estrutura estrutura) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titulo = new JLabel("Lista de registros");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        lista = new JList<>();
        carregarDados();

        add(titulo, BorderLayout.NORTH);
        add(new JScrollPane(lista), BorderLayout.CENTER);
    }

    private void carregarDados() {
        DefaultListModel<String> model = new DefaultListModel<>();

        /**
         * ponto de diferença
         * * antes listávamos os registros diretamente da lista dados da Estrutura
         * * agora buscamos os dados dinâmicos através da função listar da nossa DAO
         */
        for (String[] registro : RegistroDAO.listar()) {
            model.addElement("Nome: " + registro[0] + " | CPF: " + registro[1]);
        }

        lista.setModel(model);
    }
}