package com.tablemasteradmin.admintablemaster;

import com.tablemasteradmin.admintablemaster.model.InputValidations;
import com.tablemasteradmin.admintablemaster.model.MenuItemModel;
import com.tablemasteradmin.admintablemaster.services.AdminService;
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

public class AddMenuItemController implements Initializable {
    @FXML
    private Button addItemLabel;

    @FXML
    private Label itemDescriptionLabel;
    private String itemDescriptionLabelBackup;
    @FXML
    private TextField itemDescriptionTextField;

    @FXML
    private Label itemNameLabel;
    private String itemNameLabelBackup;
    @FXML
    private TextField itemNameTextField;

    @FXML
    private Label itemPriceLabel;
    private String itemPriceLabelBackup;
    @FXML
    private TextField itemPriceTextField;

    @FXML
    private Label itemServingLabel;
    private String itemServingLabelBackup;
    @FXML
    private TextField itemServingTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemDescriptionLabelBackup= "Item Description";
        itemNameLabelBackup="Item Name";
        itemPriceLabelBackup="Item Price";
        itemServingLabelBackup="Item Serving";
    }


    private void disableButton() {
        addItemLabel.setDisable(true);
    }

    private void enableButton() {
        addItemLabel.setDisable(false);

    }
    private void handleFieldErrors(Label nameLabel, String firstNameLabelBackup, TextField firstNameField) {
        InputValidations.clearErrors(nameLabel, firstNameLabelBackup);

        if (!InputValidations.validateAlpha(firstNameField.getText())) {
            InputValidations.setErrors(nameLabel);
            disableButton();
            return;
        }
        if (!InputValidations.validateLength(firstNameField.getText(), 3, 30)) {
            InputValidations.setErrors(nameLabel);
            disableButton();
            return;
        }

        enableButton();
        InputValidations.clearErrors(nameLabel, firstNameLabelBackup);
    }

    public void onButtonAction(ActionEvent actionEvent) throws IOException {
        String itemDescription = itemDescriptionTextField.getText();
        String itemName = itemNameTextField.getText();
        double itemprice= Double.parseDouble(itemPriceTextField.getText());
        int servings = Integer.parseInt(itemServingTextField.getText());
        MenuItemModel menuItemModel=new MenuItemModel(itemName,itemprice,servings,itemDescription);
        MenuService menuService=new MenuService();
        menuService.savemenuitem(menuItemModel);
    }

    public void validate(Event e)
    {
        String source = ((TextField) e.getSource()).getId();
        switch (source) {
            case "itemDescriptionLabel" -> handleFieldErrors(itemDescriptionLabel, itemDescriptionLabelBackup, itemDescriptionTextField);

            case "itemNameLabel" -> handleFieldErrors(itemNameLabel, itemNameLabelBackup, itemNameTextField);

            case "itemPriceLabel" -> {
                InputValidations.clearErrors(itemPriceLabel, itemPriceLabelBackup);
                if (!InputValidations.isDigits(itemPriceLabel.getText())) {
                    InputValidations.setErrors(itemPriceLabel);
                    disableButton();
                    return;
                }

                enableButton();

                InputValidations.clearErrors(itemPriceLabel, itemPriceLabelBackup);
            }


            case "itemServingLabel" -> {
                InputValidations.clearErrors(itemServingLabel, itemServingLabelBackup);
                if (!InputValidations.isDigits(itemServingLabel.getText())) {
                    InputValidations.setErrors(itemServingLabel);
                    disableButton();
                    return;
                }

                enableButton();

                InputValidations.clearErrors(itemServingLabel, itemServingLabelBackup);
            }

        }




    }






}
