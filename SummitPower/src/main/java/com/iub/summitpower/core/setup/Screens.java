package com.iub.summitpower.core.setup;

import com.iub.summitpower.features.senior_executive.*;
import com.iub.summitpower.features.unlogged.login.LoginController;
import com.iub.summitpower.features.unlogged.splash.SplashController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class Screens {
    public static Parent splashScreen,
            loginScreen,
            seniorExecutiveDashboard,
            seniorExecutiveAddEmployee,
            seniorExecutiveViewAllEmployee,
            seniorExecutiveEmployeeDetails,
            hrExecutiveDashboard,
            hrAddEmployee,
            hrEmployeeList,
            hrEmployeeDetails;


    protected static void loadNavigationItems() throws IOException {
        splashScreen = FXMLLoader.load(Objects.requireNonNull(SplashController.class.getResource("splash-view.fxml")));
        loginScreen = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getResource("login-view.fxml")));
        refreshScreens();
    }

    public static void refreshScreens() throws IOException {
        FXMLLoader.load(Objects.requireNonNull(SideNavViewController.class
                .getResource("side-nav-view.fxml")));

        FXMLLoader.load(Objects.requireNonNull(com.iub.summitpower.features.hr_executive.SideNavViewController.class
                .getResource("side-nav-view.fxml")));

        // Senior Executive Screens
        seniorExecutiveDashboard = FXMLLoader.load(Objects.requireNonNull(DashboardController.class
                .getResource("dashboard-view.fxml")));
        seniorExecutiveAddEmployee = FXMLLoader.load(Objects.requireNonNull(AddEmployeeController.class
                .getResource("add-employee-view.fxml")));
        seniorExecutiveViewAllEmployee = FXMLLoader.load(Objects.requireNonNull(EmployeeListController.class
                .getResource("employee-list-view.fxml")));
        seniorExecutiveEmployeeDetails = FXMLLoader.load(Objects.requireNonNull(EmployeeDetailsViewController.class
                .getResource("employee-details-view.fxml")));


        // HR Executive Screens
        hrExecutiveDashboard = FXMLLoader.load(Objects.requireNonNull(com.iub.summitpower.features.hr_executive.DashboardController.class
                .getResource("dashboard-view.fxml")));
        hrAddEmployee = FXMLLoader.load(Objects.requireNonNull(com.iub.summitpower.features.hr_executive.DashboardController.class
                .getResource("add-employee-view.fxml")));
        hrEmployeeList = FXMLLoader.load(Objects.requireNonNull(com.iub.summitpower.features.hr_executive.DashboardController.class
                .getResource("employee-list-view.fxml")));
        hrEmployeeDetails = FXMLLoader.load(Objects.requireNonNull(com.iub.summitpower.features.hr_executive.DashboardController.class
                .getResource("employee-details-view.fxml")));

    }

}
