package com.tablemasteradmin.admintablemaster;

import com.tablemasteradmin.admintablemaster.model.AdminDashboardData;
import com.tablemasteradmin.admintablemaster.model.OrderModel;
import com.tablemasteradmin.admintablemaster.services.AdminService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private TableView<OrderModel> allOrders;

    @FXML
    private TextField customersCount;

    @FXML
    private TextField orders;

    @FXML
    private TextField revnue;

    @FXML
    private TableColumn<?, ?> tableOrderDate;

    @FXML
    private TableColumn<?, ?> tableOrderNotes;

    @FXML
    private TableColumn<?, ?> tableOrderPayment;

    @FXML
    private ImageView totalCustomer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AdminDashboardData adminDashboardData = null;
        try {
            adminDashboardData = new AdminService().getAdminDashboardData();
        } catch (IOException | NullPointerException e) {
            return;
        }

        if (adminDashboardData.getRevenue() > 0) {
            revnue.setText(adminDashboardData.getRevenue() + " Rs");
        }

        if (adminDashboardData.getTotalCustomers() > 0) {
            customersCount.setText(adminDashboardData.getTotalCustomers() + "");
        }

        if (adminDashboardData.getTotalOrders() > 0) {
            orders.setText(adminDashboardData.getTotalOrders() + "");
        }

        if (adminDashboardData.getOrders().size() > 0) {
            tableOrderDate.setCellValueFactory(new PropertyValueFactory<>("orderPlacedDate"));
            tableOrderNotes.setCellValueFactory(new PropertyValueFactory<>("orderDescription"));
            tableOrderPayment.setCellValueFactory(new PropertyValueFactory<>("orderAmount"));

            ObservableList<OrderModel> ordersModels = FXCollections.observableArrayList(adminDashboardData.getOrders());
            allOrders.setItems(ordersModels);
        }
    }

    public void navigateToHome() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Afterlogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 720);
        Stage stage;
        stage = (Stage) orders.getScene().getWindow();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
