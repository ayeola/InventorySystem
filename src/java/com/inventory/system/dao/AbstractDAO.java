/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.dao;

import com.inventory.system.utils.HibernateBDUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Abiodun.Ayeola
 * @param <PK>
 * @param <T>
 */
public abstract class AbstractDAO<PK extends Serializable, T> {
    
    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }


    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        return (T) session.get(persistentClass, key);
    }

    public void persist(T entity) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        session.persist(entity);
    }

    public void delete(T entity) {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        session.delete(entity);
    }

    protected Criteria createEntityCriteria() {
        Session session = HibernateBDUtil.getSessionFactory().openSession();
        return session.createCriteria(persistentClass);
    }
}
