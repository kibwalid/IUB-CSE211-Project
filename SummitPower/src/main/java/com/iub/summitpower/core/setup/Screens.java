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
            addEmployee, viewAllEmployee, employeeDetails;


    protected static void loadNavigationItems() throws IOException {
        splashScreen = FXMLLoader.load(Objects.requireNonNull(SplashController.class.getResource("splash-view.fxml")));
        loginScreen = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getResource("login-view.fxml")));
        refreshScreens();
    }

    public static void refreshScreens() throws IOException {
        FXMLLoader.load(Objects.requireNonNull(SideNavViewController.class
                .getResource("side-nav-view.fxml")));

        seniorExecutiveDashboard = FXMLLoader.load(Objects.requireNonNull(DashboardController.class
                .getResource("dashboard-view.fxml")));
        addEmployee = FXMLLoader.load(Objects.requireNonNull(AddEmployeeController.class
                .getResource("add-employee-view.fxml")));
        viewAllEmployee = FXMLLoader.load(Objects.requireNonNull(EmployeeListController.class
                .getResource("employee-list-view.fxml")));

        employeeDetails = FXMLLoader.load(Objects.requireNonNull(EmployeeDetailsViewController.class
                .getResource("employee-details-view.fxml")));


    }

}
