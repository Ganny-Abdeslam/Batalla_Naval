package com.example.batallanaval.logic;

import com.example.batallanaval.logic.field.Box;
import javafx.scene.control.Button;

import java.util.ArrayList;

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

    public static boolean win(ArrayList<ArrayList<Button>> buttons, String msj){
        int count = 0;
        for (ArrayList<Button> button: buttons) {
            for (Button item: button) {
                if(item.getId().equals("damage")){
                    count++;
                }
            }
        }

        if(count >= 14){
            System.out.println("Win " + msj);
            return true;
        }
        return false;
    }
}