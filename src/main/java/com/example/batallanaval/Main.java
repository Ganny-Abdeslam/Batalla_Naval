package com.example.batallanaval;

import com.example.batallanaval.controller.Splash;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


import java.io.FileNotFoundException;

import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Splash splash = new Splash();
        splash.show();
        primaryStage.setScene(splash.getSplahScene());

        Timeline timeline = new Timeline(5000);
        KeyFrame key = new KeyFrame(Duration.millis(2000));
        timeline.getKeyFrames().add(key);
        timeline.setOnFinished(event ->{
                    try {
                        Parent root = FXMLLoader.load(Main.class.getResource("interface.fxml"));
                        Scene scene = new Scene(root);
                        scene.getStylesheets().add(getClass().getResource("interfaceCSS.css").toExternalForm());
                        primaryStage.setScene(scene);
                        primaryStage.show();
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
        );
        timeline.play();
        primaryStage.show();
        //FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        //stage.setTitle("Hello!");
        //stage.setScene(scene);
        //stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}