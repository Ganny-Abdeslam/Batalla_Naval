package com.example.batallanaval.logic.utilities;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class Window {

    static  double x = 0, y = 0;
    public static void extras(Stage primaryStage, HBox root){

        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);
        });
    }

    public static HBox bar(){
        HBox hBox = new HBox();
        hBox.setLayoutX(0);
        hBox.setLayoutY(0);
        hBox.setPrefSize(778, 18);
        hBox.setMinHeight(26);
        hBox.setStyle("-fx-background-color: gray");
        hBox.setAlignment(Pos.TOP_RIGHT);

        Button button = new Button("X");
        button.setId("close");

        button.setOnAction(event -> {
            System.exit(0);
        });

        hBox.getChildren().add(button);

        return hBox;
    }
}
