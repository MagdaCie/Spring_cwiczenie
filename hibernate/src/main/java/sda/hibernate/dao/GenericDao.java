package sda.hibernate.dao;

import java.util.List;

public interface GenericDao<T> {
    T findById(int id);
    void insertObject(T t);
    void deleteObject(T t);
    void deleteObject(int T);
    void updateObject(T t, int id);
    List<T> getAll();
    List<T> getAll(int maxResults, int firstResoult);
}
