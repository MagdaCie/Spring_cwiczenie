package sda.jdbc.dao;

import sda.jdbc.przyklad4.Country;

import java.sql.SQLException;
import java.util.List;

public interface CountryDao {

    List<Country> getAll() throws SQLException;

    Country findById(int id) throws SQLException;

    void addNewCountry(Country country) throws SQLException;

    void deleteById(int id) throws SQLException;

    void updateCountry(Country country) throws SQLException;
}
