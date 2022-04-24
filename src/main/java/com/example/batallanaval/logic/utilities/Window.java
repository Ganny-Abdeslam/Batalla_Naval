package com.example.batallanaval.logic.utilities;

import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class Window {

    static  double x, y = 0;
    public static void extras(Stage primaryStage, Parent root){

        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);
        });
    }

    public static void extras(Stage primaryStage, Pane root){

        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);
        });
    }
}
