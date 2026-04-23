import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Estrutura extends JFrame {
    public static ArrayList<String> dados = new ArrayList<>();

    private JPanel painelConteudo;

    public Estrutura() {
        setTitle("Um CRUD básico (com dados estáticos)");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // dados estáticos iniciais para lista
        dados.add("Fulano de Tal");
        dados.add("Antônio Pires");

        painelConteudo = new JPanel(new BorderLayout());

        Menu menu = new Menu(this);

        add(painelConteudo, BorderLayout.CENTER);
        add(menu, BorderLayout.EAST);

        carregarLista();

        setVisible(true);
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