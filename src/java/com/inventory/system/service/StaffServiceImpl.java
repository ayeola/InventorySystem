/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.service;

import com.inventory.system.dao.StaffDAOImpl;
import com.inventory.system.model.AcademicClass;
import com.inventory.system.model.Admin;
import com.inventory.system.model.AuditTrail;
import com.inventory.system.model.LocalGovernment;
import com.inventory.system.model.NonTeachingStaff;
import com.inventory.system.model.State;
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
@Service
public class StaffServiceImpl extends AdminServiceImpl implements StaffService {

    @Autowired
    @Qualifier("staffDAO")
    private StaffDAOImpl staffDAOImpl;

    @Transactional
    @Override
    public ServiceResponse addTeacher(Teacher teacher) {
        ServiceResponse response = new ServiceResponse();

        boolean verifyUser = this.verifyUser(teacher.getSystemUser());
        if (!verifyUser) {
            response.setStatusCode("01");
            response.setStatusMessage("User Not Found");
        }

        Teacher findTeacher = staffDAOImpl.findTeacherByRegNumber(teacher.getStaffRegistrationNo());
        if (findTeacher != null) {
            response.setStatusCode("01");
            response.setStatusMessage("Teacher Already Exists");
            return response;
        }
        
        Teacher verifyEmail = staffDAOImpl.findTeacherByEmail(teacher.getEmail());
        if(verifyEmail!=null){
            response.setStatusCode("01");
            response.setStatusMessage("Email address Already exists, please choose another email address");
            return response;
        }
        
        Teacher verifyPhone = staffDAOImpl.findTeacherByPhoneNumber(teacher.getPhoneNumber());
        if(verifyPhone!=null){
            response.setStatusCode("01");
            response.setStatusMessage("Phone Number Already exists, please choose another Phone Number");
            return response;
        }

        teacher.setRegisteredDate(new Date());
        Teacher newTeacher = staffDAOImpl.register(teacher);
        if (newTeacher != null && newTeacher.getId() != null) {
            Admin admin = this.findUserByUsername(teacher.getSystemUser());
            AuditTrail trail = new AuditTrail();
            trail.setActionPerformed("");
            trail.setAdmin(admin);
            trail.setSource(teacher.getSourceIp());
            trail.setStatus("Successful");
            trail.setTrailDate(new Date());
            this.logTrail(trail);
            response.setStatusCode("01");
            response.setStatusMessage("Registration Successful");
            return response;
        } else {
            response.setStatusCode("01");
            response.setStatusMessage("System couldn't create the user");
            return response;
        }

    }

    @Override
    public ServiceResponse editTeacher(Teacher teacher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ServiceResponse removeTeacher(String regNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Teacher> fetchTeacher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Teacher> fetchTeacherByClass(AcademicClass teacherClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Teacher> fetchTeacherByState(State state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Teacher> fetchTeacherByLocalGovtAndState(State state, LocalGovernment localGovt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ServiceResponse addNTS(NonTeachingStaff nts) {
        ServiceResponse response = new ServiceResponse();

        boolean verifyUser = this.verifyUser(nts.getSystemUser());
        if (!verifyUser) {
            response.setStatusCode("01");
            response.setStatusMessage("User Not Found");
        }

        NonTeachingStaff findNTS = staffDAOImpl.findNTSByRegNumber(nts.getStaffRegistrationNo());
        if (findNTS != null) {
            response.setStatusCode("01");
            response.setStatusMessage("Non teaching staff Already Exists");
            return response;
        }
        
        NonTeachingStaff verifyEmail = staffDAOImpl.findNTSByEmail(nts.getEmail());
        if(verifyEmail!=null){
            response.setStatusCode("01");
            response.setStatusMessage("Email address Already exists, please choose another email address");
            return response;
        }
        
        NonTeachingStaff verifyPhone = staffDAOImpl.findNTSByPhoneNumber(nts.getPhoneNumber());
        if(verifyPhone!=null){
            response.setStatusCode("01");
            response.setStatusMessage("Phone Number Already exists, please choose another Phone Number");
            return response;
        }

        NonTeachingStaff newTeacher = staffDAOImpl.addNonTeachingStaff(nts);
        if (newTeacher != null && newTeacher.getId() != null) {
            Admin admin = this.findUserByUsername(nts.getSystemUser());
            AuditTrail trail = new AuditTrail();
            trail.setActionPerformed("");
            trail.setAdmin(admin);
            trail.setSource(nts.getSourceIp());
            trail.setStatus("Successful");
            trail.setTrailDate(new Date());
            this.logTrail(trail);
            response.setStatusCode("01");
            response.setStatusMessage("Registration Successful");
            return response;
        } else {
            response.setStatusCode("01");
            response.setStatusMessage("System couldn't create the user");
            return response;
        }

    }

    @Override
    public ServiceResponse editNTS(NonTeachingStaff nts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ServiceResponse removeNTS(String regNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NonTeachingStaff> fetchNTSByState(State state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NonTeachingStaff> fetchNTSByLocalGovtAndState(State state, LocalGovernment localGovt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NonTeachingStaff> fetchNTSByDateRange(Date fromDate, Date toDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NonTeachingStaff> fetchNTS() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
