package com.example.batallanaval.logic.ships;

public enum ShipType {
    CARRIER(5),
    BATTLESHIP(4),
    CRUISER(3),
    DESTROYER(3),
    PATROL_BOAT(2);

    private int size;

    ShipType(int size){
        this.size = size;
    }

    int getSize(){return this.size;}
}