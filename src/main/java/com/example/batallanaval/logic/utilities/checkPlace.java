package com.example.batallanaval.logic.utilities;

import com.example.batallanaval.logic.field.Grid;
import com.example.batallanaval.logic.ships.Ship;

public class checkPlace {
    public static boolean checkPlaceHorizontal(int a, int b, Ship ship, int size, Grid grid){
        if(grid.getBoxes()[a][b].getShip() == null && size != 0){
            if(a < 10 && b+1 < 10){
                if(checkPlaceHorizontal(a, b+1,ship, size-1, grid)){
                    grid.getBoxes()[a][b].setShip(ship);
                    return true;
                }
                return false;
            }
        }else if (size == 0 && grid.getBoxes()[a][b].getShip() == null) {
            return true;
        }

        return false;
    }

    public static boolean checkPlaceVertical(int a, int b, Ship ship, int size, Grid grid){
        if(grid.getBoxes()[a][b].getShip() == null && size != 0){
            if(a+1 < 10 && b < 10){
                if(checkPlaceVertical(a+1, b,ship, size-1, grid)){
                    grid.getBoxes()[a][b].setShip(ship);
                    return true;
                }
                return false;
            }
        }else return size == 0;

        return false;
    }
}
