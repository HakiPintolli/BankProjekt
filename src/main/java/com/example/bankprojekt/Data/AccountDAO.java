package com.example.bankprojekt.Data;

import com.example.bankprojekt.Models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    public Account getAccount(String accountNumber) throws SQLException {
        String query = "SELECT * FROM accounts WHERE account_number = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Account(
                        rs.getString("owner"),
                        rs.getString("account_number"),
                        rs.getDouble("balance"),
                        rs.getString("account_type"),
                        rs.getInt("transaction_limit"),
                        rs.getDouble("withdrawal_limit")
                );
            }
        }
        return null;
    }
}

