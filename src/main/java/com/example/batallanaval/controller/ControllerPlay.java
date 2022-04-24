package com.example.batallanaval.controller;

import java.io.IOException;

import com.example.batallanaval.logic.field.Grid;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import static com.example.batallanaval.logic.utilities.Window.extras;

public class ControllerPlay {

    private Stage stage;
    private Scene scene;
    private Parent root;
    final private Pane pane;

    public ControllerPlay(){
        this.pane = new Pane();
    }

    public void mover(ActionEvent e) throws  IOException{
        Grid grid = new Grid();

        System.out.println(grid.toString());
    }

    public Pane getPane(){
        return this.pane;
    }

    public void setScene(Scene scene){
        this.scene = scene;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void stile(){
        this.scene.getStylesheets().add(getClass().getResource("/com/example/batallanaval/interfaceCSS.css").toExternalForm());
    }

    public void text(){
        Text text = new Text();
        text.setText("Hola mundo");
        text.setX(40);
        text.setY(60);
        this.pane.getChildren().add(text);
    }

    public void  buttonClose(String msj){
        Button button = new Button();
        button.setText(msj);
        button.setLayoutX(530);
        button.setLayoutY(500);

        button.setTextAlignment(TextAlignment.CENTER);
        button.setPrefHeight(60);
        button.setPrefWidth(179);

        button.setOnAction(event -> {
            System.exit(0);
        });

        this.pane.getChildren().add(button);
    }

    public void init(){
        extras(stage, pane);
        stile();
        text();
        buttonClose("Close");
    }


}
