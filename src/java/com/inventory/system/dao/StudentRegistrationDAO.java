/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.AcademicClass;
import com.inventory.system.model.StudentRegistration;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Abiodun.Ayeola
 */
public interface StudentRegistrationDAO{
    public StudentRegistration register(StudentRegistration student);
    public StudentRegistration update(StudentRegistration student);
    public List<StudentRegistration> fetchStudentsByClass(AcademicClass stdClass);
    public List<StudentRegistration> fetchStudentsByDateRange(Date fromDate,Date toDate);
    public List<StudentRegistration> fetchRegisteredStudents();
}
