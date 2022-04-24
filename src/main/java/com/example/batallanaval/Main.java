package com.example.batallanaval;

import com.example.batallanaval.controller.Splash;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


import java.io.FileNotFoundException;

import javafx.animation.KeyFrame;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import static com.example.batallanaval.logic.utilities.Window.extras;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Splash splash = new Splash();
        splash.show();

        primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setScene(splash.getSplahScene());

        Timeline timeline = new Timeline(500);
        KeyFrame key = new KeyFrame(Duration.millis(400));
        timeline.getKeyFrames().add(key);
        timeline.setOnFinished(event ->{
                    try {
                        Parent root = FXMLLoader.load(Main.class.getResource("interface.fxml"));
                        Scene scene = new Scene(root);
                        extras(primaryStage, root);
                        scene.getStylesheets().add(getClass().getResource("interfaceCSS.css").toExternalForm());
                        primaryStage.setScene(scene);
                        primaryStage.getIcons().add(new Image("https://gamehag.com/img/games/logo/azur-lane.png"));
                        primaryStage.show();
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
        );
        timeline.play();
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}