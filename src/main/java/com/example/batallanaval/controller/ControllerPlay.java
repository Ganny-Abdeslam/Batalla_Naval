package com.example.batallanaval.controller;

import java.io.IOException;

import com.example.batallanaval.logic.field.Grid;
import javafx.event.ActionEvent;

public class ControllerPlay {

    public void mover(ActionEvent e) throws  IOException{
        Grid grid = new Grid();

        System.out.println(grid.toString());
    }
}
