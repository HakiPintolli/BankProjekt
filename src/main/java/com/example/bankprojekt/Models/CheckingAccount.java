package com.example.bankprojekt.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CheckingAccount extends Account {
    private final IntegerProperty transactionLimit;
    public CheckingAccount(String owner, String accountNumber, double balance,int tlimit){
super(owner,accountNumber,balance);
this.transactionLimit = new SimpleIntegerProperty(this,"Transaction Limit",tlimit);
    }
    public IntegerProperty TransactionLimitProp(){return transactionLimit;}
}