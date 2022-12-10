/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import model.EcoSys;
import model.Enterprise.Enterprise;
import model.Network.Network;
import model.Organization.OrgPharmacist;
import model.Organization.Organization;
import model.UserAccount.UserAccount;
import model.WorkQueue.MedicineWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author dipikam
 */
public class RequestMedicineJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSys business;
    private String patientname;
    /**
     * Creates new form RequestLabTestJPanel
     */
    public RequestMedicineJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, EcoSys business, String patientname) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business=business;
        this.patientname=patientname;
        jLabel2.setText(enterprise.getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requestMedJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        messageJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestMedJButton.setBackground(new java.awt.Color(0, 153, 153));
        requestMedJButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        requestMedJButton.setForeground(new java.awt.Color(255, 255, 255));
        requestMedJButton.setText("REQUEST MEDICINE");
        requestMedJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestMedJButtonActionPerformed(evt);
            }
        });
        add(requestMedJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setText("Message");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        messageJTextField.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        add(messageJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 230, -1));

        backJButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(0, 153, 153));
        backJButton.setText("BACK");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 160, -1));

        enterpriseLabel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        enterpriseLabel.setText("Enterprise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 110, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("<name>");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 230, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void requestMedJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestMedJButtonActionPerformed
               if(messageJTextField.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Do not enter a empty  message!!");
            return;
            
        }
        else if(messageJTextField.getText().length()>25)
        {
            JOptionPane.showMessageDialog(null,"DO not exceed 25 characters limit !!");
            return;
            
        }else {
        String message = messageJTextField.getText();
        
        MedicineWorkRequest request = new MedicineWorkRequest();
        request.setMessage(message);
        request.setSender(userAccount);
        request.setStatus("Sent");
        request.setType("medicine");
        request.setPatient(patientname);
        
        
        
        Organization org = null;
        for(Network network:business.getNetworkList()){
        for(Enterprise enterprise1:network.getEnterpriseDirectory().getEnterpriseList()){
        for (Organization organization : enterprise1.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof OrgPharmacist){
                org = organization;
                break;
            }
        }
        }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
        }
         JOptionPane.showMessageDialog(null,"Medicine Requested");
        }
        
    }//GEN-LAST:event_requestMedJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DoctorWorkAreaJPanel dwjp = (DoctorWorkAreaJPanel) component;
        dwjp.populateMedicineRequestTable(patientname);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_backJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JButton requestMedJButton;
    // End of variables declaration//GEN-END:variables
}
