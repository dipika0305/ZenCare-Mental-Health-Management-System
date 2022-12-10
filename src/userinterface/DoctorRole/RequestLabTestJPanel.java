/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import model.EcoSys;
import model.Enterprise.Enterprise;
import model.Organization.OrgLab;
import model.Organization.Organization;
import model.UserAccount.UserAccount;
import model.WorkQueue.LabTestWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author dipikam
 */
public class RequestLabTestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private String patientname;
    /**
     * Creates new form RequestLabTestJPanel
     */
    public RequestLabTestJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise,String patientname) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.patientname=patientname;
        PatientName.setText(patientname);
    }

    public RequestLabTestJPanel(JPanel userProcessContainer, UserAccount userAccount, EcoSys business) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requestTestJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        messageJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        PatientName = new java.awt.Label();
        label2 = new java.awt.Label();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestTestJButton.setBackground(new java.awt.Color(0, 153, 153));
        requestTestJButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        requestTestJButton.setForeground(new java.awt.Color(255, 255, 255));
        requestTestJButton.setText("REQUEST TEST");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setText("Message");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, -1, -1));

        messageJTextField.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        add(messageJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 210, -1));

        backJButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(0, 153, 153));
        backJButton.setText("BACK");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 140, -1));

        enterpriseLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        enterpriseLabel.setText("LAB TEST");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 130, 30));

        PatientName.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        PatientName.setName(""); // NOI18N
        add(PatientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 210, -1));

        label2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        label2.setText("Patient Name :");
        add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 110, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
             if(messageJTextField.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Do not enter a empty  message!!");
            return;
            
        }
        else if(messageJTextField.getText().length()>25)
        {
            JOptionPane.showMessageDialog(null,"DO not exceed 25 characters limit !!");
            return;
            
        }else{
        String message = messageJTextField.getText();
        
        LabTestWorkRequest request = new LabTestWorkRequest();
        request.setMessage(message);
        request.setSender(userAccount);
        request.setStatus("Sent");
        request.setType("lab");
        request.setPatient(patientname);
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof OrgLab){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
        }
         JOptionPane.showMessageDialog(null,"Test Requested");
        }
        
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DoctorWorkAreaJPanel dwjp = (DoctorWorkAreaJPanel) component;
        dwjp.populateRequestTable(patientname);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_backJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label PatientName;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private java.awt.Label label2;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JButton requestTestJButton;
    // End of variables declaration//GEN-END:variables
}
