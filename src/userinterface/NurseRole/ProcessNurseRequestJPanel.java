/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.NurseRole;

import model.Enterprise.Enterprise;
import model.Organization.OrgCareTaker;
import model.Organization.Organization;
import model.Organization.OrgSupport;
import model.UserAccount.UserAccount;
import model.WorkQueue.CareTakerWorkRequest;
import model.WorkQueue.PatientWorkRequest;
import model.WorkQueue.SupportWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Mitali
 */
public class ProcessNurseRequestJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    PatientWorkRequest request;
    UserAccount account;
    Enterprise enterprise;
    Organization organization;
     
        HashMap<String,Integer> n;

    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    public ProcessNurseRequestJPanel(JPanel userProcessContainer, PatientWorkRequest request, UserAccount account, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.enterprise = enterprise;
        this.account = account;
        this.organization=organization;
        patientname.setText(request.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submitJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        careTakeInfo = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        submitJButton1 = new javax.swing.JButton();
        dieticianInfo = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        patientname = new java.awt.Label();
        label2 = new java.awt.Label();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        submitJButton.setBackground(new java.awt.Color(0, 153, 153));
        submitJButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        submitJButton.setForeground(new java.awt.Color(255, 255, 255));
        submitJButton.setText("Forward Request to CareTaker");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 280, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setText("Message");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, 30));

        careTakeInfo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        add(careTakeInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 210, -1));

        backJButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(0, 153, 153));
        backJButton.setText("BACK");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        submitJButton1.setBackground(new java.awt.Color(0, 153, 153));
        submitJButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        submitJButton1.setForeground(new java.awt.Color(255, 255, 255));
        submitJButton1.setText("Forward Request to Dietician");
        submitJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButton1ActionPerformed(evt);
            }
        });
        add(submitJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 280, -1));

        dieticianInfo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        dieticianInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dieticianInfoActionPerformed(evt);
            }
        });
        add(dieticianInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 210, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("Message");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("NURSE ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, -1));

        patientname.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        patientname.setText("<name>");
        add(patientname, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 190, -1));

        label2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        label2.setText("Patient Name");
        add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 100, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        NurseWorkAreaJPanel dwjp = (NurseWorkAreaJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed

        try {
            String message = careTakeInfo.getText();

            CareTakerWorkRequest request1 = new CareTakerWorkRequest();

            request1.setcaretakerInfo(careTakeInfo.getText());
            request1.setSender(account);
            request1.setStatus("pendimg CareTaker");
            request1.setCaretakerStatus("pending in caretaker");
            request1.setType("Patient");
            request1.setPatient(request.getPatientName());
            request1.setState(request.getPatientState());
            request1.setCaretakerreceiver(null);

            Organization org = null;
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof OrgCareTaker) {
                    org = organization;
                    break;
                }
            }
            if (org != null) {
                org.getWorkQueue().getWorkRequestList().add(request1);
                //account.getWorkQueue().getWorkRequestList().add(request1);
            }
            
            JOptionPane.showMessageDialog(null, "Request sent to CareTaker!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error in sedning request!!");
        }

    }//GEN-LAST:event_submitJButtonActionPerformed

    private void submitJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButton1ActionPerformed
        // TODO add your handling code here:
        
        try{
        String message = dieticianInfo.getText();

        SupportWorkRequest request1 = new SupportWorkRequest();

        request1.setSupportinfo(dieticianInfo.getText());
        request1.setSender(account);
        request1.setStatus("Finding Dietician");
        request1.setType("Patient");
        request1.setSupportStatus("pending");
        request1.setSupportreceiver(null);
        request1.setPatient(request.getPatientName());
        request1.setState(request.getPatientState());

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof OrgSupport) {
                org = organization;
                break;
            }
        }
        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(request1);
            //account.getWorkQueue().getWorkRequestList().add(request1);
        }
        JOptionPane.showMessageDialog(null, "Request sent to dietician!!");
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "error in sedning request!!");
        }

    }//GEN-LAST:event_submitJButton1ActionPerformed

    private void dieticianInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dieticianInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dieticianInfoActionPerformed
      
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField careTakeInfo;
    private java.awt.TextField dieticianInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private java.awt.Label label2;
    private java.awt.Label patientname;
    private javax.swing.JButton submitJButton;
    private javax.swing.JButton submitJButton1;
    // End of variables declaration//GEN-END:variables
}
