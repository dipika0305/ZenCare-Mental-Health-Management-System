/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Role;

import model.DoctorSchedule;
import model.EcoSys;
import model.Enterprise.Enterprise;
import model.Organization.OrgDoctor;
import model.Organization.Organization;
import model.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.DoctorRole.DoctorWorkAreaMainJPanel;

/**
 *
 * @author dipikam
 */
public class RoleDoctor extends Role{
 public DoctorSchedule schedule =new DoctorSchedule();
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSys business) {
        return new DoctorWorkAreaMainJPanel(userProcessContainer, account, (OrgDoctor)organization, enterprise, business,schedule);
    }
    
    
}
