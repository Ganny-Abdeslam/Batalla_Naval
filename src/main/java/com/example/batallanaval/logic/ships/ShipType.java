package com.example.batallanaval.logic.ships;

/**
 * Enumeracion de los tipos de barcos del juego con sus respectivos tamanios
 */
public enum ShipType {
    CARRIER(5),
    BATTLESHIP(4),
    SUBMARINE(4),
    DESTROYER(3),
    PATROL_BOAT(2);

    private int size;

    ShipType(int size){
        this.size = size;
    }

    public int getSize(){return this.size;}
}