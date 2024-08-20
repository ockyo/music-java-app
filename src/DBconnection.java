import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    public static Connection connect() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:musicDB.db"); // Assign the connection to con
            System.out.println("Connected");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Class not found: " + e);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception: " + e);
        }
        return con;
    }
    public static void main(String[] args) {
        DBconnection.connect();
    }
}
