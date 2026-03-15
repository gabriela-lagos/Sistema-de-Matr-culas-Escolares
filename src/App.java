import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {

        create("Maria", "Engenharia");

        read();

        update(1, "Maria Silva", "Computação");

        read();

        delete(1);

        read();
    }

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:postgresql://aws-1-us-east-1.pooler.supabase.com:6543/postgres?user=postgres.ercypczcbdowfjyzgsxx&password=fu9wMYXdk8Pyvzyj";

        Connection con = DriverManager.getConnection(url);

        return con;
    }

    public static void create(String nome, String curso) throws SQLException {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "INSERT INTO aluno (nome, curso) VALUES ('" + nome + "', '" + curso + "')";

        try {

            con = getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            if (con != null) {
                con.close();
            }
        }
    }

    public static void read() throws SQLException {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM aluno";

        try {

            con = getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String curso = rs.getString("curso");

                System.out.println(id + " " + nome + " " + curso);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            if (con != null) {
                con.close();
            }
        }
    }

    public static void update(int id, String nome, String curso) throws SQLException {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "UPDATE aluno SET nome='" + nome + "', curso='" + curso + "' WHERE id=" + id;

        try {

            con = getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            if (con != null) {
                con.close();
            }
        }
    }

    public static void delete(int id) throws SQLException {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "DELETE FROM aluno WHERE id=" + id;

        try {

            con = getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            if (con != null) {
                con.close();
            }
        }
    }
}