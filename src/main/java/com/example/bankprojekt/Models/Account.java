package com.example.bankprojekt.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Account {
    private final StringProperty owner;
    private final StringProperty accountNumber;
    private final DoubleProperty balance;
    private final StringProperty accountType; // Added to hold account type
    private final SimpleDoubleProperty withdrawalLimit; // Changed to DoubleProperty for consistency
    private final SimpleDoubleProperty transactionLimit; // Changed to DoubleProperty for consistency

    public Account(String owner, String accountNumber, double balance, String accountType, double transactionLimit, double withdrawalLimit){
        this.owner = new SimpleStringProperty(this, "owner", owner);
        this.accountNumber = new SimpleStringProperty(this, "accountNumber", accountNumber);
        this.balance = new SimpleDoubleProperty(this, "balance", balance);
        this.accountType = new SimpleStringProperty(this, "accountType", accountType);
        this.transactionLimit = new SimpleDoubleProperty(this, "transactionLimit", transactionLimit);
        this.withdrawalLimit = new SimpleDoubleProperty(this, "withdrawalLimit", withdrawalLimit);
    }

    // Property getters for JavaFX binding
    public StringProperty ownerProperty() { return owner; }
    public StringProperty accountNumberProperty() { return accountNumber; }
    public DoubleProperty balanceProperty() { return balance; }
    public StringProperty accountTypeProperty() { return accountType; }
    public DoubleProperty transactionLimitProperty() { return transactionLimit; }
    public DoubleProperty withdrawalLimitProperty() { return withdrawalLimit; }

    // Normal getters
    public String getOwner() { return owner.get(); }
    public String getAccountNumber() { return accountNumber.get(); }
    public double getBalance() { return balance.get(); }
    public String getAccountType() { return accountType.get(); }
    public double getTransactionLimit() { return transactionLimit.get(); }
    public double getWithdrawalLimit() { return withdrawalLimit.get(); }
}
