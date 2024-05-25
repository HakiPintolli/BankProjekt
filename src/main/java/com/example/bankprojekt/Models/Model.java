package com.example.bankprojekt.Models;

import com.example.bankprojekt.Views.ViewFactory;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
     private Client client;
    private boolean clientLoginSuccessFlag;
    
    private Model(){
        this.viewFactory = new ViewFactory();
    }
    public static synchronized Model getInstance(){
if (model == null){
    model = new Model();
}
return model;
    }
    public ViewFactory getViewFactory(){
        return viewFactory;
    }
}
 public boolean getClientSuccessFlag(){
        return this.clientLoginSuccessFlag;
    }

    public void setClientLoginSuccessFlag(boolean flag){
        this.clientLoginSuccessFlag = flag;
    }

    public Client getClient(){
        return client;
    }

    public void evalusteClient(String pAddress, String password){
        CheckingAccount checkingAccount;
        SavingsAccount savingsAccount;
        ResultSet resultSet = databaseDriver.geClientData(pAddress,password);
        try{
            if (resultSet.isBeforeFirst()){
                this.client.firstNameProperty().set(resultSet.getString("FirstName"));
                this.client.lastNameProperty().set(resultSet.getString("LastName"));
                this.client.pAddressProperty().set(resultSet.getString("PayeeAddress"));
                String[] dateParts = resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]),Integer.parseInt(dateParts[1]),Integer.parseInt(dateParts[2]));
                this.client.dateProperty().set(date);
                this.clientLoginSuccessFlag = true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
