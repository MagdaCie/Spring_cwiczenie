package sda.hibernate.dao;

import org.hibernate.Session;
import sda.hibernate.model.*;
import sda.hibernate.model.Order;
import sda.hibernate.util.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.*;
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
                criteriaBuilder.like(userRoot.get(User_.lastName), "%" + s + "%")
        );
        Query query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

    public List<User> findAllBornBetween(LocalDate date1, LocalDate date2) {
        return null;
    }

    public List<User> findAllByCountryAlias(String alias) {
        Root<User> userRoot = getRoot(); // SELECT * FROM `User`
        Join<User, Address> addressJoin = userRoot.join(User_.address); //join Address on USR_ADD_ID = ADD_ID
        Join<Address, Country> countryJoin = addressJoin.join(Address_.country); //join Country on ADD_CO_ID = CO_ID
        criteriaQuery.select(userRoot).where(criteriaBuilder.equal(countryJoin.get(Country_.alias), alias)); //where CO_ALIAS = ?
        Query query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        session.close();
        return users;

    }

    public List<User> findAllWhoBoughtProduct(Product product) {
        Root<User> userRoot = getRoot();
        Join<User, Order> orderJoin = userRoot.join(User_.orders);
        Join<Order, Product> productJoin = orderJoin.join(Order_.PRODUCTS);
        criteriaQuery.select(userRoot).where(criteriaBuilder.equal(productJoin, product));
        Query query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

    public List<User> findNonCriteriaIsAllWhoBoughtProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(
                "select u from User u " +
                        "join u.orders o " +
                        "join o.products p " +
                        "where p = :product",
                User.class
        ).setParameter("product", product);
        List<User> productList = query.getResultList();
        session.close();
        return productList;
    }

}