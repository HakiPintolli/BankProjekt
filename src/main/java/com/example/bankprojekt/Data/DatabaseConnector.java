package com.example.bankprojekt.Data;

import com.example.bankprojekt.Models.Client;

import java.sql.*;
import java.time.LocalDate;

public class DatabaseConnector {
    private static final String URL = "jdbc:postgresql://localhost:5432/bankProject";
    private static final String USER = "postgres";
    private static final String PASSWORD = "bank";
    private static Connection connection = null;

    private DatabaseConnector() {
        // private constructor to prevent instantiation
    }

    public static synchronized Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    public static Client getClientData(String pAddress, String password) {
        Client client = null;
        String query = "SELECT * FROM users WHERE payee_address = ? AND password = ? AND account_type = 'CLIENT'";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, pAddress);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                     client = new Client(
                            resultSet.getInt("client_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("payee_address"),
                            resultSet.getString("date_created")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }


    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("Connection established successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getAdminData(String username, String password) {
        ResultSet resultSet = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM users WHERE payee_address = ? AND password = ? AND account_type = 'ADMIN'"
             )) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


}
