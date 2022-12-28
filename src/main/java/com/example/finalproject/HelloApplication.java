package com.example.finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        //Final Loading Screen
         /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoadingScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();*/

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainControl.fxml"));
        Scene scene;
        scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UNDECORATED);
        stage1.setScene(scene);
        stage1.show();
    }
}