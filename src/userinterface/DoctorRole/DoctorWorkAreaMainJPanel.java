/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import model.EcoSys;
import model.DoctorSchedule;
import model.Enterprise.Enterprise;
import model.MailNew;
import model.Organization.OrgDoctor;
import model.Organization.Organization;
import model.UserAccount.UserAccount;
import model.WorkQueue.PatientWorkRequest;
import model.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dipikam
 */
public class DoctorWorkAreaMainJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private OrgDoctor organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSys business;
    DoctorSchedule sched;
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public DoctorWorkAreaMainJPanel(JPanel userProcessContainer, UserAccount account, OrgDoctor organization, Enterprise enterprise,EcoSys business,DoctorSchedule sched) {
        initComponents();
        btnBook.setVisible(false);
         listSched.setVisible(false);
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business=business;
        this.sched=sched;
        valueLabel.setText(enterprise.getName());
        populateTable();
        populateTable2();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable2.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            if(request.getType()!=null)
            {
           if(request.getType().equals("Patient")&& request.getReceiver()== null)
           {
               
            Object[] row = new Object[3];
            row[0] = request;
            row[1] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[2] = request.getStatus();
            
            model.addRow(row);
            }
        }
    }
    }
    public void populateTable2(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable3.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            if(request.getType()!=null)
            {
           if(request.getType().equals("Patient")&& request.getReceiver()!= null && request.getReceiver().equals(userAccount))
           {
               
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[2] = request.getStatus();
            row[3] = request.getState();
            model.addRow(row);
            }
        }
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refreshTestJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        workRequestJTable2 = new javax.swing.JTable();
        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        listsched = new java.awt.List();
        btnBook = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        workRequestJTable3 = new javax.swing.JTable();
        listSched = new java.awt.List();
        btnForward = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        refreshTestJButton.setBackground(new java.awt.Color(255, 255, 255));
        refreshTestJButton.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13)); // NOI18N
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });
        add(refreshTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        enterpriseLabel.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 23, 127, 30));

        valueLabel.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 27, 158, 26));

        workRequestJTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Patient", "Receiver", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(workRequestJTable2);
        if (workRequestJTable2.getColumnModel().getColumnCount() > 0) {
            workRequestJTable2.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable2.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable2.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 390, 96));

        assignJButton.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13)); // NOI18N
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, -1, -1));

        processJButton.setBackground(new java.awt.Color(255, 255, 255));
        processJButton.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13)); // NOI18N
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, -1));

        listsched.setVisible(false);
        add(listsched, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 84, 0, 0));

        btnBook.setBackground(new java.awt.Color(255, 255, 255));
        btnBook.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13)); // NOI18N
        btnBook.setText("Book");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });
        add(btnBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 84, -1, -1));

        workRequestJTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Patient", "Receiver", "Status", "State"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(workRequestJTable3);
        if (workRequestJTable3.getColumnModel().getColumnCount() > 0) {
            workRequestJTable3.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable3.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable3.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable3.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 380, 96));
        add(listSched, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 80, 180));

        btnForward.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13)); // NOI18N
        btnForward.setText("Forward to other network hospital");
        btnForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForwardActionPerformed(evt);
            }
        });
        add(btnForward, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, 260, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

       
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable2.getSelectedRow();
        btnBook.setVisible(true);
        listSched.setVisible(true);
        if (selectedRow < 0){
             JOptionPane.showMessageDialog(null,"Select a row");
           
            return;
        }
      
        for(String s:sched.getSchedDir())
          listSched.add(s);
       

    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = workRequestJTable3.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Select a row");
            return;
        }

        PatientWorkRequest request = (PatientWorkRequest)workRequestJTable3.getValueAt(selectedRow, 0);

        request.setStatus("Processing");
        request.setReceiver(userAccount);
        request.setPatient(request.getPatientName());
        request.setState(request.getPatientState());
        JOptionPane.showMessageDialog(null,"Processing");
        
        DoctorWorkAreaJPanel doctorWorkAreaJPanel = new DoctorWorkAreaJPanel(userProcessContainer, userAccount, (OrgDoctor)organization, enterprise,business,request.getPatient());
        userProcessContainer.add("doctorWorkAreaJPanel", doctorWorkAreaJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_processJButtonActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        // TODO add your handling code here:
         int selectedRow = workRequestJTable2.getSelectedRow();
           if (selectedRow < 0){
                JOptionPane.showMessageDialog(null,"Select a appointment");
           
            //return;
        } else {
           int row=listSched.getSelectedIndex();
       if(row>=0)
       {
           
          
        PatientWorkRequest request = (PatientWorkRequest)workRequestJTable2.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        request.setAppointmentTime(listSched.getSelectedItem());
                try {
                   MailNew m=new MailNew("steveaeddemo@gmail.com","Appointment with doctor: "+ userAccount,"Your appointment is confirmed at "+listSched.getSelectedItem());
               } catch (MessagingException ex) {
                   Logger.getLogger(DoctorWorkAreaMainJPanel.class.getName()).log(Level.SEVERE, null, ex);
               }
        request.setBillamount("500");
        sched.removerow(listSched.getSelectedItem());
         listSched.remove(listSched.getSelectedItem());
          JOptionPane.showMessageDialog(null,"Booked Successfully!!");
              
       populateTable();
        populateTable2();
       // btnBook.setVisible(true);
//listsched.setVisible(true);

       }else
        {
           JOptionPane.showMessageDialog(null,"No appointments!!");
        }
           }
           
       
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForwardActionPerformed
        int selectedRow = workRequestJTable2.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!!");
            return;
        }
        else{
        PatientWorkRequest request = (PatientWorkRequest)workRequestJTable2.getValueAt(selectedRow, 0);
       
        //request.setBillstatus("Forwarded to other network hospital");
       
        request.setType("Patient");
        
        request.setSender(userAccount);
       Organization org = null;
         
            //System.out.println(business.getNetworkList().get(0).getEnterpriseDirectory().getEnterpriseList());
         
         for(Organization organization1 : business.getNetworkList().get(1).getEnterpriseDirectory().getEnterpriseList().get(0).getOrganizationDirectory().getOrganizationList()){
             
       // for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization1 instanceof OrgDoctor){
                org = organization1;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            //System.out.println(request.getReceiver());
        }
        JOptionPane.showMessageDialog(null, "Forwarded!!");
        populateTable();
        populateTable2();
        }
    }//GEN-LAST:event_btnForwardActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnForward;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private java.awt.List listSched;
    private java.awt.List listsched;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable2;
    private javax.swing.JTable workRequestJTable3;
    // End of variables declaration//GEN-END:variables
}
