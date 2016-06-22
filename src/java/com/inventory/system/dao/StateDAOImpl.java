/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.State;
import com.inventory.system.model.Teacher;
import com.inventory.system.utils.HibernateBDUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Abiodun.Ayeola
 */
@Repository("stateDAO")
public class StateDAOImpl implements StateDAO {

    @Override
    public State addState(State state) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(state);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return state;
    }

    @Override
    public State editState(State state) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(state);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return state;
    }

    @Override
    public State findStateByStateCode(String stateCode) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        State state = null;
        try {
            Criteria criteria = session.createCriteria(State.class);
            criteria.add(Restrictions.eq("stateCode", stateCode));
            List list = criteria.list();
            state = (State) (list.isEmpty() ? null : list.get(0));
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return state;
    }

    @Override
    public State findStateByStateId(Integer indexValue) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        State state = null;
        try {
            Criteria criteria = session.createCriteria(State.class);
            criteria.add(Restrictions.eq("id", indexValue));
            List list = criteria.list();
            state = (State) (list.isEmpty() ? null : list.get(0));
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return state;
    }

    @Override
    public List<State> fetchState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public State findStateByName(String stateName) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        State state = null;
        try {
            Criteria criteria = session.createCriteria(State.class);
            criteria.add(Restrictions.eq("stateName", stateName));
            List list = criteria.list();
            state = (State) (list.isEmpty() ? null : list.get(0));
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return state;
    }

}
