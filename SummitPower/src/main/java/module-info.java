module com.iub.summitpower {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires jdk.jdi;

    opens com.iub.summitpower to javafx.fxml;
    exports com.iub.summitpower;
    exports com.iub.summitpower.features.unlogged.splash;
    exports com.iub.summitpower.features.unlogged.login;
    opens com.iub.summitpower.features.unlogged.splash to javafx.fxml;
}