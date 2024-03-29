/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.dougmcneil.plsql.ui;

import java.awt.Dialog;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import name.dougmcneil.plsql.PLSQLDriver;
import org.openide.util.NbBundle;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;

/**
 *
 * @author doug
 */
public class PLSQLPropertiesPanel extends javax.swing.JPanel {

    private DialogDescriptor _descriptor;
    
    
    /**
     * Creates new form SQLPropertiesPanel
     */
    public PLSQLPropertiesPanel() {
        initComponents();
    }

    public static boolean showPLSQLProperties() {
        assert SwingUtilities.isEventDispatchThread();

        PLSQLPropertiesPanel panel = new PLSQLPropertiesPanel();
        PLSQLDriver driver = PLSQLDriver.getInstance();
        if (driver.getStatus() != PLSQLDriver.Status.REGISTERED) {
            PLSQLDriver.getInstance().init();
        }
        checkStatus(panel.jCheckBoxRegistered, panel.jTextFieldStatus);
        panel.jCheckBoxRegistered.setSelected(driver.getStatus() == PLSQLDriver.Status.REGISTERED);
        
        String title = NbBundle.getMessage(PLSQLPropertiesPanel.class, "LBL_PropertiesPanel");
        DialogDescriptor desc = new DialogDescriptor(panel, title);
        desc.createNotificationLineSupport();

        for (;;) {
            Dialog dialog = DialogDisplayer.getDefault().createDialog(desc);


            String acsd = NbBundle.getMessage(PLSQLPropertiesPanel.class, "LBL_PropertiesPanel");
            dialog.getAccessibleContext().setAccessibleDescription(acsd);
            dialog.setVisible(true);
            dialog.dispose();

            if (!DialogDescriptor.OK_OPTION.equals(desc.getValue())) {
                return false; // NOI18N
            }

            return true;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jCheckBoxRegistered = new javax.swing.JCheckBox();
        jTextFieldStatus = new javax.swing.JTextField();

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabelTitle, org.openide.util.NbBundle.getMessage(PLSQLPropertiesPanel.class, "PLSQLPropertiesPanel.jLabelTitle.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBoxRegistered, org.openide.util.NbBundle.getMessage(PLSQLPropertiesPanel.class, "PLSQLPropertiesPanel.jCheckBoxRegistered.text")); // NOI18N
        jCheckBoxRegistered.setToolTipText(org.openide.util.NbBundle.getMessage(PLSQLPropertiesPanel.class, "registered.checkbox")); // NOI18N
        jCheckBoxRegistered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRegisteredActionPerformed(evt);
            }
        });

        jTextFieldStatus.setEditable(false);
        jTextFieldStatus.setForeground(new java.awt.Color(255, 0, 0));
        jTextFieldStatus.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxRegistered)
                    .addComponent(jLabelTitle)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxRegistered)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxRegisteredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRegisteredActionPerformed
        String action = evt.getActionCommand();
        if (jCheckBoxRegistered.isSelected()) {
            PLSQLDriver.getInstance().init();
            checkStatus(jCheckBoxRegistered, jTextFieldStatus);
            if (PLSQLDriver.getInstance().getStatus() != PLSQLDriver.Status.REGISTERED) {
                jCheckBoxRegistered.setSelected(false);
            }
        }
    }//GEN-LAST:event_jCheckBoxRegisteredActionPerformed

    private static void checkStatus(final JCheckBox box, final JTextField text) {
        if (PLSQLDriver.getInstance().getStatus() == PLSQLDriver.Status.NO_DRIVER_OR_NO_JAR) {
            text.setText(NbBundle.getMessage(
                    PLSQLPropertiesPanel.class, "registered.status.no_driver_or_no_jar"));
        } else if (PLSQLDriver.getInstance().getStatus() == PLSQLDriver.Status.NO_PLSQL_JAR) {
            text.setText(NbBundle.getMessage(
                    PLSQLPropertiesPanel.class, "registered.status.no_plsql_jar"));
        } else if (PLSQLDriver.getInstance().getStatus() == PLSQLDriver.Status.CANNOT_CREATE_DRIVER) {
            text.setText(NbBundle.getMessage(
                    PLSQLPropertiesPanel.class, "registered.status.cannot_create_driver"));
        } else {
            box.setEnabled(false);
            text.setText(null);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxRegistered;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables
}
