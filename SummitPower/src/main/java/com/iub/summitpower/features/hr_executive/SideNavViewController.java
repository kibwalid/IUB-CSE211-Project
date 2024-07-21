package com.iub.summitpower.features.hr_executive;

import com.iub.summitpower.core.setup.Screens;
import com.iub.summitpower.core.setup.Setup;
import com.iub.summitpower.helpers.NavigationHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Objects;

public class SideNavViewController extends NavigationHelper {


    @FXML
    public Label addEmployeLabel;

    @FXML
    public Button backButton;

    @FXML
    public Label paySalaryLabel;

    @FXML
    public Label dashboardLabel;

    @FXML
    public Label employeeListLabel;


    @FXML
    public Label sendMessageLabel;

    @FXML
    public Label messagesLabel;

    @FXML
    public Label userNameLabel;

    @FXML
    public Label userPositionLabel;


    @FXML
    public void initialize() {
        setCurrentNavItemToBold();
        if(Setup.currentUser != null) {
            userNameLabel.setText(Setup.currentUser.getName());
            userPositionLabel.setText(Setup.currentUser.getPosition());
        }
    }

    private void setCurrentNavItemToBold() {
        String normalStyle = "-fx-font-family: 'Calibri';";
        dashboardLabel.setStyle(normalStyle);
        addEmployeLabel.setStyle(normalStyle);
        employeeListLabel.setStyle(normalStyle);
        paySalaryLabel.setStyle(normalStyle);
        messagesLabel.setStyle(normalStyle);
        sendMessageLabel.setStyle(normalStyle);

        String boldStyle = "-fx-font-family: 'Calibri Bold';";
        if(Objects.equals(Setup.currentNavPage, dashboardLabel.getText())) {
            dashboardLabel.setStyle(boldStyle);
        }  else if (Objects.equals(Setup.currentNavPage, addEmployeLabel.getText())) {
            addEmployeLabel.setStyle(boldStyle);
        }  else if (Objects.equals(Setup.currentNavPage, employeeListLabel.getText())) {
            employeeListLabel.setStyle(boldStyle);
        }  else if (Objects.equals(Setup.currentNavPage, paySalaryLabel.getText())) {
            paySalaryLabel.setStyle(boldStyle);
        }  else if (Objects.equals(Setup.currentNavPage, messagesLabel.getText())) {
            messagesLabel.setStyle(boldStyle);
        }  else if (Objects.equals(Setup.currentNavPage, sendMessageLabel.getText())) {
            sendMessageLabel.setStyle(boldStyle);
        }
    }

    @FXML
    public void onAddEmployeeNavPressed(MouseEvent event) throws IOException {
        Setup.currentNavPage = addEmployeLabel.getText();
        Screens.refreshScreens();
        navigateToPage(dashboardLabel, Screens.hrAddEmployee);
    }

    @FXML
    public void onPaySalaryNavPressed(MouseEvent event) throws IOException {
        Setup.currentNavPage = paySalaryLabel.getText();
        Screens.refreshScreens();
        navigateToPage(dashboardLabel, Screens.hrExecutiveDashboard);
    }

    @FXML
    public void onDashboardNavPressed(MouseEvent event) throws IOException {
        Setup.currentNavPage = dashboardLabel.getText();
        Screens.refreshScreens();
        navigateToPage(dashboardLabel, Screens.hrExecutiveDashboard);
    }

    @FXML
    public void onEmployeeListNavPressed(MouseEvent event) throws IOException {
        Setup.currentNavPage = employeeListLabel.getText();
        Screens.refreshScreens();
        navigateToPage(employeeListLabel, Screens.hrEmployeeList);
    }


    @FXML
    public void onSendMessagesNavPressed(MouseEvent event) throws IOException {
        Setup.currentNavPage = sendMessageLabel.getText();
        Screens.refreshScreens();
        navigateToPage(sendMessageLabel, Screens.hrSendMessages);

    }

    @FXML
    public void onMessagesNavPressed(MouseEvent event) throws IOException {
        Setup.currentNavPage = messagesLabel.getText();
        Screens.refreshScreens();
        navigateToPage(messagesLabel, Screens.hrMessages);

    }



}
