package sda.hibernate.zadanie1;

import sda.hibernate.dao.GenericDao;
import sda.hibernate.dao.GenericDaoImpl;
import sda.hibernate.model.Country;

public class Zadanie1 {

    public static void main(String[] args) {
        GenericDao<Country> genericDao = new GenericDaoImpl<>(Country.class);
        System.out.println(genericDao.findById(1));

    }
}
