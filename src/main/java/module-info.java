module com.tablemasteradmin.admintablemaster {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tablemasteradmin.admintablemaster to javafx.fxml;
    exports com.tablemasteradmin.admintablemaster;
}