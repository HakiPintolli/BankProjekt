package com.example.bankprojekt.Controller.Client;

import javafx.fxml.Initializable;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.net.ResourceBundle;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Text user_name;
    public label login_date;
    public label checking_bal;
    public label checking_acc_num;
    public label savings_bal;
    public label savings_acc_num;
    public label income_lbl;
    public label expense_lbl;
    public ListView transaction_listview;
    public TextField payee_fld;
    public TextField amount_fld;

    @Override
    public void initiaize(URL url, ResourceBundle resourceBundle){}
}
