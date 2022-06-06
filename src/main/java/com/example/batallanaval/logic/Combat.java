package com.example.batallanaval.logic;

import com.example.batallanaval.logic.field.Box;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

import static com.example.batallanaval.controller.utilities.Window.topBar;

public class Combat {
    /**
     * Combate para la IA. Identifica si hay una imagen en el boton, si hay realiza el daño al barco, sino falla
     * La IA solo requiere saber si hay un barco pntado en el boton
     */
    public static void combat(Button button){
        if(button.getGraphic()!=null){
            button.setId("damage");
            button.setDisable(true);
            button.setGraphic(null);
        }else{
            button.setId("missing");
            button.setDisable(true);
        }
    }

    /**
     * Combate del Jugador. Identifica si las cajas tienen un barco, si existe se hace daño, en caso contrario falla
     * Ya que en el campo de la IA no hay barcos pintados, se requiere saber si hay un barco en la caja
     */
    public static void combat(Box box, Button button){
        if(box.getShip()!=null){
            button.setId("damage");
            button.setDisable(true);
            box.setShip(null);
        }else{
            button.setId("missing");
            button.setDisable(true);
        }
    }
    /**
     * Identifica el ganador. Contando la cantidad de botones con daño (rojos)
     * Cuando la cantidad iguala al tamanio combinado de todos los barcos, se tiene un ganador
     */
    public static boolean win(ArrayList<ArrayList<Button>> buttons, String msj, Stage stage){
        int count = 0;
        for (ArrayList<Button> button: buttons) {
            for (Button item: button) {
                if(item.getId().equals("damage")){
                    count++;
                }
            }
        }
        //Mensaje del ganador
        if(count >= 18){
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(stage);
            VBox dialogVbox = new VBox(20);

            HBox hBox = topBar();

            Text text = new Text(("Win"+msj));
            text.setId("textWin");

            dialogVbox.getChildren().add(hBox);
            dialogVbox.getChildren().add(text);
            dialogVbox.setId("dialog");


            Scene dialogScene = new Scene(dialogVbox, 180, 60);
            dialog.setScene(dialogScene);
            dialog.show();
            return true;
        }
        return false;
    }
}