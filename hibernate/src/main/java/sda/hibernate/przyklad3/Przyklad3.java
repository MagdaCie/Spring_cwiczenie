package sda.hibernate.przyklad3;

import org.hibernate.Session;

import org.hibernate.query.Query;
import sda.hibernate.model.Address;
import sda.hibernate.model.Country;
import sda.hibernate.util.HibernateUtil;

public class Przyklad3 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Country> query = session.createQuery(
                "select c from Country c where c.name = :name",
                Country.class)
                .setParameter("name","Japan");

        query.getResultList().forEach(country -> System.out.println(country.getName()));

        Address address = session.find(Address.class, 1);
        System.out.println("Test");
        session.close();
        System.out.println();
    }
}
