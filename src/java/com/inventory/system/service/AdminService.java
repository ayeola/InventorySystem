/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.service;

import com.inventory.system.model.Admin;
import com.inventory.system.response.ServiceResponse;
import java.util.List;

/**
 *
 * @author Abiodun.Ayeola
 */
public interface AdminService {
    public ServiceResponse addUser(Admin admin);
    public Admin updateUser(Admin admin);
    public Admin findUserByUsername(String username);    
    public List<Admin> fetchUsersByCategory(String category);    
    public boolean verifyUser(String username);
}
