package com.example.bankprojekt.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class ViewFactory {

    private AnchorPane transactionsView;


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
