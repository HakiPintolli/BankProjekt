package com.example.bankprojekt.Models;

import java.time.LocalDate;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String payeeAddress;
    private String password; // Note: Storing passwords in plain text is not recommended.
    private String accountType;
    private LocalDate date; // Using java.time.LocalDate to represent DATE SQL type.

    // Constructor
    public User(int userId, String firstName, String lastName, String payeeAddress, String password, String accountType, LocalDate date) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.payeeAddress = payeeAddress;
        this.password = password;
        this.accountType = accountType;
        this.date = date;
    }

    // Getters and setters for each property
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPayeeAddress() {
        return payeeAddress;
    }

    public void setPayeeAddress(String payeeAddress) {
        this.payeeAddress = payeeAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", payeeAddress='" + payeeAddress + '\'' +
                ", password='" + password + '\'' + // Be cautious with logging passwords!
                ", accountType='" + accountType + '\'' +
                ", date=" + date +
                '}';
    }
}
