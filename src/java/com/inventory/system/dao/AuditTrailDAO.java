/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.AuditTrail;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Abiodun.Ayeola
 */
public interface AuditTrailDAO {
    public AuditTrail addTrail(AuditTrail trail);
    public List<AuditTrail> fetchAuditTrail();
    public List<AuditTrail> fetchAuditByDateRange(Date fromDate,Date toDate);
}
