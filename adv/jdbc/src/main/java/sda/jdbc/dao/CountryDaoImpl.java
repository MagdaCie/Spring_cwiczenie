package sda.jdbc.dao;

import sda.jdbc.przyklad4.Country;
import sda.jdbc.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl implements CountryDao {

    private static final String selectAll = "select * from Country;";
    private static final int COUNTRY_NAME_INDEX = 1;
    private static final int COUNTRY_NAME_INDEX_UPDATE = 2;
    private static final String selectById = "select * from Country where CO_ID = ?;";
    private static final String addNewCountry = "Insert into Country (CO_NAME, CO_ALIAS) values (?, ?);";
    private static final int ADD_COUNTRY_NAME_INDEX = 1;
    private static final int ADD_COUNTRY_ALIAS_INDEX = 2;
    private final String deleteById = "delete from Country where CO_ID = ?;";
    private final int CO_ID_INDEX = 1;
    private final String sqlUpdate = "Update country SET CO_NAME = ?, CO_ALIAS = ?;";

    private Country mapResultSetToCountry(ResultSet resultSet) throws SQLException {
        return new Country(
                resultSet.getInt("CO_ID"),
                resultSet.getString("CO_NAME"),
                resultSet.getString("CO_ALIAS")
        );
    }

    @Override
    public List<Country> getAll() throws SQLException {
        ResultSet resultSet = getConnection().createStatement().executeQuery(selectAll);
        List<Country> countries = new ArrayList<>();
        while (resultSet.next()) {
            countries.add(mapResultSetToCountry(resultSet));
        }
        return countries;
    }

    @Override
    public Country findById(int id) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(selectById);
        preparedStatement.setString(COUNTRY_NAME_INDEX, String.valueOf(id));
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return mapResultSetToCountry(resultSet);
        }
        return null;
    }

    @Override
    public void addNewCountry(Country country) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(addNewCountry);
        preparedStatement.setString(ADD_COUNTRY_NAME_INDEX, country.getName());
        preparedStatement.setString(ADD_COUNTRY_ALIAS_INDEX, country.getAlias());
        preparedStatement.executeUpdate();
    }


    @Override
    public void deleteById(int Id) throws SQLException {
        if(findById(Id)!= null){
            PreparedStatement preparedStatement = getConnection().prepareStatement(deleteById);
            preparedStatement.setInt(CO_ID_INDEX, Id);
            preparedStatement.executeUpdate();
            preparedStatement.getConnection().close();
        }
    }

    @Override
    public void updateCountry(Country country) throws SQLException {
        if (findById(country.getId()) != null) {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sqlUpdate);
            preparedStatement.setString(ADD_COUNTRY_NAME_INDEX, country.getName());
            preparedStatement.setString(ADD_COUNTRY_ALIAS_INDEX, country.getAlias());
            preparedStatement.setInt(COUNTRY_NAME_INDEX_UPDATE, country.getId());
            preparedStatement.executeUpdate();
        } else {
            addNewCountry(country);
        }
    }

    private Connection getConnection() {
        return new DatabaseConnection().getConnection();
    }
}
