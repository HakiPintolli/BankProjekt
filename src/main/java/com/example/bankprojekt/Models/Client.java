package com.example.bankprojekt.Models;

public class Client {
    private int clientId;
    private String firstName;
    private String lastName;
    private String payeeAddress;
    private String dateCreated;

    public Client(int clientId, String firstName, String lastName, String payeeAddress, String dateCreated) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.payeeAddress = payeeAddress;
        this.dateCreated = dateCreated;
    }

    public int getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPayeeAddress() {
        return payeeAddress;
    }

    public String getDateCreated() {
        return dateCreated;
    }
}


