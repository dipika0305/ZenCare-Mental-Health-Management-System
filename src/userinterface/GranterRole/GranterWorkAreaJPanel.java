/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.GranterRole;

import model.EcoSys;
import model.Organization.OrgGranting;
import model.Organization.Organization;
import model.UserAccount.UserAccount;
import model.WorkQueue.GranterWorkRequest;
import model.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mitali
 */
public class GranterWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSys business;
    private UserAccount userAccount;
    private Organization organization;
    private OrgGranting grantingOrganization;
    HashMap<String,Integer> m;
    
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public GranterWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSys business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        
        this.organization = organization;
        
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            System.out.println(request);
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
            if(((GranterWorkRequest)request).getGrantreceiver()==null){
                 row[2] = " ";
            }else{
                 row[2] = ((GranterWorkRequest)request).getGrantreceiver();
            }

            row[3] = ((GranterWorkRequest)request).getGrantingstatus();
            
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Status"
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
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 375, 96));

        assignJButton.setBackground(new java.awt.Color(255, 255, 255));
        assignJButton.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, -1));

        processJButton.setBackground(new java.awt.Color(255, 255, 255));
        processJButton.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, -1, -1));

        refreshJButton.setBackground(new java.awt.Color(255, 255, 255));
        refreshJButton.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, -1, -1));

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel1.setText("GRANTER");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a row!!");
            return;
            
        }
        GranterWorkRequest request = (GranterWorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
        
        if(request.getGrantreceiver()==null){
        request.setGrantreceiver(userAccount);
        request.setGrantingstatus("processing");
        populateTable();
        }else{
             JOptionPane.showMessageDialog(null,"A granter is already allocated to his case");
            return;
        }
        populateTable();
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        
        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a row!!");
            return;
        }
        
        GranterWorkRequest request = (GranterWorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
     
        
        
        if(request.getGrantreceiver().equals(userAccount)){
            request.setStatus("Processing");
            JOptionPane.showMessageDialog(null,"Processing!!");

            ProcessWorkRequestJPanel processWorkRequestJPanel = new ProcessWorkRequestJPanel(userProcessContainer, userAccount ,request,business);
            userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else if (request.getGrantreceiver()== null){
            JOptionPane.showMessageDialog(null,"assign the case first!!");
            return;
        } else{
            JOptionPane.showMessageDialog(null,"cant process as you are not the granter of this case!!");
            return;
        }
        
        
        populateTable();
    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
        JOptionPane.showMessageDialog(null, "refreshed");
    }//GEN-LAST:event_refreshJButtonActionPerformed
//
//     public HashMap<String,Integer> createHashMap()
//    {
//        HashMap<String,Integer> map=new HashMap<String,Integer>();
//        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
//            if(request.getType()!=null)
//            {
//           if(request.getType().equals("Patient")&& request.getReceiver()!= null) 
// 
//               //&& request.getReceiver().equals(userAccount))
//           {
//                    ///based on granting status we can know- for ex how many are approved, rejected , pending
//                     String key=((GranterWorkRequest)request).getGrantingstatus();
//                    if(request.getState()!=null)
//                    {
//                        map.put(key, map.containsKey(key)?map.get(key)+1:1);
//                    }
//            }
//            //}
//        }
//        }
//       return map; 
//    }
//    public void createPiechart(HashMap<String,Integer> m)
//    {
//        Graph g=new Graph();
//       //ChartFrame c= 
//               g.create(m);
//        
//        JPanel imgPanel=new JPanel();
//            
//            
//            imgPanel.add(c);
//            imgPanel.setVisible(true);
//            add(imgPanel);
        
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
