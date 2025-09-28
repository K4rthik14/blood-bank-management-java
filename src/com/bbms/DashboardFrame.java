public class DashboardFrame extends javax.swing.JFrame {

    public DashboardFrame() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        new AddDonorFrame();
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        new ViewDonorFrame();
    }

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
        new SearchDonorFrame();
    }
    // ... (rest of the generated code)
}