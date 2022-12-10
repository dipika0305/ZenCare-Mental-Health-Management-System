/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ClaimsRole;

import model.EcoSys;
import model.Enterprise.Enterprise;
import model.Organization.OrgBillings;
import model.Organization.Organization;
import model.UserAccount.UserAccount;
import model.WorkQueue.BillingWorkRequest;
import model.WorkQueue.ClaimsWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;

/**
 *
 * @author dipikam
 */
public class ProcessWorkRequestJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;

    ClaimsWorkRequest request;
    private EcoSys business;
    private UserAccount useraccount;
    Enterprise enterprise;
    float amount_Approved;
    UserAccount account;
    int amount;
    String forward;
    String status;
    int updatedbill;
    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    public ProcessWorkRequestJPanel(JPanel userProcessContainer, ClaimsWorkRequest request,UserAccount account, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.enterprise = enterprise;
        this.account=account;

         patientname.setText(request.getPatient());
        amountRequested.setText(request.getBill().toString());

    }
    
//    public void sendemailto() throws Exception
//{
//   //MailClass mailclass=new MailClass(txtemail.getText(),"You are registered to Brigham Hospital","Registeration-Brigham");
// // mailclass.sendmail();
//    
////    PatientInfoJPanel p = null;
//    String text = request.getEmailid();
//    String name = request.getPatient();
//    MailNew m=new MailNew(text,"Hi!!"+name +" , Your bill status is updated to " + status ,"");
//}

//    private void populateboxes() {
//       
//        int jspinner = (Integer) PercentageApproved.getValue();
//
//        float k = (float) (jspinner / 100.0);
//
//        //int billamount = request.getbillAmount();
//        int billamount = 500;   //bydefault
//
//        float amountapproved = billamount * k;
//
//        amountApproved.setText(String.valueOf(amountapproved));
//
//        this.amount_Approved = amountapproved;
//
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        submitJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        amountRequested = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        patientname = new java.awt.Label();
        label2 = new java.awt.Label();
        textfield = new java.awt.Label();
        PercentageApproved = new javax.swing.JSpinner();
        label1 = new java.awt.Label();
        amountApproved = new java.awt.TextField();
        ApprovedJbtn = new javax.swing.JRadioButton();
        RejectedJbtn = new javax.swing.JRadioButton();
        calculatebtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        messageTextField = new javax.swing.JTextField();
        refreshBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        submitJButton.setBackground(new java.awt.Color(0, 153, 153));
        submitJButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        submitJButton.setForeground(new java.awt.Color(255, 255, 255));
        submitJButton.setText("Submit Result");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("CLAIMS RESULT ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 200, 30));

        amountRequested.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        amountRequested.setEnabled(false);
        add(amountRequested, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 170, -1));

        backJButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(0, 153, 153));
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 130, -1));

        patientname.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        patientname.setText("<name>");
        add(patientname, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 170, -1));

        label2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        label2.setText("Patient Name");
        add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 110, -1));

        textfield.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        textfield.setText("Percentage Of Amount to be Given");
        add(textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        PercentageApproved.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        PercentageApproved.setModel(new javax.swing.SpinnerNumberModel(5, 5, 100, 5));
        add(PercentageApproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 170, -1));

        label1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        label1.setText("Amount Approved");
        add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 143, -1));

        amountApproved.setEditable(false);
        amountApproved.setEnabled(false);
        amountApproved.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        add(amountApproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 170, -1));

        ApprovedJbtn.setBackground(new java.awt.Color(255, 255, 255));
        ApprovedJbtn.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        ApprovedJbtn.setText("Approve");
        ApprovedJbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApprovedJbtnActionPerformed(evt);
            }
        });
        add(ApprovedJbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 100, -1));

        RejectedJbtn.setBackground(new java.awt.Color(255, 255, 255));
        RejectedJbtn.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        RejectedJbtn.setText("Reject");
        RejectedJbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RejectedJbtnActionPerformed(evt);
            }
        });
        add(RejectedJbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 80, -1));

        calculatebtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        calculatebtn.setForeground(new java.awt.Color(0, 153, 153));
        calculatebtn.setText("Calculate");
        calculatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculatebtnActionPerformed(evt);
            }
        });
        add(calculatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("Status");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, -1, -1));

        messageTextField.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        add(messageTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 170, -1));

        refreshBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        refreshBtn.setForeground(new java.awt.Color(0, 153, 153));
        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });
        add(refreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setText("Message");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setText("Amount Requested");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 191, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ClaimsWorkAreaJPanel dwjp = (ClaimsWorkAreaJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    
        
    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        
        if(ApprovedJbtn.isSelected() && RejectedJbtn.isSelected() ){
              JOptionPane.showMessageDialog(null, "Please select either Accept or Reject (only 1) to submit the claim");
              return;
        }
        else if(ApprovedJbtn.isSelected()==false && RejectedJbtn.isSelected()==false) {
            JOptionPane.showMessageDialog(null, "Please Accept or Reject the Claim Before Submission");
            return;
        }else if (ApprovedJbtn.isSelected()) {
            if (amountApproved.getText() == null || amountApproved.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter amount!!");
                return;
            }
           
            int temp =Integer.parseInt(amountApproved.getText());
//            System.out.println(temp);
            //check condition
             if(amountApproved.getText().equals("") || amountApproved.getText().equals(null)){
             JOptionPane.showMessageDialog(null, "Please calculate approved amount before submitting");
              return;
            }else if(temp <= 0){
             JOptionPane.showMessageDialog(null, "Amount should be more than 0");
              return;
            }
             
            this.amount = Integer.parseInt(amountApproved.getText());
            this.status="Claim Approved";
            request.setClaimstatus("Claim Approved");
            forward = "not required";
            
            ///amount calculation
             try {
                 this.updatedbill = Integer.parseInt(request.getBill()) - Integer.parseInt(amountApproved.getText()) ;
             }catch(Exception ex){
                 this.updatedbill = 500 - Integer.parseInt(amountApproved.getText()) ;
             }
            

        } else if (RejectedJbtn.isSelected()) {
            amount = 0;
            this.status= "Claim Rejected";
            request.setClaimstatus("Claim Rejected");
            forward = "required";
            
           updatedbill=Integer.parseInt(request.getBill());
            
        }
        
        BillingWorkRequest newrequest = new BillingWorkRequest();
        
        
        newrequest.setMessage(messageTextField.getText());
        newrequest.setSender(account);
        newrequest.setClaimstatus(status);
        newrequest.setType("Patient");
        newrequest.setPatient(request.getPatient());
        newrequest.setInsurancecard(request.getInsuranceCard());
        
        
        
           
            
             
        newrequest.setBill(String.valueOf(updatedbill));
        newrequest.setEmail(request.getEmailid());
        newrequest.setAmountApproved(amount);
        newrequest.setForwardrequest(forward);

       
     
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof OrgBillings){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(newrequest);
            //userAccount.getWorkQueue().getWorkRequestList().add(request);
        }
        JOptionPane.showMessageDialog(null,"Forwarded to Billing Successfully!!!!");
       
        
        ///////sending back to billing dept
        
        

    }//GEN-LAST:event_submitJButtonActionPerformed

    private void calculatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculatebtnActionPerformed
        
        
        int jspinner = (Integer) PercentageApproved.getValue();

        float k = (float) (jspinner / 100.0);
        
        int billamount = 500;
        try{
            billamount = Integer.parseInt(request.getBill());
        }catch(Exception ex){
              billamount=500;
        }
//         //bydefault

        float temp = billamount * k;
    try
    {   int amountapproved = Math.round(temp);
        amountApproved.setText(String.valueOf(amountapproved));

        this.amount_Approved = amountapproved;
    }
//    catch(Exception ex)
//    {
//        JOptionPane.showMessageDialog(null,"Please enter a valid claim amount perentage!!");
//        return;
//    }
        finally{
        System.out.println("hello");
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_calculatebtnActionPerformed

    private void ApprovedJbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApprovedJbtnActionPerformed
        RejectedJbtn.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_ApprovedJbtnActionPerformed

    private void RejectedJbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RejectedJbtnActionPerformed
       ApprovedJbtn.setEnabled(false);
       amountApproved.setText("0");
       amountApproved.setEnabled(false);
       calculatebtn.setEnabled(false);
       PercentageApproved.setEnabled(false);
       
    }//GEN-LAST:event_RejectedJbtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        ApprovedJbtn.setSelected(false);
        ApprovedJbtn.setEnabled(true);
        RejectedJbtn.setSelected(false);    
        RejectedJbtn.setEnabled(true);
        calculatebtn.setEnabled(true);
        PercentageApproved.setEnabled(true);
        amountApproved.setEnabled(true);
        amountApproved.setText("");
        messageTextField.setText("");
    }//GEN-LAST:event_refreshBtnActionPerformed
//
//    private void sendeapprovedmailto() throws Exception {
////    MailClass mailclass=new MailClass("Your Claim registered of amount"+ request.getBill() + " has been Approved","Registeration-Brigham");
////   mailclass.sendmail();
//        MailNew m = new MailNew(request.getEmailid(), "Welcome to " + enterprise.getName(), "This is your welcome mail from" + enterprise.getName() + ". It is to inform you that Your Claim registered of amount" + request.getBill() + " has been Rejected.");
//    }
//
//    private void senderejectedmailto() throws Exception {
////    MailClass mailclass=new MailClass(txtemail.getText(),"Your Claim registered of amount"+ request.getBill() + " has been Rejected","Registeration-Brigham");
////   mailclass.sendmail();
//        MailNew m = new MailNew(request.getEmailid(), "Welcome to " + enterprise.getName(), "This is your welcome mail from" + enterprise.getName() + ". It is to inform you that Your Claim registered of amount" + request.getBill() + " has been Rejected.");
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ApprovedJbtn;
    private javax.swing.JSpinner PercentageApproved;
    private javax.swing.JRadioButton RejectedJbtn;
    private java.awt.TextField amountApproved;
    private javax.swing.JTextField amountRequested;
    private javax.swing.JButton backJButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton calculatebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JTextField messageTextField;
    private java.awt.Label patientname;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton submitJButton;
    private java.awt.Label textfield;
    // End of variables declaration//GEN-END:variables
}
