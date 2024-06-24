package com.iub.summitpower.features.unlogged.splash;

import com.iub.summitpower.core.setup.Screens;
import com.iub.summitpower.helpers.NavigationHelper;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class SplashController extends NavigationHelper {

    @FXML
    private HBox loginBox;


    @FXML
    public void initialize() {
        loginBox.setOnMouseClicked(event -> handleLoginBoxClick());
    }

    private void handleLoginBoxClick() {
        navigateToPage(loginBox, Screens.loginScreen);
    }
}