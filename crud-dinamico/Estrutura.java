import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Estrutura extends JFrame {
    /**
     * ponto de diferença
     * * trabalhamos agora com uma lista dinâmica de dados onde antes era uma estática
     */

    private JPanel painelConteudo;

    public Estrutura() {
        setTitle("CRUD de registros");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        painelConteudo = new JPanel(new BorderLayout());

        Menu menu = new Menu(this);

        add(painelConteudo, BorderLayout.CENTER);
        add(menu, BorderLayout.EAST);

        setVisible(true);

        carregarLista();
    }

    public void trocarTela(JPanel novaTela) {
        painelConteudo.removeAll();
        painelConteudo.add(novaTela, BorderLayout.CENTER);
        painelConteudo.revalidate();
        painelConteudo.repaint();
    }

    public void carregarLista() {
        trocarTela(new Lista(this));
    }

    public void carregarForm() {
        trocarTela(new Form(this));
    }

    public void carregarApagar() {
        trocarTela(new Apagar(this));
    }
}