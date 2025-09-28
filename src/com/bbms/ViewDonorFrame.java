import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ViewDonorFrame extends javax.swing.JFrame {
    private static final Logger logger = Logger.getLogger(ViewDonorFrame.class.getName());

    public ViewDonorFrame() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        viewDonors();
    }

    void viewDonors() {
        try {
            Connection con = DBUtility.getConnection();
            String sql = "SELECT * FROM donor";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int columnCount = rsmd.getColumnCount();

            // Clear existing columns and add new ones
            model.setColumnCount(0);
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }

            // Clear existing rows
            model.setRowCount(0);
            while (rs.next()) {
                Object[] rowData = {
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4)
                };
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error fetching donors", ex);
        }
    }
    // ... (rest of the generated code)
}