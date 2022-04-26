package com.example.batallanaval.logic.utilities;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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

    public static ImageView image(String url, int setX, int setY, int width, int height) throws FileNotFoundException {

        InputStream stream = new FileInputStream(url);
        Image image = new Image(stream);
        //Creating the image view
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(setX);
        imageView.setY(setY);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);

        return imageView;
    }
}
