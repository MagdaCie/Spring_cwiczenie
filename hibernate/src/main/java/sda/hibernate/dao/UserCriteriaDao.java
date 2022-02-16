package sda.hibernate.dao;

import org.hibernate.Session;
import sda.hibernate.model.User;
import sda.hibernate.model.User_;
import sda.hibernate.util.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class UserCriteriaDao {

    Session session;
    CriteriaBuilder criteriaBuilder;
    CriteriaQuery<User> criteriaQuery;

    private Root<User> getRoot() {
        session = HibernateUtil.getSessionFactory().openSession();
        criteriaBuilder = session.getCriteriaBuilder();
        criteriaQuery = criteriaBuilder.createQuery(User.class);
        //"select from User
        return criteriaQuery.from(User.class);
    }

    // select * from user where usr_lastname like %s%"
    public List<User> findUserWhereNameContains(String s) {
        Root<User> userRoot = getRoot();
        //"where"
        criteriaQuery.select(userRoot).where(
                //user.lastName like s
                criteriaBuilder.like(userRoot.get(User_.lastName), "%"+s+"%")
        );
        Query query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

    public List<User> findAllBornBetween(LocalDate date1, LocalDate date2) {
        return null;
    }

}