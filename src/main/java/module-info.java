module com.example.bankprojekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires kotlin.stdlib;
    requires java.desktop;

    opens com.example.bankprojekt to javafx.fxml;
    exports com.example.bankprojekt;
    exports com.example.bankprojekt.Controller;
    exports com.example.bankprojekt.Controller.Admin;
    exports com.example.bankprojekt.Controller.Client;
    exports com.example.bankprojekt.Models;
    exports com.example.bankprojekt.Views;
    opens com.example.bankprojekt.Controller.Client to javafx.fxml;

}