package com.example.bankprojekt.Data;

import com.example.bankprojekt.Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public User getUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM users WHERE payee_address = ? AND password = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("payee_address"),
                        rs.getString("password"),
                        rs.getString("account_type"),
                        rs.getDate("date").toLocalDate() // Assuming 'date' is of SQL DATE type
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
