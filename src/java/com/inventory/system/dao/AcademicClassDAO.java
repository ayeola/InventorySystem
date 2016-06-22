/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.AcademicClass;

/**
 *
 * @author Abiodun.Ayeola
 */
public interface AcademicClassDAO {
    public AcademicClass addClass(AcademicClass object);
    public AcademicClass updateClass(AcademicClass object);
    public AcademicClass findClassByName(String object);
    public AcademicClass findClassById(Integer indexValue);
}
