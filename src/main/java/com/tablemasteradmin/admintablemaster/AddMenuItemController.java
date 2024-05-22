package com.tablemasteradmin.admintablemaster;

import com.tablemasteradmin.admintablemaster.model.InputValidations;
import com.tablemasteradmin.admintablemaster.model.MenuItemModel;
import com.tablemasteradmin.admintablemaster.model.UpdateMenuItem;
import com.tablemasteradmin.admintablemaster.services.AdminService;
import com.tablemasteradmin.admintablemaster.services.MenuService;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddMenuItemController implements Initializable {
    @FXML
     Button addItemLabel;

    @FXML
    Label itemDescriptionLabel;
    String itemDescriptionLabelBackup;
    @FXML
    TextField itemDescriptionTextField;

    @FXML
    Label itemNameLabel;
    String itemNameLabelBackup;
    @FXML
     TextField itemNameTextField;

    @FXML
     Label itemPriceLabel;
     String itemPriceLabelBackup;
    @FXML
    TextField itemPriceTextField;

    @FXML
     Label itemServingLabel;
     String itemServingLabelBackup;
    @FXML
     TextField itemServingTextField;

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
        if (itemNameTextField.isDisable()) {
            updateMenuItem();
            return;
        }
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
            case "itemNameTextField" -> handleFieldErrors(itemNameLabel, itemNameLabelBackup, itemNameTextField);

            case "itemPriceTextField" -> {
                InputValidations.clearErrors(itemPriceLabel, itemPriceLabelBackup);
                
                if (!InputValidations.isDouble(itemPriceTextField.getText())) {
                    InputValidations.setErrors(itemPriceLabel);
                    disableButton();
                    return;
                }

                enableButton();
                InputValidations.clearErrors(itemPriceLabel, itemPriceLabelBackup);
            }


            case "itemServingTextField" -> {
                InputValidations.clearErrors(itemServingLabel, itemServingLabelBackup);
                if( !InputValidations.isNotEmpty(itemServingTextField.getText())){
                    InputValidations.setErrors(itemServingLabel);
                    disableButton();
                    return;
                }
                if(!InputValidations.isInteger(itemServingTextField.getText())){
                    InputValidations.setErrors(itemServingLabel);
                    disableButton();
                    return;
                }


                enableButton();

                InputValidations.clearErrors(itemServingLabel, itemServingLabelBackup);
            }

        }




    }

    public void setmenuitems(MenuItemModel menuItemModel){
        itemNameTextField.setText(menuItemModel.getMenuItemName());
        itemDescriptionTextField.setText(menuItemModel.getMenuItemDescription());
        itemPriceTextField.setText(String.valueOf(menuItemModel.getMenuItemPrice()));
        itemServingTextField.setText(String.valueOf(menuItemModel.getMenuItemServing()));
        itemServingTextField.setVisible(false);
        itemServingLabel.setVisible(false);
        itemNameTextField.setDisable(true);
        addItemLabel.setText("Update");
    }

    private void updateMenuItem() throws IOException {
        UpdateMenuItem menuItemModel = new UpdateMenuItem(itemNameTextField.getText(), Double.parseDouble(itemPriceTextField.getText()), itemDescriptionTextField.getText());

        MenuService menuService=new MenuService();
        menuService.updateMenuItem(menuItemModel);

        navigateToHome();
    }

    public void navigateToHome() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Afterlogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 720);
        Stage stage;
        stage = (Stage) itemNameLabel.getScene().getWindow();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
