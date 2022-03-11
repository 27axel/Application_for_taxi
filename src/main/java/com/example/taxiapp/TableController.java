package com.example.taxiapp;


import com.example.taxiapp.entity.CarEntityDay;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class TableController implements Initializable {

    @FXML
    private ChoiceBox<String> car;

    @FXML
    private TableView<CarEntityDay> table;

    @FXML
    private TableColumn<CarEntityDay, String> colDate;

    @FXML
    private TableColumn<CarEntityDay, String> colIncome;

    @FXML
    private TableColumn<CarEntityDay, String> colFuel;

    @FXML
    private TableColumn<CarEntityDay, String> colWash;

    @FXML
    private TableColumn<CarEntityDay, String> colOther;

    @FXML
    private TableColumn<CarEntityDay, String> colDriver;

    @FXML
    private TableColumn<CarEntityDay, String> colDispetch;

    @FXML
    private TableColumn<CarEntityDay, String> colRepair;

    @FXML
    private TableColumn<CarEntityDay, String> colSpares;

    @FXML
    private TableColumn<CarEntityDay, String> colTotal;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showCarDay();

    }

    public void showCarDay(){
        try {
            ObservableList<CarEntityDay> list = DB.getCarDay(car.getValue());

            colDate.setCellValueFactory(new PropertyValueFactory<CarEntityDay, String>("date"));
            colIncome.setCellValueFactory(new PropertyValueFactory<CarEntityDay, String>("income_d"));


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
