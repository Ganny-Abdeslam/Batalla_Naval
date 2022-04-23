package com.example.batallanaval.controller;

import javafx.scene.Scene;
import java.io.InputStream;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Splash {
    
    private Scene splash;
    final private Pane pane;
    
    public Splash() {

        this.pane = new Pane();
        this.pane.setStyle("-fx-background-color:skyblue");

        this.splash = new Scene(this.pane, 700, 600);
    }
    
    public void show() throws FileNotFoundException{

        InputStream stream = new FileInputStream("./resource/Img/logo.png");
        Image image = new Image(stream);
        //Creating the image view
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(0);
        imageView.setY(40);
        imageView.setFitWidth(700);
        imageView.setFitHeight(600);
        imageView.setPreserveRatio(true);

        this.pane.getChildren().add(imageView);
    }

    public Scene getSplahScene(){
        return this.splash;
    }

}
