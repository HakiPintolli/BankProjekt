package com.example.bankprojekt.Controller.Client;

import com.example.bankprojekt.Data.AccountDAO;
import com.example.bankprojekt.Models.Account;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class AccountsController implements Initializable{
    @FXML
    private Label ch_acc_num;
    @FXML private Label transaction_limit;
    @FXML private Label ch_acc_bal;
    @FXML private Label sv_acc_num;
    @FXML private Label withdrawal_limit;
    @FXML private Label sv_acc_bal;

    private AccountDAO accountDao = new AccountDAO();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAccountData();
    }

    private void loadAccountData() {
        try {
            Account checkingAccount = accountDao.getAccount("checkingAccountNumber"); // Replace with actual account number
            Account savingsAccount = accountDao.getAccount("savingsAccountNumber");   // Replace with actual account number

            if (checkingAccount != null) {
                ch_acc_num.setText(checkingAccount.getAccountNumber());
                transaction_limit.setText(String.valueOf(checkingAccount.getTransactionLimit()));
                ch_acc_bal.setText("$" + String.format("%.2f", checkingAccount.getBalance()));
            }

            if (savingsAccount != null) {
                sv_acc_num.setText(savingsAccount.getAccountNumber());
                withdrawal_limit.setText("$" + String.format("%.2f", savingsAccount.getWithdrawalLimit()));
                sv_acc_bal.setText("$" + String.format("%.2f", savingsAccount.getBalance()));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

