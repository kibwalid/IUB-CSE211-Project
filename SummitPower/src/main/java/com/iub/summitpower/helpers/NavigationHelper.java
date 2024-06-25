package com.iub.summitpower.helpers;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;


public abstract class NavigationHelper {


    public void navigateToPage(Node node, Parent navigateTo) {
        Scene scene = node.getScene();
        scene.setRoot(navigateTo);
    }

}
