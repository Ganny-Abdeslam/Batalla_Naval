package com.example.batallanaval;

import com.example.batallanaval.controller.Splash;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javafx.animation.KeyFrame;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import static com.example.batallanaval.logic.utilities.Window.bar;
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
                        primary(primaryStage);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
        );
        timeline.play();
        primaryStage.show();
    }

    public static void primary(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("interface.fxml"));
        Group groupObject = new Group();
        HBox hBox = bar();

        groupObject.getChildren().add(root);
        groupObject.getChildren().add(hBox);
        groupObject.getChildren().add(imageView());

        Scene scene = new Scene(groupObject);
        extras(primaryStage, hBox);
        scene.getStylesheets().add(Main.class.getResource("interfaceCSS.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("https://gamehag.com/img/games/logo/azur-lane.png"));
        primaryStage.show();
    }

    public static ImageView imageView() throws FileNotFoundException {

        InputStream stream = new FileInputStream("./resource/Img/init.png");
        Image image = new Image(stream);
        //Creating the image view
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(20);
        imageView.setY(180.0);
        imageView.setFitWidth(550.0);
        imageView.setFitHeight(800.0);
        imageView.setPreserveRatio(true);

        return imageView;
    }

    public static void main(String[] args) {
        launch();
    }
}