/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.State;
import java.util.List;

/**
 *
 * @author Abiodun.Ayeola
 */
public interface StateDAO {
    public State addState(State state);
    public State editState(State state);
    public State findStateByStateCode(String stateCode);
    public State findStateByStateId(Integer indexValue);
    public State findStateByName(String stateName);
    public List<State> fetchState();
}
