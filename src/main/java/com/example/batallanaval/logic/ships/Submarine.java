package com.example.batallanaval.logic.ships;
/**
 * Clase del barco tipo Submarine
 */
public class Submarine extends Ship {

    public Submarine(){
        super();
        this.image = "./resource/Img/Submarine/submarine.png";
        this.shipType = ShipType.SUBMARINE;
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
