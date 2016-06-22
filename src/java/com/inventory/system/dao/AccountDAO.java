/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.Accounts;
import com.inventory.system.model.Students;
import java.util.List;

/**
 *
 * @author Abiodun.Ayeola
 */
public interface AccountDAO{
    
    public Accounts addAccount(Accounts account);
    public Accounts updateAccount(Accounts account);
    public Accounts findAccountByStudent(Students student);
    public Accounts findAccountByAccountNo(String accountNo);
    public List<Accounts> getAccounts();
}
