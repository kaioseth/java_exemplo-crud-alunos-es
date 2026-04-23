import javax.swing.*;
import java.awt.*;

public class Form extends JPanel {
    public Form(Estrutura estrutura) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel painelForm = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField txtNome = new JTextField();
        JTextField txtCpf = new JTextField();
        JTextField txtRg = new JTextField();
        JTextField txtCargo = new JTextField();

        adicionarCampo(painelForm, gbc, 0, "Nome:", txtNome);
        adicionarCampo(painelForm, gbc, 1, "CPF:", txtCpf);
        adicionarCampo(painelForm, gbc, 2, "RG:", txtRg);
        adicionarCampo(painelForm, gbc, 3, "Cargo:", txtCargo);

        gbc.gridy = 4;
        gbc.weighty = 1;
        painelForm.add(new JLabel(), gbc);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

        JButton btnOk = new JButton("OK");
        JButton btnCancelar = new JButton("Cancelar");

        btnOk.addActionListener(e -> {
            if (!txtNome.getText().isEmpty()) {
                Estrutura.dados.add(txtNome.getText());
                estrutura.carregarLista();
            }
        });

        btnCancelar.addActionListener(e -> estrutura.carregarLista());

        painelBotoes.add(btnOk);
        painelBotoes.add(btnCancelar);

        add(painelForm, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void adicionarCampo(JPanel painel, GridBagConstraints gbc, int y, String label, JTextField campo) {
        // Label (30%)
        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.weightx = 0.3;
        painel.add(new JLabel(label), gbc);

        // Campo (70%)
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        painel.add(campo, gbc);
    }
}