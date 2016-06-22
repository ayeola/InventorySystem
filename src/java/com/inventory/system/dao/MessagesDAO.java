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
public interface MessagesDAO {
    public Messages addMessage(Messages message);
    public Messages updateMessage(Messages message);
    public List<Messages> fetchMessages();
}
