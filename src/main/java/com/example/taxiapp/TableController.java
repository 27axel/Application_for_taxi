package com.example.taxiapp;


import com.example.taxiapp.entity.CarEntity;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class TableController implements Initializable {

    @FXML
    private Button btn;

    @FXML
    private ChoiceBox<String> car;

    @FXML
    private ChoiceBox<String> day;

    @FXML
    private TableView<CarEntity> table;

    @FXML
    private TableColumn<CarEntity, String> colDate;

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
    private TableColumn<CarEntity, String> colDispetch;

    @FXML
    private TableColumn<CarEntity, String> colRepair;

    @FXML
    private TableColumn<CarEntity, String> colSpares;

    @FXML
    private TableColumn<CarEntity, String> colTotal;

    public void cb() throws SQLException {
        for(int i = 0; i < DB.tables().size(); i++ ){
            car.getItems().add(DB.tables().get(i));
        }

        day.getItems().add("День");
        day.getItems().add("Ночь");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            cb();
            car.setOnAction(event -> {

            });
            day.setOnAction(event -> {
                if(day.getValue() == "День"){
                    showCarDay();
                } else{
                    showCarNight();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void back() throws IOException {
        Application app = new Application();
        app.changeScene("home.fxml", 600, 400);
    }

    public void showCarDay(){
        try {
            ObservableList<CarEntity> day = DB.getCarDay(car.getValue());

            colDate.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("date"));
            colIncome.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("income_d"));
            colFuel.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("fuel_d"));
            colWash.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("wash_d"));
            colOther.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("other_d"));
            colDriver.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("salary_d"));
            colDispetch.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("dispatcher_d"));
            colRepair.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("repair"));
            colSpares.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("spare"));
            colTotal.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("profit"));

            table.setItems(day);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void showCarNight(){
        try {
            ObservableList<CarEntity> night = DB.getCarNight(car.getValue());

            colDate.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("date"));
            colIncome.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("income_n"));
            colFuel.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("fuel_n"));
            colWash.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("wash_n"));
            colOther.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("other_n"));
            colDriver.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("salary_n"));
            colDispetch.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("dispatcher_n"));
            colRepair.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("repair"));
            colSpares.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("spare"));
            colTotal.setCellValueFactory(new PropertyValueFactory<CarEntity, String>("profit"));

            table.setItems(night);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
