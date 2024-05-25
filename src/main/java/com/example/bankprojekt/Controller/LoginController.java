package com.example.bankprojekt.Controller;

import com.example.bankprojekt.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable{
    public ChoiceBox ac_selector;
    public Label payee_adress_lbl;
    public TextField payee_adress_fld;
    public PasswordField password_fld;
    public Button login_btn;
    public Label error_lbl;
    @Override
    public void initialize(URL url,ResourceBundle resourceBundle){
        login_btn.setOnAction(event -> Model.getInstance().getViewFactory().showClientWindow());
    }
    private void onLogin(){
        Stage stage = (Stage)error_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showClientWindow();
    }
}
