/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.AcademicClass;
import com.inventory.system.model.NonTeachingStaff;
import com.inventory.system.model.StudentRegistration;
import com.inventory.system.utils.HibernateBDUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Abiodun.Ayeola
 */
@Repository("registerDAO")
public class StudentRegistrationDAOImpl extends AcademicClassDAOImpl implements StudentRegistrationDAO {
    

    @Override
    public StudentRegistration register(StudentRegistration student) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(student);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return student;
    }

    @Override
    public StudentRegistration update(StudentRegistration student) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(student);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return student;
    }

    @Override
    public List<StudentRegistration> fetchStudentsByClass(AcademicClass stdClass) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        List<StudentRegistration> list;

        Criteria criteria = session.createCriteria(StudentRegistration.class);
        criteria.add(Restrictions.eq("academicclass", stdClass));
        criteria.setFirstResult(0);
        criteria.setMaxResults(500);
        criteria.addOrder(Order.desc("id"));
        list = criteria.list();

        return list;
    }

    @Override
    public List<StudentRegistration> fetchStudentsByDateRange(Date fromDate, Date toDate) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        List<StudentRegistration> list;

        Criteria criteria = session.createCriteria(StudentRegistration.class);
        criteria.add(Restrictions.between("registeredDate", fromDate, toDate));
        criteria.setFirstResult(0);
        criteria.setMaxResults(500);
        criteria.addOrder(Order.desc("id"));
        list = criteria.list();

        return list;
    }

    @Override
    public List<StudentRegistration> fetchRegisteredStudents() {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        List<StudentRegistration> list;

        Criteria criteria = session.createCriteria(StudentRegistration.class);
        criteria.setFirstResult(0);
        criteria.setMaxResults(500);
        criteria.addOrder(Order.desc("id"));
        list = criteria.list();

        return list;
    }

    

}
