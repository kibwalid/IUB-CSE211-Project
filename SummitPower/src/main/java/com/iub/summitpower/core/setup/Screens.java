package com.iub.summitpower.core.setup;

import com.iub.summitpower.features.senior_executive.AddEmployeeController;
import com.iub.summitpower.features.senior_executive.DashboardController;
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
            addEmployee;


    protected static void loadNavigationItems() throws IOException {
        splashScreen = FXMLLoader.load(Objects.requireNonNull(SplashController.class.getResource("splash-view.fxml")));
        loginScreen = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getResource("login-view.fxml")));
        refreshScreens();
    }

    public static void refreshScreens() throws IOException {
        seniorExecutiveDashboard = FXMLLoader.load(Objects.requireNonNull(DashboardController.class
                .getResource("dashboard-view.fxml")));
        addEmployee = FXMLLoader.load(Objects.requireNonNull(AddEmployeeController.class
                .getResource("add-employee-view.fxml")));

    }

}
