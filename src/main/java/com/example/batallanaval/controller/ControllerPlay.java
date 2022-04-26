package com.example.batallanaval.controller;


import com.example.batallanaval.logic.field.Grid;
import javafx.event.ActionEvent;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
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

    public void buttonStar(Button button){
        button.setId("start");

        button.setOnAction(event -> {
            disableButton(this.buttonsJugador, true);
            disableButton(this.buttonsIA, false);
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
        buttonStar(buttonStar);

        Button buttonBack = button("Back", 298, 500);
        buttonBack(buttonBack);

        HBox hBox = bar();
        extras(stage, hBox);
        this.pane.getChildren().add(hBox);

        this.buttonsJugador = field(20, 55);
        this.buttonsIA = field(400, 55);
        disableButton(this.buttonsIA, true);
    }

    public ArrayList<ArrayList<Button>> field(int x, int y){
        ArrayList<ArrayList<Button>> buttonsT = new ArrayList<>();
        Grid grid = new Grid();


        for(int i = 0; i < grid.getBoxes().length; i++){
            ArrayList<Button> buttons = new ArrayList<>();
            for (int j=0; j< grid.getBoxes()[i].length; j++) {
                Button button = new Button();
                button.setText("");

                button.setId("ships");

                button.setMinWidth(30);
                button.setMinHeight(29);
                button.setMaxHeight(30);
                button.setLayoutX(x+30*(j+1));
                button.setLayoutY(y+30*(i+1));

                buttons.add(button);

                this.pane.getChildren().add(button);

                coordinatesField(i, j, x, y);
            }
            buttonsT.add(buttons);
        }

        return buttonsT;
    }

    public void coordinatesField(int i, int j, int x, int y){
        String textField = "ABCDEFGHIJ";
        String numbField = "1234567890";

        if(j == 0){
            Button text = new Button(textField.charAt(i)+"");
            text.setLayoutX(x+30*(i+1));
            text.setLayoutY(y-5);

            text.setMinHeight(30);
            text.setMinWidth(30);
            text.setMaxHeight(30);
            text.setMaxWidth(30);
            text.setId("textField");

            text.setDisable(true);
            this.pane.getChildren().add(text);
        }

        if(i == 0){
            Button text = new Button(numbField.charAt(j)+"");
            if(x < 300){
                text.setLayoutX(x-2);
            }else{
                text.setLayoutX(x+30*(11)+5);
            }

            text.setLayoutY(y+30*(j+1));

            text.setId("textField");

            text.setMaxHeight(30);
            text.setMaxWidth(30);

            text.setDisable(true);
            this.pane.getChildren().add(text);
        }
    }

    public void disableButton(ArrayList<ArrayList<Button>> buttons, boolean condition){
        for(int i=0; i < buttons.size(); i++){
            for (Button button: buttons.get(i)) {
                if (condition){
                    button.setDisable(true);
                }
                else{
                    button.setDisable(false);
                }
            }
        }
    }
}
