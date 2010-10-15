/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChangePassDlg.java
 *
 * Created on Oct 14, 2010, 9:38:30 PM
 */

package org.childcare.ui;

/**
 *
 * @author Dang Van Thanh
 */
public class ChangePassDlg extends javax.swing.JDialog {

    /** Creates new form ChangePassDlg */
    public ChangePassDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Change Password");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlContainer = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        lblOldPass = new javax.swing.JLabel();
        pdfOldPass = new javax.swing.JPasswordField();
        lblNewPass = new javax.swing.JLabel();
        pdfNewPass = new javax.swing.JPasswordField();
        lblConfirmPass = new javax.swing.JLabel();
        pdfConfirmPass = new javax.swing.JPasswordField();
        pnlButton = new javax.swing.JPanel();
        btnChange = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlContainer.setLayout(new java.awt.GridBagLayout());

        lblTitle.setText("Change Pass");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        pnlContainer.add(lblTitle, gridBagConstraints);

        pnlContent.setLayout(new java.awt.GridBagLayout());

        lblOldPass.setText("Old Passworld :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        pnlContent.add(lblOldPass, gridBagConstraints);

        pdfOldPass.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pnlContent.add(pdfOldPass, gridBagConstraints);

        lblNewPass.setText("New Password :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        pnlContent.add(lblNewPass, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pnlContent.add(pdfNewPass, gridBagConstraints);

        lblConfirmPass.setText("Confirm Password :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        pnlContent.add(lblConfirmPass, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pnlContent.add(pdfConfirmPass, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        pnlContainer.add(pnlContent, gridBagConstraints);

        btnChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/childcare/images/accept.png"))); // NOI18N
        btnChange.setText("Change");
        pnlButton.add(btnChange);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/childcare/images/cancel.png"))); // NOI18N
        btnCancel.setText("Cancel");
        pnlButton.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        pnlContainer.add(pnlButton, gridBagConstraints);

        getContentPane().add(pnlContainer, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChangePassDlg dialog = new ChangePassDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChange;
    private javax.swing.JLabel lblConfirmPass;
    private javax.swing.JLabel lblNewPass;
    private javax.swing.JLabel lblOldPass;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPasswordField pdfConfirmPass;
    private javax.swing.JPasswordField pdfNewPass;
    private javax.swing.JPasswordField pdfOldPass;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlContent;
    // End of variables declaration//GEN-END:variables

}
