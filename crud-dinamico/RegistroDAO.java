import java.sql.*;
import java.util.ArrayList;

public class RegistroDAO {
    public static void inserir(String nome, String cpf, String rg, String cargo) {
        String sql = "INSERT INTO registros (nome, cpf, rg, cargo) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, rg);
            stmt.setString(4, cargo);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String[]> listar() {
        ArrayList<String[]> lista = new ArrayList<>();

        String sql = "SELECT nome, cpf, rg, cargo FROM registros";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String[] registro = new String[4];

                registro[0] = rs.getString("nome");
                registro[1] = rs.getString("cpf");
                registro[2] = rs.getString("rg");
                registro[3] = rs.getString("cargo");

                lista.add(registro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static void remover(String cpf) {
        String sql = "DELETE FROM registros WHERE cpf = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}