package com.example.batallanaval.logic.utilities;

import java.util.Random;

public class RandomFunction {
    public static int generateRandomNumbers(int max, int min){
        Random random = new Random();
        return  random.nextInt(min)+max;
    }
}
