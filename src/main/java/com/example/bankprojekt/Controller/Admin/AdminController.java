package com.example.bankprojekt.Controller.Admin;

import com.almasb.fxgl.net.Client;
import com.example.bankprojekt.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
  public BorderPane admin_parent;


@Override
public void initialize(URL url, ResourceBundle resourceBundle){
    Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
        switch (newVal){
            case CLIENTS -> admin_parent.setCenter(Model.getInstance().getViewFactory().getClientsView());
            default  -> admin_parent.getCenter(Model.getInstance().getViewFactory().getCreateCLientView());
        }
    } );

    }
  }
