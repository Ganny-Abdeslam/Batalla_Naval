package com.example.batallanaval.logic;

import com.example.batallanaval.logic.field.Box;
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

    public static void combat(Box box, Button button){
        if(box.getShip()!=null){
            button.setId("damage");
            button.setDisable(true);
            box.setShip(null);
        }else{
            button.setId("missing");
            button.setDisable(true);
        }
    }
}
