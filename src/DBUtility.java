/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
/**
 *
 * @author kniha
 */
public class DBUtility {
    public static Connection getConnection(){
        try {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root","newton@123");
            return con;
        } catch (SQLException ex) {
            System.getLogger(DBUtility.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }
}
