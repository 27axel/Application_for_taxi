package com.example.taxiapp.util;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public abstract class AlertManager extends Application{

   public static void showInfo(String text) {
       Alert alert = new Alert(AlertType.INFORMATION);
       alert.setTitle("Информация");

       // Header Text: null
       alert.setHeaderText(null);
       alert.setContentText(text);

       alert.showAndWait();
   }

    public static void showWarning(String text) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Ошибка");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText(text);

        alert.showAndWait();
    }


}