package com.example.batallanaval.logic.field;

import com.example.batallanaval.logic.utilities.Coordinate;

public class Grid {
    private Box boxes[][] = new Box[10][10];

    public  Grid(){
        for (int row = 0; row < boxes.length; row++) {
            for (int columm = 0; columm < boxes[row].length; columm++) {
                boxes[row][columm] =  new Box(new Coordinate(row, columm));
            }
        }
        this.iniciar();
    }

    public void  iniciar(){
        for(int row=0; row < boxes.length; row++){
            for (int column=0; column < boxes[row].length; column++){
                Box box = new Box(new Coordinate(row, column));

                //Indicación del tablero o Grilla para este cas
                box.setGrid(this);

                //Incluimos cada casilla "BOX" en nuestro arreglo de estas
                boxes[row][column] = box;

            }
        }
    }

    public String toString() {
        String resultado = "";
        for (int row = 0; row < boxes.length; row++) {
            String line = "";
            for (int columm = 0; columm < boxes[row].length; columm++) {
                line += " " + boxes[row][columm].toString() + " ";
            }
            resultado += line + "\n";
        }
        return resultado;
    }
}
