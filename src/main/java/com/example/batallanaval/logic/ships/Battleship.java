package com.example.batallanaval.logic.ships;

public class Battleship extends Ship{

    public Battleship() {
        super();
        this.shipType = ShipType.BATTLESHIP;
        this.image = "./resource/Img/Battleship/battleship.png";
    }

    @Override
    public String getImage(){
        return this.image;
    }

    @Override
    public String dirImages() {
        return "./resource/Img/Battleship/";
    }
}
