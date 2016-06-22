/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.model.NonTeachingStaff;
import com.inventory.system.model.Teacher;
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
@Repository("staffDAO")
public class StaffDAOImpl extends AcademicClassDAOImpl implements TeacherDAO, NonTeachingStaffDAO {

    @Override
    public Teacher register(Teacher teacher) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(teacher);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return teacher;
    }

    @Override
    public Teacher editProfile(Teacher teacher) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(teacher);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return teacher;
    }

    @Override
    public void remove(Teacher teacher) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(teacher);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

    }

    @Override
    public Teacher findTeacherByRegNumber(String regNumber) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Teacher teacher = null;
        try {
            Criteria criteria = session.createCriteria(Teacher.class);
            criteria.add(Restrictions.eq("registrationNumber", regNumber));
            List list = criteria.list();
            teacher = (Teacher) (list.isEmpty() ? null : list.get(0));
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return teacher;
    }

    @Override
    public List<Teacher> fetchTeacherByDateRange(Date fromDate, Date toDate) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        List<Teacher> list;

        Criteria criteria = session.createCriteria(Teacher.class);
        criteria.add(Restrictions.between("registeredDate", fromDate, toDate));
        criteria.setFirstResult(0);
        criteria.setMaxResults(500);
        criteria.addOrder(Order.desc("id"));
        list = criteria.list();

        return list;
    }

    @Override
    public List<Teacher> fetchTeacher() {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        List<Teacher> list;

        Criteria criteria = session.createCriteria(NonTeachingStaff.class);
        criteria.setFirstResult(0);
        criteria.setMaxResults(500);
        criteria.addOrder(Order.desc("id"));
        list = criteria.list();

        return list;
    }

    @Override
    public NonTeachingStaff addNonTeachingStaff(NonTeachingStaff nts) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(nts);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return nts;
    }

    @Override
    public NonTeachingStaff editNonTeachingStaff(NonTeachingStaff nts) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(nts);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return nts;
    }

    @Override
    public List<NonTeachingStaff> fetchByDateRange(Date fromDate, Date toDate) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        List<NonTeachingStaff> list;

        Criteria criteria = session.createCriteria(NonTeachingStaff.class);
        criteria.add(Restrictions.between("registeredDate", fromDate, toDate));
        criteria.setFirstResult(0);
        criteria.setMaxResults(500);
        criteria.addOrder(Order.desc("id"));
        list = criteria.list();

        return list;
    }

    @Override
    public NonTeachingStaff findNTSByRegNumber(String regNumber) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        NonTeachingStaff nts = null;
        try {
            Criteria criteria = session.createCriteria(NonTeachingStaff.class);
            criteria.add(Restrictions.eq("registrationNumber", regNumber));
            List list = criteria.list();
            nts = (NonTeachingStaff) (list.isEmpty() ? null : list.get(0));
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return nts;
    }

    @Override
    public List<NonTeachingStaff> fetchNonTeachingStaff() {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        List<NonTeachingStaff> list;

        Criteria criteria = session.createCriteria(NonTeachingStaff.class);
        criteria.setFirstResult(0);
        criteria.setMaxResults(500);
        criteria.addOrder(Order.desc("id"));
        list = criteria.list();

        return list;
    }

    @Override
    public Teacher findTeacherByPhoneNumber(String phoneNumber) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Teacher teacher = null;
        try {
            Criteria criteria = session.createCriteria(Teacher.class);
            criteria.add(Restrictions.eq("phoneNumber", phoneNumber));
            List list = criteria.list();
            teacher = (Teacher) (list.isEmpty() ? null : list.get(0));
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return teacher;
    }

    @Override
    public Teacher findTeacherByEmail(String email) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Teacher teacher = null;
        try {
            Criteria criteria = session.createCriteria(Teacher.class);
            criteria.add(Restrictions.eq("email", email));
            List list = criteria.list();
            teacher = (Teacher) (list.isEmpty() ? null : list.get(0));
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return teacher;
    }

    @Override
    public NonTeachingStaff findNTSByPhoneNumber(String phoneNumber) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        NonTeachingStaff nts = null;
        try {
            Criteria criteria = session.createCriteria(Teacher.class);
            criteria.add(Restrictions.eq("phoneNumber", phoneNumber));
            List list = criteria.list();
            nts = (NonTeachingStaff) (list.isEmpty() ? null : list.get(0));
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return nts;
    }

    @Override
    public NonTeachingStaff findNTSByEmail(String email) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        Transaction tx = null;
        NonTeachingStaff nts = null;
        try {
            Criteria criteria = session.createCriteria(Teacher.class);
            criteria.add(Restrictions.eq("email", email));
            List list = criteria.list();
            nts = (NonTeachingStaff) (list.isEmpty() ? null : list.get(0));
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }

        return nts;
    }

}
