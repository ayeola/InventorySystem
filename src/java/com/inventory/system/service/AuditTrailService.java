/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.service;

import com.inventory.system.model.AuditTrail;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Abiodun.Ayeola
 */
public interface AuditTrailService {
    public void logTrail(AuditTrail trail);
    public List<AuditTrail> fetchTrailByDateRage(Date fromDate, Date toDate);
    public List<AuditTrail> fetchTrail();
}
