/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.service;

import com.inventory.system.dao.AuditTrailDAOImpl;
import com.inventory.system.model.AuditTrail;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Abiodun.Ayeola
 */
@Service
public class AuditTrailServiceImpl implements AuditTrailService{
    @Autowired
    @Qualifier("auditTrailDAO")
    private AuditTrailDAOImpl auditTrailImpl;

    @Override
    public void logTrail(AuditTrail trail) {
        auditTrailImpl.addTrail(trail);
    }

    @Override
    public List<AuditTrail> fetchTrailByDateRage(Date fromDate, Date toDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AuditTrail> fetchTrail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
