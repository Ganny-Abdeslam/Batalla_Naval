package com.example.batallanaval.logic.ships;

public class Carrier extends  Ship implements Image{

    public Carrier(){
        super();
        this.image = "./resource/Img/Carrier/carrier.png";
        this.shipType = ShipType.CARRIER;
    }

    @Override
    public String getImage() {
        return this.image;
    }

    @Override
    public String dirImages() {
        return "./resource/Img/Carrier/";
    }
}
