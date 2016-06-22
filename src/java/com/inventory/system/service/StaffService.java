/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.service;

import com.inventory.system.model.AcademicClass;
import com.inventory.system.model.LocalGovernment;
import com.inventory.system.model.NonTeachingStaff;
import com.inventory.system.model.State;
import com.inventory.system.model.Teacher;
import com.inventory.system.response.ServiceResponse;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Abiodun.Ayeola
 */
public interface StaffService {
    public ServiceResponse addTeacher(Teacher teacher);
    public ServiceResponse editTeacher(Teacher teacher);
    public ServiceResponse removeTeacher(String regNumber);
    public List<Teacher> fetchTeacher();
    public List<Teacher> fetchTeacherByClass(AcademicClass teacherClass);
    public List<Teacher> fetchTeacherByState(State state);
    public List<Teacher> fetchTeacherByLocalGovtAndState(State state,LocalGovernment localGovt);
    public ServiceResponse addNTS(NonTeachingStaff nts);
    public ServiceResponse editNTS(NonTeachingStaff nts);
    public ServiceResponse removeNTS(String regNumber);
    public List<NonTeachingStaff> fetchNTSByState(State state);
    public List<NonTeachingStaff> fetchNTSByLocalGovtAndState(State state,LocalGovernment localGovt);
    public List<NonTeachingStaff> fetchNTSByDateRange(Date fromDate,Date toDate);
    public List<NonTeachingStaff> fetchNTS();
}
