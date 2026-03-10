import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {

    public static void main(String[] args) throws Exception {

        AlunoDAO dao = new AlunoDAO();

        // INSERT
        Aluno aluno1 = new Aluno("Maria", "Engenharia");
        dao.inserir(aluno1);

        // READ
        System.out.println("Lista de alunos:");
        read();

        // UPDATE
        dao.atualizar(1, "Maria Silva", "Computação");

        System.out.println("Após atualização:");
        read();

        // DELETE
        dao.remover(1);

        System.out.println("Após remoção:");
        read();
    }

    public static Connection getConnection() throws Exception {

        String url = "jdbc:postgresql://aws-1-us-east-1.pooler.supabase.com:6543/postgres?user=postgres.ercypczcbdowfjyzgsxx&password=fu9wMYXdk8Pyvzyj";

        Connection con = DriverManager.getConnection(url);
        return con;
    }

    public static void read() throws Exception {

        String sql = "SELECT * FROM aluno";
        Connection con = null;

        try {

            con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String curso = rs.getString("curso");

                System.out.println(id + " - " + nome + " - " + curso);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (con != null) {
                con.close();
            }
        }
    }
}