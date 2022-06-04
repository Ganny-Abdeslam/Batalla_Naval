package com.example.batallanaval.logic.ships;
/**
 * Clase del barco tipo Carrier
 */
public class Carrier extends  Ship{

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
