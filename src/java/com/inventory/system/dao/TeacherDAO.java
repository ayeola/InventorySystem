/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.Teacher;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Abiodun.Ayeola
 */
public interface TeacherDAO{
    public Teacher register(Teacher teacher);
    public Teacher editProfile(Teacher teacher);
    public void remove(Teacher teacher);
    public Teacher findTeacherByRegNumber(String regNumber);
    public List<Teacher> fetchTeacherByDateRange(Date fromDate,Date toDate);
    public List<Teacher> fetchTeacher();
    public Teacher findTeacherByPhoneNumber(String phoneNumber);
    public Teacher findTeacherByEmail(String email);
    
}
