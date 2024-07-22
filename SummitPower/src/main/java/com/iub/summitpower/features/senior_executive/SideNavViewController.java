package com.iub.summitpower.features.senior_executive;

import java.io.IOException;
import java.util.Objects;

import com.iub.summitpower.core.setup.Screens;
import com.iub.summitpower.core.setup.Setup;
import com.iub.summitpower.helpers.NavigationHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class SideNavViewController extends NavigationHelper {


    @FXML
    public Label addEmployeLabel;

    @FXML
    public Button backButton;

    @FXML
    public Label customerListLabel;

    @FXML
    public Label dashboardLabel;

    @FXML
    public Label employeeListLabel;

    @FXML
    public Label financialReportLabel;

    @FXML
    public Label issuesLabel;

    @FXML
    public Label projectLabel;

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
        customerListLabel.setStyle(normalStyle);
        projectLabel.setStyle(normalStyle);
        issuesLabel.setStyle(normalStyle);
        financialReportLabel.setStyle(normalStyle);

        String boldStyle = "-fx-font-family: 'Calibri Bold';";
        if(Objects.equals(Setup.currentNavPage, dashboardLabel.getText())) {
            dashboardLabel.setStyle(boldStyle);
        }  else if (Objects.equals(Setup.currentNavPage, addEmployeLabel.getText())) {
            addEmployeLabel.setStyle(boldStyle);
        }  else if (Objects.equals(Setup.currentNavPage, employeeListLabel.getText())) {
            employeeListLabel.setStyle(boldStyle);
        }  else if (Objects.equals(Setup.currentNavPage, customerListLabel.getText())) {
            customerListLabel.setStyle(boldStyle);
        }  else if (Objects.equals(Setup.currentNavPage, projectLabel.getText())) {
            projectLabel.setStyle(boldStyle);
        }  else if (Objects.equals(Setup.currentNavPage, issuesLabel.getText())) {
            issuesLabel.setStyle(boldStyle);
        }  else if (Objects.equals(Setup.currentNavPage, financialReportLabel.getText())) {
            financialReportLabel.setStyle(boldStyle);
        }
    }

    @FXML
    public void onAddEmployeeNavPressed(MouseEvent event) throws IOException {
        Setup.currentNavPage = addEmployeLabel.getText();
        Screens.refreshScreens();
        navigateToPage(dashboardLabel, Screens.seniorExecutiveAddEmployee);
    }

    @FXML
    public void onCustomerListNavPressed(MouseEvent event) throws IOException {
        Setup.currentNavPage = customerListLabel.getText();
        Screens.refreshScreens();
        navigateToPage(dashboardLabel, Screens.seniorExecutiveCustomerList);
    }

    @FXML
    public void onDashboardNavPressed(MouseEvent event) throws IOException {
        Setup.currentNavPage = dashboardLabel.getText();
        Screens.refreshScreens();
        navigateToPage(dashboardLabel, Screens.seniorExecutiveDashboard);
    }

    @FXML
    public void onEmployeeListNavPressed(MouseEvent event) throws IOException {
        Setup.currentNavPage = employeeListLabel.getText();
        Screens.refreshScreens();
        navigateToPage(dashboardLabel, Screens.seniorExecutiveViewAllEmployee);
    }

    @FXML
    public void onFinanceNavPressed(MouseEvent event) throws IOException {
        Setup.currentNavPage = financialReportLabel.getText();
        Screens.refreshScreens();
    }

    @FXML
    public void onIssuesNavPressed(MouseEvent event) throws IOException {
        Setup.currentNavPage = issuesLabel.getText();
        Screens.refreshScreens();
    }

    @FXML
    public void onProjectNavPressed(MouseEvent event) throws IOException {
        Setup.currentNavPage = projectLabel.getText();
        Screens.refreshScreens();
    }



}
