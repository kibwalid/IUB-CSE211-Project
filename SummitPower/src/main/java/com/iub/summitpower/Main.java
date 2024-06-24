package com.iub.summitpower;

import com.iub.summitpower.core.Setup;
import com.iub.summitpower.features.unlogged.splash.SplashController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(SplashController.class.getResource("splash-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.initStyle(StageStyle.UTILITY); // Remove window decorations
        stage.setTitle("Summit Power");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Setup setup = new Setup();
        setup.injectDependencies();
        setup.createDefaultUsers();
        launch();
    }
}
