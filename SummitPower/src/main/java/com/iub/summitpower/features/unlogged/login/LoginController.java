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
    public Button loginButton;

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
                UserType userType = selectedUserType;
                Screens.refreshScreens();
                navigateAfterLogin(userType);
            }

        } catch (Exception e) {
            ViewControlUtils.showAlert(e.getMessage());
        }
    }

    private void navigateAfterLogin(UserType userType) {
        switch (userType) {
            case SENIOR_EXECUTIVE -> {
                navigateToPage(loginButton, Screens.seniorExecutiveDashboard);
            }
            case HR_EXECUTIVE -> {
                navigateToPage(loginButton, Screens.hrExecutiveDashboard);
            }
            case SALES_EXECUTIVE -> {
            }
            case BUSINESS_ANALYST -> {
            }
            case PROJECT_MANAGER -> {
            }
            case ENGINEER -> {
            }
            case QUALITY_ASSURANCE_TESTER -> {
            }
            case MAINTENANCE_ENGINEER -> {
            }
            case CUSTOMER_AGENT -> {
            }
            case CUSTOMER_SUPPORT_AGENT -> {
            }
            default -> ViewControlUtils.showAlert("Something went wrong with user types. Contact Khalid!");
        }
    }
}
