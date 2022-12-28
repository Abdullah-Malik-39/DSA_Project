package com.example.Controllers;

import com.example.finalproject.HelloApplication;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoadingScreen implements Initializable {
    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label name;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> progressBar.setProgress(0.1)));
        timeline1.play();
        timeline1.setOnFinished(event -> {
            Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(0.5), event1 -> progressBar.setProgress(0.3)));
            timeline2.play();
            timeline2.setOnFinished(event2 -> {
                Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(0.5), event3 -> progressBar.setProgress(0.4)));
                timeline3.play();
                timeline3.setOnFinished(event4 -> {
                    Timeline timeline4 = new Timeline(new KeyFrame(Duration.seconds(0.5), event5 -> progressBar.setProgress(0.8)));
                    timeline4.play();
                    timeline4.setOnFinished(event6 -> {
                        Timeline timeline5 = new Timeline(new KeyFrame(Duration.seconds(0.5), event7 -> progressBar.setProgress(1.0)));
                        timeline5.play();
                        timeline5.setOnFinished(event8 -> {
                            Timeline timeline6 = new Timeline(new KeyFrame(Duration.seconds(0.3), event9 -> progressBar.setProgress(1.0)));
                            timeline6.play();
                            timeline6.setOnFinished(event10 -> {
                                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainControl.fxml"));
                                Scene scene;
                                try {
                                    scene = new Scene(fxmlLoader.load(), 800, 600);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                Stage stage1 = new Stage();
                                stage1.initStyle(StageStyle.UNDECORATED);
                                stage1.setScene(scene);
                                stage1.setMaximized(true);
                                stage1.show();
                                Stage stage = (Stage) name.getScene().getWindow();
                                stage.close();
                            });
                        });
                    });
                });
            });
        });
    }
}
