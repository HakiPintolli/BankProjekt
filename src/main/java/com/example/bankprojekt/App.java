package com.example.bankprojekt;

import javafx.application.Application;
import com.example.bankprojekt.Models.Model;
import javafx.stage.Stage;

public class App extends Application{

    @Override
 public void start(Stage stage){
       Model.getInstance().getViewFactory().showLoginWindow();

    }
    
}





