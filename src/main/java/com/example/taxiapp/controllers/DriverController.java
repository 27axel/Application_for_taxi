package com.example.taxiapp.controllers;

import com.example.taxiapp.Application;
import com.example.taxiapp.util.AlertManager;
import com.example.taxiapp.util.databaseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DriverController implements Initializable {
    @FXML
    private TextField nameField;

    @FXML
    private ListView<String> driverList;

    @FXML
    private Label home;

    ObservableList<String> list;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        home.setOnMouseClicked(mouseEvent -> {
            Application app = new Application();
            try {
                app.changeScene("mainPage.fxml", 1050, 600);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        try {
            list = FXCollections.observableArrayList(databaseManager.getDrivers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        driverList.setItems(list);
    }

    public void addBtn() {
        try {
            if (!nameField.getText().equals("")) {
                databaseManager.addDriver(nameField.getText());
                list.add(nameField.getText());
                AlertManager.showInfo(nameField.getText() + " успешно добавлен");
                nameField.setText("");
            } else {
                AlertManager.showWarning("Введите ФИО");
            }
        } catch (SQLException e) {
            AlertManager.showWarning("Неккоректный ввод");
            e.printStackTrace();
        }
    }

    public void addDriver() throws IOException {
        Application app = new Application();
        app.changeScene("driverPage", 1050, 600);
    }

    public void addDispatch() throws IOException {
        Application app = new Application();
        app.changeScene("dispatcherPage.fxml", 1050, 600);
    }

    public void addCars() throws IOException {
        Application app = new Application();
        app.changeScene("carPage.fxml", 1050, 600);
    }

    public void addRepair() {
    }

    public void deleteDriver() {
        try {
            String driver = driverList.selectionModelProperty().get().getSelectedItem();
            databaseManager.deleteDriver(driver);
            driverList.getItems().remove(driver);
            AlertManager.showInfo("Водитель " + driver + " успешно удален");
        } catch (SQLException e) {
            AlertManager.showWarning("Ошибка при удалении");
            e.printStackTrace();
        }
    }
}
