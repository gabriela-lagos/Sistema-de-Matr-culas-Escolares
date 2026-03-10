import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Aluno2 {

    // INSERT
    public void inserir(Aluno aluno) throws Exception {

        String sql = "INSERT INTO aluno (nome, curso) VALUES (?, ?)";

        Connection con = Conexao.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, aluno.getNome());
        stmt.setString(2, aluno.getCurso());

        stmt.executeUpdate();
        con.close();

        System.out.println("Aluno inserido com sucesso!");
    }

    // SELECT
    public void listar() throws Exception {

        String sql = "SELECT * FROM aluno";

        Connection con = Conexao.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String curso = rs.getString("curso");

            System.out.println(id + " - " + nome + " - " + curso);
        }

        con.close();
    }

    // UPDATE
    public void atualizar(int id, String novoNome, String novoCurso) throws Exception {

        String sql = "UPDATE aluno SET nome = ?, curso = ? WHERE id = ?";

        Connection con = Conexao.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, novoNome);
        stmt.setString(2, novoCurso);
        stmt.setInt(3, id);

        stmt.executeUpdate();
        con.close();

        System.out.println("Aluno atualizado!");
    }

    // DELETE
    public void remover(int id) throws Exception {

        String sql = "DELETE FROM aluno WHERE id = ?";

        Connection con = Conexao.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();
        con.close();

        System.out.println("Aluno removido!");
    }
}