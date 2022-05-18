package com.example.batallanaval.controller;


import com.example.batallanaval.logic.field.Grid;
import com.example.batallanaval.logic.ships.Battleship;
import com.example.batallanaval.logic.ships.Carrier;
import com.example.batallanaval.logic.ships.Image;
import com.example.batallanaval.logic.ships.Ship;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static com.example.batallanaval.Main.primary;
import static com.example.batallanaval.controller.Combat.combat;
import static com.example.batallanaval.controller.utilities.ImageFX.image;
import static com.example.batallanaval.controller.utilities.Window.*;
import static com.example.batallanaval.logic.utilities.RandomFunction.generateRandomNumbers;

public class ControllerPlay {

    private Stage stage;
    private Scene scene;
    final private Pane pane;
    private boolean condition;
    private ArrayList<ArrayList<Button>> buttonsPlayer;
    private ArrayList<ArrayList<Button>> buttonsIA;
    private Ship ship;
    private boolean startGame = false;

    public ControllerPlay(){
        this.pane = new Pane();

        this.pane.setStyle("-fx-background-color:#074f94");

        this.buttonsPlayer = new ArrayList<>();
        this.buttonsIA = new ArrayList<>();

        this.condition = false;
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

    public void eventShip(Button button){
        button.setOnAction(event -> {
            if(this.condition && !this.startGame){
                try {
                    String pos = button.getText();
                    String[] position = pos.split(",");

                    int y = Integer.parseInt(position[0]);
                    int x = Integer.parseInt(position[1]);

                    for(int i=1; i <= this.ship.getShipType().getSize(); i++){
                        this.buttonsPlayer.get(y).get(x+(i-1)).setGraphic(image(this.ship.dirImages()+i+".png", 0, 0, 30, 30));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                condition = false;
            }else if(this.startGame){
                combat(button);
                prueba();
            }
        });
    }

    //Probando IA
    public void prueba(){
        int a = generateRandomNumbers(0, 10);
        int b = generateRandomNumbers(0,10);
        if(!this.buttonsPlayer.get(a).get(b).getId().equals("missing")){
            combat(this.buttonsPlayer.get(a).get(b));
        }else {
            prueba();
        }
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
            disableButton(this.buttonsPlayer, true);
            disableButton(this.buttonsIA, false);
            this.startGame = true;
        });
    }
    public void buttonInfo(Button button){
        button.setId("Info");

        button.setOnAction(event -> {

        });
    }

    public void generateButtons(){
        Button buttonInfo = button("Info", 608, 500);
        buttonInfo(buttonInfo);
        this.pane.getChildren().add(buttonInfo);

        Button buttonStar = button("Start", 0,500);
        buttonStar(buttonStar);
        this.pane.getChildren().add(buttonStar);

        Button buttonBack = button("Back", 298, 500);
        buttonBack(buttonBack);
        this.pane.getChildren().add(buttonBack);

        HBox hBox = topBar();
        extras(stage, hBox);
        this.pane.getChildren().add(hBox);
    }

    //Inicializador de toda la parte grafica y se podría decir que de todo el juego
    public void init() throws FileNotFoundException {
        stile();

        generateButtons();

        this.buttonsPlayer = field(20, 55, true);
        this.buttonsIA = field(400, 55, false);
        disableButton(this.buttonsIA, true);

        this.buttonsIA.get(0).get(0).setText("*");
        this.buttonsIA.get(0).get(1).setText("*");
        this.buttonsIA.get(0).get(2).setText("*");
        this.buttonsIA.get(0).get(3).setText("*");

        generacionBotones();
    }

    public ArrayList<ArrayList<Button>> field(int x, int y, boolean condition){

        ArrayList<ArrayList<Button>> buttonsT = new ArrayList<>();
        Grid grid = new Grid();

        for(int i = 0; i < grid.getBoxes().length; i++){
            ArrayList<Button> buttons = new ArrayList<>();
            for (int j=0; j< grid.getBoxes()[i].length; j++) {
                Button button = button(i+","+j+"", x+30*(j+1), y+30*(i+1), 30, 30);

                if (condition){
                    button.setId("shipsPlayer");
                }else{
                    button.setId("shipsIA");
                }
                eventShip(button);

                buttons.add(button);

                this.pane.getChildren().add(button);

                //Calculos que ni dios sabe del todo porque pero hacen que se vea mamalon el tablero en pantalla
                coordinatesField(j, i,x+30*(i+1), y-5, "0123456789");
                if(x < 300){
                    coordinatesField(i, j, x-3, y+30*(j+1), "ABCDEFGHIJ");
                }else {
                    coordinatesField(i, j, x+30*(11)+3, y+30*(j+1), "ABCDEFGHIJ");
                }

            }
            buttonsT.add(buttons);
        }

        return buttonsT;
    }

    public void coordinatesField(int condition, int index, int x, int y, String textField){
        if(condition == 0){
            Button text = button(textField.charAt(index)+"", x, y, 30, 30);
            text.setId("textField");

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

    /**
     * Generacion de Botones
     */
    public void  generacionBotones() throws FileNotFoundException{
        Battleship battleship = new Battleship();
        //PRUEBA
        Text text = new Text("Battleship");
        text.setX(20);
        text.setY(400);
        this.pane.getChildren().add(text);

        Button buttonBarquit_BattleShip = button("", 20, 410);
        barquito(buttonBarquit_BattleShip);
        this.pane.getChildren().add(buttonBarquit_BattleShip);
        buttonBarquit_BattleShip.setGraphic(image(battleship.getImage(), 0, 0, 60, 10));


        Carrier carrier = new Carrier();
        Button buttonBarquit_Carrier = button("", 140, 410);
        barquito(buttonBarquit_Carrier);
        this.pane.getChildren().add(buttonBarquit_Carrier);
        buttonBarquit_Carrier.setGraphic(image(carrier.getImage(), 0, 0, 60, 20));
    }

    //PRUEBA
    public void barquito(Button button){
        button.setId("battleship");
        button.setOnAction(event -> {
            condition = true;
            this.ship = new Carrier();
            mouse(button);
        });
    }
}
