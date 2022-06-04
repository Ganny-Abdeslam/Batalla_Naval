package com.example.batallanaval.logic.utilities;

import java.util.Random;

public class RandomFunction {
    public static int generateRandomNumbers(int min, int max){
        Random random = new Random();
        return  random.nextInt(max)+min;
    }
}
