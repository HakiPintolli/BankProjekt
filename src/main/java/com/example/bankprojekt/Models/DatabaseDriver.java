package com.example.bankprojekt.Models;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class DatabaseDriver {
    private Collection conn;

    public DatabaseDriver(){
        try{
            this.conn = (Collection) DriverManager.getConnection("jdbc:sqlite:mazebank,db");
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
