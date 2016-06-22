/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.support;

/**
 *
 * @author Abiodun.Ayeola
 */
public class InventoryHelper {
    private String staffRegistrationNo;
    private String sourceIp;
    private String systemUser;

    public InventoryHelper() {
    }

    public InventoryHelper(String staffRegistrationNo) {
        this.staffRegistrationNo = staffRegistrationNo;
    }

    public InventoryHelper(String staffRegistrationNo, String sourceIp, String systemUser) {
        this.staffRegistrationNo = staffRegistrationNo;
        this.sourceIp = sourceIp;
        this.systemUser = systemUser;
    }         

    public String getStaffRegistrationNo() {
        return staffRegistrationNo;
    }

    public void setStaffRegistrationNo(String staffRegistrationNo) {
        this.staffRegistrationNo = staffRegistrationNo;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public String getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(String systemUser) {
        this.systemUser = systemUser;
    }

    
    
    
    
}
