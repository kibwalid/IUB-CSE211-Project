package com.iub.summitpower.features.unlogged.login;

import com.iub.summitpower.core.enums.UserType;
import com.iub.summitpower.core.setup.Screens;
import com.iub.summitpower.core.utills.ViewControlUtils;
import com.iub.summitpower.features.unlogged.login.services.ILoginServices;
import com.iub.summitpower.features.unlogged.login.services.LoginServicesImpl;
import com.iub.summitpower.helpers.NavigationHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController extends NavigationHelper {


    ILoginServices loginServices = new LoginServicesImpl();

    private UserType selectedUserType;


    @FXML
    public TextField usernameField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public ComboBox<UserType> dropdownMenu;
    @FXML
    public Button backButton;

    @FXML
    public void initialize() {
        dropdownMenu.getItems().addAll(UserType.values());
        dropdownMenu.setValue(UserType.CUSTOMER_AGENT);
        dropdownMenu.setOnAction(event -> onDropdownSelect());
        backButton.setOnMouseClicked(event -> handleBackButtonClick());
        selectedUserType = UserType.CUSTOMER_AGENT;
    }

    private void onDropdownSelect() {
        this.selectedUserType = dropdownMenu.getValue();
        System.out.println("Selected user type: " + selectedUserType);
    }


    private void handleBackButtonClick() {
        navigateToPage(backButton, Screens.splashScreen);
    }

    public void onLoginPressed(ActionEvent event) {
        try {
            boolean isLogin = loginServices.login(usernameField.getText(), passwordField.getText(), selectedUserType);
            if(isLogin) {
                ViewControlUtils.showAlert("Login Successful");
            }
            ViewControlUtils.showAlert("Something unexpected happened. Please contact Khalid!");
        } catch (Exception e) {
            ViewControlUtils.showAlert(e.getMessage());
        }
    }
}
