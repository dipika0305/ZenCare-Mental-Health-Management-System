/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SupportRole;

import model.MailNew;
import model.WorkQueue.SupportWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userinterface.DoctorRole.DoctorWorkAreaMainJPanel;

/**
 *
 * @author Vidhi
 */
public class ProcessWorkRequestJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    SupportWorkRequest request;
    /**
     * Creates new form ProcessWorkRequestJPanel
     */
   

   public  ProcessWorkRequestJPanel(JPanel userProcessContainer, SupportWorkRequest request) {
       initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        patientname.setText(request.getPatient());
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
        resultJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        patientname = new java.awt.Label();
        label2 = new java.awt.Label();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        submitJButton.setBackground(new java.awt.Color(0, 153, 153));
        submitJButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        submitJButton.setForeground(new java.awt.Color(255, 255, 255));
        submitJButton.setText("SUBMIT");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 170, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setText("Message");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, -1));

        resultJTextField.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        add(resultJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 300, 30));

        backJButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(0, 153, 153));
        backJButton.setText("BACK");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 170, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("DIETICIAN MESSAGE");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        patientname.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        patientname.setText("<name>");
        add(patientname, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 230, -1));

        label2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        label2.setText("Patient Name");
        add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 110, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SupportWorkAreaJPanel dwjp = (SupportWorkAreaJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        
        if(resultJTextField.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Do not enter a empty  message!!");
            return;
            
        }
        else if(resultJTextField.getText().length()>25)
        {
            JOptionPane.showMessageDialog(null,"DO not exceed 25 characters limit !!");
            return;
            
        }else {
            
        request.setSupportinfo(resultJTextField.getText());
        request.setSupportStatus("completed");
        request.setStatus("Completed");
        
         JOptionPane.showMessageDialog(null,"Request Completed !!");
         
         
           try {
                   MailNew m=new MailNew("johndoezencare@gmail.com","Updated status for Support ","Support Team has allocated you a dietician, Hope to see you in good state!! ");
               } catch (MessagingException ex) {
                   Logger.getLogger(DoctorWorkAreaMainJPanel.class.getName()).log(Level.SEVERE, null, ex);
               }
        
        }
    }//GEN-LAST:event_submitJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.awt.Label label2;
    private java.awt.Label patientname;
    private javax.swing.JTextField resultJTextField;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
