package LOGIC;

import java.util.Random;

public class Dice {

    public static int throwDice(){
        int firstDice = new Random().nextInt(6) + 1;
        int secoundDice = new Random().nextInt(6) + 1;

        return firstDice + secoundDice;
    }
}
