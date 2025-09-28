import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class SearchDonorFrame extends javax.swing.JFrame {

    public SearchDonorFrame() {
        initComponents();
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String searchQuery = searchField.getText();
        try {
            Connection con = DBUtility.getConnection();
            String sql = "SELECT * FROM donor WHERE name LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchQuery + "%");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            int columnCount = rsmd.getColumnCount();
            model.setColumnCount(0);
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // ... (rest of the generated code)
}