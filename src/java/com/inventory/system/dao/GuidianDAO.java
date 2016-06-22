/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.Guidian;
import com.inventory.system.model.Students;
import java.util.List;

/**
 *
 * @author Abiodun.Ayeola
 */
public interface GuidianDAO{
    public Guidian addGuidian(Guidian guidian);
    public Guidian updateGuidian(Guidian guidian);
    public Guidian findGuidianByStudent(Students student);
    public List<Guidian> fetchGuidian();
    
}
