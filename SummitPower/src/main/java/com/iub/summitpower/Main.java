package com.iub.summitpower;

import com.iub.summitpower.core.Setup;
import com.iub.summitpower.features.unlogged.splash.SplashController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(SplashController.class.getResource("splash-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
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
