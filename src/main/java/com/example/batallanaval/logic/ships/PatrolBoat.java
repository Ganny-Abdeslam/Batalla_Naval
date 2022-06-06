package com.example.batallanaval.logic.ships;
/**
 * Clase del barco tipo PatrolBoat
 */
public class PatrolBoat extends Ship {

    public PatrolBoat() {
        super();
        this.image = "./resource/Img/PatrolBoat/patrolBoat.png";
        this.shipType = ShipType.PATROL_BOAT;
    }

    @Override
    public String getImage() {
        return this.image;
    }

    @Override
    public String dirImages() {
        return "./resource/Img/PatrolBoat/";
    }
}
