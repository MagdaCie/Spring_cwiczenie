package sda.jdbc.przyklad2;

import sda.jdbc.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Przyklad2 {

    public static void main(String[] args) throws SQLException {
        String id = "3 or 1=1";
        String query = "Select * from Address where add_id = ?";

        DatabaseConnection databaseConnection = new DatabaseConnection();

        PreparedStatement preparedStatement = databaseConnection
                .getConnection()
                .prepareStatement(query);

        preparedStatement.setString(1, id);


        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("ADD_Street"));
        }
    }

}
