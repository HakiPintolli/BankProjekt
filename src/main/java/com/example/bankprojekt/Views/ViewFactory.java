package com.example.bankprojekt.Views;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class ViewFactory {

    private final StringProperty clientSelectedMenuItem;
    private AnchorPane transactionsView;

    public ViewFactory(){
        this.clientSelectedMenuItem= new SimpleStringProperty("");
    }
    public StringProperty getClientSelectedMenuItem(){
        return clientSelectedMenuItem;
    }
    public AnchorPane getTransactionsView() {
        if (transactionsView==null){
            try {
                transactionsView = new FXMLLoader(getClass().getResource("/Fxml/Client/Transactions.fmxl")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return transactionsView;
    }
}
