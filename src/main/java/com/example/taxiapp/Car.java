package com.example.taxiapp;

import com.example.taxiapp.util.AlertManager;
import com.example.taxiapp.util.DB;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class Car {

    @FXML
    private TextField nameCar;

    @FXML
    private Button addButton;

    @FXML
    private Button backButton;

    public void add() {
        try {
            DB.create(nameCar.getText());
            AlertManager.showInfo(nameCar.getText());

        } catch (SQLException e) {
            e.printStackTrace();
            AlertManager.showWarning(nameCar.getText());
        }
    }

    public void back() throws IOException {
        Application app = new Application();
        app.changeScene("home.fxml", 600, 400);
    }
}
