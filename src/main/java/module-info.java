module com.tablemasteradmin.admintablemaster {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;


    opens com.tablemasteradmin.admintablemaster to javafx.fxml;
    exports com.tablemasteradmin.admintablemaster;
    exports com.tablemasteradmin.admintablemaster.model;
}