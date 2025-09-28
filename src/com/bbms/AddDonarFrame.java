import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddDonorFrame extends javax.swing.JFrame {
    private static final Logger logger = Logger.getLogger(AddDonorFrame.class.getName());

    public AddDonorFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void addDonor() {
        try {
            Connection con = DBUtility.getConnection();
            String sql = "INSERT INTO donor (roll_number, name, age, blood_group) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(jTextField1.getText())); // Roll Number
            ps.setString(2, jTextField2.getText()); // Name
            ps.setInt(3, Integer.parseInt(jTextField3.getText())); //Age
            ps.setString(4, jTextField4.getText()); // Blood Group
            ps.executeUpdate();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
    // ... (rest of the generated code)
}