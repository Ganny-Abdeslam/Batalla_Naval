package com.example.batallanaval.logic.field;

import com.example.batallanaval.logic.ships.Ship;
import com.example.batallanaval.logic.utilities.Coordinate;

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
}
