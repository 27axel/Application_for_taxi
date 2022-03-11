package com.example.taxiapp;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public abstract class AlertManager extends Application{

   public static void showInfo(String car) {
       Alert alert = new Alert(AlertType.INFORMATION);
       alert.setTitle(car);

       // Header Text: null
       alert.setHeaderText(null);
       alert.setContentText("Машина " + car + ", успешно добавленна!");

       alert.showAndWait();
   }

    public static void showWarning(String car) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(car);

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Машина " + car + ", уже существует!");

        alert.showAndWait();
    }


}