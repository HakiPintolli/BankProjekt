package com.example.bankprojekt.Controller;

import com.example.bankprojekt.Models.User;
import com.example.bankprojekt.Data.SessionManager;
import com.example.bankprojekt.Data.UserDAO;
import com.example.bankprojekt.Models.Model;
import com.example.bankprojekt.Views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<AccountType> ac_selector;
    public Label payee_adress_lbl;
    public TextField payee_adress_fld;
    public PasswordField password_fld;
    public Button login_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ac_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT, AccountType.ADMIN));
        ac_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        login_btn.setOnAction(event -> onLogin());
        ac_selector.valueProperty().addListener(observable -> Model.getInstance().setLoginAccountType(ac_selector.getValue()));
    }

    private void onLogin() {
        String username = payee_adress_fld.getText();
        String password = password_fld.getText();
        UserDAO userDao = new UserDAO();

        try {
            User user = userDao.getUserByUsernameAndPassword(username, password);
            if (user != null) {
                SessionManager.getInstance().setCurrentUser(user);
                switch (user.getAccountType()) {
                    case "CLIENT":
                        Model.getInstance().getViewFactory().showClientWindow(); // Navigate to the client dashboard
                        break;
                    case "ADMIN":
                        Model.getInstance().getViewFactory().showAdminWindow(); // Navigate to the admin dashboard
                        break;
                    default:
                        showError("Access Denied: Your account does not have permission to access this application.");
                        return; // Exit the method if neither case is applicable
                }// Set the logged-in user
                closeStage();
            } else {
                showError("Login error. Please check your username and password.");
            }
        } catch (Exception e) {
            showError("Unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private void closeStage() {
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }

    private void showError(String message) {
        payee_adress_fld.setText("");
        password_fld.setText("");
        error_lbl.setText(message);
    }
}
