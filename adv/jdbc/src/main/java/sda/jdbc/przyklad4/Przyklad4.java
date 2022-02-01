package sda.jdbc.przyklad4;

import sda.jdbc.util.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Przyklad4 {

    public static void main(String[] args) throws SQLException {
        String sqlSelect = "Select * from Address join Country on add_co_id = co_id";
        DatabaseConnection databaseConnection = new DatabaseConnection();
        ResultSet resultSet = databaseConnection
                .getConnection()
                .createStatement()
                .executeQuery(sqlSelect);

        List<Address> addresses = new ArrayList<>();
        while (resultSet.next()) {
            addresses.add(new Address(
                    resultSet.getInt("ADD_ID"),
                    resultSet.getString("ADD_STREET"),
                    resultSet.getString("ADD_BUILDING_NO"),
                    resultSet.getString("ADD_APARTAMENT_NO"),
                    resultSet.getString("ADD_CITY"),
                    resultSet.getString("ADD_POSTAL_CODE"),
                    new Country(
                            resultSet.getInt("CO_ID"),
                            resultSet.getString("CO_NAME"),
                            resultSet.getString("CO_ALIAS")
                    )
            ));
        }
        addresses.forEach(address -> System.out.println((address.toString())));
    }
}
