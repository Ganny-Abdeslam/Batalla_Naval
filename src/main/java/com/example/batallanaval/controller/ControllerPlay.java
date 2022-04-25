package com.example.batallanaval.controller;


import com.example.batallanaval.logic.field.Grid;
import javafx.event.ActionEvent;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import static com.example.batallanaval.Main.primary;

import static com.example.batallanaval.logic.utilities.Window.bar;
import static com.example.batallanaval.logic.utilities.Window.extras;

public class ControllerPlay {

    private Stage stage;
    private Scene scene;
    //private Parent root;
    final private Pane pane;
    private ArrayList<ArrayList<Button>> buttonsJugador;
    private ArrayList<ArrayList<Button>> buttonsIA;

    public ControllerPlay(){
        this.pane = new Pane();

        this.pane.setStyle("-fx-background-color:#074f94");

        buttonsJugador = new ArrayList<>();
        buttonsIA = new ArrayList<>();
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

    public void buttonBack(Button button){
        button.setId("back");

        button.setOnAction(event -> {
            try {
                primary(this.stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public Button  button(String msj, int x, int y){
        Button button = new Button();
        button.setText(msj);
        button.setLayoutX(x);
        button.setLayoutY(y);

        button.setTextAlignment(TextAlignment.CENTER);
        button.setPrefHeight(60);
        button.setPrefWidth(179);
        this.pane.getChildren().add(button);

        return  button;
    }

    public void init(){
        stile();

        Button buttonClose = button("Info", 608, 500);

        Button buttonStar = button("Start", 0,500);
        buttonStar.setId("start");

        Button buttonBack = button("Back", 298, 500);
        buttonBack(buttonBack);

        HBox hBox = bar();
        extras(stage, hBox);
        this.pane.getChildren().add(hBox);

        this.buttonsJugador = field(20, 15);
        this.buttonsIA = field(410, 15);
    }

    public ArrayList<ArrayList<Button>> field(int x, int y){
        ArrayList<ArrayList<Button>> buttonsT = new ArrayList<>();
        Grid grid = new Grid();

        for(int i = 0; i < grid.getBoxes().length; i++){
            ArrayList<Button> buttons = new ArrayList<>();
            for (int j=0; j< grid.getBoxes()[i].length; j++) {
                Button button = new Button();
                button.setText(""+i);

                button.setId("ships");

                button.setLayoutX(x+30*(j+1));
                button.setLayoutY(y+35*(i+1));

                buttons.add(button);

                this.pane.getChildren().add(button);
            }
            buttonsT.add(buttons);
        }

        return buttonsT;
    }
}
