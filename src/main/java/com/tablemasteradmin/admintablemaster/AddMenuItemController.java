package com.tablemasteradmin.admintablemaster;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddMenuItemController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemDescriptionLabelBackup= "Item Description";
        itemNameLabelBackup="Item Name";
        itemPriceLabelBackup="Item Price";
        itemServingLabelBackup="Item Serving";
    }

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



}
