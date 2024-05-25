package com.example.bankprojekt.Controller.Client;

import com.example.bankprojekt.Models.Model;
import com.example.bankprojekt.Views.ClientMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {
  public Button dashboard_btn;
  public Button Transactions_btn;
  public Button Accounts_btn;
  public Button Profile_btn;
  public Button LogOut_btn;
  public Button Report_btn;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle){
    addListeners();
  }

  private void addListeners (){
    dashboard_btn.setOnAction(event -> onDashboard());
    Transactions_btn.setOnAction(event -> onTransactions());
     Accounts_btn.setOnAction(event ->onAccounts());
  }
  private void onDashboard(){
    Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.DASHBOARD);
  }

  private void onTransactions(){
    Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.TRANSACTIONS);
  }

   private void onAccounts() {
    Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.ACCOUNTS);
  }
}
