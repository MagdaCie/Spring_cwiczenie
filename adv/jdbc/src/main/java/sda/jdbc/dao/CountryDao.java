package sda.jdbc.dao;

import sda.jdbc.przyklad4.Country;

import java.sql.SQLException;
import java.util.List;

public interface CountryDao {

    List<Country> getAll() throws SQLException;
    Country findById(int id);
    void addNewCountry(Country country);
    void deleteById(int id);

}
