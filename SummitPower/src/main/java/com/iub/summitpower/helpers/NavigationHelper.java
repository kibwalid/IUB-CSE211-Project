package com.iub.summitpower.helpers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public abstract class NavigationHelper {


    public void navigateToPage(Node node, Parent navigateTo) {
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(navigateTo));
    }

}
