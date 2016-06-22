/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.Admin;
import com.inventory.system.model.Role;
import java.util.List;

/**
 *
 * @author Abiodun.Ayeola
 */
public interface RoleDAO{
    public Role addRole(Role role);
    public Role editRole(Role role);
    public Role findRoleByName(String role);
    public List<Role> findRoleByAdmin(Admin admin);
    public List<Role> fetchRole();
    
}
