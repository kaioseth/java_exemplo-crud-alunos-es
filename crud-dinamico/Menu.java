import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    public Menu(Estrutura estrutura) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(120, 0));

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(3, 1, 5, 5));

        JButton btnNovo = new JButton("Novo");
        JButton btnApagar = new JButton("Apagar");
        JButton btnSair = new JButton("Sair");

        btnNovo.addActionListener(e -> estrutura.carregarForm());
        btnApagar.addActionListener(e -> estrutura.carregarApagar());
        btnSair.addActionListener(e -> System.exit(0));

        painelBotoes.add(btnNovo);
        painelBotoes.add(btnApagar);
        painelBotoes.add(btnSair);

        add(painelBotoes, BorderLayout.NORTH);
    }
}