package com.example.taxiapp;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private DatePicker dateWork, dateRepair;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Button saveButton;
    @FXML
    public TextField income_d, income_n, costFuel_d, costFuel_n, wash_d, wash_n, other_d, other_n, costRepair, costSpares;
    @FXML
    public TextArea commRepair;
    @FXML
    public Label total, dispatcher_d, dispatcher_n, salary_d, salary_n;


    public void cb() throws SQLException {
        for(int i = 0; i < DB.tables().size(); i++ ){
            choiceBox.getItems().add(DB.tables().get(i));
        }
    }

    public void back() throws IOException{
        Application app = new Application();
        app.changeScene("home.fxml", 600, 400);
    }


    public void save() {

        double profit = -Integer.parseInt(dispatcher_d.getText()) - Integer.parseInt(dispatcher_n.getText()) - Integer.parseInt(salary_d.getText()) - Integer.parseInt(salary_n.getText());

        if(!income_d.getText().equals("")){
            profit += Integer.parseInt(income_d.getText());
        }
        else {
            income_d.setText("0");
        }

        if(!income_n.getText().equals("")){
            profit += Integer.parseInt(income_n.getText());
        }
        else {
            income_n.setText("0");
        }

        if(!costFuel_d.getText().equals("")){
            profit -= Integer.parseInt(costFuel_d.getText());
        }
        else {
            costFuel_d.setText("0");
        }

        if(!costFuel_n.getText().equals("")){
            profit -= Integer.parseInt(costFuel_n.getText());
        }
        else {
            costFuel_n.setText("0");
        }

        if(!wash_d.getText().equals("")){
            profit -= Integer.parseInt(wash_d.getText());
        }
        else {
            wash_d.setText("0");
        }

        if(!wash_n.getText().equals("")){
            profit -= Integer.parseInt(wash_n.getText());
        }
        else {
            wash_n.setText("0");
        }

        if(!other_d.getText().equals("")){
            profit -= Integer.parseInt(other_d.getText());
        }
        else {
            other_d.setText("0");
        }

        if(!other_n.getText().equals("")){
            profit -= Integer.parseInt(other_n.getText());
        }
        else {
            other_n.setText("0");
        }

        if(!costRepair.getText().equals("")){
            profit -= Integer.parseInt(costRepair.getText());
        }
        else {
            costRepair.setText("0");
        }

        if(!costSpares.getText().equals("")){
            profit -= Integer.parseInt(costSpares.getText());
        }
        else {
            costSpares.setText("0");
        }

        total.setText(String.format("%.0f", profit));


        try {
            DB.insert(choiceBox.getValue(), String.valueOf(dateWork.getValue()), income_d.getText(), income_n.getText(), costFuel_d.getText(), costFuel_n.getText(),wash_d.getText(), wash_n.getText(), other_d.getText(), other_n.getText(), salary_d.getText(), salary_n.getText(), costRepair.getText(), String.valueOf(dateRepair.getValue()), costSpares.getText(), commRepair.getText(), total.getText(), dispatcher_d.getText(), dispatcher_n.getText());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            cb();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        income_d.textProperty().addListener((observableValue, s, t1) -> {
            double disp_d, driver_d;

            if(!income_d.getText().equals("")){
                disp_d = Integer.parseInt(income_d.getText())*0.06;
                dispatcher_d.setText(String.format("%.0f", disp_d));

                driver_d = Integer.parseInt(income_d.getText())*0.3;
                salary_d.setText(String.format("%.0f", driver_d));
            }

            if(income_d.getText().equals("")){
                dispatcher_d.setText("0");
                salary_d.setText("0");
            }

        });

        income_n.textProperty().addListener((observableValue, s, t1) -> {

            double disp_n, driver_n;

            if(!income_n.getText().equals("")){
                disp_n = Integer.parseInt(income_n.getText())*0.08;
                dispatcher_n.setText(String.format("%.0f", disp_n));

                driver_n = Integer.parseInt(income_n.getText())*0.3;
                salary_n.setText(String.format("%.0f", driver_n));


            }

            if(income_n.getText().equals("")){
                dispatcher_n.setText("0");
                salary_n.setText("0");

            }

        });









    }
}