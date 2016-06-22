/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.LocalGovernment;
import java.util.List;

/**
 *
 * @author Abiodun.Ayeola
 */
public interface LocalGovernmentDAO {
    public LocalGovernment addLocalGovernment(LocalGovernment local);
    public LocalGovernment updateLocalGovernment(LocalGovernment local);
    public LocalGovernment findLocalGovtByCode(String localCode);
    public LocalGovernment findLocalGovtByName(String localName);
    public LocalGovernment findLocalGovtById(Integer indexValue);
    public List<LocalGovernment> fetchLocalGovt();
}
