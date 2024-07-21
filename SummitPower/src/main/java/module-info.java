module com.iub.summitpower {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires jdk.jdi;
    requires java.naming;

    opens com.iub.summitpower to javafx.fxml;
    exports com.iub.summitpower;
    exports com.iub.summitpower.core.enums;
    exports com.iub.summitpower.features.unlogged.splash;
    exports com.iub.summitpower.features.unlogged.login;
    exports com.iub.summitpower.features.senior_executive;
    exports com.iub.summitpower.features.senior_executive.models;
    exports com.iub.summitpower.features.hr_executive.models;
    exports com.iub.summitpower.features.hr_executive;
    opens com.iub.summitpower.features.unlogged.splash to javafx.fxml;
}