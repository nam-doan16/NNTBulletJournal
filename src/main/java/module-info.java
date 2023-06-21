module cs3500.pa05 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.fasterxml.jackson.annotation;
  requires jdk.jfr;
  requires java.desktop;

  opens cs3500.pa05 to javafx.fxml;
    exports cs3500.pa05;
    exports cs3500.pa05.controller;
    exports cs3500.pa05.model;
    exports cs3500.pa05.view;
    exports cs3500.pa05.model.enums;
    opens cs3500.pa05.controller to javafx.fxml;
}