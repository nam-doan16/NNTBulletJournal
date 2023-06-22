module cs3500.pa05 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    requires org.controlsfx.controls;
  requires jdk.jfr;
  requires java.desktop;

  opens cs3500.pa05 to javafx.fxml;
    exports cs3500.pa05.model.json;
    exports cs3500.pa05;
    exports cs3500.pa05.controller;
    exports cs3500.pa05.model;
    exports cs3500.pa05.view;
    exports cs3500.pa05.model.enums;
    exports cs3500.pa05.model.adapterclasses;
    opens cs3500.pa05.controller to javafx.fxml, org.testfx.junit5;
}