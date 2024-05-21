package com.tablemasteradmin.admintablemaster;

import com.tablemasteradmin.admintablemaster.model.Discount;
import com.tablemasteradmin.admintablemaster.model.InputValidations;
import com.tablemasteradmin.admintablemaster.model.MenuItemModel;
import com.tablemasteradmin.admintablemaster.services.AdminService;
import com.tablemasteradmin.admintablemaster.services.MenuService;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DiscountController implements Initializable {

    @FXML
    Label DiscountPercentageLabels;
    String DiscountPercentageLabelsBackup;

    @FXML
    TextField DiscountPercentageTextField;

    @FXML
    Label DiscountTitleLabel;
    String DiscountTitleLabelBackup;
    @FXML
    TextField DiscountTitleTextField;

    @FXML
    Button discount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DiscountTitleLabelBackup= "Discount Title";
        DiscountPercentageLabelsBackup= "Discount Percentage";
    }

    private void disableButton() {
        discount.setDisable(true);
    }

    private void enableButton() {
       discount.setDisable(false);
    }


    public void validatePercentage(Event e)
    {
        InputValidations.clearErrors(DiscountPercentageLabels, DiscountPercentageLabelsBackup);
        String discountPercentageTextField= DiscountPercentageTextField.getText();

        if (!InputValidations.isDouble(discountPercentageTextField)) {
            InputValidations.errorMessage= "Invalid Format";
            InputValidations.setErrors(DiscountPercentageLabels);
            disableButton();
            return;
        }

        double discountPercentage= Double.parseDouble(discountPercentageTextField);

        if (discountPercentage>100 || discountPercentage<0)
        {
            InputValidations.errorMessage= "Percentage out of range";
            InputValidations.setErrors(DiscountPercentageLabels);
            disableButton();
            return;
        }

        enableButton();
        InputValidations.clearErrors(DiscountPercentageLabels, DiscountPercentageLabelsBackup);

    }

    public void addDiscount(Event e) throws IOException {
       String discountTitle= DiscountTitleTextField.getText();
       String discountPercentageTextField= DiscountPercentageTextField.getText();

        Discount d= new Discount(discountTitle,Double.parseDouble(discountPercentageTextField));

        AdminService adminService = new AdminService();
        boolean res = adminService.updateDiscount(d);

        if (res) {
            navigateToHome();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Could Not Add Discount");
            alert.showAndWait();
        }
    }

    public void navigateToHome() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Afterlogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 720);
        Stage stage;
        stage = (Stage) DiscountTitleLabel.getScene().getWindow();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
