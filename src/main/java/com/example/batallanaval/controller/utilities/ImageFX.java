package com.example.batallanaval.controller.utilities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ImageFX {
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
