package com.example.batallanaval.controller;


import com.example.batallanaval.logic.field.Grid;
import javafx.event.ActionEvent;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;

import static com.example.batallanaval.logic.utilities.Window.extras;

public class ControllerPlay {

    private Stage stage;
    private Scene scene;
    //private Parent root;
    final private Pane pane;
    private ArrayList<ArrayList<Button>> buttons;

    public ControllerPlay(){
        this.pane = new Pane();

        buttons = new ArrayList<>();
    }

    public void mover(ActionEvent e){
        Grid grid = new Grid();

        System.out.println(grid);
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

    public void  buttonClose(String msj){
        Button button = new Button("Close");
        button.setText(msj);
        button.setLayoutX(530);
        button.setLayoutY(500);

        button.setTextAlignment(TextAlignment.CENTER);
        button.setPrefHeight(60);
        button.setPrefWidth(179);

        button.setId("close");

        button.setOnAction(event -> {
            System.exit(0);
        });

        this.pane.getChildren().add(button);
    }

    public void init(){
        extras(stage, pane);
        stile();
        buttonClose("Close");

        field();
    }

    public void field(){
        Grid grid = new Grid();

        for(int i = 0; i < grid.getBoxes().length; i++){
            ArrayList<Button> buttons = new ArrayList<>();
            for (int j=0; j< grid.getBoxes()[i].length; j++) {
                Button button = new Button();
                button.setText(""+i);

                button.setId("ships");

                button.setLayoutX(35*(j+1));
                button.setLayoutY(35*(i+1));

                buttons.add(button);

                this.pane.getChildren().add(button);
            }
            this.buttons.add(buttons);
        }
    }
}
