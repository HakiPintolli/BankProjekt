package com.example.bankprojekt.Models;

import com.example.bankprojekt.Data.DatabaseConnector; // Import DatabaseConnector
import com.example.bankprojekt.Views.AccountType;
import com.example.bankprojekt.Views.ViewFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static com.example.bankprojekt.Data.DatabaseConnector.getConnection;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private AccountType loginAccountType = AccountType.CLIENT;
    private Client client;
    private boolean clientLoginSuccessFlag;
    private boolean adminLoginSuccessFlag;

    private Model() {
        this.viewFactory = new ViewFactory();
        this.clientLoginSuccessFlag = false;
        this.client = new Client(1, "", "", null, null);
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public boolean getClientSuccessFlag() {
        return this.clientLoginSuccessFlag;
    }

    public void setClientLoginSuccessFlag(boolean flag) {
        this.clientLoginSuccessFlag = flag;
    }

    public Client getClient() {
        return client;
    }

    public void evaluateClient(String pAddress, String password) {
        Client client = DatabaseConnector.getClientData(pAddress, password);
        if (client != null) {
            this.client = client;
            this.clientLoginSuccessFlag = true;
        } else {
            this.clientLoginSuccessFlag = false;
        }
    }

    public boolean evaluateAdmin(String username, String password) {
        boolean isAdminValid = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM users WHERE payee_address = ? AND password = ? AND account_type = 'ADMIN'"
             )) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) { // Checks if there is at least one result
                    isAdminValid = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdminValid;
    }


    public boolean getAdminSuccessFlag() {
        return adminLoginSuccessFlag;
    }
}
