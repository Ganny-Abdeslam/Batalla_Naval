package com.example.batallanaval.logic;

import com.example.batallanaval.logic.field.Box;
import javafx.scene.control.Button;

import java.util.ArrayList;

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
    public static boolean win(ArrayList<ArrayList<Button>> buttons, String msj){
        int count = 0;
        for (ArrayList<Button> button: buttons) {
            for (Button item: button) {
                if(item.getId().equals("damage")){
                    count++;
                }
            }
        }

        if(count >= 14){
            System.out.println("Win " + msj);
            return true;
        }
        return false;
    }
}