package com.iub.summitpower.core.utills;

import javafx.scene.control.Alert;

public class ViewControlUtils {

    public static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static boolean showOptionsAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
        return alert.getResult().getButtonData().isDefaultButton();
    }
}
