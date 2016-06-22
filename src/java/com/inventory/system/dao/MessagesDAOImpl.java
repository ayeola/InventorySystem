/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.Messages;
import java.util.List;

/**
 *
 * @author Abiodun.Ayeola
 */
public class MessagesDAOImpl extends AbstractDAO<Integer, Messages> implements MessagesDAO{

    @Override
    public Messages addMessage(Messages message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Messages updateMessage(Messages message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Messages> fetchMessages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
