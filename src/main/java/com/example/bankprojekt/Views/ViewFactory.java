package com.example.bankprojekt.Views;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class ViewFactory {

    private final StringProperty clientSelectedMenuItem;
    private AnchorPane transactionsView;

    //Admin Views
    private final StringProperty adminSelectedMenuItems;
    private AnchorPane createClientView;
    
    public ViewFactory(){
        this.clientSelectedMenuItem= new SimpleStringProperty("");
        this.adminSelectedMenuItems= new SimpleStringProperty("");
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
    //fik une e shtova qito lidhet me CreateClientControler 
    /*
    *Admin Views Section
    */
    public StringProperty getAdminSelectedMenuItems(){
        return adminSelectedMenuItems;
    }
    public AnchorPane getCreateClientView(){
        if(CreateClientView = null){
        try{CreateClientView = new FXMLLoader(getClass().getResource("/Fxml/Admin/CreateClient.fxml")).load();
           }catch(Exception e){
            e.printStackTrace();
           }
        }
         return CreateClientView;
    }
    public void showAdminWindow() {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Admin.fxml"));
        AdminController controller = new AdminController();
        Loader.setController (controller);
        createStage (Loader);
    }
    //......
}
