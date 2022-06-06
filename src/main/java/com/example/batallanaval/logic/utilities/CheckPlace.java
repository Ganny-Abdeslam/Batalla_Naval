package com.example.batallanaval.logic.utilities;

import com.example.batallanaval.logic.field.Grid;
import com.example.batallanaval.logic.ships.Ship;
/**
 * Verifica si puede colocar un barco completo ya sea de forma horizontal o vertical
 */
public class CheckPlace {
    /**
     * Este metodo verifica casilla por casilla si es posible colocar un barco de forma horizontal
     * Recursivamente revisa si las cajas de la grilla estan vacias o el tamanio es diferente de cero
     */
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

    /**
     * Este metodo verifica casilla por casilla si es posible colocar un barco de forma vertical
     * Recursivamente revisa si las cajas de la grilla estan vacias o el tamanio es diferente de cero
     */
    public static boolean checkPlaceVertical(int a, int b, Ship ship, int size, Grid grid){
        if(grid.getBoxes()[a][b].getShip() == null && size != 0){
            if(a+1 < 10 && b < 10){
                if(checkPlaceVertical(a+1, b,ship, size-1, grid)){
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
}
