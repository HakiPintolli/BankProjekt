package com.example.bankprojekt.Controller.Admin;

import com.example.bankprojekt.Data.DatabaseConnector;
import com.example.bankprojekt.Models.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ClientsController {
    @FXML
    public TableView<Client> clients_tableview;

    @FXML
    public TableColumn<Client, Integer> client_id_col;

    @FXML
    public TableColumn<Client, String> first_name_col;

    @FXML
    public TableColumn<Client, String> last_name_col;

    @FXML
    public TableColumn<Client, String> payee_address_col;

    @FXML
    public TableColumn<Client, String> date_created_col;

    @FXML
    public void initialize() {
        client_id_col.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        first_name_col.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        last_name_col.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        payee_address_col.setCellValueFactory(new PropertyValueFactory<>("payeeAddress"));
        date_created_col.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));

        clients_tableview.setItems(getClients());
    }

    private ObservableList<Client> getClients() {
        ObservableList<Client> clients = FXCollections.observableArrayList();

        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM clients")) {

            while (resultSet.next()) {
                clients.add(new Client(
                        resultSet.getInt("client_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("payee_address"),
                        resultSet.getString("date_created")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }
}