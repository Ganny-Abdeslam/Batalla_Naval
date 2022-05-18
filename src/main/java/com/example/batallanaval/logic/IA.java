package com.example.batallanaval.logic;

import com.example.batallanaval.logic.field.Grid;
import com.example.batallanaval.logic.ships.*;
import javafx.scene.control.Button;

import java.util.ArrayList;

import static com.example.batallanaval.logic.Combat.combat;
import static com.example.batallanaval.logic.utilities.RandomFunction.generateRandomNumbers;

public class IA {
    private Grid grid;

    public IA(Grid grid){
        this.grid = grid;

        placeShip(new Destroyer());
        placeShip(new Carrier());
        placeShip(new Submarine());
        placeShip(new PatrolBoat());
    }

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

    public void checkDestroyed(ArrayList<ArrayList<Button>> buttons){

    }

    public void placeShip(Ship ship){
        int a = generateRandomNumbers(0, 10);
        int b = generateRandomNumbers(0,10);
        if(!checkPlace(a, b, ship, ship.getShipType().getSize())){
            placeShip(ship);
        }
    }

    public boolean checkPlace(int a, int b, Ship ship, int size){
        if(this.grid.getBoxes()[a][b].getShip() == null && size != 0){
            if(a < 10 && b+1 < 10){
                if(checkPlace(a, b+1,ship, size-1)){
                    this.grid.getBoxes()[a][b].setShip(ship);
                    return true;
                }
                return false;
            }
        }else return size == 0;

        return false;
    }

}
