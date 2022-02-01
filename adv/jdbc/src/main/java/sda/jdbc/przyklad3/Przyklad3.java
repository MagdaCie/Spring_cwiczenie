package sda.jdbc.przyklad3;

import sda.jdbc.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Przyklad3 {

    private static final int BUILDING_NO_PARAMETER_INDEX = 1;
    private static final int POSTAL_CODE_PARAMETER_INDEX = 2;

    public static void main(String[] args) throws SQLException {
        String sqlUpdate = "Update Address "+
                " SET ADD_BUILDING_NO = ?"+
                " WHERE ADD_POSTAL_CODE = ?;";

        DatabaseConnection databaseConnection = new DatabaseConnection();

        PreparedStatement preparedStatement = databaseConnection
                .getConnection()
                .prepareStatement(sqlUpdate);

        preparedStatement.setString(BUILDING_NO_PARAMETER_INDEX, "1");
        preparedStatement.setString(POSTAL_CODE_PARAMETER_INDEX, "79677");

        int countUpdatedRecords = preparedStatement.executeUpdate();
        System.out.println("zaktualizowano "+countUpdatedRecords+ " wierszy");
        databaseConnection.getConnection().close();
    }
}


