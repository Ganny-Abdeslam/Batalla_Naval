package com.example.batallanaval.logic.utilities;

import java.util.Random;

public class RandomFunction {
    public static int generateRandomNumbers(int min, int max){
    /**
     * Metodo que genera numeros aleatorios
     */
        Random random = new Random();
        return  random.nextInt(max)+min;
    }
}
