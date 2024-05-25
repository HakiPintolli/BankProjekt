package com.example.bankprojekt.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SavingsAccount extends Account{
    private final DoubleProperty withdrawlLimit;
        public SavingsAccount(String owner, String accountNumber, double balance,double withdrawlLimit){
            super(owner,accountNumber,balance);
            this.withdrawlLimit = new SimpleDoubleProperty(this,"Transaction Limit",withdrawlLimit);
        }
        public DoubleProperty withdrawlLimitProp(){return withdrawlLimit;}
    }
}
