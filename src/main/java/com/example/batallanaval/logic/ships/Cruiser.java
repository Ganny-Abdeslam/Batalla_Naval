package com.example.batallanaval.logic.ships;

public class Cruiser extends Ship {

    public Cruiser(){
        super();
        this.image = "./resource/Img/Submarine/submarine.png";
        this.shipType = ShipType.BATTLESHIP;
    }

    @Override
    public String getImage() {
        return this.image;
    }

    @Override
    public String dirImages() {
        return "./resource/Img/Submarine/";
    }
}
