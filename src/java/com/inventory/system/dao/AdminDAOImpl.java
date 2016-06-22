/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.Admin;
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
@Repository("adminDAO")
public class AdminDAOImpl extends StaffDAOImpl implements AdminDAO {

    @Override
    public Admin addUser(Admin admin) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(admin);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return admin;
    }

    @Override
    public Admin updateUser(Admin admin) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(admin);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return admin;
    }

    @Override
    public Admin findUserByUsername(String username) {
//        Configuration configuration = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
//        applySettings(configuration.getProperties());
//        SessionFactory factory = configuration.buildSessionFactory(builder.build());
        
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Admin admin = null;
        try {
            Criteria criteria = session.createCriteria(Admin.class);
            criteria.add(Restrictions.eq("username", username));
            List list = criteria.list();
            admin = (Admin) (list.isEmpty() ? null : list.get(0));
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return admin;
    }

    @Override
    public List<Admin> fetchUsersByCategory(String category) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List list = null;
        try {
            Criteria criteria = session.createCriteria(Admin.class);
            criteria.add(Restrictions.eq("category", category));
            list = criteria.list();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return list;
    }

}
