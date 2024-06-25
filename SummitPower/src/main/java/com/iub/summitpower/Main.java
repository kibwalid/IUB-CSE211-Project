package com.iub.summitpower;

import com.iub.summitpower.core.setup.Screens;
import com.iub.summitpower.core.setup.Setup;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {


        Scene scene = new Scene(Screens.splashScreen, 1280, 720);
        stage.initStyle(StageStyle.UTILITY); // Remove window decorations
        stage.setTitle("Summit Power");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        Setup setup = new Setup();
        setup.injectDependencies();
        setup.createDefaultUsers();
        launch();
    }
}
