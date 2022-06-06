package com.example.batallanaval.controller;

import com.example.batallanaval.logic.ButtonShip;
import com.example.batallanaval.logic.IA;
import com.example.batallanaval.logic.field.Grid;
import com.example.batallanaval.logic.ships.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static com.example.batallanaval.Main.primary;
import static com.example.batallanaval.logic.Combat.combat;
import static com.example.batallanaval.controller.utilities.ImageFX.image;
import static com.example.batallanaval.controller.utilities.Window.*;
import static com.example.batallanaval.logic.Combat.win;
import static com.example.batallanaval.logic.utilities.CheckPlace.checkPlaceHorizontal;
import static com.example.batallanaval.logic.utilities.CheckPlace.checkPlaceVertical;

/**
 * Clase principal que le da la mayor parte de la logica al juego (La vista con el controlador)
 */
public class ControllerPlay {
    /**
     * Definicion de variables
     */
    private Stage stage;
    private Scene scene;
    final private Pane pane;
    private Grid gridIA;
    private Grid gridPlayer;
    private boolean condition;
    private IA ia;
    private ArrayList<ArrayList<Button>> buttonsPlayer;
    private ArrayList<ArrayList<Button>> buttonsIA;
    private boolean startGame = false;
    private ButtonShip buttonShip;
    private boolean twirl = false;

    /**
     * Constructor de la clase
     */
    public ControllerPlay(){
        this.pane = new Pane();

        this.pane.setStyle("-fx-background-color:#074f94");

        this.buttonsPlayer = new ArrayList<>();
        this.buttonsIA = new ArrayList<>();

        this.condition = false;

        this.gridPlayer = new Grid();
        this.gridIA = new Grid();

        this.ia = new IA(this.gridIA);
        this.buttonShip = new ButtonShip();

        clickRight(this);
    }

    /**
     * Getters y Setters
     */
    public Pane getPane(){
        return this.pane;
    }
    public void setScene(Scene scene){
        this.scene = scene;
    }
    public void setTwirl(boolean twirl){
        this.twirl = twirl;
    }
    public boolean getCondition(){
        return this.condition;
    }
    public boolean getTwirl(){
        return this.twirl;
    }
    public ButtonShip getButtonShip(){
        return this.buttonShip;
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }

    /**
     * Otorga el estilo al juego implementado en el CSS
     */
    public void style(){
        this.scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/batallanaval/interfaceCSS.css")).toExternalForm());
    }

    /**
     * Evento para la colocacion de barcos por parte del jugador si el juego no ha iniciado
     * Si el juego a iniciado, son eventos de la partida (como combate y verificacion de victoria)
     */
    public void eventShip(Button button){
        button.setOnAction(event -> {
            if(this.condition && !this.startGame){
                try {
                    if(this.buttonShip.isPlace()){
                        remove();
                    }

                    if(button.getText().equals("")){
                        return;
                    }
                    String[] position = getText(button);

                    int y = Integer.parseInt(position[0]);
                    int x = Integer.parseInt(position[1]);

                    if(!twirl){
                        placeHorizontal(y, x);
                    }else{
                        placeVertical(y, x);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                condition = false;
                this.buttonShip.getButton().setId("battleship");
             }else if(this.startGame){
                String[] position = getText(button);

                int y = Integer.parseInt(position[0]);
                int x = Integer.parseInt(position[1]);

                combat(this.gridIA.getBoxes()[y][x], button);
                if(win(this.buttonsIA, "Player", this.stage)){
                    backOut();
                }
                this.ia.attack(this.buttonsPlayer);
                if(win(this.buttonsPlayer, "IA", this.stage)){
                    backOut();
                }
            }
        });
    }

    /**
     * Metodo para el colocado del barco de forma Horizontal
     */
    public void placeHorizontal(int y, int x) throws FileNotFoundException {

        if (checkPlaceHorizontal(y, x, this.buttonShip.getShip(), this.buttonShip.getShip().getShipType().getSize()-1, this.gridPlayer)){
            for (int i = 0; i < this.buttonShip.getShip().getShipType().getSize(); i++) {
                this.buttonsPlayer.get(y).get(x + i).setText("");
                this.buttonsPlayer.get(y).get(x + i).setGraphic(image(this.buttonShip.getShip().dirImages() + (i+1) + "horizontal.png", 0, 0, 30, 30));

                this.gridPlayer.getBoxes()[y][x + i].setShip(this.buttonShip.getShip());
                this.buttonShip.setPositions(y, i,0);
                this.buttonShip.setPositions(x+i, i, 1);
            }
            this.buttonShip.setPlace(true);
        }else{
            this.buttonShip.setPlace(false);
        }
    }

    /**
     * Metodo para el colocado del barco de forma vertical
     */
    public void placeVertical(int y, int x) throws FileNotFoundException {

        if (checkPlaceVertical(y, x, this.buttonShip.getShip(), this.buttonShip.getShip().getShipType().getSize()-1, this.gridPlayer)){
            for (int i = 0; i < this.buttonShip.getShip().getShipType().getSize(); i++) {
                this.buttonsPlayer.get(y+i).get(x).setText("");
                this.buttonsPlayer.get(y+i).get(x).setGraphic(image(this.buttonShip.getShip().dirImages() + (i+1) + "vertical.png", 0, 0, 30, 30));

                this.gridPlayer.getBoxes()[y+i][x].setShip(this.buttonShip.getShip());
                this.buttonShip.setPositions(y+i, i,0);
                this.buttonShip.setPositions(x, i, 1);
            }
            this.buttonShip.setPlace(true);
        }else{
            this.buttonShip.setPlace(false);
        }
    }

    /**
     * Metodo para remover el barco
     * Esto sucede en caso de que ya este en el campo y se quiera poner en oto lado
     */
    public void remove(){
        for(int i=0; i < this.buttonShip.getShip().getShipType().getSize(); i++) {
            this.buttonsPlayer.get(this.buttonShip.getPosition(i, 0))
                    .get(this.buttonShip.getPosition(i, 1))
                    .setText(this.buttonShip.getPosition(i, 0)+","+this.buttonShip.getPosition(i, 1));

            this.buttonsPlayer.get(this.buttonShip.getPosition(i, 0))
                    .get(this.buttonShip.getPosition(i, 1)).setGraphic(null);

            this.gridPlayer.getBoxes()[this.buttonShip.getPosition(i, 0)]
                    [this.buttonShip.getPosition(i, 1)].setShip(null);
        }
    }

    /**
     * Metodo para el evento del boton Back que vuelve a la pantalla de inicio
     * Llama al metodo backout para generar la pantalla de inicio
     */
    public void buttonBack(Button button){
        button.setId("back");

        button.setOnAction(event -> {
            backOut();
        });
    }

    /**
     * Metodo para el evento del boton Start que in inicia el juego
     */
    public void buttonStart(Button button){
        button.setId("start");

        button.setOnAction(event -> {
            disableButton(this.buttonsPlayer, true);
            disableButton(this.buttonsIA, false);
            this.startGame = true;

            button.setDisable(true);
        });
    }

    /**
     * Metodo para el evento del boton Info que muestra una pestaña con informacion del juego
     */
    public void buttonInfo(Button button){
        button.setId("Info");

        button.setOnAction(event -> {
            try {
                primary(new Stage(), "info.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Metodo que vuelve a generar la pantalla de inicio como escenario principal
     */
    public void backOut(){
        try {
            primary(this.stage, "interface.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para la generacion de los botones Info, Start y Back
     */
    public void generateButtons(){
        Button buttonInfo = button("Info", 608, 500);
        buttonInfo(buttonInfo);
        this.pane.getChildren().add(buttonInfo);

        Button buttonStar = button("Start", 0,500);
        buttonStart(buttonStar);
        this.pane.getChildren().add(buttonStar);

        Button buttonBack = button("Back", 298, 500);
        buttonBack(buttonBack);
        this.pane.getChildren().add(buttonBack);

        HBox hBox = topBar();
        extras(stage, hBox);
        this.pane.getChildren().add(hBox);
    }

    /**
     * Inicializador de toda la parte grafica y se podría decir que de todo el juego
     */
    public void init() throws FileNotFoundException {
        style();

        generateButtons();

        this.buttonsPlayer = field(20, 55, true);
        this.buttonsIA = field(400, 55, false);
        disableButton(this.buttonsIA, true);

        generationsButtons();
    }

    /**
     * Metodo para la generacion del campo
     */
    public ArrayList<ArrayList<Button>> field(int x, int y, boolean condition){

        ArrayList<ArrayList<Button>> buttonsT = new ArrayList<>();
        Grid grid = new Grid();

        for(int i = 0; i < grid.getBoxes().length; i++){
            ArrayList<Button> buttons = new ArrayList<>();
            for (int j=0; j< grid.getBoxes()[i].length; j++) {
                Button button = button(i+","+j, x+30*(j+1), y+30*(i+1), 30, 30);

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

    /**
     * Metodo que imprime las coordenadas del campo
     */
    public void coordinatesField(int condition, int index, int x, int y, String textField){
        if(condition == 0){
            Button text = button(textField.charAt(index)+"", x, y, 30, 30);
            text.setId("textField");

            text.setDisable(true);
            this.pane.getChildren().add(text);
        }
    }

    /**
     * Metodo para deshabilitar botones
     */
    public void disableButton(ArrayList<ArrayList<Button>> buttons, boolean condition){
        for (ArrayList<Button> buttonArrayList : buttons) {
            for (Button button : buttonArrayList) {
                button.setDisable(condition);
            }
        }
    }

    /**
     * Generacion de Botones de los diferentes barcos
     */
    public void generationsButtons() throws FileNotFoundException{
        ButtonShip submarine = new ButtonShip(new Submarine(), button("", 20, 410));
        shipButton(submarine.getButton(), submarine);
        this.pane.getChildren().add(submarine.getButton());
        submarine.getButton().setGraphic(image(submarine.getShip().getImage(), 0, 0, 60, 20));

        ButtonShip carrier  = new ButtonShip(new Carrier(), button("", 120, 410));
        shipButton(carrier.getButton(), carrier);
        this.pane.getChildren().add(carrier.getButton());
        carrier.getButton().setGraphic(image(carrier.getShip().getImage(), 0, 0, 60, 20));

        ButtonShip destroyer  = new ButtonShip(new Destroyer(), button("", 220, 410));
        shipButton(destroyer.getButton(), destroyer);
        this.pane.getChildren().add(destroyer.getButton());
        destroyer.getButton().setGraphic(image(destroyer.getShip().getImage(), 0, 0, 60, 20));

        ButtonShip patrolBoat  = new ButtonShip(new PatrolBoat(), button("", 320, 410));
        shipButton(patrolBoat.getButton(), patrolBoat);
        this.pane.getChildren().add(patrolBoat.getButton());
        patrolBoat.getButton().setGraphic(image(patrolBoat.getShip().getImage(), 0, 0, 60, 20));

        ButtonShip battleship  = new ButtonShip(new Battleship(), button("", 420, 410));
        shipButton(battleship.getButton(), battleship);
        this.pane.getChildren().add(battleship.getButton());
        battleship.getButton().setGraphic(image(battleship.getShip().getImage(), 0, 0, 60, 20));
    }

    /**
     * Metodo que le da la funcionalidad a los botones de los barcos
     */
    public void shipButton(Button button, ButtonShip buttonShip){
        button.setId("battleship");
        button.setOnAction(event -> {
            this.buttonShip = buttonShip;
            condition = true;
            button.setId("battleshipActive");
        });
    }

}