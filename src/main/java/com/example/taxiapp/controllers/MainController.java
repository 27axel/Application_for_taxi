package com.example.taxiapp.controllers;

import com.example.taxiapp.Application;
import com.example.taxiapp.entity.CarEntity;
import com.example.taxiapp.util.databaseManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ChoiceBox<String> chbCar;
    @FXML
    private TableView<CarEntity> table;
    @FXML
    private TableColumn<CarEntity,String> colDate;
    @FXML
    private TableColumn<CarEntity, String> colIncome;
    @FXML
    private TableColumn<CarEntity, String> colFuel;
    @FXML
    private TableColumn<CarEntity, String> colWash;
    @FXML
    private TableColumn<CarEntity, String> colOther;
    @FXML
    private TableColumn<CarEntity, String> colDriver;
    @FXML
    private TableColumn<CarEntity, String> colDispatch;
    @FXML
    private TableColumn<CarEntity, String> colRepair;
    @FXML
    private TableColumn<CarEntity, String> colSpare;
    @FXML
    private TableColumn<CarEntity, String> colTotal;

    public void addDriver() throws IOException{
        Application app = new Application();
        app.changeScene("driverPage.fxml", 1050, 600);
    }

    public void addDispatch() throws IOException{
        Application app = new Application();
        app.changeScene("dispatcherPage.fxml", 1050, 600);
    }

    public void addCars() throws IOException{
        Application app = new Application();
        app.changeScene("carPage.fxml", 1050, 600);
    }

    public void addRepair() throws IOException{
        Application app = new Application();
        app.changeScene("car.fxml", 1050, 600);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            chbCar.setItems(databaseManager.getCar());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void initTable(){
        try {
            ObservableList<CarEntity> day = databaseManager.getInfo(chbCar.getValue());

            colDate.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("date"));
            colIncome.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("income_d"));
            colFuel.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("fuel_d"));
            colWash.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("wash_d"));
            colOther.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("other_d"));
            colDriver.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("salary_d"));
            colDispatch.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("dispatcher_d"));
            colRepair.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("repair"));
            colSpare.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("spare"));
            colTotal.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("profit"));

            table.setItems(day);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
