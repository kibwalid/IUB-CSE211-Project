package com.iub.summitpower.features.project_manager;

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
    public Label createProjectLabel;

    @FXML
    public Button backButton;

    @FXML
    public Label requestedTasksLabel;

    @FXML
    public Label dashboardLabel;

    @FXML
    public Label projectListLabel;

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
        createProjectLabel.setStyle(normalStyle);
        projectListLabel.setStyle(normalStyle);
        requestedTasksLabel.setStyle(normalStyle);

        String boldStyle = "-fx-font-family: 'Calibri Bold';";
        if(Objects.equals(Setup.currentNavPage, dashboardLabel.getText())) {
            dashboardLabel.setStyle(boldStyle);
        }  else if (Objects.equals(Setup.currentNavPage, createProjectLabel.getText())) {
            createProjectLabel.setStyle(boldStyle);
        }  else if (Objects.equals(Setup.currentNavPage, projectListLabel.getText())) {
            projectListLabel.setStyle(boldStyle);
        }  else if (Objects.equals(Setup.currentNavPage, requestedTasksLabel.getText())) {
            requestedTasksLabel.setStyle(boldStyle);
        } else if (Objects.equals(Setup.currentNavPage, messagesLabel.getText())) {
            messagesLabel.setStyle(boldStyle);
        }  else if (Objects.equals(Setup.currentNavPage, sendMessageLabel.getText())) {
            sendMessageLabel.setStyle(boldStyle);
        }
    }

    @FXML
    public void onProjectListClicked(MouseEvent event) throws IOException {
        Setup.currentNavPage = createProjectLabel.getText();
        Screens.refreshScreens();
       // navigateToPage(dashboardLabel, Screens.seniorExecutiveAddEmployee);
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


    @FXML
    public void onCustomerListNavPressed(MouseEvent event) throws IOException {
        Setup.currentNavPage = requestedTasksLabel.getText();
        Screens.refreshScreens();
       // navigateToPage(dashboardLabel, Screens.seniorExecutiveCustomerList);
    }

    @FXML
    public void onDashboardNavPressed(MouseEvent event) throws IOException {
        Setup.currentNavPage = dashboardLabel.getText();
        Screens.refreshScreens();
       // navigateToPage(dashboardLabel, Screens.seniorExecutiveDashboard);
    }

    @FXML
    public void onCreateProjectClick(MouseEvent event) throws IOException {
        Setup.currentNavPage = projectListLabel.getText();
        Screens.refreshScreens();
      //  navigateToPage(dashboardLabel, Screens.seniorExecutiveViewAllEmployee);
    }


    public void onRequestedTasksLabel(MouseEvent mouseEvent) throws IOException {
        Setup.currentNavPage = requestedTasksLabel.getText();
        Screens.refreshScreens();
        //  navigateToPage(dashboardLabel, Screens.seniorExecutiveViewAllEmployee);

    }
}
