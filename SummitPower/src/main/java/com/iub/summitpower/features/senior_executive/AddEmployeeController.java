package com.iub.summitpower.features.senior_executive;

import com.iub.summitpower.core.enums.UserType;
import com.iub.summitpower.core.setup.Screens;
import com.iub.summitpower.features.senior_executive.services.IUserServices;
import com.iub.summitpower.features.senior_executive.services.SeniorExecutiveServicesImpl;
import com.iub.summitpower.helpers.NavigationHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Arrays;

public class AddEmployeeController extends NavigationHelper {


    @FXML
    public Button backButton;



    @FXML
    public ComboBox<UserType> employeeTypeDropdown;

    @FXML
    public TextField nameTextField;

    @FXML
    public PasswordField passwordTextField;

    @FXML
    public TextField phoneNumberTextField;

    @FXML
    public TextField positionTextField;

    @FXML
    public Button registerButton;

    @FXML
    public TextField salaryTextField;

    @FXML
    public TextField signatureTextField;

    @FXML
    public TextField emailTextField;

    @FXML
    public TextField usernameField;


    private UserType selectedUserType;


    private final IUserServices userServices = new SeniorExecutiveServicesImpl();

    @FXML
    public void initialize() {
        employeeTypeDropdown.getItems().addAll(
                Arrays.stream(UserType.values())
                        .filter(userType -> userType != UserType.CUSTOMER_AGENT)
                        .toList());
        employeeTypeDropdown.setValue(UserType.HR_EXECUTIVE);
        selectedUserType = UserType.HR_EXECUTIVE;
        employeeTypeDropdown.setOnAction(event -> onDropdownSelect());
    }

    private void onDropdownSelect() {
        this.selectedUserType = employeeTypeDropdown.getValue();
        System.out.println("Selected user type: " + selectedUserType);
    }


    public void onRegisterPress(ActionEvent event) throws IOException {
        String name = nameTextField.getText();
        String username = usernameField.getText();
        String password = passwordTextField.getText();
        String email = emailTextField.getText();
        String phone = phoneNumberTextField.getText();
        String salary = salaryTextField.getText();
        String position = positionTextField.getText();
        String signature = signatureTextField.getText();

        userServices.validateUserData(name, username, password, email, phone, position, salary, selectedUserType, signature);

        boolean register = userServices.registerEmployee(name, username, password, email, phone, position, salary, selectedUserType);
        if(register) {
            navigateToPage(registerButton, Screens.seniorExecutiveDashboard);
        }
    }



}
