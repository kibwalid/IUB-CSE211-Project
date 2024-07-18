package com.iub.summitpower.core.setup;

import com.iub.summitpower.features.senior_executive.SeniorExecutiveDashboardController;
import com.iub.summitpower.features.unlogged.login.LoginController;
import com.iub.summitpower.features.unlogged.splash.SplashController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class Screens {
    public static Parent splashScreen, loginScreen, seniorExecutiveDashboard;


    protected static void loadNavigationItems() throws IOException {
        splashScreen = FXMLLoader.load(Objects.requireNonNull(SplashController.class.getResource("splash-view.fxml")));
        loginScreen = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getResource("login-view.fxml")));
        seniorExecutiveDashboard = FXMLLoader.load(Objects.requireNonNull(SeniorExecutiveDashboardController.class
                .getResource("dashboard-view.fxml")));

    }

}
