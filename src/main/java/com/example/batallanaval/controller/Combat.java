package com.example.batallanaval.controller;

import javafx.scene.control.Button;

public class Combat {

    public static void combat(Button button){
        if(button.getGraphic()!=null){
            button.setId("damage");
            button.setDisable(true);
            button.setGraphic(null);
        }else{
            button.setId("missing");
            button.setDisable(true);
        }
    }
}
