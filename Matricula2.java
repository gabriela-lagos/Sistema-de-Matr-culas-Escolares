import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Matricula2 {

    public void inserir(Matricula matricula) throws Exception {

        String sql = "INSERT INTO matricula(aluno_id, semestre) VALUES (?, ?)";

        Connection con = Conexao.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setInt(1, matricula.getAlunoId());
        stmt.setString(2, matricula.getSemestre());

        stmt.executeUpdate();
        con.close();
    }

    public void listarComAluno() throws Exception {

        String sql = """
            SELECT a.nome, a.curso, m.semestre
            FROM aluno a
            JOIN matricula m ON a.id = m.aluno_id
        """;

        Connection con = Conexao.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            System.out.println(
                rs.getString("nome") + " - " +
                rs.getString("curso") + " - " +
                rs.getString("semestre")
            );
        }

        con.close();
    }
}