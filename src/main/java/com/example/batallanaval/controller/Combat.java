package com.example.batallanaval.controller;

import javafx.scene.control.Button;

public class Combat {

    public static void combat(Button button){
        if(!button.getText().equals("")){
            button.setId("damage");
            button.setDisable(true);
        }else{
            button.setId("missing");
            button.setDisable(true);
        }
    }
}
