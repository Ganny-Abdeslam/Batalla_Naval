package com.example.batallanaval.controller.utilities;

import com.example.batallanaval.controller.ControllerPlay;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.FileNotFoundException;

import static com.example.batallanaval.controller.utilities.ImageFX.image;

/**
 * Clase para todo lo relacionado con la ventana de la app
 */
public class Window {

    static  double x = 0, y = 0;

    /**
     * Permite el movimiento de la ventana desde la hbox (barra superior)
     */
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

    /**
     * Quita la barra superior por defecto, para implementar una propia
     */
    public static HBox topBar(){
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

    /**
     * Genera botones solo con texto y ubicacion sin importar el tamanio
     */
    public static Button button(String msj, int x, int y){
        Button button = new Button();
        button.setText(msj);
        button.setLayoutX(x);
        button.setLayoutY(y);

        button.setTextAlignment(TextAlignment.CENTER);
        button.setPrefHeight(60);
        button.setPrefWidth(179);

        return  button;
    }

    /**
     * Metodo para cuando se presiona al clic derecho suceda una evento
     * Dicho evento será el de rotar el barco
     */
    public static void clickRight(ControllerPlay controllerPlay){
        controllerPlay.getPane().setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY && controllerPlay.getCondition()){
                controllerPlay.setTwirl(!controllerPlay.getTwirl());
            }
        });
    }

    /**
     * Genera botones con texto, ubicacion y tamanio
     */
    public static Button button(String msj, int x, int y, int height, int width){
        Button button = new Button(msj);
        button.setLayoutX(x);
        button.setLayoutY(y);

        button.setTextAlignment(TextAlignment.CENTER);

        button.setMinHeight(height);
        button.setMinWidth(width);
        button.setMaxHeight(height);
        button.setMaxWidth(width);

        return  button;
    }

    /**
     * Permite separar texto con la coma "," como separador
     */
    public static String[] getText(Button button){
        return button.getText().split(",");
    }
}
