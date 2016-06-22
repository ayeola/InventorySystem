/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.Accounts;
import com.inventory.system.model.Students;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Abiodun.Ayeola
 */
@Repository("accountDAO")
public class AccountDAOImpl extends StudentDAOImpl implements AccountDAO{

    @Override
    public Accounts addAccount(Accounts account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Accounts updateAccount(Accounts account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Accounts findAccountByStudent(Students student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Accounts findAccountByAccountNo(String accountNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Accounts> getAccounts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
