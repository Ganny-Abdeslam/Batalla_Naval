package com.example.batallanaval.controller;

import com.example.batallanaval.logic.IA;
import com.example.batallanaval.logic.field.Grid;
import com.example.batallanaval.logic.ships.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static com.example.batallanaval.Main.primary;
import static com.example.batallanaval.logic.Combat.combat;
import static com.example.batallanaval.controller.utilities.ImageFX.image;
import static com.example.batallanaval.controller.utilities.Window.*;

public class ControllerPlay {

    private Stage stage;
    private Scene scene;
    final private Pane pane;
    private Grid gridIA;
    private Grid gridPlayer;
    private boolean condition;
    private IA ia;
    private ArrayList<ArrayList<Button>> buttonsPlayer;
    private ArrayList<ArrayList<Button>> buttonsIA;
    private Ship ship;
    private boolean startGame = false;
    private boolean[] positionBoolean = new boolean[5];
    private int position;
    private int[][] coordinates = new int[5][2];

    public ControllerPlay(){
        this.pane = new Pane();

        this.pane.setStyle("-fx-background-color:#074f94");

        this.buttonsPlayer = new ArrayList<>();
        this.buttonsIA = new ArrayList<>();

        this.condition = false;

        this.gridPlayer = new Grid();
        this.gridIA = new Grid();

        this.ia = new IA(this.gridIA);

        Arrays.fill(this.positionBoolean, false);
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
        this.scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/batallanaval/interfaceCSS.css")).toExternalForm());
    }

    public void eventShip(Button button){
        button.setOnAction(event -> {
            if(this.condition && !this.startGame){
                try {
                    if(this.positionBoolean[this.position]){
                        for(int i=1; i <= this.ship.getShipType().getSize(); i++){
                            this.buttonsPlayer.get(this.coordinates[this.position][0]).get(i+(this.coordinates[this.position][1]-1)).setText(this.coordinates[this.position][0]+","+(i+this.coordinates[this.position][1]-1));
                            this.buttonsPlayer.get(this.coordinates[this.position][0]).get(i+(this.coordinates[this.position][1]-1)).setGraphic(null);

                            this.gridPlayer.getBoxes()[this.coordinates[this.position][0]][i+(this.coordinates[this.position][1]-1)].setShip(null);
                        }
                    }

                    String[] position = getText(button);

                    int y = Integer.parseInt(position[0]);
                    int x = Integer.parseInt(position[1]);

                    if(x+this.ship.getShipType().getSize() > 10){
                        return;
                    }

                    for(int i=1; i <= this.ship.getShipType().getSize(); i++){
                        this.buttonsPlayer.get(y).get(x+(i-1)).setText("");
                        this.buttonsPlayer.get(y).get(x+(i-1)).setGraphic(image(this.ship.dirImages()+i+".png", 0, 0, 30, 30));

                        this.gridPlayer.getBoxes()[y][x+(i-1)].setShip(this.ship);
                    }

                    this.positionBoolean[this.position] = true;
                    this.coordinates[this.position][0] = y;
                    this.coordinates[this.position][1] = x;

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                condition = false;
            }else if(this.startGame){
                String[] position = getText(button);

                int y = Integer.parseInt(position[0]);
                int x = Integer.parseInt(position[1]);

                combat(this.gridIA.getBoxes()[y][x], button);
                this.ia.attack(this.buttonsPlayer);
            }
        });
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

            button.setDisable(true);
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
        for (ArrayList<Button> buttonArrayList : buttons) {
            for (Button button : buttonArrayList) {
                button.setDisable(condition);
            }
        }
    }

    /**
     * Generacion de Botones
     */
    public void  generacionBotones() throws FileNotFoundException{

        //PRUEBA
        Text text = new Text("Battleship");
        text.setX(20);
        text.setY(400);
        this.pane.getChildren().add(text);

        Ship battleship = new Submarine();
        Button buttonBarquit_Submarine = button("S", 20, 410);
        barquito(buttonBarquit_Submarine);
        this.pane.getChildren().add(buttonBarquit_Submarine);
        buttonBarquit_Submarine.setGraphic(image(battleship.getImage(), 0, 0, 60, 20));

        Ship carrier = new Carrier();
        Button buttonBarquit_Carrier = button("C", 140, 410);
        barquito(buttonBarquit_Carrier);
        this.pane.getChildren().add(buttonBarquit_Carrier);
        buttonBarquit_Carrier.setGraphic(image(carrier.getImage(), 0, 0, 60, 20));

        Ship destroyer = new Destroyer();
        Button buttonBarquit_Destroyer = button("D", 260, 410);
        barquito(buttonBarquit_Destroyer);
        this.pane.getChildren().add(buttonBarquit_Destroyer);
        buttonBarquit_Destroyer.setGraphic(image(destroyer.getImage(), 0, 0, 60, 20));

        Ship patrolBoat = new PatrolBoat();
        Button buttonBarquit_PatrolBoat = button("PB", 380, 410);
        barquito(buttonBarquit_PatrolBoat);
        this.pane.getChildren().add(buttonBarquit_PatrolBoat);
        buttonBarquit_PatrolBoat.setGraphic(image(patrolBoat.getImage(), 0, 0, 60, 20));
    }

    //PRUEBA
    public void barquito(Button button){
        button.setId("battleship");
        button.setOnAction(event -> {
            switch (button.getText()) {
                case "D" -> {
                    this.ship = new Destroyer();
                    this.position = 0;
                }
                case "C" -> {
                    this.ship = new Carrier();
                    this.position = 1;
                }
                case "Cr" -> {
                    this.ship = new Submarine();
                    this.position = 2;
                }
                case "S" -> {
                    this.ship = new Submarine();
                    this.position = 3;
                }
                case "PB" -> {
                    this.ship = new PatrolBoat();
                    this.position = 4;
                }
            }
            condition = true;
            mouse(button);
        });
    }

}