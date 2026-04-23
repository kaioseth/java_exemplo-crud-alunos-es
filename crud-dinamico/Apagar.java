import javax.swing.*;
import java.awt.*;

public class Apagar extends JPanel {
    public Apagar(Estrutura estrutura) {
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Remover registro");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        DefaultListModel<String> model = new DefaultListModel<>();

        /**
         * ponto de diferença
         * * antes listávamos os registros diretamente da lista dados da Estrutura
         * * agora buscamos os dados dinâmicos através da função listar da nossa DAO
         */
        for (String[] registro : RegistroDAO.listar()) {
            model.addElement("Nome: " + registro[0] + " | CPF: " + registro[1]);
        }

        JList<String> lista = new JList<>(model);

        JButton btnRemover = new JButton("Remover");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel botoes = new JPanel();
        botoes.add(btnRemover);
        botoes.add(btnCancelar);

        btnRemover.addActionListener(e -> {
            /**
             * ponto de diferença
             * * anteriormente removia da lista estática um elemento pelo índice
             * * agora da string selecionada, pego apenas o número do CPF
             */
            String selecionado = lista.getSelectedValue();
            
            if (selecionado != null) {
                String cpf = selecionado.split("\\|")[1].replace("CPF:", "").trim();

                /**
                 * ponto de diferença
                 * * ao invés do "remove", uso a funçao "remover" da minha DAO que recebe o CPF por parâmetro
                 */
                RegistroDAO.remover(cpf);
                estrutura.carregarLista();
            }
        });

        add(titulo, BorderLayout.NORTH);
        add(new JScrollPane(lista), BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);
    }
}