
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBConnection {
     public static Connection getConnection() throws ClassNotFoundException{
         
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","sanju10");
            return con;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"DB connection failed!!","Database error!!",JOptionPane.ERROR_MESSAGE);
            System.getLogger(DBConnection.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }
}
