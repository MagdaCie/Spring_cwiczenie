package sda.jdbc.zadanie3;

import sda.jdbc.dao.CountryDao;
import sda.jdbc.dao.CountryDaoImpl;
import sda.jdbc.przyklad4.Country;

import java.sql.SQLException;

public class Zadanie3 {
    public static void main(String[] args) throws SQLException {
        CountryDao countryDao = new CountryDaoImpl();
        countryDao.getAll().forEach(country -> System.out.println(country.toString()));
        System.out.println(countryDao.findById(2));

        countryDao.addNewCountry(new Country(null, "USA", "US"));
        countryDao.deleteById(6);
        countryDao.updateCountry(new Country(10, "Poland", "pl"));
    }
}
