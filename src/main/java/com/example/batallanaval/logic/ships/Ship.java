package com.example.batallanaval.logic.ships;

public abstract class Ship implements Image{
    protected int positionX;
    protected int positionY;
    protected boolean destroyed;
    protected int damage_amount;
    protected ShipType shipType;
    protected String image;

    public Ship(){
        this.damage_amount = 0;
        this.destroyed = false;
    }

    /**
     * SETTERS
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * GETTERS
     */
    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public ShipType getShipType() {
        return this.shipType;
    }
}
