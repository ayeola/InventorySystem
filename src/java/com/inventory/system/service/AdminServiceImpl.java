/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.service;

import com.inventory.system.dao.AdminDAOImpl;
import com.inventory.system.dao.AuditTrailDAOImpl;
import com.inventory.system.dao.LocalGovernmentDAO;
import com.inventory.system.dao.LocalGovernmentDAOImpl;
import com.inventory.system.model.Admin;
import com.inventory.system.model.AuditTrail;
import com.inventory.system.model.NonTeachingStaff;
import com.inventory.system.model.Teacher;
import com.inventory.system.response.ServiceResponse;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Abiodun.Ayeola
 */
@Service("adminService")
public class AdminServiceImpl extends AuditTrailServiceImpl implements AdminService {

    @Autowired
    @Qualifier("adminDAO")//This specify the I'm inject adminDAO Bean
    private AdminDAOImpl adminImpl;
    
    @Autowired
    @Qualifier("")
    private LocalGovernmentDAOImpl localImpl;
    

    @Transactional
    @Override
    public ServiceResponse addUser(Admin admin) {
        ServiceResponse response = new ServiceResponse();
        AuditTrail trail = new AuditTrail();
        Admin user = adminImpl.findUserByUsername(admin.getSystemUser());
        if (user != null) {
            Admin verifyUser = adminImpl.findUserByUsername(admin.getUsername());
            if (verifyUser != null) {
                response.setStatusCode("01");
                response.setStatusMessage("Username Already exist, please choose another username");
                return response;
            }
            if (admin.getCategory().equals("TS")) {
                Teacher teacher = adminImpl.findTeacherByRegNumber(admin.getStaffRegistrationNo());
                if (teacher != null) {
                    admin.setTeacher(teacher);
                    Admin newAdmin = adminImpl.addUser(admin);
                    if (newAdmin != null && newAdmin.getId() != null) {
                        trail.setActionPerformed("CreateUser");
                        trail.setAdmin(admin);
                        trail.setSource(admin.getSourceIp());
                        trail.setStatus("Successful");
                        trail.setTrailDate(new Date());
                        this.logTrail(trail);
                        response.setStatusCode("00");
                        response.setStatusMessage("Successful");
                        return response;
                    } else {
                        response.setStatusCode("01");
                        response.setStatusMessage("Create NT User Not Successful");
                        return response;
                    }

                }
            } else {
                NonTeachingStaff nts = adminImpl.findNTSByRegNumber(admin.getStaffRegistrationNo());
                if (nts != null) {
                    admin.setNonteachingstaff(nts);
                    Admin newAdmin = adminImpl.addUser(admin);
                    if (newAdmin != null && newAdmin.getId() != null) {
                        trail.setActionPerformed("CreateUser");
                        trail.setAdmin(admin);
                        trail.setSource("");
                        trail.setStatus("Successful");
                        trail.setTrailDate(new Date());
                        this.logTrail(trail);
                        response.setStatusCode("00");
                        response.setStatusMessage("Successful");
                        return response;
                    } else {
                        response.setStatusCode("01");
                        response.setStatusMessage("Create NTS User Not Successful");
                        return response;
                    }

                }
            }
        } else {
            response.setStatusCode("01");
            response.setStatusMessage("User Not Found");
            return response;
        }

        return response;
    }

    @Override
    public Admin updateUser(Admin admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admin findUserByUsername(String username) {
        return adminImpl.findUserByUsername(username);
    }

    @Override
    public List<Admin> fetchUsersByCategory(String category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    public boolean verifyUser(String username) {
        Admin admin = adminImpl.findUserByUsername(username);
        return admin!=null;
    }
}
