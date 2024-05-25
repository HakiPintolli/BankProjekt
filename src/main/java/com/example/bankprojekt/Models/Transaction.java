package com.example.bankprojekt.Models;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {
    private final StringProperty sender;
    private final StringProperty receiver;
    private final DoubleProperty amount;
    private final ObjectProperty<LocalDate> date;
    private final StringProperty message;

    public Transaction(String sender, String receiver, double amount, LocalDate date, String message){
        this.sender = new SimpleStringProperty(this, "sender", sender);
        this.receiver = new SimpleStringProperty(this, "Receiver", receiver);
        this.amount = new SimpleDoubleProperty(this, "Amount", amount);
        this.date = new SimpleObjectProperty(this, "Date", date);
        this.message = new SimpleStringProperty(this, "Message",message);}

        public StringProperty SenderProperty(){return this.sender;}
        public StringProperty ReceiverProperty(){return this.receiver;}
        public DoubleProperty amountProperty(){return this.amount;}
        public ObjectProperty dateProperty(){return this.date;}
        public StringProperty messageProperty(){return this.message;}




}