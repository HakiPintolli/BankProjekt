package com.example.bankprojekt.Models;

import java.sql.*;


public class DatabaseDriver {
    private Connection conn;

    public DatabaseDriver(){
        try{
            this.conn = DriverManager.getConnection("jdbc:sqlite:mazebank.db");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ResultSet getClientData(String pAddress, String password){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * from Clients where PayeeAddress='"+pAddress+"' and " +
                    "Password='"+password+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
