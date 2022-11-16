module com.gmc.marsela {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    /*requires eu.hansolo.tilesfx;*/

    opens com.gmc.marsela to javafx.fxml;
    exports com.gmc.marsela;
    exports com.gmc.marsela.controller;
    opens com.gmc.marsela.controller to javafx.fxml;
}