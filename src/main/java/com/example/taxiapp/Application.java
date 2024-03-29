package com.example.taxiapp;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Application extends javafx.application.Application {

    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setMinWidth(1050);
        stage.setMinHeight(600);
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("driverPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1050, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml, int width, int height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stg.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);

    }

}

