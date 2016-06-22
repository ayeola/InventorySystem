/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.AcademicClass;
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
@Repository("academicDAO")
public class AcademicClassDAOImpl implements AcademicClassDAO {

    @Override
    public AcademicClass addClass(AcademicClass object) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(object);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return object;
    }

    @Override
    public AcademicClass findClassByName(String object) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        AcademicClass acaClass = null;
        try {
            Criteria criteria = session.createCriteria(Teacher.class);
            criteria.add(Restrictions.eq("className", object));
            List list = criteria.list();
            acaClass = (AcademicClass) (list.isEmpty() ? null : list.get(0));
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return acaClass;
    }

    @Override
    public AcademicClass findClassById(Integer indexValue) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        AcademicClass acaClass = null;
        try {
            Criteria criteria = session.createCriteria(Teacher.class);
            criteria.add(Restrictions.eq("id", indexValue));
            List list = criteria.list();
            acaClass = (AcademicClass) (list.isEmpty() ? null : list.get(0));
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return acaClass;
    }

    @Override
    public AcademicClass updateClass(AcademicClass object) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(object);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return object;
    }

}
