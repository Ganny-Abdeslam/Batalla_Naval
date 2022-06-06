package com.example.batallanaval;

import com.example.batallanaval.controller.Splash;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import static com.example.batallanaval.controller.utilities.ImageFX.image;
import static com.example.batallanaval.controller.utilities.Window.*;

public class Main extends Application {
    /**
     * Metodo del inicio de la aplicacion donde se inicializa y se le dan los parametros al Splash
     * Como el tiempo que aparece en pantalla
     * Asi como el cambio a la pantalla principal
     */
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
                        primary(primaryStage, "interface.fxml");
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
        );
        timeline.play();
        primaryStage.show();
    }
    /**
     * Generar la ventana principal
     */
    public static void primary(Stage primaryStage, String msj) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource(msj));
        Group groupObject = new Group();
        HBox hBox = topBar();

        groupObject.getChildren().add(root);
        groupObject.getChildren().add(hBox);
        groupObject.getChildren().add(image("./resource/Img/init.png", 20, 180, 550, 800));

        Scene scene = new Scene(groupObject);
        extras(primaryStage, hBox);
        scene.getStylesheets().add(Main.class.getResource("interfaceCSS.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("https://gamehag.com/img/games/logo/azur-lane.png"));
        primaryStage.show();
    }

    /**
     * Iniciar el juego
     */
    public static void main(String[] args) {
        launch();
    }
}