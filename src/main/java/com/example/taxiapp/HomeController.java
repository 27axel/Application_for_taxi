package com.example.taxiapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class HomeController{

    @FXML
    private Button editButton;
    @FXML
    private Button viewButton;

    public void editData() throws IOException {

        Application app = new Application();
        app.changeScene("main.fxml");

    }

    public void add() throws IOException {
        Application app = new Application();
        app.changeScene("car.fxml");

    }

}
