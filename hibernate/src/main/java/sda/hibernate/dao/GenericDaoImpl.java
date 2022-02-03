package sda.hibernate.dao;

import org.hibernate.Session;
import sda.hibernate.util.HibernateUtil;

import java.util.List;

public class GenericDaoImpl<T> implements GenericDao<T> {

    private Class<T> entityClass;

    public GenericDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        T result = session.find(entityClass, id);
        session.close();
        return result;
    }

    @Override
    public void insertObject(Object o) {

    }

    @Override
    public void deleteObject(Object o) {

    }

    @Override
    public void deleteObject(int T) {

    }

    @Override
    public void updateObject(Object o, int id) {

    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public List getAll(int maxResults, int firstResoult) {
        return null;
    }
}
