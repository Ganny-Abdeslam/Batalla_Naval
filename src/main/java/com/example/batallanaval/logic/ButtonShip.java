package com.example.batallanaval.logic;

import com.example.batallanaval.logic.ships.Ship;
import com.example.batallanaval.logic.ships.ShipType;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class ButtonShip {
    private Ship ship;
    private ArrayList<Integer[]> positions;
    private Button button;
    private boolean place = false;

    public ButtonShip(){
    }

    public ButtonShip(Ship ship, Button button) {
        this.positions = new ArrayList<>();
        this.ship = ship;
        this.button = button;

        generateArray();
    }

    private void generateArray(){
        for(int i=0; i<this.ship.getShipType().getSize(); i++){
            this.positions.add(new Integer[2]);
        }
    }

    public ArrayList<Integer[]> getPositions(){
        return this.positions;
    }

    public Integer getPosition(int x, int y){
        return this.positions.get(x)[y];
    }

    public void setPositions(int position, int x, int y){
        this.positions.get(x)[y] = position;
    }

    public Button getButton() {
        return button;
    }

    public Ship getShip() {
        return ship;
    }

    public boolean isPlace() {
        return place;
    }

    public void setPlace(boolean place) {
        this.place = place;
    }
}
