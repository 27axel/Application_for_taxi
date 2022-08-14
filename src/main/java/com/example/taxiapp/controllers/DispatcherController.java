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

public class DispatcherController implements Initializable {
    @FXML
    private TextField nameField;

    @FXML
    private ListView<String> dispatcherList;

    ObservableList<String> list;

    {
        try {
            list = FXCollections.observableArrayList(databaseManager.getDispatcher());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void btnDriver() throws IOException {
        Application app = new Application();
        app.changeScene("driverPage.fxml", 1050, 600);
    }

    public void btnCars() throws IOException {
        Application app = new Application();
        app.changeScene("carPage.fxml", 1050, 600);
    }

    public void btnRepair() {
    }

    public void deleteBtn() {
        try {
            String dispatcher = dispatcherList.selectionModelProperty().get().getSelectedItem();
            databaseManager.deleteDispatcher(dispatcher);
            dispatcherList.getItems().remove(dispatcher);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBtn() {
        try {
            if (!nameField.getText().equals("")){
                databaseManager.addDispatch(nameField.getText());
                list.add(nameField.getText());
                AlertManager.showInfo(nameField.getText() + " успешно добавлен");
                nameField.setText("");
            } else {
                AlertManager.showWarning("Введите ФИО");
            }
        } catch (SQLException e) {
            AlertManager.showWarning("Ошибка добавления диспетчера \n" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void btnDispatch() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dispatcherList.setItems(list);
    }
}
