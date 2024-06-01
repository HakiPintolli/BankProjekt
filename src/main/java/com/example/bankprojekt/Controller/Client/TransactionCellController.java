package com.example.bankprojekt.Controller.Client;

import com.example.bankprojekt.Models.Transaction;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionCellController implements Initializable {

    public Label transaction_date;
    public ImageView icon;
    public Label sender_lbl;
    public Label seciver_lbl;
    public Label amount_lbl;
    public Label server_lbl;

    private final Transaction transaction;


    public TransactionCellController(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
