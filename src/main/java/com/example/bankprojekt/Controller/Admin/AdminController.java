package com.example.bankprojekt.Controller.Admin;

import com.jmc.mazebank.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
  public BorderPane admin_parent;


@override
public void initialize(URL url, ResourceBundle resourceBundle){
  Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, oldVal, newVal) {
    //add swich statment ....
    }
  } );
  }
}
