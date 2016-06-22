/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.AcademicClass;
import com.inventory.system.model.Students;
import java.util.List;

/**
 *
 * @author Abiodun.Ayeola
 */
public interface StudentDAO {
    public Students register(Students student);
    public Students updateProfile(Students student);
    public Students findStudentByRegNumber(String regNumber);
    public List<Students> fetchStudentByClass(AcademicClass stdClass);
    public List<Students> fetchStudents();
    
}
