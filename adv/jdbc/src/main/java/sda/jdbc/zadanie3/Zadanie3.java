package sda.jdbc.zadanie3;

import sda.jdbc.dao.CountryDao;
import sda.jdbc.dao.CountryDaoImpl;

import java.sql.SQLException;

public class Zadanie3 {
    public static void main(String[] args) throws SQLException {
        CountryDao countryDao = new CountryDaoImpl();
        countryDao.getAll().forEach(country -> System.out.println(country.toString()));
    }
}
