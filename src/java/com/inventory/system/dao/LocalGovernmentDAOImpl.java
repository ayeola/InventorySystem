/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.LocalGovernment;
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
@Repository("localGovtDAO")
public class LocalGovernmentDAOImpl extends StateDAOImpl implements LocalGovernmentDAO {

    @Override
    public LocalGovernment addLocalGovernment(LocalGovernment local) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(local);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return local;
    }

    @Override
    public LocalGovernment updateLocalGovernment(LocalGovernment local) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(local);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return local;
    }

    @Override
    public LocalGovernment findLocalGovtByCode(String localCode) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        LocalGovernment local = null;
        try {
            Criteria criteria = session.createCriteria(LocalGovernment.class);
            criteria.add(Restrictions.eq("localGovernmentCode", localCode));
            List list = criteria.list();
            local = (LocalGovernment) (list.isEmpty() ? null : list.get(0));
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return local;
    }

    @Override
    public LocalGovernment findLocalGovtById(Integer indexValue) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        LocalGovernment local = null;
        try {
            Criteria criteria = session.createCriteria(LocalGovernment.class);
            criteria.add(Restrictions.eq("id", indexValue));
            List list = criteria.list();
            local = (LocalGovernment) (list.isEmpty() ? null : list.get(0));
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return local;
    }

    @Override
    public List<LocalGovernment> fetchLocalGovt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalGovernment findLocalGovtByName(String localName) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        LocalGovernment local = null;
        try {
            Criteria criteria = session.createCriteria(LocalGovernment.class);
            criteria.add(Restrictions.eq("localGovernmentName", localName));
            List list = criteria.list();
            local = (LocalGovernment) (list.isEmpty() ? null : list.get(0));
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return local;
    }

}
