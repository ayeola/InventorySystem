/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.NonTeachingStaff;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Abiodun.Ayeola
 */
public interface NonTeachingStaffDAO{
    public NonTeachingStaff addNonTeachingStaff(NonTeachingStaff staff);
    public NonTeachingStaff editNonTeachingStaff(NonTeachingStaff staff);
    public List<NonTeachingStaff> fetchByDateRange(Date fromDate,Date toDate);
    public List<NonTeachingStaff> fetchNonTeachingStaff();
    public NonTeachingStaff findNTSByRegNumber(String regNumber);
    public NonTeachingStaff findNTSByPhoneNumber(String phoneNumber);
    public NonTeachingStaff findNTSByEmail(String email);
    
}
