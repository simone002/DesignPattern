import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String servername = "localhost";
        String username = "root";
        String password = "Giovanni98+";
        String name_db = "Books";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://" + servername + "/" + name_db, username, password);
            System.out.println("Connection successful!");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
