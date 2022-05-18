package com.example.batallanaval.logic.ships;

public class Destroyer extends Ship {

    public Destroyer(){
        super();
        this.image = "./resource/Img/Destroyer/destroyer.png";
        this.shipType = ShipType.DESTROYER;
    }

    @Override
    public String getImage() {
        return this.image;
    }

    @Override
    public String dirImages() {
        return "./resource/Img/Destroyer/";
    }
}
