package com.example.batallanaval.logic.ships;

public class Ship implements IPlace{
    protected int positionX;
    protected int positionY;
    protected boolean destroyed;
    protected int damage_amount;

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
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    @Override
    public void move() {

    }
}
