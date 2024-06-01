package com.example.bankprojekt.Controller.Admin;

import com.example.bankprojekt.Data.DatabaseConnector;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CreateClientController  {
    @FXML
    public TextField fName_fld;

    @FXML
    public TextField lName_fld;

    @FXML
    public TextField address_fld;

    @FXML
    public Button create_client_button;

    @FXML
    public Label error_lbl;

    @FXML
    public void initialize() {
        create_client_button.setOnAction(event -> {
            try {
                handleCreateClient();
            } catch (SQLException e) {
                e.printStackTrace();
                error_lbl.setText("Error creating client: " + e.getMessage());
                error_lbl.setVisible(true);
            }
        });
    }

    private void handleCreateClient() throws SQLException {
        String firstName = fName_fld.getText();
        String lastName = lName_fld.getText();
        String payeeAddress = address_fld.getText();

        if (firstName.isEmpty() || lastName.isEmpty() || payeeAddress.isEmpty()) {
            error_lbl.setText("Please fill all required fields.");
            error_lbl.setVisible(true);
            return;
        }

        try (Connection connection = DatabaseConnector.getConnection()) {
            String insertClientSQL = "INSERT INTO clients (first_name, last_name, payee_address, date_created) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertClientSQL)) {
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, payeeAddress);
                preparedStatement.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
                preparedStatement.executeUpdate();
            }

            error_lbl.setText("Client created successfully!");
            error_lbl.setVisible(true);
        }
    }
}
