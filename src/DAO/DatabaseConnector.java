package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static final String URL = "jdbc:sqlite:musicDB.db";

    public static Connection connect() {
        Connection conn = null;
        // set up JDBC cua sqlite
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(URL); // Assign the connection to con
            System.out.println("Connected to DB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Class not found: " + e);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception: " + e);
        }
        return conn;
    }

    public static void main(String[] args) {
        DatabaseConnector.connect();
    }
}
