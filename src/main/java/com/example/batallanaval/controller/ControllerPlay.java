package com.example.batallanaval.controller;

import java.io.IOException;

import com.example.batallanaval.logic.utilities.Coordinate;
import javafx.event.ActionEvent;

public class ControllerPlay {

    public void mover(ActionEvent e) throws  IOException{
        Coordinate prueba = new Coordinate(9, 9);

        System.out.println(prueba.toString());
    }
}
