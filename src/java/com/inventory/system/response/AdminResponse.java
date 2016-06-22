/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.response;

import com.inventory.system.model.Admin;


/**
 *
 * @author ayeola
 */
public class AdminResponse extends ServiceResponse{
    
    private Admin admin;

    public AdminResponse() {
    }
          
    public AdminResponse(Admin admin) {
        this.admin = admin;
    }

    public AdminResponse(Admin admin, String statusCode, String statusMessage, String sessionId) {
        super(statusCode, statusMessage, sessionId);
        this.admin = admin;
    }
    
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    
}
