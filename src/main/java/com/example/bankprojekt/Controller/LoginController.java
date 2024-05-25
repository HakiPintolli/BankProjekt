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
        ac_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT, AccountType.ADMIN));
        ac_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        login_btn.setOnAction(event -> onLogin());
        ac_selector.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(ac_selector.getValue()));
    }
    
        private void onLogin(){
        Stage stage = (Stage)error_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT){
            Model.getInstance().getViewFactory().showClientWindow();
        }else{
            Model.getInstance().getViewFactory().showAdminWindow();
        }

    }
}
