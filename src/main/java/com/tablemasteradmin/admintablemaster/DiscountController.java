package com.tablemasteradmin.admintablemaster;

import com.tablemasteradmin.admintablemaster.model.Discount;
import com.tablemasteradmin.admintablemaster.model.InputValidations;
import com.tablemasteradmin.admintablemaster.model.MenuItemModel;
import com.tablemasteradmin.admintablemaster.services.MenuService;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

        if (discountPercentage>99 || discountPercentage<1)
        {
            InputValidations.errorMessage= "Percentage out of range";
            InputValidations.setErrors(DiscountPercentageLabels);
            disableButton();
            return;
        }

        enableButton();
        InputValidations.clearErrors(DiscountPercentageLabels, DiscountPercentageLabelsBackup);

    }

    public void addDiscount(Event e)
    {
       String discountTitle= DiscountTitleTextField.getText();
       String discountPercentageTextField= DiscountPercentageTextField.getText();

        Discount d= new Discount(discountTitle,Double.parseDouble(discountPercentageTextField));
    }

}
