import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtility {
    //TODO: Replace with your database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/bms";
    private static final String USER = "root";
    private static final String PASSWORD = "newton@123";

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}