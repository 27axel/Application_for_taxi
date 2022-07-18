package com.example.taxiapp.controllers;


import com.example.taxiapp.Application;
import com.example.taxiapp.util.AlertManager;
import com.example.taxiapp.util.databaseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CarController implements Initializable {

    @FXML
    private TextField nameField;

    @FXML
    private ListView<String> carList;

    ObservableList<String> list;

    {
        try {
            list = FXCollections.observableArrayList(databaseManager.getCar());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCar() {
        try {
            if(!nameField.getText().equals("")){
                databaseManager.addCar(nameField.getText());
                list.add(nameField.getText());
                AlertManager.showInfo("Машина " + nameField.getText() + " успешно добавлена");
            } else {
                AlertManager.showWarning("Введите название");
            }
        } catch (SQLException e) {
            AlertManager.showWarning("Неккоректный ввод или машина уже добавлена");
            e.printStackTrace();
        }
    }

    public void deleteCar() {
        try {
            String car = carList.selectionModelProperty().get().getSelectedItem();
            databaseManager.deleteCar(car);
            carList.getItems().remove(car);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDriver() throws IOException {
        Application app = new Application();
        app.changeScene("mainPage.fxml", 1050, 600);
    }

    public void addDispatch() throws IOException {
        Application app = new Application();
        app.changeScene("mainPage.fxml", 1050, 600);
    }

    public void addCars() throws IOException {
        Application app = new Application();
        app.changeScene("carPage.fxml", 1050, 600);
    }

    public void addRepair() throws IOException {
        Application app = new Application();
        app.changeScene("mainPage.fxml", 1050, 600);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carList.setItems(list);
    }

}
