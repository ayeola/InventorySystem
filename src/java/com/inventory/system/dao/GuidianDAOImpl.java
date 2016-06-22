/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.Guidian;
import com.inventory.system.model.Students;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Abiodun.Ayeola
 */
@Repository("guidianDAO")
public class GuidianDAOImpl extends StudentRegistrationDAOImpl implements GuidianDAO{

    @Override
    public Guidian addGuidian(Guidian guidian) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Guidian updateGuidian(Guidian guidian) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Guidian findGuidianByStudent(Students student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Guidian> fetchGuidian() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
