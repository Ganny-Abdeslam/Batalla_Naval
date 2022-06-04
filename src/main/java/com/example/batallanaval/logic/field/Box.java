package com.example.batallanaval.logic.field;

import com.example.batallanaval.logic.ships.Ship;
import com.example.batallanaval.logic.utilities.Coordinate;

/**
 * Esta clase crea las cajas de la grilla
 * Esto para poner los barcos dentro de ellas
 */
public class Box {
    private Ship ship;
    private Coordinate coordinate;
    private Grid grid;

    public Box(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    public Box(Coordinate coordinate, Ship ship){
        this.coordinate = coordinate;
        this.ship = ship;
    }

    /**
     * GETTERS
     */
    public Ship getShip() {
        return ship;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Grid getGrid() {
        return grid;
    }

    /**
     * SETTERS
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    //PRUEBA POR AHORA
    public String toString() {
        if (this.ship != null) {
            return this.ship.toString();
        }
        else if (coordinate != null) {
            if ((coordinate.getRow() + coordinate.getCol()) % 2 == 0) {
                return "\u2593";
            }
        }
        return "\u2591";
    }
}
