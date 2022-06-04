package com.example.batallanaval.logic;

import com.example.batallanaval.logic.field.Grid;
import com.example.batallanaval.logic.ships.*;
import javafx.scene.control.Button;

import java.util.ArrayList;

import static com.example.batallanaval.logic.Combat.combat;
import static com.example.batallanaval.logic.utilities.RandomFunction.generateRandomNumbers;
import static com.example.batallanaval.logic.utilities.CheckPlace.checkPlaceHorizontal;
import static com.example.batallanaval.logic.utilities.CheckPlace.checkPlaceVertical;

public class IA {
    private Grid grid;

    public IA(Grid grid){
        this.grid = grid;

        placeShip(new Destroyer());
        placeShip(new Carrier());
        placeShip(new Submarine());
        placeShip(new PatrolBoat());
    }

    /**
     * Metodo atacar de la IA.
     */
    public void attack(ArrayList<ArrayList<Button>> buttons){
        int a = generateRandomNumbers(0, 10);
        int b = generateRandomNumbers(0,10);
        if(!buttons.get(a).get(b).getId().equals("missing")
            && !buttons.get(a).get(b).getId().equals("damage")
            && !buttons.get(a).get(b).getId().equals("destroyed")){

            combat(buttons.get(a).get(b));
            checkDestroyed(buttons);

        }else {
            attack(buttons);
        }
    }

    /**
     * Aqui pondria mi funcion, si tuviese una
     */
    public void checkDestroyed(ArrayList<ArrayList<Button>> buttons){

    }

    /**
     * Metodo para colocar los barcos.
     */
    public void placeShip(Ship ship){
        int a = generateRandomNumbers(0, 10);
        int b = generateRandomNumbers(0,10);
        int c = generateRandomNumbers(0, 2);
        if (c == 1) {
            if (!checkPlaceHorizontal(a, b, ship, ship.getShipType().getSize(), this.grid)) {
                placeShip(ship);
            }
        }else{
            if(!checkPlaceVertical(a, b, ship, ship.getShipType().getSize(), this.grid)){
                placeShip(ship);
            }
        }
    }
}
